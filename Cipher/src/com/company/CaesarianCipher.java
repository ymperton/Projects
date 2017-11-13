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
        try {
            createDictionary();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String decipher() {
        ArrayList<CaesarianCipherPlainText> listOfPossiblePlainTexts = new ArrayList<>(26);
        double[] cipherTextLetterFrequency = createLetterFrequency();

        //TODO create the 26 PlainTexts, within them their bit shift score, and then readablitiy score, so the calcualteLeterShift mehtod should deal with that.


        for (int shift = 0; shift < 26; shift++) {
            CaesarianCipherPlainText pt = new CaesarianCipherPlainText(decipher(getCipherText(), shift, 1));

            pt.setSumOfDiscrepancyScore(calculateSumOfDiscrepancyForShift(cipherTextLetterFrequency, shift));
//            pt.setReadabilityScore(calculateReadabilityScore(pt.getPlainText()));

            listOfPossiblePlainTexts.add(pt);
        }

        listOfPossiblePlainTexts.sort(CaesarianCipherPlainText::compareTo);
        for (CaesarianCipherPlainText pt : listOfPossiblePlainTexts) {
            System.out.println(pt.getSumOfDiscrepancyScore() + "\t" + pt.getReadabilityScore() + "\t" +pt.getPlainText());
        }

        System.out.println(calculateReadabilityScore(listOfPossiblePlainTexts.get(0).getPlainText()));


        return null;
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
