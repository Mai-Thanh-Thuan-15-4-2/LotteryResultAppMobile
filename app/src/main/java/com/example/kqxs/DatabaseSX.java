package com.example.kqxs;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSX extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "kqxsdb.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "kqsxsdb";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_VALUE = "value";

    public DatabaseSX(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void insertData(String value) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_VALUE, value);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    @SuppressLint("Range")
    public List<XSDB> getAllKQXS() {
        List<XSDB> kqxsList = new ArrayList<>();
        String selectQuery = " SELECT *  FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                XSDB kqxs = new XSDB();
                kqxs.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                kqxs.setValue(cursor.getString(cursor.getColumnIndex(COLUMN_VALUE)));
                kqxsList.add(kqxs);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return kqxsList;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_VALUE + " TEXT" +
                ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            String query = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN new_column TEXT";
            db.execSQL(query);
        }

    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}