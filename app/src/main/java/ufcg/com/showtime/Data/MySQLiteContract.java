package ufcg.com.showtime.Data;

import android.provider.BaseColumns;

public final class MySQLiteContract {

    /**
     * Table 'Event' structure definition.
     * @author Franklin Wesley
     *
     */
    public static abstract class Event implements BaseColumns {
        public static final String TABLE_NAME = "Event";

        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_DATA = "data";
        public static final String COLUMN_HORA = "hora";
        public static final String COLUMN_LUGAR = "lugar";
        public static final String COLUMN_BANNER = "banner";
    }

    /**
     * Table 'Musician' structure definition.
     * @author Franklin Wesley
     *
     */
    public static abstract class Musician implements BaseColumns {
        public static final String TABLE_NAME = "Musician";

        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_PARTICIPANTES = "participantes";
        public static final String COLUMN_BANNER = "banner";
        public static final String COLUMN_ESTILO = "estilo";
        public static final String COLUMN_FAMA = "fama";
    }

    /**
     * Table 'Show' structure definition.
     * @author Franklin Wesley
     *
     */
    public static abstract class Show implements BaseColumns {
        public static final String TABLE_NAME = "Show";

        public static final String COLUMN_EVENT = "event";
        public static final String COLUMN_MUSICO = "musico";
    }

    private static final String INTEGER_TYPE = " INTEGER";
    private static final String BLOB_TYPE = " BLOB";
    private static final String STRING_TYPE = " TEXT";
    private static final String REAL_TYPE = " REAL";
    private static final String DATE_TYPE = " DATE";
    private static final String TIME_TYPE = " TIME";
    private static final String COMMA_SEP = ",";

    /**
     * CREATE TABLE Event SQL.
     */
    protected static final String SQL_CREATE_TABLE_EVENT =
            "CREATE TABLE " + Event.TABLE_NAME + " (" +
                    Event._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    Event.COLUMN_NOME + STRING_TYPE + COMMA_SEP +
                    Event.COLUMN_DATA + DATE_TYPE + COMMA_SEP +
                    Event.COLUMN_HORA + TIME_TYPE + COMMA_SEP +
                    Event.COLUMN_LUGAR + STRING_TYPE + COMMA_SEP +
                    Event.COLUMN_BANNER + STRING_TYPE + " )";

    /**
     * CREATE TABLE Musician SQL.
     */
    protected static final String SQL_CREATE_TABLE_MUSICIAN =
            "CREATE TABLE " + Musician.TABLE_NAME + " (" +
                    Musician._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    Musician.COLUMN_NOME + STRING_TYPE + COMMA_SEP +
                    Musician.COLUMN_PARTICIPANTES + STRING_TYPE + COMMA_SEP +
                    Musician.COLUMN_BANNER + STRING_TYPE + COMMA_SEP +
                    Musician.COLUMN_ESTILO + STRING_TYPE + COMMA_SEP +
                    Musician.COLUMN_FAMA + INTEGER_TYPE + " )";

    /**
     * CREATE TABLE Show SQL.
     */
    protected static final String SQL_CREATE_TABLE_SHOW =
            "CREATE TABLE " + Show.TABLE_NAME + " (" +
                    Show._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    Show.COLUMN_EVENT + STRING_TYPE + COMMA_SEP +
                    Show.COLUMN_MUSICO + STRING_TYPE + " )";

    /**
     * SQL COUNT
     */
    protected static final String SQL_COUNT_MUSICIAN_ENTRIES =
            "SELECT count(*) FROM " + Musician.TABLE_NAME;


    /**
     * SQL INSERT ENTRY
     */
    protected static final String SQL_INSERT_MUSICIAN_ENTRY =
            "INSERT INTO " + Musician.TABLE_NAME + " (" +
                Musician.COLUMN_NOME + COMMA_SEP +
                Musician.COLUMN_PARTICIPANTES + COMMA_SEP +
                Musician.COLUMN_BANNER + COMMA_SEP +
                Musician.COLUMN_ESTILO + COMMA_SEP +
                Musician.COLUMN_FAMA + ")" +
                " VALUES (?,?,?,?,?)";

