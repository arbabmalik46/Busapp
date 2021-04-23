package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddUser extends AppCompatActivity {

    EditText pid, fullname,phone,password,user,bus;
    Button submit;
    DatabaseReference registerDbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

        pid=(EditText) findViewById(R.id.pid);
        fullname=(EditText)findViewById(R.id.name);
        phone=(EditText)findViewById(R.id.phonenumber);
        user=(EditText)findViewById(R.id.UsernameSignup);
        password=(EditText)findViewById(R.id.password);
        bus=(EditText) findViewById(R.id.editText);
        submit=(Button)findViewById(R.id.b1);
        registerDbRef= FirebaseDatabase.getInstance().getReference().child("Register");

        String id=pid.getText().toString();
        String name=fullname.getText().toString();
        String ph=phone.getText().toString();
        String email=user.getText().toString();
        String  pass=password.getText().toString();
        String busroute=bus.getText().toString();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertRegister();
            }
        });
    }

    private void insertRegister() {
        String id=pid.getText().toString();
        String name=fullname.getText().toString();
        String ph=phone.getText().toString();
        String email=user.getText().toString();
        String  pass=password.getText().toString();
        String busroute=bus.getText().toString();
        Register register=new Register(
                id,
                name,
                ph,
                email,
                pass,
                busroute
        );
        registerDbRef.push().setValue(register);


        Intent intent =new Intent(AddUser.this,DisplayUsers.class);
        startActivity(intent);

    }
}