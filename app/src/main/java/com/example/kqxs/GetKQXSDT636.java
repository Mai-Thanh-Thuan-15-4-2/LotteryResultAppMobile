package com.example.kqxs;


public class GetKQXSDT636 {
    private final String prizesString;
    public GetKQXSDT636(String prizesString) {
        this.prizesString = prizesString;
    }
    public String getSet1Prize() {
        String set1PrizeString = prizesString.substring(prizesString.indexOf("1:") + 2, prizesString.indexOf("1:") + 5).trim();
        return set1PrizeString;
    }
    public String getSet2Prize() {
        String set2PrizeString = prizesString.substring(prizesString.indexOf("2:") + 2, prizesString.indexOf("2:") + 5).trim();
        return set2PrizeString;
    }
    public String getSet3Prize() {
        String set3PrizeString = prizesString.substring(prizesString.indexOf("3:") + 2, prizesString.indexOf("3:") + 5).trim();
        return set3PrizeString;
    }
    public String getSet4Prize() {
        String set4PrizeString = prizesString.substring(prizesString.indexOf("4:") + 2, prizesString.indexOf("4:") + 5).trim();
        return set4PrizeString;
    }
    public String getSet5Prize() {
        String set5PrizeString = prizesString.substring(prizesString.indexOf("5:") + 2, prizesString.indexOf("5:") + 5).trim();
        return set5PrizeString;
    }
    public String getSet6Prize() {
        String set6PrizeString = prizesString.substring(prizesString.indexOf("6:") + 2, prizesString.indexOf("6:") + 5).trim();
        return set6PrizeString;
    }

}

