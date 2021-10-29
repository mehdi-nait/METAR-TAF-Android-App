package com.example.metar_taf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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


        find_button = (Button) findViewById(R.id.find_button);
        code = (EditText) findViewById(R.id.OACI);

        find_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this,
                        MainActivity2.class
                );
                intent.putExtra("message",code.getText().toString());
                startActivity(intent);
            }
        });


    }
}