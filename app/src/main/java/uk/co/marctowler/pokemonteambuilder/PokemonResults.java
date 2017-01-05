package uk.co.marctowler.pokemonteambuilder;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


/**
 * @TODO Add results calculation
 * @TODO Add Recommendation
 */
public class PokemonResults extends AppCompatActivity {

    /**
     * @TODO Add content of strings to text views
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
    }

}
