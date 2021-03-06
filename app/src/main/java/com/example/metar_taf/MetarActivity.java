package com.example.metar_taf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MetarActivity extends AppCompatActivity {

    float X1,X2,Y1,Y2;
    ImageView home,info,logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metar);

        ActionBar actionBar =  getSupportActionBar();

        //change action bar color
        String colorHex = "#" + Integer.toHexString(ContextCompat.getColor(getApplicationContext(), R.color.bar_color) & 0x00ffffff);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor(colorHex));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.top_bar,null);
        actionBar.setCustomView(view);

        BottomNavigationView bottom_nav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottom_nav.setSelectedItemId(R.id.nav_metar);

        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_metar:
                        return true;

                    case R.id.nav_airport:
                        startActivity(new Intent(getApplicationContext(),MainActivity3.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_taf:
                        startActivity(new Intent(getApplicationContext(),TafActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });

        //home
        home = findViewById(R.id.home_button);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_home = new Intent(
                        MetarActivity.this,
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
                        MetarActivity.this,
                        MainActivity.class
                );
                startActivity(intent_home);
            }
        });

        Aeroport aero = Global.aeroport;

        TextView aeroport_name = (TextView) findViewById(R.id.aeroport_name);
        TextView aeroport_oacii = (TextView) findViewById(R.id.aeroport_oacii);
        TextView metar_temperature = (TextView) findViewById(R.id.metar_temperature);
        TextView metar_dewpoint = (TextView) findViewById(R.id.metar_dewpoint);
        TextView metar_pressure = (TextView) findViewById(R.id.metar_pressure);
        TextView metar_windSpeed = (TextView) findViewById(R.id.metar_windSpeed);
        TextView metar_windDegree = (TextView)findViewById(R.id.metar_windDegree);
        TextView metar_visibility = (TextView) findViewById(R.id.metar_visibility);
        TextView metar_clouds = (TextView) findViewById(R.id.metar_clouds);


        aeroport_name.setText(aero.getStation().getName());
        aeroport_oacii.setText(aero.getOACI());
        metar_temperature.setText(aero.getMetar().getTemperature().getValue().toString()+" ??C");
        metar_dewpoint.setText(aero.getMetar().getDewpoint().getValue().toString()+" ??C");
        metar_pressure.setText(aero.getMetar().getAltimeter().getValue().toString()+" hPa");
        metar_windSpeed.setText(aero.getMetar().getWindSpeed().getValue().toString()+" kt");
        metar_windDegree.setText(aero.getMetar().getWindDirection().getValue().toString()+" ??");
        metar_visibility.setText(aero.getMetar().getVisibility().getValue().toString()+" m");
        //metar_clouds.setText(aero.getMetar().getClouds().get().getRepr().toString());
    }
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                X1 = event.getX();
                Y1 = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                X2 = event.getX();
                Y2 = event.getY();
                if (X1 < X2) { //swipe right
                    Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                    startActivity(intent);
                }
                if (X1 > X2) { //swipe left
                    Intent intent = new Intent(getApplicationContext(), TafActivity.class);
                    startActivity(intent);
                }
        }
        return false;
    }
}