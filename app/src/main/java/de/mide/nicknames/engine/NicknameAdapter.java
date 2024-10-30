package de.mide.nicknames.engine;


import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.mide.nicknames.R;


/**
 * Adapter zwischen Datenbank und RecyclerView.
 */
public class NicknameAdapter extends RecyclerView.Adapter {

    private static final String TAG4LOGGING = "NickAdapter";

    /** Cursor für Ergebnis von Datenbank-Abfrage, die alle Nicknames liefert. */
    private Cursor _cursor = null;


    /**
     * Konstruktor.
     *
     * @param cursor Cursor für Ergebnis von Datenbank-Abfrage, die alle Nicknames
     *               liefert
     */
    public NicknameAdapter( Cursor cursor ) {

        _cursor = cursor;
    }


    /**
     * {@code ViewHolder} für Eintrag in RecyclerView erzeugen.
     *
     * @return Neuer {@code ViewHolder} für Eintrag in RecyclerView.
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {

        Context parentKontext = parentViewGroup.getContext();

        LayoutInflater luftpumpe = LayoutInflater.from( parentKontext );

        View view = luftpumpe.inflate(R.layout.nickname_zeile, parentViewGroup, false);

        return new NicknameViewHolder(view);
    }


    /**
     * Einzelnen Eintrag im {@code RecyclerView} mit Daten versorgen.
     *
     * @param holder ViewHolder-Objekt, das einen Eintrag repräsentiert und
     *               mit Daten versorgt werden soll.
     *
     * @param position Position des Eintrags in der RecyclerView (0-basiert)
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if ( holder instanceof NicknameViewHolder nicknameHolder ) {

            boolean erfolg = _cursor.moveToPosition(position);
            if ( !erfolg ) {

                Log.w( TAG4LOGGING, "Ungültige Cursor-Position: " + position );
                return;
            }

            final String adjektiv   = _cursor.getString(0);
            final String substantiv = _cursor.getString(1);

            final String nickname = adjektiv + " " + substantiv;
            nicknameHolder.setNickname(nickname);

        } else {

            Log.w(TAG4LOGGING, "Ungültiger ViewHolder-Typ: " + holder.getClass().getName());
        }
    }


    /**
     * Liefert Anzahl der Nicknames.
     *
     * @return Anzahl der Nicknames (Anzahl der Zeilen im Cursor)
     */
    @Override
    public int getItemCount() {

        final int anzahlZeilen = _cursor.getCount();

        Log.i( TAG4LOGGING, "Anzahl Zeilen: " + anzahlZeilen );

        return anzahlZeilen;
    }
}
