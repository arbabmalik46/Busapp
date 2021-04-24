package com.example.busapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {

        EditText t1, t2, t3;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

       t1 = (EditText)findViewById(R.id.editname);
        t2 = (EditText)findViewById(R.id.editemail);
        t3 = (EditText)findViewById(R.id.editphone);

       t1.setText(GlobalVar.currentUser.getFullname());
       t2.setText(GlobalVar.currentUser.getUser());
       t3.setText(GlobalVar.currentUser.getPhone());

    }
}