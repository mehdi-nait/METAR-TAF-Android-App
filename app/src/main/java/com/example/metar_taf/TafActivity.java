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

import org.w3c.dom.Text;

public class TafActivity extends AppCompatActivity {

    float X1,X2,Y1,Y2;
    ImageView home,info,logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taf);

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
        bottom_nav.setSelectedItemId(R.id.nav_taf);

        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_taf:
                        return true;

                    case R.id.nav_metar:
                        startActivity(new Intent(getApplicationContext(),MetarActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_airport:
                        startActivity(new Intent(getApplicationContext(),MainActivity3.class));
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
                        TafActivity.this,
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
                        TafActivity.this,
                        MainActivity.class
                );
                startActivity(intent_home);
            }
        });

        Aeroport aero = Global.aeroport;

        TextView aeroport_name = (TextView) findViewById(R.id.aeroport_name);
        TextView aeroport_oacii = (TextView) findViewById(R.id.aeroport_oacii);
        TextView taf_startTime = (TextView) findViewById(R.id.taf_startTime);
        TextView taf_endTime = (TextView) findViewById(R.id.taf_endTime);
        TextView taf_longitude = (TextView) findViewById(R.id.taf_longitude);
        TextView taf_latitude = (TextView) findViewById(R.id.taf_latitude);
        TextView taf_elevation = (TextView) findViewById(R.id.taf_elevation);
        TextView taf_windSpeed = (TextView) findViewById(R.id.taf_windSpeed);
        TextView taf_visibility = (TextView) findViewById(R.id.taf_visibility);
        TextView taf_clouds = (TextView) findViewById(R.id.taf_clouds);

        aeroport_name.setText(aero.getStation().getName());
        aeroport_oacii.setText(aero.getOACI());

        taf_startTime.setText(aero.getTaf().getForecast().get(0).getStartTime().getDt().toString());
        taf_endTime.setText(aero.getTaf().getForecast().get(0).getEndTime().getDt().toString());
        taf_longitude.setText(aero.getStation().getLongitude().toString()+ " °");
        taf_latitude.setText(aero.getStation().getLatitude().toString()+ " °");
        taf_elevation.setText(aero.getStation().getElevationM().toString()+" m");
        taf_windSpeed.setText(aero.getTaf().getForecast().get(0).getWindSpeed().getValue().toString()+" kt");
        taf_visibility.setText(aero.getTaf().getForecast().get(0).getVisibility().getValue().toString()+" m");
        //taf_clouds.setText();
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
                    Intent intent = new Intent(getApplicationContext(), MetarActivity.class);
                    startActivity(intent);
                }
        }
        return false;
    }
}