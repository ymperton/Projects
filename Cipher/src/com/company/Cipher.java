package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
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
    static ArrayList<ArrayList<String>> aryDictionaryBasedUponWordLength = new ArrayList<>();
    static final int ERROR_MAX = 0;

    public static ArrayList<String> getWordList() throws FileNotFoundException {
        ArrayList<String> wordList = new ArrayList<>();
        Scanner scn = new Scanner(new File("wordsEN.txt"));
        while (scn.hasNext()) {
            wordList.add(scn.next().toUpperCase());
        }
        return wordList;
    }

    public static void createDictionary() throws FileNotFoundException {
        ArrayList<String> wordList = getWordList();
        int maxWordLength = getMaxWordLength(wordList);
        int wordLength;

        for (int i = 0; i < maxWordLength; i++) {
            aryDictionaryBasedUponWordLength.add(new ArrayList<>());
            aryDictionaryBasedUponWordLength.get(i).add("."); //so that no arrayList will return an null which will result in error. NOTE: fix this.
        }

        //place word in correct slot.
        for (String word : wordList) {
            wordLength = word.length();
            aryDictionaryBasedUponWordLength.get(wordLength - 1).add(word);
        }

        for (ArrayList<String> listOfWordsByWordLength : aryDictionaryBasedUponWordLength) {
            Collections.sort(listOfWordsByWordLength);
        }
    }

    private static int getMaxWordLength(ArrayList<String> ary) {
        int max = 0;
        for (String word : ary) {
            max = word.length() > max ? word.length() : max;
        }
        return max;
    }

    static void placeSpacesInStringWithout(String lettersFiguredOut,
                                           String lettersNotUsed,
                                           int score, int errors) {

        System.out.println("Pre: " + lettersFiguredOut + " post: " + lettersNotUsed
                + " score: " + score + " errors: " + errors);

        if (lettersNotUsed.length() == 0) {
            finishUp(lettersFiguredOut, score, errors);
        } else if (errors <= ERROR_MAX) {
            String wordToBeTested = "";
            int wordResult = 0;

            for (int i = 0; i < lettersNotUsed.length(); i++) {
                wordToBeTested += lettersNotUsed.charAt(i);
                if (wordToBeTested.length() > aryDictionaryBasedUponWordLength.size()) {
                    return;
                }
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
            if (wordResult == IS_START_OF_WORD) {
                System.out.println("<" + wordToBeTested + "> is the beginning of a word");
            }

        }
        System.out.println("!!!!! Letters reached the max, going back out !!!!!");
    }

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
        ArrayList<String> listOfWordsOfSameLength = getListOfWordsOfSameLength(wordToBeTested);
        for (String wordOfSameLength : listOfWordsOfSameLength) {
            if (wordOfSameLength.equals(wordToBeTested)) {
                return true;
            }
        }


        return false;
    }

    static boolean isStartOfWord(String wordToBeTested) {
        for (int wordLengthStart = wordToBeTested.length() + 1; wordLengthStart < aryDictionaryBasedUponWordLength.size(); wordLengthStart++) {
            for (String wordOfSameLength : aryDictionaryBasedUponWordLength.get(wordLengthStart)) {
                if (wordOfSameLength.startsWith(wordToBeTested)) {
                    return true;
                }
            }
        }
        return false;
    }

    static ArrayList<String> getListOfWordsOfSameLength(String wordToBeTested) {
        if (aryDictionaryBasedUponWordLength.get(wordToBeTested.length() - 1).size() > 0) {
            return aryDictionaryBasedUponWordLength.get(wordToBeTested.length() - 1);
        } else {
            return null;
        }
    }

    public static void finishUp(String plainText, int score, int errors) {
        System.out.println("---Finished\n");
        PlainText pT = new PlainText(plainText);
        pT.setReadabilityScore(score);
        pT.setReadabilityErrorRate(errors);
        aryPossibleSentences.add(pT);
    }
}
