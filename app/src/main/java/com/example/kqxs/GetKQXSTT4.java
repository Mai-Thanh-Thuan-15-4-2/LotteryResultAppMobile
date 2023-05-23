package com.example.kqxs;

public class GetKQXSTT4 {
    private final String prizesString;
    public GetKQXSTT4(String prizesString) {
        this.prizesString = prizesString;
    }
    public String getSet1Prize() {
        String set1PrizeString = prizesString.substring(prizesString.indexOf("1:") + 2, prizesString.indexOf("1:") + 7).trim();
        return set1PrizeString;
    }
}
