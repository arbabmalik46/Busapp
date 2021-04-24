package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Ticket extends AppCompatActivity {

    TextView rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        Random r = new Random();
        int random_no = r.nextInt((9999999 - 10)+ 9999999);

        rand = (TextView)findViewById(R.id.random_ticket);
        rand.setText("#"+random_no);


        Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),bookedsuccesfully.class);
                startActivity(intent);
            }
        });

    }
}