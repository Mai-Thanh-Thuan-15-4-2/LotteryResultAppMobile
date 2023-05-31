package com.example.kqxs;

public class GetRadioResult {
    private final String prizesString;

    public GetRadioResult(String prizesString) {
        this.prizesString = prizesString;
    }

    public String getSpecialPrize() {
        String specialPrizeString = prizesString.substring(prizesString.indexOf("ĐB:") + 3, prizesString.indexOf("1:")).trim();
        return specialPrizeString;
    }

    public String getFirstPrize() {
        String firstPrizeString = prizesString.substring(prizesString.indexOf("1:") + 2, prizesString.indexOf("2:")).trim();
        return firstPrizeString;
    }

    public String getSecondPrize() {
        String secondPrizeString = prizesString.substring(prizesString.indexOf("2:") + 2, prizesString.indexOf("3:")).trim();
        return secondPrizeString;
    }

    public String getThirdPrize() {
        String thirdPrizeString = prizesString.substring(prizesString.indexOf("3:") + 2, prizesString.indexOf("4:")).trim();
        return thirdPrizeString;
    }

    public String getFourthPrize() {
        String fourthPrizeString = prizesString.substring(prizesString.indexOf("4:") + 2, prizesString.indexOf("5:")).trim();
        return fourthPrizeString;
    }

    public String getFifthPrize() {
        String fifthPrizeString = prizesString.substring(prizesString.indexOf("5:") + 2, prizesString.indexOf("6:")).trim();
        return fifthPrizeString;
    }

    public String getSixthPrize() {
        String sixthPrizeString = prizesString.substring(prizesString.indexOf("6:") + 2, prizesString.indexOf("7:")).trim();
        return sixthPrizeString;
    }

    public String getSeventhPrize() {
        String seventhPrizeString = prizesString.substring(prizesString.indexOf("7:") + 2, prizesString.indexOf("8:")).trim();
        return seventhPrizeString;
    }

    public String getEighthPrize() {
        String eighthPrizeString = prizesString.substring(prizesString.indexOf("8:") + 2).trim();
        return eighthPrizeString;
    }
}
