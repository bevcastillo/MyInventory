package com.example.myinventory.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myinventory.Model.ItemModel;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    //your database
    public static final String DB_NAME = "item_db";

    //your table name
    public static final String TABLE_NAME = "tbl_items";

    //your table columns
    public static final String ITEM_ID = "item_id";
    public static final String ITEM_NAME = "item_name";
    public static final String ITEM_DESC = "item_desc";
    public static final String ITEM_CAT = "item_cat";

    //query to create table
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ITEM_NAME + " TEXT NOT NULL, "
            + ITEM_CAT + " TEXT NOT NULL, "
            + ITEM_DESC + " TEXT);";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //insert data to sqlitedatabase
    public void insertItem(ItemModel itemModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ITEM_NAME, itemModel.getItemName());
        cv.put(ITEM_DESC, itemModel.getItemDesc());
        cv.put(ITEM_CAT, itemModel.getItemCat());

        db.insert(TABLE_NAME, null, cv);
        db.close();
    }

    //display all items
    public ArrayList<ItemModel> getAll() {
        ArrayList<ItemModel> itemModelArrayList = new ArrayList<ItemModel>();

        String selectQuery = "SELECT * FROM "+ TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //looping through all the rows and adding them to the list
        if (cursor.moveToFirst()) {
            do {
                ItemModel itemModel = new ItemModel();
                itemModel.setItemId(cursor.getInt(cursor.getColumnIndex(ITEM_ID)));
                itemModel.setItemName(cursor.getString(cursor.getColumnIndex(ITEM_NAME)));
                itemModel.setItemDesc(cursor.getString(cursor.getColumnIndex(ITEM_DESC)));
                itemModel.setItemCat(cursor.getString(cursor.getColumnIndex(ITEM_CAT)));
                itemModelArrayList.add(itemModel);
            }while (cursor.moveToNext());
        }
        return itemModelArrayList;
    }
}
