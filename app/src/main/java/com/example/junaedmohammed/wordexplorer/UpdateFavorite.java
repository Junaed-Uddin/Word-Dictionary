package com.example.junaedmohammed.wordexplorer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateFavorite extends AppCompatActivity {


    EditText edt_update;
    Button upt_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_favorite);

        edt_update = (EditText)findViewById(R.id.edit_update);
        upt_button = (Button)findViewById(R.id.update_button);

        final int rec_pos = getIntent().getIntExtra("MYKEY",999);

        final FavoriteFunctions fb = new FavoriteFunctions(getApplicationContext());

        String t = fb.fetch_data(rec_pos+1);
        edt_update.setText(t);
        edt_update.setSelection(edt_update.getText().length());

        upt_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fb.Update_data((rec_pos+1), edt_update.getText().toString());
                Toast.makeText(UpdateFavorite.this, "Update Successfully", Toast.LENGTH_SHORT).show();

            }
        });

    }

}
