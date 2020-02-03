package com.example.myinventory.DatabaseManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.myinventory.Helper.DatabaseHelper;

public class DBManager {

    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase sqLiteDatabase;

    public DBManager(Context context) {
        this.context = context;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    //inserting data to database table
    public void insert(String name, String desc, String category) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.ITEM_NAME, name);
        contentValues.put(DatabaseHelper.ITEM_DESC, desc);
        contentValues.put(DatabaseHelper.ITEM_CAT, category);
        sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper.ITEM_ID,
                                          DatabaseHelper.ITEM_NAME,
                                          DatabaseHelper.ITEM_DESC,
                                          DatabaseHelper.ITEM_CAT };
        Cursor cursor = sqLiteDatabase.query(DatabaseHelper.TABLE_NAME, columns,
                                        null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;

    }
}
