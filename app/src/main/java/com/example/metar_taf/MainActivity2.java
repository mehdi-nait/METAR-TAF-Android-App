package com.example.metar_taf;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView code ;
    ImageView home;
    ImageView info;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActionBar actionBar =  getSupportActionBar();

        //change action bar color
        String colorHex = "#" + Integer.toHexString(ContextCompat.getColor(getApplicationContext(), R.color.bar_color) & 0x00ffffff);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor(colorHex));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.top_bar,null);
        actionBar.setCustomView(view);

        //Home button
        home = findViewById(R.id.home_button);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_home = new Intent(
                        MainActivity2.this,
                        MainActivity.class
                );
                startActivity(intent_home);
            }
        });


        logo = findViewById(R.id.logo_button);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_home = new Intent(
                        MainActivity2.this,
                        MainActivity.class
                );
                startActivity(intent_home);
            }
        });

        code = findViewById(R.id.txt_code);

        String received_code = this.getIntent().getExtras().get("message").toString();
        code.setText(received_code);
    }
}