package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;

public class CaesarianCipher extends Cipher implements Decipher {
    private String cipherText;
    private double[] englishLanguageLetterFrequency = {8.167, 1.492, 2.782, 4.253,
            12.7, 2.228, 2.015, 6.094, 6.966, 0.153, 0.772, 4.025, 2.406, 6.749,
            7.507, 1.929, 0.095, 5.987, 6.327, 9.056, 2.758, 0.978, 2.36, 0.15,
            1.974, 0.074};


    public CaesarianCipher() {
    }

    public CaesarianCipher(String cipherText) {
        enterCipherTextAndClean(cipherText);
    }

    @Override
    public CaesarianPlainText decipher() {
        ArrayList<CaesarianPlainText> listOfPossiblePlainTexts = new ArrayList<>(ENGLISH_ALPHABET_LENGTH);

        //create all 26 permutations and score them
        listOfPossiblePlainTexts = getAllPossibleCaesarianPlainTexts();

        return listOfPossiblePlainTexts.get(0);
    }

    //Create the 26 possibilities and calculate how close they are to the english letter frequency
    public ArrayList<CaesarianPlainText> getAllPossibleCaesarianPlainTexts() {
        ArrayList<CaesarianPlainText> listOfPossiblePlainTexts = new ArrayList<>(ENGLISH_ALPHABET_LENGTH);
        double[] cipherTextLetterFrequency = createLetterFrequency();

        for (int shift = 0; shift < ENGLISH_ALPHABET_LENGTH; shift++) {
            CaesarianPlainText pt = new CaesarianPlainText(decipher(getCipherText(), shift, 1), shift);
            pt.setSumOfDiscrepancyScore(calculateSumOfDiscrepancyForShift(cipherTextLetterFrequency, shift));
            listOfPossiblePlainTexts.add(pt);
        }

        //sort from lowest score to highest
        listOfPossiblePlainTexts.sort(CaesarianPlainText::compareTo);

        return listOfPossiblePlainTexts;
    }

    private double calculateSumOfDiscrepancyForShift(double[] cipherTextLetterFrequency, int shift) {
        double total = 0;
        for (int percent = 0; percent < 26; percent++) { //will go through all the letters and create a running total.
            total += Math.abs(englishLanguageLetterFrequency[percent]
                    - cipherTextLetterFrequency[(percent + shift) % 26]); //add a discrepency
        }
        return total;
    }


//    int calculateLetterShift(double[] textLetterFrequency) {
//        double[] sumOfLetterDiscrepencyPerShift = new double[26];
//        int indexOfLowestSumOfShiftDiscrepancy = 0;
//        double lowestSumOfShiftDiscrepancy = Double.MAX_VALUE;
//        for (int shift = 0; shift < 26; shift++) { //go through 26 shifts
//            double total = 0;
//            for (int percent = 0; percent < 26; percent++) { //will go through all the letters and create a running total.
//                total += Math.abs(textLetterFrequency[percent]
//                        - englishLanguageLetterFrequency[(percent + shift) % 26]); //add a discrepency
//            }
//            sumOfLetterDiscrepencyPerShift[shift] = total;
//            indexOfLowestSumOfShiftDiscrepancy = lowestSumOfShiftDiscrepancy < total ? indexOfLowestSumOfShiftDiscrepancy : shift;
//            System.out.println("shift: " + shift + ": sum: " + total);
//        }
//
//        return indexOfLowestSumOfShiftDiscrepancy;
//    }
}
