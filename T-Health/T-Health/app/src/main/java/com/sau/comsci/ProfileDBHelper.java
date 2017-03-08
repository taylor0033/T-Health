package com.sau.comsci;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import android.util.Log;

public class ProfileDBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "dbProfile";

    private static final String DB_CREATE = "" +
            "CREATE TABLE tbMyProfile (" +
            "id INTEGER PRIMARY KEY, " +
            "name TEXT NOT NULL, " +
            "age INTEGER NOT NULL," +
            "weight INTEGER NOT NULL, " +
            "height INTEGER NOT NULL, " +
            "sex TEXT NOT NULL);";


    public ProfileDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w(ProfileDBHelper.class.getName(),
                "Upgread database version from version" + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS tbMyProfile");
        onCreate(db);
    }
}