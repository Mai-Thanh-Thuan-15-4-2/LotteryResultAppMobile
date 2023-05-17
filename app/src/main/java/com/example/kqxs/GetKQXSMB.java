package com.example.kqxs;

public class GetKQXSMB {
    private final String prizesString;

    public GetKQXSMB(String prizesString) {
        this.prizesString = prizesString;
    }

    public int getSpecialPrize() {
        String specialPrizeString = prizesString.substring(prizesString.indexOf("ĐB:") + 3, prizesString.indexOf("ĐB:") + 9).trim();
        return Integer.parseInt(specialPrizeString);
    }

    public int getFirstPrize() {
        String firstPrizeString = prizesString.substring(prizesString.indexOf("1:") + 2, prizesString.indexOf("1:") + 7).trim();
        return Integer.parseInt(firstPrizeString);
    }

    public int[] getSecondPrize() {
        String secondPrizeString = prizesString.substring(prizesString.indexOf("2:") + 2, prizesString.indexOf("3:")).trim();
        String[] secondPrizeParts = secondPrizeString.split("-");
        int[] secondPrize = new int[2];
        secondPrize[0] = Integer.parseInt(secondPrizeParts[0].trim());
        secondPrize[1] = Integer.parseInt(secondPrizeParts[1].trim());
        return secondPrize;
    }

    public int[] getThirdPrize() {
        String thirdPrizeString = prizesString.substring(prizesString.indexOf("3:") + 2, prizesString.indexOf("4:")).trim();
        String[] thirdPrizeParts = thirdPrizeString.split("-");
        int[] thirdPrize = new int[6];
        for (int i = 0; i < thirdPrizeParts.length; i++) {
            thirdPrize[i] = Integer.parseInt(thirdPrizeParts[i].trim());
        }
        return thirdPrize;
    }

    public int[] getFourthPrize() {
        String fourthPrizeString = prizesString.substring(prizesString.indexOf("4:") + 2, prizesString.indexOf("5:")).trim();
        String[] fourthPrizeParts = fourthPrizeString.split("-");
        int[] fourthPrize = new int[4];
        for (int i = 0; i < fourthPrizeParts.length; i++) {
            fourthPrize[i] = Integer.parseInt(fourthPrizeParts[i].trim());
        }
        return fourthPrize;
    }

    public int[] getFifthPrize() {
        String fifthPrizeString = prizesString.substring(prizesString.indexOf("5:") + 2, prizesString.indexOf("6:")).trim();
        String[] fifthPrizeParts = fifthPrizeString.split("-");
        int[] fifthPrize = new int[6];
        for (int i = 0; i < fifthPrizeParts.length; i++) {
            fifthPrize[i] = Integer.parseInt(fifthPrizeParts[i].trim());
        }
        return fifthPrize;
    }

    public int[] getSixthPrize() {
        String sixthPrizeString = prizesString.substring(prizesString.indexOf("6:") + 2, prizesString.indexOf("7:")).trim();
        String[] sixthPrizeParts = sixthPrizeString.split("-");
        int[] sixthPrize = new int[3];
        for (int i = 0; i < sixthPrizeParts.length; i++) {
            sixthPrize[i] = Integer.parseInt(sixthPrizeParts[i].trim());
        }
        return sixthPrize;
    }

    public int[] getSeventhPrize() {
        String seventhPrizeString = prizesString.substring(prizesString.indexOf("7:") + 2).trim();
        String[] seventhPrizeParts = seventhPrizeString.split("-");
        int[] seventhPrize = new int[4];
        for (int i = 0; i < seventhPrizeParts.length; i++) {
            seventhPrize[i] = Integer.parseInt(seventhPrizeParts[i].trim());
        }
        return seventhPrize;
    }
}