package de.mide.nicknames.engine;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.mide.nicknames.R;


/**
 * Ein Objekt dieser Klasse repräsentiert einen Nickname im {@code RecyclerView}-Element.
 */
public class NicknameViewHolder extends RecyclerView.ViewHolder {

    /** Textview-Element in Eintrag in {@code RecyclerView}-Element. */
    private TextView _textView = null;


    /**
     * Konstruktor.
     *
     * @param itemView View-Element, das einen Eintrag in der Liste repräsentiert.
     */
    public NicknameViewHolder(@NonNull View itemView) {

        super(itemView);

        _textView = itemView.findViewById(R.id.nicknameTextView);
    }


    /**
     * Nickname setzen.
     *
     * @param nickname Nickname für Eintrag (Zeile) in {@code RecyclerView}-Element
     */
    public void setNickname( String nickname ) {

        _textView.setText( nickname );
    }

}
