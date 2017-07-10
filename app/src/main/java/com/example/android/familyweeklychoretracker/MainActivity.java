package com.example.android.familyweeklychoretracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.familyweeklychoretracker.data.ChoreContract.ChoreEntry;
import com.example.android.familyweeklychoretracker.data.ChoreDbHelper;

public class MainActivity extends AppCompatActivity {

    private ChoreDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO I don't think I actually need this so remember to remove
        //mDbHelper = new ChoreDbHelper(this);
    }

    //TODO do I need onStart method?

    private void createChoreCursor () {
        //instantiate subclass of SQLiteOpenHelper and pass context
        ChoreDbHelper mDbHelper = new ChoreDbHelper(this);

        //Create/open database to read from
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        //Define projection
        String[] projection = {
                ChoreEntry.COLUMN_NAME,
                ChoreEntry.COLUMN_WEEK,
                ChoreEntry.COLUMN_CHORE_DONE
        };

        //Cursor
        Cursor cursor = db.query(
                ChoreEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);

        cursor.close();
        }

    //insert method
    private void insertChore () {
        //Get database in write more
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        //Create a map of new values
        ContentValues values = new ContentValues();
        values.put(ChoreEntry.COLUMN_NAME, "Mom");
        values.put(ChoreEntry.COLUMN_WEEK, ChoreEntry.WEEK_SUNDAY);
        values.put(ChoreEntry.COLUMN_CHORE_DONE, "Mowed Lawn");

        //Insert new row and return primary key value
        long newRowId = db.insert(ChoreEntry.TABLE_NAME, null, values);
        Log.v("MainActivity", "New row ID" + newRowId);
    }
}
