package com.example.busapp;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Register_Class extends Fragment {
//
//    EditText t1, t2, t3;
//    FirebaseDatabase firebaseDatabase;
//    DatabaseReference databaseReference;
//    FirebaseUser user;
//    String userID;
//    ImageView img;
//
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.activity_register_class, container, false);
//
//        user = FirebaseAuth.getInstance().getCurrentUser();
//        databaseReference = FirebaseDatabase.getInstance().getReference("Register");
//        userID = user.getUid();
//
//        t1 = view.findViewById(R.id.editname);
//        t2 = view.findViewById(R.id.editemail);
//        t3 = view.findViewById(R.id.editphone);
//
//        databaseReference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                img=view.findViewById(R.id.img2);
//                img.setVisibility(View.INVISIBLE);
//                Register register = snapshot.getValue(Register.class);
//                if (register != null) {
//                    String fullname = register.fullname;
//                    String email = register.user;
//                    String phone = register.phone;
//
//                    t1.setText(fullname);
//                    t2.setText(email);
//                    t3.setText(phone);
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//                Toast.makeText(getActivity(), "Something Happened Wrong ", Toast.LENGTH_LONG).show();
//            }
//        });
//                return view;
//    }
}
