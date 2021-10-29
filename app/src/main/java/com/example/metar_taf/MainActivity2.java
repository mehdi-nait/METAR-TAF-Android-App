package com.example.metar_taf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView code ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        code = findViewById(R.id.txt_code);

        String received_code = this.getIntent().getExtras().get("message").toString();
        code.setText(received_code);
    }
}