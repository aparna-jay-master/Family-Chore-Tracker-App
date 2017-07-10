package com.example.android.familyweeklychoretracker.data;

import android.provider.BaseColumns;

/**
 * Contract for Chores
 */

public class ChoreContract {

    public static final class ChoreEntry implements BaseColumns {

        //Table name
        public static final String TABLE_NAME = "chores";

        //Columns
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_WEEK = "day_of_week";
        public static final String COLUMN_CHORE_DONE = "chore";

        //Possible values for day of week
        public static final int WEEK_SUNDAY = 0;
        public static final int WEEK_MONDAY = 1;
        public static final int WEEK_TUESDAY = 2;
        public static final int WEEK_WEDNESDAY = 3;
        public static final int WEEK_THURSDAY = 4;
        public static final int WEEK_FRIDAY = 5;
        public static final int WEEK_SATURDAY = 6;
    }
}
