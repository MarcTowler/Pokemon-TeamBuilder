package uk.co.marctowler.pokemonteambuilder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MarcT on 11/01/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "typeChart.db";
    public static final String TABLE_NAME    = "pokemon";
    public static final String Col1 = "ID";
    public static final String Col2 = "NAME";
    public static final String Col3 = "Type 1";
    public static final String Col4 = "Type 2";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
