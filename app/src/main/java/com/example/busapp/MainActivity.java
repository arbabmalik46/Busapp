package com.example.busapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

                  // name,username,phoneno,password
    TextInputLayout  e1,e2,e3,e4;
    TextView busroutetext;
    Button b1,b2;
    Spinner busroute;
        FirebaseAuth mAuth;
    DatabaseReference registerDbRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));
    e1=(TextInputLayout)findViewById(R.id.name);
    e2=(TextInputLayout)findViewById(R.id.UsernameSignup);
    e3=(TextInputLayout)findViewById(R.id.phonenumber);
    e4=(TextInputLayout)findViewById(R.id.Passwordsignup);
    busroute=(Spinner) findViewById(R.id.spinner);
    mAuth= FirebaseAuth.getInstance();
    registerDbRef= FirebaseDatabase.getInstance().getReference().child("Register");


    b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
//    final PopupMenu popupMenu=new PopupMenu(MainActivity.this,busroute);
//    MenuInflater menuInflater = popupMenu.getMenuInflater();
//    menuInflater.inflate(R.menu.dropdownbusselection, popupMenu.getMenu());

        String fullname=e1.getEditText().getText().toString();
        String phone=e3.getEditText().getText().toString();
        String user=e2.getEditText().getText().toString();
        String password=e4.getEditText().getText().toString();
        String bus=busroute.getSelectedItem().toString();
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            insertRegister();

        }
    });
    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
        }
    });


    }
    private void insertRegister()
    {
        final Random myrandom=new Random();
        String passengerno=String.valueOf(myrandom.nextInt(200));
        String fullname=e1.getEditText().getText().toString();
        String phone=e3.getEditText().getText().toString();
        String email=e2.getEditText().getText().toString();
        String password=e4.getEditText().getText().toString();
        String bus=busroute.getSelectedItem().toString();


        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Register register=new Register(
                                    passengerno,
                                    fullname,
                                    phone,
                                    email,
                                    password,
                                    bus
                            );
                            FirebaseDatabase.getInstance().getReference("Register")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(register).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                               if(task.isSuccessful())
                               {
                                 Toast.makeText(getApplicationContext(),"User has been Registered",Toast.LENGTH_LONG).show();
                               }
                               else
                               {
                                   Toast.makeText(getApplicationContext(),"Failed to Registered",Toast.LENGTH_LONG).show();

                               }
                                }
                            });
                        }
                    }
                });


//
//        registerDbRef.push().setValue(register);

        Intent intent =new Intent(MainActivity.this,Login.class);
        startActivity(intent);
    }

}