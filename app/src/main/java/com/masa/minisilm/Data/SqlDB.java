package com.masa.minisilm.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import java.util.ArrayList;

public class SqlDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "minislam.db";
    private static final int DATABASE_VERSION = 1;

    public SqlDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String noteQ = "CREATE TABLE noteList ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "title TEXT,"
                + "des TEXT"
                + ")";
        db.execSQL(noteQ);

        createTable(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if EXISTS taskList");
        createTable(db);
        db.execSQL("drop table if EXISTS noteList");
        createTable(db);
    }

    public ArrayList<DataSourse> getData() {
        ArrayList<DataSourse> array = new ArrayList();

            SQLiteDatabase sql = this.getReadableDatabase();
            Cursor cursor = sql.rawQuery("SELECT * FROM taskList", null);
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                array.add(new DataSourse(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getLong(3)));
                cursor.moveToNext();
            }
        return array;
    }

    public void createTable(SQLiteDatabase sql){

        String createTableQuery = "CREATE TABLE taskList ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "title TEXT,"
                + "des TEXT,"
                + "date TEXT"
                + ")";
        sql.execSQL(createTableQuery);
    }
    public ArrayList<NoteSourse> getDataNote() {
        ArrayList<NoteSourse> note = new ArrayList();

        SQLiteDatabase sql = this.getReadableDatabase();
        Cursor cursor = sql.rawQuery("SELECT * FROM noteList", null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            note.add(new NoteSourse(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)));

            cursor.moveToNext();
        }
        return note;
    }

    public void insertNote(String title, String des) {


        SQLiteDatabase sql;
        sql = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("des", des);


        sql.insert("noteList", null, values);

    }
    public void insert(String title, String des, Long date) {


            SQLiteDatabase sql;
            sql = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("title", title);
            values.put("des", des);
            values.put("date", date);

             sql.insert("taskList", null, values);

    }

    public void updateitem(String id, String title, String des, String date) {

        SQLiteDatabase sql = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("des", des);
        values.put("date", date);
        sql.update("taskList", null, "id?", new String[]{id});
    }

    public void deleteItem (String id){
        SQLiteDatabase sql = getWritableDatabase();
        sql.delete("taskList", "id?", new String[]{id});

    }

}
