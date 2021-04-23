package com.example.busapp;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class AdminPannel extends AppCompatActivity {


    ImageButton b1,b2,b3,b4,b5,b6;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_pannel);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

        b1=(ImageButton)findViewById(R.id.imageButton2);
        b2=(ImageButton)findViewById(R.id.imageButton4);
        b3=(ImageButton)findViewById(R.id.imageButton5);
        b4=(ImageButton)findViewById(R.id.imageButton7);
        b5=(ImageButton)findViewById(R.id.imageButton8);
        b6=(ImageButton)findViewById(R.id.imageButton10);


    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        Intent intent=new Intent(AdminPannel.this,Addbuses.class);
        startActivity(intent);
        }
    })
    ;
    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(AdminPannel.this,DisplayBuses.class);
            startActivity(intent);
        }
    });
    b3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(AdminPannel.this,AddUser.class);
            startActivity(intent);
        }
    });
    b4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent=new Intent(AdminPannel.this,DisplayUsers.class);
            startActivity(intent);

        }
    });
    b5.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(AdminPannel.this,Aboutus.class);
            startActivity(intent);

        }
    });


    b6.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(AdminPannel.this,whyonlinebooking.class);
            startActivity(intent);
        }
    });




    }
}