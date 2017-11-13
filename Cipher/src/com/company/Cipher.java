package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Cipher {
    private String cipherText;
    private static int languageLetterLength;

    public void enterCipherTextAndClean(String text) {
        StringBuilder sb = new StringBuilder();
        text = text.toUpperCase();
        char letter;
        for (int i = 0; i < text.length(); i++) {
            letter = text.charAt(i);
            if (letter >= 'A' && letter <= 'Z') {
                sb.append(letter);
            }
        }
        cipherText = sb.toString();
    }

    static String decipher(String cipherText, int shift, int skip) {
        char letter;
        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            letter = cipherText.charAt(i);
            letter -= shift;
            if (letter > 'Z') {
                letter -= 26;
            }
            if (letter < 'A') {
                letter += 26;
            }
            plainText.append(letter);
        }

        return plainText.toString();
    }
    //thedogjumped

    static ArrayList<String> aryDictionary = new ArrayList<>();
    static final int ERROR_MAX = 2;

    void createDictionary() throws FileNotFoundException {
//        ArrayList<String> wordList = new ArrayList<>();
        Scanner scn = new Scanner(new File("wordsEN.txt"));
        while (scn.hasNext()) {
            aryDictionary.add(scn.next().toUpperCase());
        }
    }

    int calculateReadabilityScore(String plainText) {
        String[] plainTextSplitUp = createArrayOfStrings(plainText);
        int total = 0;
        int i = 0;
//        for (String miniPlainText : plainTextSplitUp) {
//            System.out.println(i++);
//            total += placeSpacesInStringWithout("", miniPlainText, 0, 0);
//            max = 0;
//        }
        for (int j = 0; j < 10; j++) {
            String s = plainTextSplitUp[j];
            total += placeSpacesInStringWithout("", s, 0, 0);
            max = 0;
        }

        return total;

    }

    private String[] createArrayOfStrings(String plainText) {
        final int LETTERS_FRAGMENT = 15;
        ArrayList<String> ary = new ArrayList<>();
        int counter = 0;
        int iterations = (int) (plainText.length() / LETTERS_FRAGMENT);

        for (int i = 0; i < iterations; i++) {
            ary.add(plainText.substring(counter * LETTERS_FRAGMENT, counter * LETTERS_FRAGMENT + LETTERS_FRAGMENT));
            counter++;
            System.out.println(ary.get(counter - 1));
        }
        ary.add(plainText.substring(counter * LETTERS_FRAGMENT));

        for (String s : ary) {
            System.out.println(s);
        }
        return ary.toArray(new String[ary.size()]);
    }

    int max = 0;

    int placeSpacesInStringWithout(String lettersFiguredOut,
                                   String lettersNotUsed,
                                   int score, int errors) {

        System.out.println("Pre: " + lettersFiguredOut + " post: " + lettersNotUsed
                + " score: " + score + " errors: " + errors);

        if (lettersNotUsed.length() == 0) { //done
            max = score > max ? score : max;
            System.out.println("the score is " + max);
        } else if (errors <= ERROR_MAX) {
            String wordToBeTested = "";

            for (int i = 0; i < lettersNotUsed.length(); i++) {
                wordToBeTested += lettersNotUsed.charAt(i);
                getResultForWord(wordToBeTested, lettersFiguredOut, lettersNotUsed, score, errors);
            }
            System.out.println("got to the end");
            max = score > max ? score : max;
            System.out.println("the score is " + max);
//            System.out.println("!!!!! Letters reached the max, going back out !!!!!");
        }

        return max;
    }

    private void getResultForWord(String wordToBeTested, String lettersFiguredOut, String lettersNotUsed,
                                  int score, int errors) {
        if (isWord(wordToBeTested)) {
            System.out.println("<" + wordToBeTested + "> is word, going in with " + lettersNotUsed.substring(wordToBeTested.length()));
            placeSpacesInStringWithout(lettersFiguredOut + "_" + wordToBeTested,
                    lettersNotUsed.substring(wordToBeTested.length()),
                    score += Math.pow(wordToBeTested.length(), 2),
                    errors);
        }

        if (!isStartOfWord(wordToBeTested)) {
//            System.out.println("<" + wordToBeTested + "> will not be a word, but will have to go in none the less");
            placeSpacesInStringWithout(lettersFiguredOut + "_" + wordToBeTested,
                    lettersNotUsed.substring(wordToBeTested.length()),
                    score,// += wordToBeTested.length(),
                    errors + 1);

        }
    }

    static boolean isWord(String wordToBeTested) {
        for (String wordOfSameLength : aryDictionary) {
            if (wordOfSameLength.equals(wordToBeTested)) {
                return true;
            }
        }


        return false;
    }

    static boolean isStartOfWord(String wordToBeTested) {
        for (String wordOfSameLength : aryDictionary) {
            if (wordOfSameLength.startsWith(wordToBeTested)) {
                return true;
            }
        }

        return false;
    }

    double[] createLetterFrequency() {
        int textLength = cipherText.length();
        int[] letterHistogram = createLetterHistogram();
        double[] textLetterFrequency = new double[26];

        for (int i = 0; i < textLetterFrequency.length; i++) {
            textLetterFrequency[i] = letterHistogram[i] / (double) textLength * 100;
        }
        return textLetterFrequency;
    }

    //TODO: use streams
    int[] createLetterHistogram() {
        int[] letterHistogram = new int[26];
        char letter;
        for (int i = 0; i < cipherText.length(); i++) {
            letter = cipherText.charAt(i);
            letterHistogram[letter - 'A']++;
        }
        return letterHistogram;
    }

    public String getCipherText() {
        return cipherText;
    }
}
