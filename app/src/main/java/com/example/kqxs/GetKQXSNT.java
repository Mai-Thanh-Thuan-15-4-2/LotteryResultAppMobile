package com.example.kqxs;

public class GetKQXSNT {
    private String tenTinh;  // lưu thông tin tên tỉnh
    private String[] giaiThuong;  // lưu thông tin từng giải thưởng

    // Hàm khởi tạo class XSKT
    public GetKQXSNT(String xskt) {
        // Tách chuỗi theo ký tự "-"
        String[] xsktArray = xskt.split("-");

        // Duyệt từng phần tử của mảng kết quả
        for (int i = 0; i < xsktArray.length; i++) {
            String elem = xsktArray[i];

            // Nếu phần tử chứa ký tự "[", lấy thông tin tên tỉnh
            if (elem.contains("[")) {
                this.tenTinh = elem.substring(1, elem.length() - 1);  // bỏ ký tự "[" và "]"
            }

            // Nếu phần tử chứa ký tự "ĐB", lấy thông tin giải đặc biệt
            else if (elem.contains("ĐB")) {
                this.giaiThuong[0] = elem.substring(4).trim();  // bỏ ký tự "ĐB: "
            }

            // Nếu phần tử chứa ký tự ":", lấy thông tin giải từ 1 đến 7
            else if (elem.contains(":")) {
                String[] giaiArray = elem.split(":");
                int giai = Integer.parseInt(giaiArray[0].trim());
                this.giaiThuong[giai] = giaiArray[1].trim();
            }

            // Nếu phần tử ko chứa ký tự đặc biệt, ":", "[" thì bỏ qua
            else {
                continue;
            }
        }
    }

    // Hàm lấy tên tỉnh
    public String getTenTinh() {
        return this.tenTinh;
    }

    // Hàm lấy thông tin giải thưởng
    public String[] getGiaiThuong() {
        return this.giaiThuong;
    }
    public static void main(String[] args) {
        String xskt = "[Bình Định] ĐB: 714605 1: 66306 2: 37351 3: 57126 - 06197 4: 91191 - 39400 - 79968 - 67492 - 96767 - 32093 - 64208 5: 1427 6: 5898 - 3101 - 9550 7: 4888: 46 [Quảng Bình] ĐB: 658883 1: 15353 2: 77493 3: 22318 - 01594 4: 40034 - 40280 - 63232 - 09258 - 95895 - 92799 - 96679 5: 4436 6: 3157 - 6861 - 9312 7: 1958: 40 [Quảng Trị] ĐB: 396689 1: 88251 2: 15796 3: 20675 - 85555 4: 15111 - 19521 - 61750 - 38811 - 66724 - 64631 - 41273 5: 1084 6: 3160 - 9534 - 2448 7: 3958: 36";

        // Khởi tạo đối tượng XSKT
        GetKQXSNT xsktObj = new GetKQXSNT(xskt);

        String[] giaiThuong = xsktObj.getGiaiThuong();

        // In từng giải thưởng ra
        for (int i = 0; i < giaiThuong.length; i++) {
            if (giaiThuong[i] != null) {
                System.out.println("Giải " + i + ": " + giaiThuong[i]);
            }
        }
    }

}
