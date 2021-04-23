package com.example.busapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Booking extends AppCompatActivity {
    private RecyclerView recview;
    BookingAdapter adapter;
    DatabaseReference mbase;
Context ctx;
    private FirebaseAuth firebaseAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

        String Frombus = getIntent().getStringExtra("from");
        String toBus = getIntent().getStringExtra("to");
        String datebus = getIntent().getStringExtra("Date");

        recview = findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        mbase = FirebaseDatabase.getInstance().getReference().child("Buses");
        Query query =mbase.orderByChild("arrival").equalTo("Wapda Town");
//
//        firebaseAuth = FirebaseAuth.getInstance();
//        user = firebaseAuth.getCurrentUser();

                FirebaseRecyclerOptions<Buses> op =
                        new FirebaseRecyclerOptions.Builder<Buses>()
                                .setQuery(query, Buses.class)
                                .build();
                adapter=new BookingAdapter(op);
                recview.setAdapter(adapter);




    }


//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                if (snapshot.exists()) {
//                    for (DataSnapshot ds : snapshot.getChildren()) {
//                        FirebaseRecyclerOptions<Buses> op =
//                                new FirebaseRecyclerOptions.Builder<Buses>()
//                                        .setQuery(mbase, Buses.class)
//                                        .build();
//                        adapter = new BookingAdapter(op);
//                        recview.setAdapter(adapter);
//                    }
//                }
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

//        FirebaseRecyclerOptions<Buses> op =
//                new FirebaseRecyclerOptions.Builder<Buses>()
//                        .setQuery(mbase, Buses.class)
//                        .build();
//        adapter = new BookingAdapter(op);
//        recview.setAdapter(adapter);

//        firebaseAuth = FirebaseAuth.getInstance();
//
//        if (firebaseAuth.getCurrentUser() == null) {
//            finish();
//            startActivity(new Intent(this, Login.class));
//        }
//
//        FirebaseDatabase.getInstance().getReference("Buses")
//                .orderByChild("depature").equalTo(Frombus)
//                .addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                        if (dataSnapshot.exists()) {
//                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                                FirebaseRecyclerOptions<Buses> op =
//                                        new FirebaseRecyclerOptions.Builder<Buses>()
//                                                .setQuery(mbase, Buses.class)
//                                                .build();
//                                adapter = new BookingAdapter(op);
//                                recview.setAdapter(adapter);
//
//                            }
//                            adapter.notifyDataSetChanged();
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//                        Toast.makeText(Booking.this, "Firebase Database Error", Toast.LENGTH_LONG).show();
//                    }
//                });






    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stoping of the activity
    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }
}


//
//        firebaseAuth = FirebaseAuth.getInstance();
//        mbase= FirebaseDatabase.getInstance().getReference();
//
//        if (firebaseAuth.getCurrentUser() == null) {
//            finish();
//            startActivity(new Intent(this, Login.class));
//        }
//
//        String Frombus =getIntent().getStringExtra("from");
//        String toBus=getIntent().getStringExtra("to");
//        String datebus=getIntent().getStringExtra("Date");
//
//        FirebaseDatabase.getInstance().getReference("Buses")
//                .orderByChild("depature").equalTo(Frombus)
//                .addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                if(dataSnapshot.exists())
//                           {
//                    for(DataSnapshot snapshot:dataSnapshot.getChildren() )
//                    {  FirebaseRecyclerOptions<Buses> op =
//                            new FirebaseRecyclerOptions.Builder<Buses>()
//                                    .setQuery(mbase, Buses.class)
//                                    .build();
//                        adapter=new BookingAdapter(op);
//                        recview.setAdapter(adapter);
//
//                    }
//                    adapter.notifyDataSetChanged();
//                }
////                FirebaseDatabase.getInstance().getReference().child("Buses")
////                        .orderByChild("arrival")
////                        .equalTo(toBus)
////                        .addValueEventListener(new ValueEventListener() {
////                            @Override
////                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//////                                busList.clear();
////
////                                if(dataSnapshot.exists())
////                                {
////                                    for(DataSnapshot snapshot:dataSnapshot.getChildren())
////                                    {
////                                        FirebaseRecyclerOptions<Buses> op =
////                                                new FirebaseRecyclerOptions.Builder<Buses>()
////                                                        .setQuery(mbase, Buses.class)
////                                                        .build();
////                                        adapter=new BookingAdapter(op);
////                                        recview.setAdapter(adapter);
//////                                        Buses buses=snapshot.getValue(Buses.class);
//////                                        busList.add(buses);
////                                    }
////                                    adapter.notifyDataSetChanged();
////                                }
////                                FirebaseDatabase.getInstance().getReference()
////                                        .child("date").equalTo(datebus)
////                                        .addValueEventListener(new ValueEventListener() {
////                                            @Override
////                                            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
////
////                                                if(dataSnapshot.exists())
////                                                {
////                                                    for(DataSnapshot snapshot:dataSnapshot.getChildren())
////                                                    {
////                                                        FirebaseRecyclerOptions<Buses> op =
////                                                                new FirebaseRecyclerOptions.Builder<Buses>()
////                                                                        .setQuery(mbase, Buses.class)
////                                                                        .build();
////                                                        adapter=new BookingAdapter(op);
////                                                        recview.setAdapter(adapter);
////                                                    }
//////                                                        Buses buses=snapshot.getValue(Buses.class);
//////                                                             busList.add(buses);
//////                                                    }
////                                                    adapter.notifyDataSetChanged();
////                                                }
////
////
////                                            }
////
////                                            @Override
////                                            public void onCancelled(@NonNull DatabaseError error) {
////                                                Toast.makeText(Booking.this,"Firebase Database Error",Toast.LENGTH_LONG).show();
////
////                                            }
////                                        });
//
//
//
////                            }
////
////                            @Override
////                            public void onCancelled(@NonNull DatabaseError error) {
////                                Toast.makeText(Booking.this,"Firebase Database Error",Toast.LENGTH_LONG).show();
////
////                            }
////                        });
//
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(Booking.this,"Firebase Database Error",Toast.LENGTH_LONG).show();
//
//
//            }
//        });
//    }
//    ValueEventListener valueEventListener=new ValueEventListener() {
//        @Override
//        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
//
//            if(datasnapshot.exists())
//            {
//                for(DataSnapshot snapshot:datasnapshot.getChildren())
//                {
//                    FirebaseRecyclerOptions<Buses> op =
//                            new FirebaseRecyclerOptions.Builder<Buses>()
//                                    .setQuery(mbase, Buses.class)
//                                    .build();
//                    adapter=new BookingAdapter(op);
//                    recview.setAdapter(adapter);
//                }
//                adapter.notifyDataSetChanged();
//            }
//
//        }
//
//        @Override
//        public void onCancelled(@NonNull DatabaseError error) {
//
//        }
//    };
//}