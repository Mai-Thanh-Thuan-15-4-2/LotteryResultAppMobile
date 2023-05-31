package com.example.kqxs;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TicketModel implements Parcelable {
    private String soTrungThuong;
    private int soLuongVe;
    private String loaiXoSo;
    private Date ngayXo;
    private KQXSTicketModel kqxsModel;

    private String ketQuaXo = "Đang đợi";
    public TicketModel(String soTrungThuong, int soLuongVe, String loaiXoSo, Date ngayXo) {
        this.soTrungThuong = soTrungThuong;
        this.soLuongVe = soLuongVe;
        this.loaiXoSo = loaiXoSo;
        this.ngayXo = ngayXo;
    }

    public TicketModel(String soTrungThuong, int soLuongVe, String loaiXoSo, Date ngayXo, KQXSTicketModel kqxsModel) {
        this.soTrungThuong = soTrungThuong;
        this.soLuongVe = soLuongVe;
        this.loaiXoSo = loaiXoSo;
        this.ngayXo = ngayXo;
        this.kqxsModel = kqxsModel;
    }

    protected TicketModel(Parcel in) {
        soTrungThuong = in.readString();
        soLuongVe = in.readInt();
        loaiXoSo = in.readString();
        ngayXo = new Date(in.readLong());
        kqxsModel = in.readParcelable(KQXSTicketModel.class.getClassLoader());
    }

    public TicketModel() {
    }

    public String getSoTrungThuong() {
        return soTrungThuong;
    }

    public void setSoTrungThuong(String soTrungThuong) {
        this.soTrungThuong = soTrungThuong;
    }

    public int getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(int soLuongVe) {
        this.soLuongVe = soLuongVe;
    }

    public String getLoaiXoSo() {
        return loaiXoSo;
    }

    public void setLoaiXoSo(String loaiXoSo) {
        this.loaiXoSo = loaiXoSo;
    }

    public Date getNgayDo() {
        return ngayXo;
    }

    public String getNgayXoString(){
        int day = ngayXo.getDate();
        int month = ngayXo.getMonth();
        String dayString = "";
        String monthString = "";

        if(day < 10){
            dayString = "0" + day;
        }else{
            dayString = ngayXo.getDate()+ "" ;
        }

        if(month < 10){
            monthString = "0" + month;
        }else{
            monthString = "" + ngayXo.getMonth();
        }
        String ngayXoString = dayString +"/"+ monthString;
        return ngayXoString;
    }

    public Date getNgayXo() {
        return ngayXo;
    }

    public void setNgayXo(Date ngayXo) {
        this.ngayXo = ngayXo;
    }

    public KQXSTicketModel getKqxsModel() {
        return kqxsModel;
    }

    public void setKqxsModel(KQXSTicketModel kqxsModel) {
        this.kqxsModel = kqxsModel;
    }

    public void setNgayDo(Date ngayXo) {
        this.ngayXo = ngayXo;
    }


    public String getKetQuaXo() {
        return ketQuaXo;
    }

    public void setKetQuaXo(String ketQuaXo) {
        this.ketQuaXo = ketQuaXo;
    }

    @Override
    public String toString() {
        return "TicketModel{" +
                "soTrungThuong='" + soTrungThuong + '\'' +
                ", soLuongVe=" + soLuongVe +
                ", loaiXoSo='" + loaiXoSo + '\'' +
                ", ngayXo=" + ngayXo +
                ", kqxsModel=" + kqxsModel +
                ", ketQuaXo='" + ketQuaXo + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(soTrungThuong);
        parcel.writeInt(soLuongVe);
        parcel.writeString(loaiXoSo);
        parcel.writeLong(ngayXo.getTime());
        parcel.writeParcelable(kqxsModel, i);
    }

    public static final Parcelable.Creator<TicketModel> CREATOR = new Parcelable.Creator<TicketModel>() {
        @Override
        public TicketModel createFromParcel(Parcel source) {
            return new TicketModel(source);
        }

        @Override
        public TicketModel[] newArray(int size) {
            return new TicketModel[size];
        }
    };
}
