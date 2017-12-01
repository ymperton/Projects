package com.company;

import java.util.ArrayList;
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
        ArrayList<Integer> possibleKeyLengths = getKeyLength();



        return null;
    }

    public ArrayList<Integer> getKeyLength() {
        factors = new int[10];

        String twoRepetitions = "(\\w{3,})\\w+(\\1)";
        Pattern pattern = Pattern.compile(twoRepetitions);
        Matcher matcher = pattern.matcher(getCipherText());
//        Matcher matcher = pattern.matcher("ACABBBBBACA");

        int i = 0;
        while (matcher.find(i)) {
            System.out.print("Match " + i + ": " + matcher.group(1));
//            System.out.print("\tstart1: " + matcher.start(1));
//            System.out.println("\tstart2: " + matcher.start(2));

            int distanceBetweenPairs = matcher.start(2) - matcher.start(1);
            int pairLength = matcher.end(1) - matcher.start(1);
//            System.out.println("Distance: " + distanceBetweenPairs + "\tlength: " + pairLength);

            calculateFactorsAndAddToList(distanceBetweenPairs, pairLength);
            i++;
        }

        for (int j = 0; j < factors.length; j++) {
            System.out.println(j + ". " + factors[j]);
        }

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

    int[] factors;

    private void calculateFactorsAndAddToList(int distance, int pairLength) {
        for (int i = 2; i < factors.length; i++) {
            if (distance % i == 0) {
                factors[i] += pairLength;
            }
        }
    }
}
