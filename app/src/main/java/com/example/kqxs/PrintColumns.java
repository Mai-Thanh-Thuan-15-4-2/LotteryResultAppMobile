package com.example.kqxs;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class PrintColumns {
    private static final String TAG = "PrintColumns";

    public static void printColumns(DatabaseSX dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] columns = {DatabaseSX.COLUMN_ID, DatabaseSX.COLUMN_VALUE};
        Cursor cursor = db.query(DatabaseSX.TABLE_NAME, columns, null, null, null, null, null);

        int idIndex = cursor.getColumnIndex(DatabaseSX.COLUMN_ID);
        int valueIndex = cursor.getColumnIndex(DatabaseSX.COLUMN_VALUE);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(idIndex);
            String value = cursor.getString(valueIndex);
            Log.d(TAG, "ID: " + id + ", value: " + value);
        }

        cursor.close();
        db.close();
    }
}
