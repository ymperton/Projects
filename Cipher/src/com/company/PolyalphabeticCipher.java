package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolyalphabeticCipher extends Cipher implements Decipher {

    public PolyalphabeticCipher() {
    }

    public PolyalphabeticCipher(String cipherText) {
        enterCipherTextAndClean(cipherText);
    }

    @Override
    public PlainText decipher() {
        ArrayList<Integer> possibleKeyLengths = getKeyLengths();
        ArrayList<String> arrayOfSplitPolyalphabeticCipherText = new ArrayList<>();
        ArrayList<ArrayList<CaesarianPlainText>> arrayOfCaesarianPlainTexts = new ArrayList<>();

        ArrayList<PolyalphabeticPlainText> arrayOfTopPlainTexts = new ArrayList<>();

        for (Integer keyLength : possibleKeyLengths) {
            arrayOfSplitPolyalphabeticCipherText = splitCipherTextAmongstKeyLength(keyLength);

            arrayOfCaesarianPlainTexts = convertToArrayOfCaesarianPlainTexts(arrayOfSplitPolyalphabeticCipherText);

            arrayOfTopPlainTexts.add(createTopPolyAlphabeticPlainTexts(arrayOfCaesarianPlainTexts));
        }

        arrayOfTopPlainTexts.sort(PolyalphabeticPlainText::compareTo);
        return arrayOfTopPlainTexts.get(0);
    }

    private PolyalphabeticPlainText createTopPolyAlphabeticPlainTexts(ArrayList<ArrayList<CaesarianPlainText>> keyArrayOfCaesarianPlainTexts) {

        ArrayList<CaesarianPlainText> arrayOfTopCaesarianPlainTexts = new ArrayList<>();
        CaesarianPlainText topCaesarianPlainText;
        char[] key = new char[keyArrayOfCaesarianPlainTexts.size()];
        int index = 0;
        double scoreTotal = 0;
        for (ArrayList<CaesarianPlainText> arrayOfPlainTexts : keyArrayOfCaesarianPlainTexts) {
            topCaesarianPlainText = arrayOfPlainTexts.get(0);
            key[index++] = (char) (topCaesarianPlainText.getLetterShift() + ENGLISH_ALPHABET_START);
            scoreTotal += topCaesarianPlainText.getSumOfDiscrepancyScore();
            arrayOfTopCaesarianPlainTexts.add(topCaesarianPlainText);
        }
        scoreTotal /= key.length;
        String plainText = decrypt(getCipherText(), key);
        PolyalphabeticPlainText ppt = new PolyalphabeticPlainText(key, plainText, scoreTotal);

        return ppt;
    }

    private String decrypt(String cipherText, char[] key) {
        StringBuilder plainText = new StringBuilder(cipherText.length());
        char letter = 0;
        char keyLetter = 0;
        int keyLength = key.length;

        for (int i = 0; i < cipherText.length(); i++) {
            letter = cipherText.charAt(i);
            keyLetter = key[i % keyLength];

            letter = (char) (letter - keyLetter + ENGLISH_ALPHABET_START);
            if (letter < ENGLISH_ALPHABET_START) {
                letter += ENGLISH_ALPHABET_LENGTH;
            }
            plainText.append(letter);
        }

        return plainText.toString();
    }

    private ArrayList<String> splitCipherTextAmongstKeyLength(Integer keyLength) {
        ArrayList<StringBuilder> arrayOfSplitPolyalphabeticCipherText = new ArrayList<>(keyLength);

        //creating the ArrayList
        for (int i = 0; i < keyLength; i++) {
            arrayOfSplitPolyalphabeticCipherText.add(new StringBuilder());
        }

        int index = 0;
        for (char letter : getCipherText().toCharArray()) {
            arrayOfSplitPolyalphabeticCipherText.get(index).append(letter);

            index = index + 1 == keyLength ? 0 : index + 1;
        }

        ArrayList<String> temp = new ArrayList<>();
        for (StringBuilder sb : arrayOfSplitPolyalphabeticCipherText) {
            temp.add(sb.toString());
        }
        return temp;
    }

    /**
     * Goes through each of the split up segments of the cipherText, and treats each one as a Caesarian cipher text.
     * Results in an arrayList of PlainTexts for each of the key letters, sorted with the best scoring letter shift
     * for each key letter.
     *
     * @param arrayOfSplitPolyalphabeticCipherText
     * @return
     */
    private ArrayList<ArrayList<CaesarianPlainText>> convertToArrayOfCaesarianPlainTexts(ArrayList<String> arrayOfSplitPolyalphabeticCipherText) {
        ArrayList<ArrayList<CaesarianPlainText>> arrayOfCaesarianPlainTexts = new ArrayList<>();

        for (String cipherText : arrayOfSplitPolyalphabeticCipherText) {
            CaesarianCipher cc = new CaesarianCipher(cipherText);
            arrayOfCaesarianPlainTexts.add(cc.getAllPossibleCaesarianPlainTexts());
        }

        return arrayOfCaesarianPlainTexts;
    }

    public ArrayList<Integer> getKeyLengths() {
        ArrayList<Integer> arrayOfAllDistancesOfPairs = new ArrayList<>();

        String twoRepetitions = "(\\w{3,})\\w+(\\1)";
        Pattern pattern = Pattern.compile(twoRepetitions);
        Matcher matcher = pattern.matcher(getCipherText());

        int i = 0;
        while (matcher.find(i)) {
            int distanceBetweenPairs = matcher.start(2) - matcher.start(1);
            arrayOfAllDistancesOfPairs.add(distanceBetweenPairs);
            i++;
        }

        int[] factors = createFactors(arrayOfAllDistancesOfPairs);
        //get average of list
        double listAverage = getAverage(factors);

        ArrayList<Integer> possibleKeyLengths = new ArrayList<>();
        for (int j = 0; j < factors.length; j++) {
            if (factors[j] >= listAverage) {
                possibleKeyLengths.add(j);
            }
        }
        return possibleKeyLengths;
    }

    private int[] createFactors(ArrayList<Integer> ary) {
        int[] factors = new int[maxOfArray(ary) + 1];
        for (Integer elt : ary) {
            for (int i = 2; i <= elt; i++) {
                if (elt % i == 0) {
                    factors[i] ++;
                }
            }
        }

        return factors;
    }

    private int maxOfArray(ArrayList<Integer> ary) {
        int max = 0; //TODO corner case if no elts
        for (Integer elt : ary) {
            max = elt > max ? elt : max;
        }
        return max;
    }

    private double getAverage(int[] factors) {
        int total = 0;
        int counter = 0;

        for (int i : factors) {
            if (i != 0) {
                counter++;
                total += i;
            }
        }
        return (double) total / counter;
    }

}
