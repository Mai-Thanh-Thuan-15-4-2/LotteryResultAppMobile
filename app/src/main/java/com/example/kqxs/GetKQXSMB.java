package com.example.kqxs;

public class GetKQXSMB {
    private final String prizesString;

    public GetKQXSMB(String prizesString) {
        this.prizesString = prizesString;
    }

    public String getSpecialPrize() {
        String specialPrizeString = prizesString.substring(prizesString.indexOf("ĐB:") + 3, prizesString.indexOf("ĐB:") + 9).trim();
        return specialPrizeString;
    }

    public String getFirstPrize() {
        String firstPrizeString = prizesString.substring(prizesString.indexOf("1:") + 2, prizesString.indexOf("1:") + 8).trim();
        return firstPrizeString;
    }

    public String[] getSecondPrize() {
        String secondPrizeString = prizesString.substring(prizesString.indexOf("2:") + 2, prizesString.indexOf("3:")).trim();
        String[] secondPrizeParts = secondPrizeString.split("-");
        String[] secondPrize = new String[2];
        secondPrize[0] = secondPrizeParts[0].trim();
        secondPrize[1] = secondPrizeParts[1].trim();
        return secondPrize;
    }

    public String[] getThirdPrize() {
        String thirdPrizeString = prizesString.substring(prizesString.indexOf("3:") + 2, prizesString.indexOf("4:")).trim();
        String[] thirdPrizeParts = thirdPrizeString.split("-");
        String[] thirdPrize = new String[6];
        for (int i = 0; i < thirdPrizeParts.length; i++) {
            thirdPrize[i] = thirdPrizeParts[i].trim();
        }
        return thirdPrize;
    }

    public String[] getFourthPrize() {
        String fourthPrizeString = prizesString.substring(prizesString.indexOf("4:") + 2, prizesString.indexOf("5:")).trim();
        String[] fourthPrizeParts = fourthPrizeString.split("-");
        String[] fourthPrize = new String[4];
        for (int i = 0; i < fourthPrizeParts.length; i++) {
            fourthPrize[i] = fourthPrizeParts[i].trim();
        }
        return fourthPrize;
    }

    public String[] getFifthPrize() {
        String fifthPrizeString = prizesString.substring(prizesString.indexOf("5:") + 2, prizesString.indexOf("6:")).trim();
        String[] fifthPrizeParts = fifthPrizeString.split("-");
        String[] fifthPrize = new String[6];
        for (int i = 0; i < fifthPrizeParts.length; i++) {
            fifthPrize[i] = fifthPrizeParts[i].trim();
        }
        return fifthPrize;
    }

    public String[] getSixthPrize() {
        String sixthPrizeString = prizesString.substring(prizesString.indexOf("6:") + 2, prizesString.indexOf("7:")).trim();
        String[] sixthPrizeParts = sixthPrizeString.split("-");
        String[] sixthPrize = new String[3];
        for (int i = 0; i < sixthPrizeParts.length; i++) {
            sixthPrize[i] = sixthPrizeParts[i].trim();
        }
        return sixthPrize;
    }

    public String[] getSeventhPrize() {
        String seventhPrizeString = prizesString.substring(prizesString.indexOf("7:") + 2).trim();
        String[] seventhPrizeParts = seventhPrizeString.split("-");
        String[] seventhPrize = new String[4];
        for (int i = 0; i < seventhPrizeParts.length; i++) {
            seventhPrize[i] = seventhPrizeParts[i].trim();
        }
        return seventhPrize;
    }
}
