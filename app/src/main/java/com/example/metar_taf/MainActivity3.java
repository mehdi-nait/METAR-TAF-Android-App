package com.example.metar_taf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.CustomZoomButtonsController;
import org.osmdroid.views.MapView;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    float X1,X2,Y1,Y2;
    private final int REQUEST_PERMISSIONS_REQUEST_CODE = 1;
    ImageView home,info,logo;
    private MapView map = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

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
        bottom_nav.setSelectedItemId(R.id.nav_airport);

        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.nav_metar:
                        startActivity(new Intent(getApplicationContext(),MetarActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_taf:
                        startActivity(new Intent(getApplicationContext(),TafActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_airport:
                        return true;
                }

                return false;
            }
        });

        home = findViewById(R.id.home_button);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_home = new Intent(
                        MainActivity3.this,
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
                        MainActivity3.this,
                        MainActivity.class
                );
                startActivity(intent_home);
            }
        });

        map = (MapView) findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);

        Configuration.getInstance().setUserAgentValue("metarTafApp");

        requestPermissionsIfNecessary(new String[] {

                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        });

        map.setUseDataConnection(true);
        map.getZoomController().setVisibility(CustomZoomButtonsController.Visibility.ALWAYS);
        map.setMultiTouchControls(true);

        IMapController mapController = map.getController();
        mapController.setZoom(9.5);
        GeoPoint startPoint = new GeoPoint(48.01906, 0.15798);
        mapController.setCenter(startPoint);

        //intent
        Intent intent = getIntent();
        Aeroport aero = Global.aeroport;
        //Toast.makeText(getApplicationContext(), aero.getOACI(), Toast.LENGTH_SHORT).show();

        TextView aeroport_name = (TextView) findViewById(R.id.aeroport_name);
        TextView aeroport_oacii = (TextView) findViewById(R.id.aeroport_oacii);
        TextView aeroport_country = (TextView) findViewById(R.id.aeroport_country);
        TextView aeroport_coordinates  = (TextView) findViewById(R.id.aeroport_coordinates);


        aeroport_name.setText(aero.getStation().getName());
        aeroport_oacii.setText(aero.getOACI());
        aeroport_country.setText(aero.getStation().getCountry());
        aeroport_coordinates.setText(aero.getStation().getLatitude().toString()+"° "+ aero.getStation().getLongitude().toString());


        mapController.setZoom(12.0);
        GeoPoint Point = new GeoPoint(aero.getStation().getLatitude(), aero.getStation().getLongitude());
        mapController.setCenter(Point);

    }
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        ArrayList<String> permissionsToRequest = new ArrayList<>();
        for (int i = 0; i < grantResults.length; i++) {
            permissionsToRequest.add(permissions[i]);
        }
        if (permissionsToRequest.size() > 0) {
            ActivityCompat.requestPermissions(
                    this,
                    permissionsToRequest.toArray(new String[0]),
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }

    private void requestPermissionsIfNecessary(String[] permissions) {
        ArrayList<String> permissionsToRequest = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission)
                    != PackageManager.PERMISSION_GRANTED) {
                // Permission is not granted
                permissionsToRequest.add(permission);
            }
        }
        if (permissionsToRequest.size() > 0) {
            ActivityCompat.requestPermissions(
                    this,
                    permissionsToRequest.toArray(new String[0]),
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
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
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(intent);
                }

                if (X1 > X2) { //swipe right
                    Intent intent = new Intent(getApplicationContext(), MetarActivity.class);
                    startActivity(intent);

                }
        }
        return false;
    }


}