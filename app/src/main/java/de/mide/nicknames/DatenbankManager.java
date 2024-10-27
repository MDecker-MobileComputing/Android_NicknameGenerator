package de.mide.nicknames;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Klasse für die Verwaltung der Datenbank.
 */
public class DatenbankManager extends SQLiteOpenHelper {

    /** Tag für das Schreiben von Log-Nachrichten. */
    private static final String TAG4LOGGING = "DBManager";


    /**
     * Konstruktor.
     *
     * @param context Referenz auf Kontext der App (Selbstreferenz auf aufrufende Activity)
     */
    public DatenbankManager(Context context) {

        super(context, "nicknames.db", null, 1);
    }


    /**
     * In dieser Methode werden die beiden Tabellen angelegt und mit Adjektiven
     * bzw. Substantiven gefüllt.
     *
     * Diese Methode verwendet mehrzeilige String-Literale; hierfür musste die
     * Java-Version in der Datei app/build.gradle von 1.8 auf 17 erhöht werden.
     *
     * @param db Datenbank
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

            final String createSql1 =
                    """
                        CREATE TABLE ADJEKTIVE (
                              adjektiv_id INTEGER PRIMARY KEY,
                              adjektiv    TEXT    NOT NULL
                        )
                    """;

            final String createSql2 =
                    """
                        CREATE TABLE SUBSTANTIVE (                        
                              substantiv_id INTEGER PRIMARY KEY,
                              substantiv    TEXT    NOT NULL
                        )
                    """;

            db.execSQL( createSql1 );
            db.execSQL( createSql2 );


            final String insertSql1 =
                    """
                      INSERT INTO ADJEKTIVE (adjektiv) VALUES
                            ("Awesome"), ("Brave"), ("Clever"), ("Daring"), ("Eager"), ("Fantastic"),
                            ("Gentle"), ("Happy"), ("Intelligent"), ("Jolly"), ("Kind"), ("Lively"), 
                            ("Magnificent"), ("Nice"), ("Optimistic"), ("Pleasant"), ("Quirky"), 
                            ("Radiant"), ("Silly"), ("Thoughtful"), ("Unique"), ("Vibrant"), ("Witty"), 
                            ("Xenial"), ("Youthful"), ("Zealous")
                    """;

            final String insertSql2 =
                    """
                        INSERT INTO SUBSTANTIVE (substantiv) VALUES
                               ("Ant"), ("Bear"), ("Cat"), ("Dog"), ("Elephant"), ("Frog"), ("Giraffe"),
                               ("Horse"), ("Iguana"), ("Jaguar"), ("Kangaroo"), ("Lion"), ("Monkey"), 
                               ("Narwhal"), ("Owl"), ("Penguin"), ("Quokka"), ("Rabbit"), ("Snake"), 
                               ("Turtle"), ("Unicorn"), ("Vulture"), ("Whale"), 
                               ("Xylophone"), ("Yak"), ("Zebra")
                    """;

            db.execSQL( insertSql1 );
            db.execSQL( insertSql2 );
        }
        catch (SQLException ex) {

            Log.e(TAG4LOGGING, "Fehler beim Erstellen und Befüllen der Tabellen", ex);
        }
    }


    /**
     * Abstrakte Methode aus der Oberklasse {@link SQLiteOpenHelper},
     * muss also überschrieben werden, damit diese Klasse nicht selbst
     * wieder abstrakt ist. Wird aufgerufen wenn die Datenbank für diese
     * App auf eine neue Version aktualisiert werden muss.
     *
     * @param db  Referenz auf Datenbank-Objekt
     *
     * @param oldVersion  Alte Version Datenbank-Schema die DB für diese App-Installation derzeit
     *                    hat.
     *
     * @param newVersion  Neue Version Datenbank-Schema die hergestellt werden soll.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Absichtlich leer gelassen, da wir diese Methode für die
        // erste Version der App nicht überschreiben müssen.
    }


    /**
     * Diese Methode liefert die Nicknames, die durch einen Join der beiden Tabellen
     * erzeugt werden sollen (kartesisches Produkt) und durch das RecyclerView dargestellt
     * werden sollen.
     *
     * @return Cursor-Objekt für alle erzeugten Nicknames bestehend aus Adjektiv und Substantiv;
     *         die Zeilen sind zufällig sortiert. Index 0 enthält den String mit dem Adjektiv,
     *         Index 1 enthält den String mit dem Substantiv.
     */
    public Cursor holeNicknames() {

        final String sql =
                """
                    SELECT adjektiv, substantiv
                           FROM ADJEKTIVE, SUBSTANTIVE
                           ORDER BY RANDOM()
                """;

        SQLiteDatabase db = getReadableDatabase();

        return db.rawQuery( sql, null ); // null=keine Platzhalter
    }

}
