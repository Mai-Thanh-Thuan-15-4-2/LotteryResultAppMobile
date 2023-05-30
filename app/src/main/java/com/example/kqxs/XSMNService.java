package com.example.kqxs;

import java.util.Arrays;

public class XSMNService {
    private static String describe = "";
    private static String titleTinh1 = "";
    private static String titleTinh2 = "";
    private static String titleTinh3 = "";
    private static String g8Tinh1 = "";
    private static String g7Tinh1 = "";
    private static String g6Tinh1 = "";
    private static String g5Tinh1 = "";
    private static String g4Tinh1 = "";
    private static String g3Tinh1 = "";
    private static String g2Tinh1 = "";
    private static String g1Tinh1 = "";
    private static String gDBTinh1 = "";

    private static String g8Tinh2 = "";
    private static String g7Tinh2 = "";
    private static String g6Tinh2 = "";
    private static String g5Tinh2 = "";
    private static String g4Tinh2 = "";
    private static String g3Tinh2 = "";
    private static String g2Tinh2 = "";
    private static String g1Tinh2 = "";
    private static String gDBTinh2 = "";

    private static String g8Tinh3 = "";
    private static String g7Tinh3 = "";
    private static String g6Tinh3 = "";
    private static String g5Tinh3 = "";
    private static String g4Tinh3 = "";
    private static String g3Tinh3 = "";
    private static String g2Tinh3 = "";
    private static String g1Tinh3 = "";
    private static String gDBTinh3 = "";

    public XSMNService(String describe) {
        this.describe = describe;
    }

    public static void prepareData(){
        String[] resultsByProvince = describe.split("\\[");
        resultsByProvince = Arrays.copyOfRange(resultsByProvince, 1, resultsByProvince.length);

        String[] provinceResults = new String[resultsByProvince.length];
        for (int i = 0; i < resultsByProvince.length; i++) {
            String provinceResult = resultsByProvince[i];
            System.out.println(provinceResult);
            int titleEndIndex = provinceResult.indexOf("]");
            String title = provinceResult.substring(0, titleEndIndex);
            // Tách các giải thưởng
            if(i == 0){
                titleTinh1 = title;
                g8Tinh1 = getPrizeResult(provinceResult, "8:");
                g7Tinh1 = getPrizeResult(provinceResult, "7:");
                g6Tinh1 = getPrizeResult(provinceResult, "6:");
                g5Tinh1 = getPrizeResult(provinceResult, "5:");
                g4Tinh1 = getPrizeResult(provinceResult, "4:");
                g3Tinh1 = getPrizeResult(provinceResult, "3:");
                g2Tinh1 = getPrizeResult(provinceResult, "2:");
                g1Tinh1 = getPrizeResult(provinceResult, "1:");
                gDBTinh1 = getPrizeResult(provinceResult, "ĐB:");
            }else if(i==1){
                titleTinh2 = title;
                g8Tinh2 = getPrizeResult(provinceResult, "8:");
                g7Tinh2 = getPrizeResult(provinceResult, "7:");
                g6Tinh2 = getPrizeResult(provinceResult, "6:");
                g5Tinh2 = getPrizeResult(provinceResult, "5:");
                g4Tinh2 = getPrizeResult(provinceResult, "4:");
                g3Tinh2 = getPrizeResult(provinceResult, "3:");
                g2Tinh2 = getPrizeResult(provinceResult, "2:");
                g1Tinh2 = getPrizeResult(provinceResult, "1:");
                gDBTinh2 = getPrizeResult(provinceResult, "ĐB:");
            }else{
                titleTinh3 = title;
                g8Tinh3 = getPrizeResult(provinceResult, "8:");
                g7Tinh3 = getPrizeResult(provinceResult, "7:");
                g6Tinh3 = getPrizeResult(provinceResult, "6:");
                g5Tinh3 = getPrizeResult(provinceResult, "5:");
                g4Tinh3 = getPrizeResult(provinceResult, "4:");
                g3Tinh3 = getPrizeResult(provinceResult, "3:");
                g2Tinh3 = getPrizeResult(provinceResult, "2:");
                g1Tinh3 = getPrizeResult(provinceResult, "1:");
                gDBTinh3 = getPrizeResult(provinceResult, "ĐB:");
            }
        }
    }

