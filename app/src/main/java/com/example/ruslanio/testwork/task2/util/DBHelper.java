package com.example.ruslanio.testwork.task2.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ruslanio on 27.08.2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "test_db";
    private static final int DB_VERSION = 1;
    private String query;

    public DBHelper(Context context, String query) {
        super(context, DB_NAME, null, DB_VERSION);
        this.query = query;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if (query != null) {
            db.execSQL(query);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
