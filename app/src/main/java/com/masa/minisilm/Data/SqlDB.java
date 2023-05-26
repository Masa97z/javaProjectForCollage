package com.masa.minisilm.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class SqlDB extends SQLiteOpenHelper {

    public static final String DataBaseName = "task.db";

    public SqlDB(Context ctx) {
        super(ctx, DataBaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    createTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if EXISTS TASK");
        onCreate(db);
    }
    private void createTable() {
        SQLiteDatabase sql = getWritableDatabase();
        String createTableQuery = "CREATE TABLE IF NOT EXISTS TASK ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "title TEXT,"
                + "des TEXT,"
                + "date TEXT"
                + ")";
        sql.execSQL(createTableQuery);
        sql.close(); // Close the database connection
    }

    public ArrayList<DataSourse> getData() {
        ArrayList<DataSourse> array = new ArrayList();
        SQLiteDatabase sql = this.getReadableDatabase();
        Cursor cursor = sql.rawQuery("SELECT * FROM TASK", null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            array.add(new DataSourse(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)));
            cursor.moveToNext();
        }
        return array;
    }

    public String insert(String title, String des, String date) {
        createTable(); // Create the table if it doesn't exist
        SQLiteDatabase sql = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("des", des);
        values.put("date", date);
        long res = sql.insert("TASK", null, values);
        sql.close(); // Close the database connection
        if (res == -1) {
            return "Error";
        } else {
            return "Insert Table";
        }
    }

    public void update(String id, String title, String des, String date) {

        SQLiteDatabase sql = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("des", des);
        values.put("date", date);
        sql.update("TASK", null, "id?", new String[]{id});
    }

    public void deleteItem (String id){
        SQLiteDatabase sql = getWritableDatabase();
        sql.delete("TASK", "id?", new String[]{id});

    }


}
