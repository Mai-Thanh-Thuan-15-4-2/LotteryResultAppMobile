package com.example.kqxs;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseCus extends SQLiteOpenHelper {
    private static final String B_DB = ".db";
    private static final int DATABASE_VERSION = 1;
    public static final String TAB_NAME = "customers";
    public static final String COLUMN_ID = "idcus";
    public static final String COLUMN_HOTEN = "hoten";
    public static final String COLUMN_SDT = "sdt";
    public static final String COLUMN_DC = "diachi";
    public static final String COLUMN_SLM = "soluongmua";
    public static final String COLUMN_SM = "sodatmua";
    private Context mContext;

    public DatabaseCus(Context context) {
        super(context, B_DB, null, DATABASE_VERSION);
        mContext = context;
    }

    public void deleteAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TAB_NAME, null, null);
        db.close();
    }

    public void insertData(SQLiteDatabase db, String hoTen, String sdt, String diachi, String soLuongmua, String soDatmua) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_HOTEN, hoTen);
        values.put(COLUMN_SDT, sdt);
        values.put(COLUMN_DC, diachi);
        values.put(COLUMN_SLM, soLuongmua);
        values.put(COLUMN_SM, soDatmua);
        db.insert(TAB_NAME, null, values);
    }
    public void updateData(SQLiteDatabase db, int rowId, String hoTen, String sdt, String diachi, String soLuongmua, String soDatmua) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_HOTEN, hoTen);
        values.put(COLUMN_SDT, sdt);
        values.put(COLUMN_DC, diachi);
        values.put(COLUMN_SLM, soLuongmua);
        values.put(COLUMN_SM, soDatmua);
        String selection = COLUMN_ID + "=?";
        String[] selectionArgs = {String.valueOf(rowId)};
        db.update(TAB_NAME, values, selection, selectionArgs);
    }

    @SuppressLint("Range")
    public List<CustomerModel> getAllCus() {
        List<CustomerModel> vesoList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TAB_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                CustomerModel cus = new CustomerModel();
                cus.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                cus.setHoten(cursor.getString(cursor.getColumnIndex(COLUMN_HOTEN)));
                cus.setSdt(cursor.getString(cursor.getColumnIndex(COLUMN_SDT)));
                cus.setDiachi(cursor.getString(cursor.getColumnIndex(COLUMN_DC)));
                cus.setSoluongmua(cursor.getInt(cursor.getColumnIndex(COLUMN_SLM)));
                cus.setSodatmua(cursor.getInt(cursor.getColumnIndex(COLUMN_SM)));
                vesoList.add(cus);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return vesoList;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS " + TAB_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_HOTEN + " TEXT, " +
                COLUMN_SDT + " TEXT, " +
                COLUMN_DC + " TEXT, " +
                COLUMN_SLM + " TEXT, " +
                COLUMN_SM + " INTEGER" +
                ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            String query = "ALTER TABLE " + TAB_NAME + " ADD COLUMN new_column_2 INTEGER DEFAULT 0";
            db.execSQL(query);
        }
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
