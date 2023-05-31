package com.example.kqxs;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseVS extends SQLiteOpenHelper {
    private static final String B_DB = ".db";
    private static final int DATABASE_VERSION = 1;
    public static final String TAB_NAME = "banvesoonline";
    public static final String COLUMN_ID = "idvs";
    public static final String COLUMN_DAYSO = "dayso";
    public static final String COLUMN_TENTINH = "tenhtinh";
    public static final String COLUMN_NGAYXO = "ngayxo";
    public static final String COLUMN_SOLUONG = "soluong";
    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_DATA_INSERTED = "data_inserted";
    private Context mContext;

    public DatabaseVS(Context context) {
        super(context, B_DB, null, DATABASE_VERSION);
        mContext = context;
    }

    public void deleteAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TAB_NAME, null, null);
        db.close();
    }

    public void insertData(SQLiteDatabase db, String daySo, String tenTinh, String ngayXo, String soLuong) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_DAYSO, daySo);
        values.put(COLUMN_TENTINH, tenTinh);
        values.put(COLUMN_NGAYXO, ngayXo);
        values.put(COLUMN_SOLUONG, soLuong);
        db.insert(TAB_NAME, null, values);
    }
    public void updateData(SQLiteDatabase db, int rowId, String daySo, String tenTinh, String ngayXo, String soLuong) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_DAYSO, daySo);
        values.put(COLUMN_TENTINH, tenTinh);
        values.put(COLUMN_NGAYXO, ngayXo);
        values.put(COLUMN_SOLUONG, soLuong);
        String selection = COLUMN_ID + "=?";
        String[] selectionArgs = {String.valueOf(rowId)};
        db.update(TAB_NAME, values, selection, selectionArgs);
    }

    @SuppressLint("Range")
    public List<VesoModel> getAllveso() {
        List<VesoModel> vesoList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TAB_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                VesoModel veso = new VesoModel();
                veso.setMavs(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                veso.setDayso(cursor.getString(cursor.getColumnIndex(COLUMN_DAYSO)));
                veso.setTentinh(cursor.getString(cursor.getColumnIndex(COLUMN_TENTINH)));
                veso.setNgayxo(cursor.getString(cursor.getColumnIndex(COLUMN_NGAYXO)));
                veso.setSoluong(cursor.getInt(cursor.getColumnIndex(COLUMN_SOLUONG)));
                vesoList.add(veso);
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
                COLUMN_DAYSO + " TEXT, " +
                COLUMN_TENTINH + " TEXT, " +
                COLUMN_NGAYXO + " TEXT, " +
                COLUMN_SOLUONG + " INTEGER" +
                ")";
        db.execSQL(query);
        SharedPreferences prefs = mContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        boolean dataInserted = prefs.getBoolean(KEY_DATA_INSERTED, false);
        if (!dataInserted) {
            insertData(db, "999999", "TP HCM", "2023-06-01", "10");
            insertData(db, "234567", "Long An", "2023-06-01", "9");
            insertData(db, "456678", "Bình Dương", "2023-06-01", "2");
            insertData(db, "456787", "Đồng Tháp", "2023-06-01", "1");
            insertData(db, "435673", "Vũng Tàu", "2023-06-01", "2");
            insertData(db, "111111", "Sóc Trăng", "2023-06-01", "1");
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(KEY_DATA_INSERTED, true);
            editor.apply();
        }
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
