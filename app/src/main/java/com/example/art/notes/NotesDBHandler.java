package com.example.art.notes;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.renderscript.Sampler;

public class NotesDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "notes.db";
    private static final String TABLE_NOTESDB = "notesDB";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NOTE = "_noteEntry";

    public NotesDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = " CREATE TABLE " + TABLE_NOTESDB + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                COLUMN_NOTE + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTESDB);
        onCreate(db);
    }

    //Add new row to database
    public void addNote(NotesDB note){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOTE, note.get_noteEntry());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NOTESDB, null, values);
        db.close();
    }

    //Delete row from database
    public void deleteNote(String note){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + DATABASE_NAME + " WHERE " + COLUMN_NOTE + "=\"" + note + "\";");
    }

}
