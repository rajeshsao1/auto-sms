package com.autosms.myapplicationcallevent.BlockContact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.autosms.myapplicationcallevent.FreqModel;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "11zon";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "tbl_notes";
    public static final String TABLE_NAME1 = "tbl_frequency";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tbl_notes(ID INTEGER PRIMARY KEY, mob TEXT)");
        db.execSQL("CREATE TABLE tbl_frequency(ID INTEGER PRIMARY KEY, mob1 TEXT,dt TEXT)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbl_notes");
        db.execSQL("DROP TABLE IF EXISTS tbl_frequency");
        onCreate(db);
    }

    public void addNotes(String title) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("mob", title);
        sqLiteDatabase.insert(TABLE_NAME, (String) null, values);
        sqLiteDatabase.close();
    }

    public void addFrequency(String mob1) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("INSERT INTO tbl_frequency (mob1, dt) VALUES ('9503470133', datetime('now'))");
        sqLiteDatabase.close();
    }

    public ArrayList<NoteModel> getNotes() {
        ArrayList<NoteModel> arrayList = new ArrayList<>();
        Cursor cursor = getWritableDatabase().rawQuery("SELECT *FROM tbl_notes", (String[]) null);
        if (cursor.moveToFirst()) {
            do {
                NoteModel noteModel = new NoteModel();
                noteModel.setID(cursor.getString(0));
                noteModel.setTitle(cursor.getString(1));
                arrayList.add(noteModel);
            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    public ArrayList<FreqModel> getFreq() {
        ArrayList<FreqModel> arrayList = new ArrayList<>();
        Cursor cursor = getWritableDatabase().rawQuery("SELECT *FROM tbl_frequency", (String[]) null);
        if (cursor.moveToFirst()) {
            do {
                FreqModel freqModel = new FreqModel();
                freqModel.setID(cursor.getString(0));
                freqModel.setMob(cursor.getString(1));
                freqModel.setDt(Long.valueOf(cursor.getLong(2)));
                arrayList.add(freqModel);
            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    public void delete(String ID) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, "ID=" + ID, (String[]) null);
        sqLiteDatabase.close();
    }

    public void updateNote(String title, String ID) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("mob", title);
        sqLiteDatabase.update(TABLE_NAME, values, "ID=" + ID, (String[]) null);
        sqLiteDatabase.close();
    }
}