    public String formatPrize(String prize){
        String result = "";
        String[] arrays = prize.split(" - ");
        for(String array : arrays){
            result += array +"\n";
        }
        return result;
    }

    public static String getPrizeResult(String provinceResult, String prizeName) {
        int startIndex = provinceResult.indexOf(prizeName);
        if (startIndex == -1) {
            return ""; // Không tìm thấy giải thưởng, trả về chuỗi rỗng
        }

        startIndex += prizeName.length() + 1; // Điểm bắt đầu của giải thưởng
        String endString = "";

        if(prizeName.equals("1:")){
            endString = "2:";
        }else if(prizeName.equals("2:")){
            endString = "3:";
        }else if(prizeName.equals("3:")){
            endString = "4:";
        }else if(prizeName.equals("4:")){
            endString = "5:";
        }else if(prizeName.equals("5:")){
            endString = "6:";
        }else if(prizeName.equals("6:")){
            endString = "7:";
        }else if(prizeName.equals("7:")){
            endString = "8:";
        }else if(prizeName.equals("8:")){
            endString = " ";
        }else{
            endString = "1:";
        }
        int endIndex = provinceResult.indexOf(endString, startIndex); // Điểm kết thúc của giải thưởng
        if (endIndex == -1) {
            endIndex = provinceResult.length(); // Nếu không tìm thấy , lấy đến cuối chuỗi
        }
        return provinceResult.substring(startIndex, endIndex);
    }

    public String getNameTinh1(){
        return titleTinh1;
    }

    public String getNameTinh2(){
        return titleTinh2;
    }

    public String getNameTinh3(){
        return titleTinh3;
    }


    public String getSpecialPrizeTinh1() {
        return gDBTinh1;
    }

    public  String getFirstPrizeTinh1() {
        return g1Tinh1;
    }

    public String getSecondPrizeTinh1() {
        return g2Tinh1;
    }

    public  String getThirdPrizeTinh1() {
        return formatPrize(g3Tinh1);
    }

    public  String getFourthPrizeTinh1() {
        return formatPrize(g4Tinh1);
    }

    public static String getFifthPrizeTinh1() {
        return g5Tinh1;
    }

    public String getSixthPrizeTinh1() {
        return formatPrize(g6Tinh1);
    }

    public String getSeventhPrizeTinh1() {
        return g7Tinh1;
    }

    public String getEighthPrizeTinh1() {
        return g8Tinh1;
    }


    public String getSpecialPrizeTinh2() {
        return gDBTinh2;
    }

    public String getFirstPrizeTinh2() {
        return g1Tinh2;
    }

    public String getSecondPrizeTinh2() {
        return g2Tinh2;
    }

    public String getThirdPrizeTinh2() {
        return formatPrize(g3Tinh2);
    }

    public String getFourthPrizeTinh2() {
        return formatPrize(g4Tinh2);
    }

    public String getFifthPrizeTinh2() {
        return g5Tinh2;
    }

    public String getSixthPrizeTinh2() {
        return formatPrize(g6Tinh2);
    }

    public String getSeventhPrizeTinh2() {
        return g7Tinh2;
    }

    public String getEighthPrizeTinh2() {
        return g8Tinh2;
    }

    public String getSpecialPrizeTinh3() {
        return gDBTinh3;
    }

    public String getFirstPrizeTinh3() {
        return g1Tinh3;
    }

    public String getSecondPrizeTinh3() {
        return g2Tinh3;
    }

    public String getThirdPrizeTinh3() {
        return formatPrize(g3Tinh3);
    }

    public String getFourthPrizeTinh3() {
        return formatPrize(g4Tinh3);
    }

    public String getFifthPrizeTinh3() {
        return g5Tinh3;
    }

    public String getSixthPrizeTinh3() {
        return formatPrize(g6Tinh3);
    }

    public String getSeventhPrizeTinh3() {
        return g7Tinh3;
    }

    public String getEighthPrizeTinh3() {
        return g8Tinh3;
    }
}
