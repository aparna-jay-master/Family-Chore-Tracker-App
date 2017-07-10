package com.example.android.familyweeklychoretracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.familyweeklychoretracker.data.ChoreContract.ChoreEntry;

/**
 * DB helper for Chore
 */

public class ChoreDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FamilyToDo.db";

    //Constructor
    public ChoreDbHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create chores table
        String SQL_CREATE_CHORES_TABLE = "CREATE TABLE " + ChoreEntry.TABLE_NAME + "("
                + ChoreEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ChoreEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + ChoreEntry.COLUMN_WEEK + " INTEGER NOT NULL, "
                + ChoreEntry.COLUMN_CHORE_DONE + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_CHORES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
