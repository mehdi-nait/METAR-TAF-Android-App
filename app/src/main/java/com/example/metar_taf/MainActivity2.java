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
import android.text.Editable;
<<<<<<< HEAD
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
=======
import android.view.LayoutInflater;
import android.view.View;
>>>>>>> 639b3a0ca3e3c85ca74b17952561698f2f161600
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

<<<<<<< HEAD
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import com.example.metar_taf.pojo_metar.METAR;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
=======
import java.util.ArrayList;
>>>>>>> 639b3a0ca3e3c85ca74b17952561698f2f161600

public class MainActivity2 extends AppCompatActivity {

    ListView list;
    ImageView home,info,logo;
    Button add_destination,clear;
    EditText OACI2;
<<<<<<< HEAD
    private static final String TAG = "API_Service";
=======

>>>>>>> 639b3a0ca3e3c85ca74b17952561698f2f161600
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

        //List adapter
        ArrayAdapter<String> adapter;
        ArrayList searchList;
        searchList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, searchList);


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

        //code = findViewById(R.id.txt_code);

        //Getting code from intent
        String received_code = this.getIntent().getExtras().get("message").toString();
        searchList.add(received_code);
        list = (ListView) findViewById(R.id.list_codes);
        OACI2 = (EditText) findViewById(R.id.OACI2);
        clear = (Button) findViewById(R.id.clear);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.clear();
                list.setAdapter(adapter);
            }
        });

        add_destination = (Button) findViewById(R.id.add_destination);
        add_destination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                String code = OACI2.getText().toString();

                    new API_Service().searchMETAR(code, new Callback() {

                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {

                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        final Gson gson = new Gson();
                        Log.d(TAG, "response from service = " + response);

                        ResponseBody body = response.body();
                        String value = body.string();

                        Log.d(TAG, "response body to string =" + value);
                        METAR metar = gson.fromJson(value, METAR.class);

                        Log.d(TAG, "response  en json =" + metar.toString());

                        Log.d(TAG, "temp = " + metar.getTemperature().getValue() + "°C");

                    }
                });

                searchList.add(code);
                list.setAdapter(adapter);

=======
                searchList.add(OACI2.getText().toString());
                list.setAdapter(adapter);
>>>>>>> 639b3a0ca3e3c85ca74b17952561698f2f161600
            }
        });



    }
}