package com.company;

//interface PlainTextI {
//    double getScore();
//}

import java.util.ArrayList;

class PlainText {
    private String plainText;

    public PlainText() {
    }

    public PlainText(String plainText) {
        this.plainText = plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    @Override
    public String toString() {
        return plainText;
    }
}

class CaesarianPlainText extends PlainText implements Comparable<CaesarianPlainText> {
    private int letterShift;
    private int readabilityScore;
    private int readabilityErrorRate;
    private double sumOfDiscrepancyScore;

    public CaesarianPlainText(String plainText, int shift) {
        super(plainText);
        this.letterShift = shift;
    }

    public void setSumOfDiscrepancyScore(double score) {
        this.sumOfDiscrepancyScore = score;
    }

    public double getSumOfDiscrepancyScore() {
        return sumOfDiscrepancyScore;
    }

    public void setReadabilityScore(int score) {
        this.readabilityScore = score;
    }

    public int getReadabilityScore() {
        return readabilityScore;
    }

    public double getScore() {
        return sumOfDiscrepancyScore;
    }

    public int getLetterShift() {
        return letterShift;
    }

    @Override
    public int compareTo(CaesarianPlainText that) {
        return (int) (this.getScore() - that.getScore());
    }

    @Override
    public String toString() {
        return "Shift: " + letterShift + "\n" + super.toString();
    }
}

class PolyalphabeticPlainText extends PlainText implements Comparable<PolyalphabeticPlainText> {
    String key;
    private String plainText;
    double letterFrequencyPerLetterScore;

    public PolyalphabeticPlainText(char[] key, String plainText, double letterFrequencyPerLetterScore) {
        this.key = convertKeyArrayToString(key);
        this.plainText = plainText;
        this.letterFrequencyPerLetterScore = letterFrequencyPerLetterScore;
    }

    private String convertKeyArrayToString(char[] ary) {
        String key = "";
        for (char letter : ary) {
            key += letter;
        }
        return key;
    }

    public double getScore() {
        return letterFrequencyPerLetterScore;
    }

    @Override
    public int compareTo(PolyalphabeticPlainText that) {
        return (int) (this.getScore() - that.getScore());
    }

    @Override
    public String toString() {
        return "Key: " + key +
                "\nMessage: " + plainText;
    }
}

