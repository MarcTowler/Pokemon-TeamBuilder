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
import android.widget.TextView;

import java.lang.reflect.Array;

public class AddPokemonActivity extends AppCompatActivity {

    AutoCompleteTextView pkmnList1;
    AutoCompleteTextView pkmnList2;
    AutoCompleteTextView pkmnList3;
    AutoCompleteTextView pkmnList4;
    AutoCompleteTextView pkmnList5;
    AutoCompleteTextView pkmnList6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pokemon);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.pkmnList1 = (AutoCompleteTextView) findViewById(R.id.pkmn1);
        this.pkmnList2 = (AutoCompleteTextView) findViewById(R.id.pkmn2);
        this.pkmnList3 = (AutoCompleteTextView) findViewById(R.id.pkmn3);
        this.pkmnList4 = (AutoCompleteTextView) findViewById(R.id.pkmn4);
        this.pkmnList5 = (AutoCompleteTextView) findViewById(R.id.pkmn5);
        this.pkmnList6 = (AutoCompleteTextView) findViewById(R.id.pkmn6);

        String[] pokemon = getResources().getStringArray(R.array.lstPkmn);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pokemon);

        this.pkmnList1.setAdapter(adapter);
        this.pkmnList2.setAdapter(adapter);
        this.pkmnList3.setAdapter(adapter);
        this.pkmnList4.setAdapter(adapter);
        this.pkmnList5.setAdapter(adapter);
        this.pkmnList6.setAdapter(adapter);

        Button btn_submit = (Button) findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(checkSubmission()) {
                    Intent intent = new Intent(getApplicationContext(), PokemonResults.class);
                    intent.putExtra("pkmn1", pkmnList1.getText().toString());
                    intent.putExtra("pkmn2", pkmnList2.getText().toString());
                    intent.putExtra("pkmn3", pkmnList3.getText().toString());
                    intent.putExtra("pkmn4", pkmnList4.getText().toString());
                    intent.putExtra("pkmn5", pkmnList5.getText().toString());
                    intent.putExtra("pkmn6", pkmnList6.getText().toString());
                    startActivity(intent);
                } else {
                    TextView warning = (TextView) findViewById(R.id.txt_warning);
                    warning.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    protected boolean checkSubmission() {
        if(pkmnList1.getText().toString().matches("") ||
           pkmnList2.getText().toString().matches("") ||
           pkmnList3.getText().toString().matches("") ||
           pkmnList4.getText().toString().matches("") ||
           pkmnList5.getText().toString().matches("") ||
           pkmnList6.getText().toString().matches(""))
        {
            return false;
        } else {
            return true;
        }
    }
}
