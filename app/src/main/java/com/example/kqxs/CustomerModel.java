package com.example.kqxs;

public class CustomerModel {
    private int id;
    private String hoten;
    private String sdt;
    private String diachi;
    private int soluongmua;
    private int sodatmua;

    public CustomerModel() {
        this.id = id;
        this.hoten = hoten;
        this.sdt = sdt;
        this.diachi = diachi;
        this.soluongmua = soluongmua;
        this.sodatmua = sodatmua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getSoluongmua() {
        return soluongmua;
    }

    public void setSoluongmua(int soluongmua) {
        this.soluongmua = soluongmua;
    }

    public int getSodatmua() {
        return sodatmua;
    }

    public void setSodatmua(int sodatmua) {
        this.sodatmua = sodatmua;
    }
}
