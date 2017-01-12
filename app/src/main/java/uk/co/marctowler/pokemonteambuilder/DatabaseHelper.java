package uk.co.marctowler.pokemonteambuilder;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.InputStream;

/**
 * Created by MarcT on 11/01/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "typeChart.db";
    private final Context myContext;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, context.getResources().getInteger(R.string.databaseVersion));
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            InputStream is = myContext.getResources().getAssets().open("create_database.sql");

            String[] statements = FileHelper.parseSqlFile(is);

            for (String statement : statements) {
                db.execSQL(statement);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        try {
            InputStream is = myContext.getResources().getAssets().open("upgrade_database.sql");

            String[] statements = FileHelper.parseSqlFile(is);

            for (String statement : statements) {
                db.execSQL(statement);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Cursor queryOne(String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("SELECT type1, type2 FROM pokemon WHERE name = ?",
                new String[]{name});

        return res;
    }
}