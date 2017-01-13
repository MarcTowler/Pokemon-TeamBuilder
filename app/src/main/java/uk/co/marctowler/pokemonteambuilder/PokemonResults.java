package uk.co.marctowler.pokemonteambuilder;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


/**
 * @TODO Add results calculation
 * @TODO Add Recommendation
 */
public class PokemonResults extends AppCompatActivity {

    DatabaseHelper myDB;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myDB = new DatabaseHelper(this);

        String pkmn1 = getIntent().getStringExtra("pkmn1");
        String pkmn2 = getIntent().getStringExtra("pkmn2");
        String pkmn3 = getIntent().getStringExtra("pkmn3");
        String pkmn4 = getIntent().getStringExtra("pkmn4");
        String pkmn5 = getIntent().getStringExtra("pkmn5");
        String pkmn6 = getIntent().getStringExtra("pkmn6");

        TextView pkmnName1 = (TextView) findViewById(R.id.pulled1);
        TextView pkmnName2 = (TextView) findViewById(R.id.pulled2);
        TextView pkmnName3 = (TextView) findViewById(R.id.pulled3);
        TextView pkmnName4 = (TextView) findViewById(R.id.pulled4);
        TextView pkmnName5 = (TextView) findViewById(R.id.pulled5);
        TextView pkmnName6 = (TextView) findViewById(R.id.pulled6);

        pkmnName1.setText(pkmn1);
        pkmnName2.setText(pkmn2);
        pkmnName3.setText(pkmn3);
        pkmnName4.setText(pkmn4);
        pkmnName5.setText(pkmn5);
        pkmnName6.setText(pkmn6);

        String[] tmpArray = {pkmn1, pkmn2, pkmn3, pkmn4, pkmn5, pkmn6};

        typeResults(tmpArray);
    }

    protected void typeResults(String[] pokemon) {
        String[] types = new String[11];
        int j  = 0;

        for(int i = 0; i < 12; i++) {
            Cursor res = myDB.queryOne(pokemon[i]);

            if (res != null && res.moveToFirst()) {
                types[j] = res.getString(0);
                j++;
                types[j] = res.getString(1);
                j++;
            }
        }
        //I/System.out: arr: [Abra, Abra, Dewgong, Butterfree, Bulbasaur, Ditto]
        //System.out.println("arr: " + Arrays.toString(pokemon));
    }

}
