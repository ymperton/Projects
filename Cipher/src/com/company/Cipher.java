package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cipher {
    private String cipherText;
    private static int languageLetterLength;

    static String decipher(String cipherText, int shift, int skip) {
        char letter;
        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            letter = cipherText.charAt(i);
            letter += shift;
            if (letter > languageLetterLength) {
                letter -= languageLetterLength;
            }
            plainText.append(letter);
        }

        return plainText.toString();
    }
    //thedogjumped

    static ArrayList<PlainText> aryPossibleSentences = new ArrayList<>();
    static ArrayList<String> aryDictionary = new ArrayList<>();
    static final int ERROR_MAX = 5;

    public static void readFile() throws FileNotFoundException {
        Scanner scn = new Scanner(new File("wordsEN.txt"));
        while(scn.hasNext()) {
            aryDictionary.add(scn.next().toUpperCase());
        }

    }

    static void placeSpacesInStringWithout(String lettersFiguredOut,
                                           String lettersNotUsed,
                                           int score, int errors) {

        System.out.println("Pre: " + lettersFiguredOut + " post: " + lettersNotUsed
                + " score: " + score + " errors: " + errors);

        if (lettersNotUsed.equals("")) {
            finishUp(lettersFiguredOut, score, errors);
        } else if (errors < ERROR_MAX) {
            String wordToBeTested = "";
            int wordResult = 0;

            for (int i = 0; i < lettersNotUsed.length(); i++) {
                wordToBeTested += lettersNotUsed.charAt(i);
                wordResult = getResultForWord(wordToBeTested);

                if (wordResult == IS_WORD) {
                    System.out.println("<" + wordToBeTested + "> is word, going in with " + lettersNotUsed.substring(i + 1));
                    placeSpacesInStringWithout(lettersFiguredOut + "_" + wordToBeTested,
                            lettersNotUsed.substring(i + 1),
                            score += Math.pow(wordToBeTested.length(), 2),
                            errors);
                } else if (wordResult == WILL_NEVER_BE_A_WORD) {
                    System.out.println("<" + wordToBeTested + "> will not be a word, but will have to go in none the less");
                    placeSpacesInStringWithout(lettersFiguredOut + "_" + wordToBeTested,
                            lettersNotUsed.substring(i + 1),
                            score,// += wordToBeTested.length(),
                            errors + 1);
                }
            }
            if (wordResult != IS_WORD) {
                finishUp(lettersFiguredOut, score, errors + 1);
            }
            if(wordResult == IS_START_OF_WORD) {
                System.out.println("<"+wordToBeTested + "> is the beginning of a word");
            }

        }
        System.out.println("!!!!! Letters reached the max, going back out !!!!!");
    }
    static String[] aryEnglishWords = new String[]{"the", "dog", "jumped", "he", "do", "jump", "gold", "old"};
    static final int IS_WORD = 0;
    static final int IS_START_OF_WORD = 1;
    static final int WILL_NEVER_BE_A_WORD = 2;

    private static int getResultForWord(String word) {
        if (isWord(word)) {
            return IS_WORD;
        }

        if (isStartOfWord(word)) {
            return IS_START_OF_WORD;
        } else {
            return WILL_NEVER_BE_A_WORD;
        }
    }

    static boolean isWord(String wordToBeTested) {

        for (String englishWord : aryDictionary) {
            if (englishWord.equals(wordToBeTested)) {
                return true;
            }
        }
        return false;
    }

    static boolean isStartOfWord(String wordToBeTested) {
        for (String englishWord : aryDictionary) {
            if (englishWord.startsWith(wordToBeTested)) {
                return true;
            }
        }
        return false;
    }

    public static void finishUp(String plainText, int score, int errors) {
        System.out.println("---Finished\n");
        PlainText pT = new PlainText(plainText);
        pT.setReadabilityScore(score);
        pT.setReadabilityErrorRate(errors);
        aryPossibleSentences.add(pT);
    }
}
