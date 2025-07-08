package com.autosms.myapplicationcallevent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_dt = "dt";
    public static final String CONTACTS_COLUMN_no = "no1";
    public static final String CONTACTS_TABLE_NAME = "mycontacts";
    public static final String DATABASE_NAME = "contactdb.sqlite";
    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 3);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table mycontacts (id integer primary key autoincrement, no1 text,dt text)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS mycontacts");
        onCreate(db);
    }

    public boolean addStudentContact(String no, String dt1) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contantValues = new ContentValues();
        contantValues.put(CONTACTS_COLUMN_no, no);
        contantValues.put(CONTACTS_COLUMN_dt, dt1);
        db.insert(CONTACTS_TABLE_NAME, (String) null, contantValues);
        db.close();
        return true;
    }

    public int deletedata(String dt1) {
        return getWritableDatabase().delete(CONTACTS_TABLE_NAME, "dt!=?", new String[]{dt1});
    }

    public void deletetbl() {
        getWritableDatabase().execSQL("delete from mycontacts");
    }

    public Cursor getData() {
        return getWritableDatabase().rawQuery("Select * from mycontacts", (String[]) null);
    }

    public Cursor getDatawithqry(String no3, String dt1) {
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery("Select * from mycontacts where no1='" + no3 + "' AND dt='" + dt1 + "'", (String[]) null);
    }

    public int numberOfRows() {
        return (int) DatabaseUtils.queryNumEntries(getWritableDatabase(), CONTACTS_TABLE_NAME);
    }

    public ArrayList<String> getAllStudentContacts() {
        ArrayList<String> arraylist = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery("Select * from mycontacts", (String[]) null);
        if (cursor.moveToFirst()) {
            do {
                arraylist.add(cursor.getString(cursor.getColumnIndex(CONTACTS_COLUMN_no)));
            } while (cursor.moveToNext());
        }
        return arraylist;
    }
}
