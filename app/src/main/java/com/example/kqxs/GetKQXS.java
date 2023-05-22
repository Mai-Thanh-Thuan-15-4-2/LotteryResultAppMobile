package com.example.kqxs;

public class GetKQXS {
    private final String prizesString;
    public GetKQXS(String prizesString) {
        this.prizesString = prizesString;
    }
    public String getSpecialPrize() {
        String specialPrizeString = prizesString.substring(prizesString.indexOf("ĐB:") + 3, prizesString.indexOf("ĐB:") + 10).trim();
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
    public String[] getThirdPrize() {
        String thirdPrizeString = prizesString.substring(prizesString.indexOf("3:") + 2, prizesString.indexOf("4:")).trim();
        String[] thirdPrizeParts = thirdPrizeString.split("-");
        String[] thirdPrize = new String[2];
        thirdPrize[0] = thirdPrizeParts[0].trim();
        thirdPrize[1] = thirdPrizeParts[1].trim();
        return thirdPrize;
    }
    public String[] getFourthPrize() {
        String fourthPrizeString = prizesString.substring(prizesString.indexOf("4:") + 2, prizesString.indexOf("5:")).trim();
        String[] fourthPrizeParts = fourthPrizeString.split("-");
        String[] fourthPrize = new String[7];
        for (int i = 0; i < fourthPrizeParts.length; i++) {
            fourthPrize[i] = fourthPrizeParts[i].trim();
        }
        return fourthPrize;
    }
    public String getFifthPrize() {
        String fifthPrizeString = prizesString.substring(prizesString.indexOf("5:") + 2, prizesString.indexOf("6:")).trim();
        return fifthPrizeString;
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
    public String getSeventhPrize() {
        String seventhPrizeString = prizesString.substring(prizesString.indexOf("7:") + 2, prizesString.indexOf("8:")).trim();
        return seventhPrizeString;
    }
    public String getEightthPrize() {
        String seventhPrizeString = prizesString.substring(prizesString.indexOf("8:") + 2).trim();
        return seventhPrizeString;
    }
    public static void main(String[] args) {
        String rs = "ĐB: 745698 1: 15996 2: 50030 3: 33524 - 13895 4: 10879 - 10015 - 44077 - 01740 - 36820 - 72476 - 08004 5: 3359 6: 7858 - 8481 - 4320 7: 9378: 23";
        GetKQXS parser = new GetKQXS(rs);
        String GDB = String.valueOf(parser.getSpecialPrize());
        String G1 = String.valueOf(parser.getFirstPrize());
        String G2 = String.valueOf(parser.getSecondPrize());
        String G3 = String.valueOf(parser.getThirdPrize());
        String G4 = String.valueOf(parser.getFourthPrize());
        String G5 = String.valueOf(parser.getFifthPrize());
        String G6 = String.valueOf(parser.getSixthPrize());
        String G7 = String.valueOf(parser.getSeventhPrize());
        String G8 = String.valueOf(parser.getEightthPrize());
        System.out.print(G8);
        System.out.print(G7);
        System.out.print(G6);
        System.out.print(G5);
        System.out.print(G4);
        System.out.print(G3);
        System.out.print(G2);
        System.out.print(G1);
        System.out.print(GDB);

    }
}
