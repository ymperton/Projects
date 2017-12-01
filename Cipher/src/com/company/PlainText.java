package com.company;

//interface PlainTextI {
//    double getScore();
//}

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

class CaesarianCipherPlainText extends PlainText implements Comparable<CaesarianCipherPlainText> {
    private int letterShift;
    private int readabilityScore;
    private int readabilityErrorRate;
    private double sumOfDiscrepancyScore;

    public CaesarianCipherPlainText(String plainText, int shift) {
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

    @Override
    public int compareTo(CaesarianCipherPlainText that) {
        return (int) (this.getScore() - that.getScore());
    }

    @Override
    public String toString() {
        return "Shift: " + letterShift + "\n" + super.toString();
    }
}

