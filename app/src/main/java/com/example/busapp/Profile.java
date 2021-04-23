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

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        userID=firebaseAuth.getUid();


        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("Register");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Register userprofile=snapshot.getValue(Register.class);
                t1.setText(userprofile.getFullname());
                t2.setText(userprofile.getUser());
                t3.setText(userprofile.getPhone());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}