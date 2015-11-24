package ufcg.com.showtime.Data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import ufcg.com.showtime.Models.Event;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "MY_SAMPLE_SQLITE.db";

    private SQLiteDatabase mSQLiteDB;

    public MySQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mSQLiteDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(MySQLiteContract.SQL_CREATE_TABLE_EVENT);
        sqLiteDatabase.execSQL(MySQLiteContract.SQL_CREATE_TABLE_MUSICIAN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }


    // PUBLIC API PARA MANIPULAR O BANCO DE DADOS

    public boolean inserirEvento(String nome, String lugar, String banner) {
        this.getWritableDatabase().execSQL(
                MySQLiteContract.SQL_INSERT_EVENT_ENTRY,
                new Object[] {nome, lugar, banner});
        return true;

    }

    public List<Event> recuperarEventos() {
        Cursor cursor = this.mSQLiteDB.rawQuery(MySQLiteContract.SQL_SELECT_EVENT, null);
        if(cursor.moveToFirst()) {
            List<Event> eventos = new ArrayList<Event>();
            do {
                int nomeColumnIndex = cursor.getColumnIndex(MySQLiteContract.Event.COLUMN_NOME);
                int lugarColumnIndex = cursor.getColumnIndex(MySQLiteContract.Event.COLUMN_LUGAR);
                int bannerColumnIndex = cursor.getColumnIndex(MySQLiteContract.Event.COLUMN_BANNER);

                String nome = cursor.getString(nomeColumnIndex);
                String lugar = cursor.getString(lugarColumnIndex);
                String banner = cursor.getString(bannerColumnIndex);

                eventos.add(new Event(nome, lugar, banner));

            } while (cursor.moveToNext());

            return eventos;
        } else {
            return null;
        }
    }
}
