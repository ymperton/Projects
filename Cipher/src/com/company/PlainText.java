package com.company;

public class PlainText {

    private String plainText;
    private int readabilityScore;
    private int readabilityErrorRate;

    public PlainText(String plainText) {
        this.plainText = plainText;
    }

    public void setReadabilityScore(int score) {
        this.readabilityScore = score;
    }

    public int getReadabilityScore() {
        return readabilityScore;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setReadabilityErrorRate(int error) {
        this.readabilityErrorRate = error;
    }

    public int getReadabilityErrorRate() {
        return readabilityErrorRate;
    }
}
