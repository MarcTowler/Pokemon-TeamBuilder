package uk.co.marctowler.pokemonteambuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class AddPokemonActivity extends AppCompatActivity {

    AutoCompleteTextView pkmnList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pokemon);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final AutoCompleteTextView pkmnList1 = (AutoCompleteTextView) findViewById(R.id.pkmn1);
        AutoCompleteTextView pkmnList2 = (AutoCompleteTextView) findViewById(R.id.pkmn2);
        AutoCompleteTextView pkmnList3 = (AutoCompleteTextView) findViewById(R.id.pkmn3);
        AutoCompleteTextView pkmnList4 = (AutoCompleteTextView) findViewById(R.id.pkmn4);
        AutoCompleteTextView pkmnList5 = (AutoCompleteTextView) findViewById(R.id.pkmn5);
        AutoCompleteTextView pkmnList6 = (AutoCompleteTextView) findViewById(R.id.pkmn6);

        String[] pokemon = getResources().getStringArray(R.array.lstPkmn);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pokemon);

        pkmnList1.setAdapter(adapter);
        pkmnList2.setAdapter(adapter);
        pkmnList3.setAdapter(adapter);
        pkmnList4.setAdapter(adapter);
        pkmnList5.setAdapter(adapter);
        pkmnList6.setAdapter(adapter);

        Button btn_submit = (Button) findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PokemonResults.class);
                intent.putExtra("pkmn1", pkmnList1.getText().toString());
                startActivity(intent);
            }
        });
    }

}
