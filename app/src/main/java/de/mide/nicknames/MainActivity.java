package de.mide.nicknames;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * Activity für die Anzeige der Nicknames in einem {@code RecyclerView}.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG4LOGGING = "MainActivity";


    /**
     * Lifecycle-Methode, lädt Layout-Datei, initialisiert RecyclerView und Actionbar.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionbarInitialisieren();
        recyclerViewInitialisieren();
    }


    /**
     * Actionbar initialisieren.
     */
    private void actionbarInitialisieren() {

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) {

            Log.w(TAG4LOGGING, "Keine ActionBar gefunden.");
            return;
        }

        actionBar.setTitle(R.string.app_name);
    }


    /**
     * RecyclerView initialisieren.
     */
    private void recyclerViewInitialisieren() {

        final DatenbankManager dbManager = new DatenbankManager(this);

        final RecyclerView recyclerView = findViewById( R.id.nicknameRecyclerView );
        recyclerView.setLayoutManager( new LinearLayoutManager(this) );

        final Cursor cursor = dbManager.holeNicknames();
        final NicknameAdapter adapter = new NicknameAdapter(cursor);
        recyclerView.setAdapter( adapter );
    }

}