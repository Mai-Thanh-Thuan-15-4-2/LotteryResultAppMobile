package com.example.kqxs;

public class GetKQXSDT123 {
    private final String prizesString;
    public GetKQXSDT123(String prizesString) {
        this.prizesString = prizesString;
    }
    public String getSet1Prize() {
        String set1PrizeString = prizesString.substring(prizesString.indexOf("1:") + 2, prizesString.indexOf("1:") + 4).trim();
        return set1PrizeString;
    }
    public String getSet2Prize() {
        String set2PrizeString = prizesString.substring(prizesString.indexOf("2:") + 2, prizesString.indexOf("2:") + 5).trim();
        return set2PrizeString;
    }
    public String getSet3Prize() {
        String set3PrizeString = prizesString.substring(prizesString.indexOf("3:") + 2, prizesString.indexOf("3:") + 6).trim();
        return set3PrizeString;
    }

    public static void main(String[] args) {
        String rs = "Bộ số 1: 9 Bộ số 2: 48 Bộ số 3: 134";
        GetKQXSDT123 parser = new GetKQXSDT123(rs);
        String G1 = String.valueOf(parser.getSet1Prize());
        System.out.println(G1);
    }
}
