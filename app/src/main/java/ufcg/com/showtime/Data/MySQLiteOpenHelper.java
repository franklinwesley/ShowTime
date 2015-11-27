package ufcg.com.showtime.Data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ufcg.com.showtime.Models.Event;
import ufcg.com.showtime.Models.Musico;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "SHOWTME.db";

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

    public void close() {
        if (mSQLiteDB != null) {
            mSQLiteDB.close();
        }
    }

//    private void povoarBD() {
//        inserirEvento("SHOW DO ANGRA EM CAMPINA GRANDE", "04-12-2015", "21:00", "Ventura Recepções (Aula Extra Music)", "https://scontent.xx.fbcdn.net/hphotos-xaf1/v/t1.0-0/c170.0.200.200/p200x200/1796506_852376334881263_8282178809894950046_n.jpg?oh=3ec85cba29d882c482472d21af56315a&oe=56891072");
//        inserirEvento("Forró das Antigas", "07-12-2015", "21:00", "Spazzio", "https://fbcdn-sphotos-f-a.akamaihd.net/hphotos-ak-xpl1/v/t1.0-9/p720x720/12294663_960350437333590_6274618701354522479_n.jpg?oh=0aa033eaf35d56f5ece9b3dbe9181103&oe=56E8716D&__gda__=1457818692_627f0659707dbb3cf3247a38e1705d16");
//        inserirEvento("Mato Seco em Campina Grande", "04-12-2015", "20:00", "Vibe Universitária", "https://festaseshows.com.br/wp-content/themes/festaseshows/timthumb.php?src=https://festaseshows.com.br/wp-content/uploads/2012/09/mato-seco.jpg&h=160&w=160&zc=1");
//        inserirEvento("Banda Vibrações em Campina Grande", "04-12-2015", "21:30", "Inove Recepções", "https://festaseshows.com.br/wp-content/themes/festaseshows/timthumb.php?src=https://festaseshows.com.br/wp-content/uploads/2015/08/vibra%C3%A7oes-perfil.jpg&h=160&w=160&zc=1");
//        inserirEvento("O Rappa", "05-12-2015", "20:00", "Centro de Eventos César Rosalém", "https://s3-sa-east-1.amazonaws.com/blueticket/images/imagens/eventos3/15719.jpg");
//        List<String> p1 = new ArrayList<String>();
//        p1.add("James Hetfield");
//        p1.add("Lars Ulrich");
//        p1.add("Robert Trujillo");
//        p1.add("Kirk Hammett");
//        inserirMusico("Metallica", p1, "http://perso.wanadoo.es/thesentinel2002/banner_metallica.jpg", "Rock Roll", 10);
//        List<String> p2 = new ArrayList<String>();
//        p2.add("Klaus Meine");
//        p2.add("Rudolf Schenker");
//        p2.add("Matthias Jabs");
//        p2.add("James Kottak");
//        p2.add("Paweł Mąciwoda");
//        p2.add("Michael Schenker");
//        p2.add("Herman Rarebell");
//        inserirMusico("Scorpions", p2, "http://i306.photobucket.com/albums/nn250/Nycce/scorpions-banner.jpg", "Rock Roll", 8);
//        List<String> p3 = new ArrayList<String>();
//        p3.add("Saulo Fernandes");
//        inserirMusico("Saulo Fernandes", p3, "http://www.odiariodaregiao.com/wp-content/uploads/2012/02/saulo.jpg", "Axe", 1);
//        List<String> p4 = new ArrayList<String>();
//        p1.add("Luan Santana");
//        inserirMusico("Luan Santana", p4, "http://4.bp.blogspot.com/_AjLELYzxkoE/TUDhI9NBLOI/AAAAAAAAAE4/XIas8-6Bkhs/s1600/luan-santana-banner.jpg", "Sertanejo", 2);
//        List<String> p5 = new ArrayList<String>();
//        p5.add("Corey Taylor");
//        p5.add("Mick Thomson");
//        p5.add("James Root");
//        p5.add("Shawn Crahan");
//        p5.add("Sid Wilson");
//        p5.add("Jay Weinberg");
//        p5.add("Craig Jones");
//        p5.add("Chris Fehn");
//        p5.add("Alessandro Venturella");
//        inserirMusico("Slipknot", p5, "https://sidemad.files.wordpress.com/2012/06/banner-slipknot.jpg", "Rock Roll", 7);
//    }

    // PUBLIC API PARA MANIPULAR O BANCO DE DADOS
    public boolean inserirEvento(String nome, String data, String hora, String lugar, String banner) {
        Event ev = new Event(nome, data, hora, lugar, banner);
        if (!recuperarEventos().contains(ev)) {
            this.getWritableDatabase().execSQL(
                    MySQLiteContract.SQL_INSERT_EVENT_ENTRY,
                    new Object[]{nome, data, hora, lugar, banner});
            return true;
        }
        return false;
    }

    public ArrayList<Event> recuperarEventos() {
        ArrayList<Event> eventos = new ArrayList<Event>();
        Cursor cursor = this.mSQLiteDB.rawQuery(MySQLiteContract.SQL_SELECT_EVENT, null);
        if(cursor.moveToFirst()) {
            do {
                int nomeColumnIndex = cursor.getColumnIndex(MySQLiteContract.Event.COLUMN_NOME);
                int dataColumnIndex = cursor.getColumnIndex(MySQLiteContract.Event.COLUMN_DATA);
                int horaColumnIndex = cursor.getColumnIndex(MySQLiteContract.Event.COLUMN_HORA);
                int lugarColumnIndex = cursor.getColumnIndex(MySQLiteContract.Event.COLUMN_LUGAR);
                int bannerColumnIndex = cursor.getColumnIndex(MySQLiteContract.Event.COLUMN_BANNER);

                String nome = cursor.getString(nomeColumnIndex);
                String data = cursor.getString(dataColumnIndex);
                String hora = cursor.getString(horaColumnIndex);
                String lugar = cursor.getString(lugarColumnIndex);
                String banner = cursor.getString(bannerColumnIndex);

                eventos.add(new Event(nome, data, hora, lugar, banner));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return eventos;
    }

    public boolean inserirMusico(String nome, List<String> participantes, String banner, String estiloMusical, int fama) {
        Musico m = new Musico(nome, participantes, banner, estiloMusical);
        m.addFama(fama);

        if (!recuperarMusicos().contains(m)) {
            this.getWritableDatabase().execSQL(
                    MySQLiteContract.SQL_INSERT_MUSICIAN_ENTRY,
                    new Object[] {nome, TextUtils.join(",", participantes), banner, estiloMusical, fama});
            return true;
        }
        return false;
    }

    public ArrayList<Musico> recuperarMusicos() {
        ArrayList<Musico> musicos = new ArrayList<Musico>();
        Cursor cursor = this.mSQLiteDB.rawQuery(MySQLiteContract.SQL_SELECT_MUSICIAN, null);
        if(cursor.moveToFirst()) {
            do {
                int nomeColumnIndex = cursor.getColumnIndex(MySQLiteContract.Musician.COLUMN_NOME);
                int participantesColumnIndex = cursor.getColumnIndex(MySQLiteContract.Musician.COLUMN_PARTICIPANTES);
                int bannerColumnIndex = cursor.getColumnIndex(MySQLiteContract.Musician.COLUMN_BANNER);
                int estiloColumnIndex = cursor.getColumnIndex(MySQLiteContract.Musician.COLUMN_ESTILO);
                int famaColumnIndex = cursor.getColumnIndex(MySQLiteContract.Musician.COLUMN_FAMA);

                String nome = cursor.getString(nomeColumnIndex);
                String participantes = cursor.getString(participantesColumnIndex);
                String banner = cursor.getString(bannerColumnIndex);
                String estiloMusical = cursor.getString(estiloColumnIndex);
                int fama = cursor.getInt(famaColumnIndex);

                Musico m = new Musico(nome, Arrays.asList(participantes.split(",")), banner, estiloMusical);
                m.addFama(fama);
                musicos.add(m);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return musicos;
    }

    public ArrayList<Event> searchEvent(String query) {
        ArrayList<Event> events = new ArrayList<>();

        Cursor cursor = this.mSQLiteDB.rawQuery(MySQLiteContract.SQL_SELECT_EVENT_ENTRY, new String[]{"%" + query + "%"});
        if(cursor.moveToFirst()) {
            do {
                int nomeColumnIndex = cursor.getColumnIndex(MySQLiteContract.Event.COLUMN_NOME);
                int dataColumnIndex = cursor.getColumnIndex(MySQLiteContract.Event.COLUMN_DATA);
                int horaColumnIndex = cursor.getColumnIndex(MySQLiteContract.Event.COLUMN_HORA);
                int lugarColumnIndex = cursor.getColumnIndex(MySQLiteContract.Event.COLUMN_LUGAR);
                int bannerColumnIndex = cursor.getColumnIndex(MySQLiteContract.Event.COLUMN_BANNER);

                String nome = cursor.getString(nomeColumnIndex);
                String data = cursor.getString(dataColumnIndex);
                String hora = cursor.getString(horaColumnIndex);
                String lugar = cursor.getString(lugarColumnIndex);
                String banner = cursor.getString(bannerColumnIndex);

                events.add(new Event(nome, data, hora, lugar, banner));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return events;
    }

    public ArrayList<Musico> searchMusic(String query) {
        ArrayList<Musico> musicos = new ArrayList<>();

        Cursor cursor = this.mSQLiteDB.rawQuery(MySQLiteContract.SQL_SELECT_MUSICIAN_ENTRY, new String[]{"%" + query + "%"});
        if(cursor.moveToFirst()) {
            do {
                int nomeColumnIndex = cursor.getColumnIndex(MySQLiteContract.Musician.COLUMN_NOME);
                int participantesColumnIndex = cursor.getColumnIndex(MySQLiteContract.Musician.COLUMN_PARTICIPANTES);
                int bannerColumnIndex = cursor.getColumnIndex(MySQLiteContract.Musician.COLUMN_BANNER);
                int estiloColumnIndex = cursor.getColumnIndex(MySQLiteContract.Musician.COLUMN_ESTILO);
                int famaColumnIndex = cursor.getColumnIndex(MySQLiteContract.Musician.COLUMN_FAMA);

                String nome = cursor.getString(nomeColumnIndex);
                String participantes = cursor.getString(participantesColumnIndex);
                String banner = cursor.getString(bannerColumnIndex);
                String estiloMusical = cursor.getString(estiloColumnIndex);
                int fama = cursor.getInt(famaColumnIndex);

                Musico m = new Musico(nome, Arrays.asList(participantes.split(",")), banner, estiloMusical);
                m.addFama(fama);
                musicos.add(m);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return musicos;
    }
}
