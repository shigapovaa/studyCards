package ru.startandroid.study_cards001.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    //поля базы данных
    public static final String KEY_ROWID = "_id";
    public static final String KEY_LEVEL = "level";
    public static final String KEY_QUESTION = "question";
    public static final String KEY_ANSWER = "answer";
    //название базы данных
    public static final String DATABASE_TABLE = "studycards";
    //версия базы данных
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_TABLE, null, DATABASE_VERSION);
    }

    //создание базы данных
    @Override
    public void onCreate(SQLiteDatabase database) {
        String DATABASE_CREATE = "create table " + DATABASE_TABLE + " (" + KEY_ROWID + " integer primary key autoincrement, "
                + KEY_LEVEL + " integer not null, " + KEY_QUESTION + " text not null, " + KEY_ANSWER + " text not null);";
        database.execSQL(DATABASE_CREATE);
    }

    //обновление базы данных
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(database);
    }
}