    /**
     * SQL DELETE ENTRY
     */
    protected static final String SQL_DELETE_MUSICIAN_ENTRY =
            "DELETE FROM " + Musician.TABLE_NAME + " WHERE " +
                    Musician.COLUMN_NOME + " = ?";

    protected static final String SQL_SELECT_MUSICIAN_ENTRY =
            "SELECT * FROM " + Musician.TABLE_NAME + " WHERE " +
                    Musician.COLUMN_NOME + " = ?";

    protected static final String SQL_SELECT_MUSICIAN_ENTRY_LIKE =
            "SELECT * FROM " + Musician.TABLE_NAME + " WHERE " +
                    Musician.COLUMN_NOME + " LIKE ?";

    protected static final String SQL_SELECT_MUSICIAN =
            "SELECT * FROM " + Musician.TABLE_NAME + " ORDER BY " + Musician.COLUMN_FAMA + " DESC";

    protected static final String SQL_SELECT_EVENT =
            "SELECT * FROM " + Event.TABLE_NAME+ " ORDER BY " + Event.COLUMN_DATA + " DESC, " + Event.COLUMN_HORA + " DESC";

    /**
     * SQL COUNT
     */
    protected static final String SQL_COUNT_EVENT_ENTRIES =
            "SELECT count(*) FROM " + Event.TABLE_NAME;

    /**
     * SQL INSERT ENTRY
     */
    protected static final String SQL_INSERT_EVENT_ENTRY =
            "INSERT INTO " + Event.TABLE_NAME + " (" +
                    Event.COLUMN_NOME + COMMA_SEP +
                    Event.COLUMN_DATA + COMMA_SEP +
                    Event.COLUMN_HORA + COMMA_SEP +
                    Event.COLUMN_LUGAR + COMMA_SEP +
                    Event.COLUMN_BANNER + ")" +
                    " VALUES (?,?,?,?,?)";


    protected static final String SQL_SELECT_EVENT_ENTRY =
            "SELECT * FROM " + Event.TABLE_NAME + " WHERE " +
                    Event.COLUMN_NOME + " = ?";

    protected static final String SQL_SELECT_EVENT_ENTRY_LIKE =
            "SELECT * FROM " + Event.TABLE_NAME + " WHERE " +
                    Event.COLUMN_NOME + " LIKE ?";

    protected static final String SQL_DELETE_EVENT_ENTRY =
            "DELETE FROM " + Event.TABLE_NAME + " WHERE " +
                    Event.COLUMN_NOME + " = ?";

    //Show
    protected static final String SQL_SELECT_SHOW_EVENT =
            "SELECT * FROM " + Show.TABLE_NAME + " WHERE " +
                    Show.COLUMN_MUSICO + " = ?";

    protected static final String SQL_SELECT_SHOW_MUSICIAN =
            "SELECT * FROM " + Show.TABLE_NAME + " WHERE " +
                    Show.COLUMN_EVENT + " = ?";

    /**
     * SQL COUNT
     */
    protected static final String SQL_COUNT_SHOW_ENTRIES =
            "SELECT count(*) FROM " + Show.TABLE_NAME;

    /**
     * SQL INSERT ENTRY
     */
    protected static final String SQL_INSERT_SHOW_ENTRY =
            "INSERT INTO " + Show.TABLE_NAME + " (" +
                    Show.COLUMN_EVENT + COMMA_SEP +
                    Show.COLUMN_MUSICO + ")" +
                    " VALUES (?,?)";

    /**
     * SQL DELETE ENTRY
     */
    protected static final String SQL_DELETE_SHOW_ENTRY =
            "DELETE FROM " + Show.TABLE_NAME + " WHERE " +
                    Show.COLUMN_EVENT + " = ?";
}
