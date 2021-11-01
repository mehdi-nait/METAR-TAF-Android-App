package com.example.metar_taf;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button find_button;
    EditText code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar =  getSupportActionBar();

        //change action bar color
        String colorHex = "#" + Integer.toHexString(ContextCompat.getColor(getApplicationContext(), R.color.bar_color) & 0x00ffffff);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor(colorHex));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.top_bar,null);
        actionBar.setCustomView(view);

        find_button = (Button) findViewById(R.id.find_button);
        code = (EditText) findViewById(R.id.OACI);

        find_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this,
                        MainActivity3.class
                );
                intent.putExtra("message",code.getText().toString());
                startActivity(intent);
            }
        });


    }
}