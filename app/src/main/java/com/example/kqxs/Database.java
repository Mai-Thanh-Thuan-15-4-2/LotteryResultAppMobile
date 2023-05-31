package com.example.kqxs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ticket_database";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_TICKETS = "tickets";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SO_TRUNG_THUONG = "so_trung_thuong";
    private static final String COLUMN_SO_LUONG_VE = "so_luong_ve";
    private static final String COLUMN_LOAI_XO_SO = "loai_xo_so";
    private static final String COLUMN_NGAY_XO = "ngay_xo";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng TICKETS
        String createTableQuery = "CREATE TABLE " + TABLE_TICKETS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SO_TRUNG_THUONG + " TEXT,"
                + COLUMN_SO_LUONG_VE + " INTEGER,"
                + COLUMN_LOAI_XO_SO + " TEXT,"
                + COLUMN_NGAY_XO + " TEXT "
                + ")";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xóa bảng TICKETS nếu tồn tại và tạo lại
        String dropTableQuery = "DROP TABLE IF EXISTS " + TABLE_TICKETS;
        db.execSQL(dropTableQuery);
        onCreate(db);
    }

    public void addTicket(TicketModel ticket) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SO_TRUNG_THUONG, ticket.getSoTrungThuong());
        values.put(COLUMN_SO_LUONG_VE, ticket.getSoLuongVe());
        values.put(COLUMN_LOAI_XO_SO, ticket.getLoaiXoSo());
        values.put(COLUMN_NGAY_XO, formatDate(ticket.getNgayXo()));
        db.insert(TABLE_TICKETS, null, values);
        db.close();
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(date);
    }

    public List<TicketModel> getAllTickets() {
        List<TicketModel> ticketList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_TICKETS, null);

        if (cursor.moveToFirst()) {
            do {
                String soTrungThuong = cursor.getString(1);
                int soLuongVe = cursor.getInt(2);
                String loaiXoSo = cursor.getString(3);
                String ngayXo= cursor.getString(4);
                String[] dateArr = ngayXo.split("-");
                int day = Integer.parseInt(dateArr[2]);
                int month = Integer.parseInt(dateArr[1]);
                int year = Integer.parseInt(dateArr[0]);
                TicketModel ticket = new TicketModel(soTrungThuong, soLuongVe, loaiXoSo, new Date(year,month,day));
                ticketList.add(ticket);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return ticketList;
    }

}
