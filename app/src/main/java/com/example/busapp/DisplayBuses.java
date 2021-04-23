package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DisplayBuses extends AppCompatActivity {


   private RecyclerView recview;
    MyAdapter adapter;
    DatabaseReference mbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_buses);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));


        mbase=FirebaseDatabase.getInstance().getReference().child("Buses");
        recview=(RecyclerView)findViewById(R.id.recview);

        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Buses> options =
                new FirebaseRecyclerOptions.Builder<Buses>()
                        .setQuery(mbase, Buses.class)
                        .build();

        adapter=new MyAdapter(options);
        recview.setAdapter(adapter);

    }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.searchmenu,menu);
        MenuItem item=menu.findItem(R.id.search);
        SearchView searchView=(SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                processsearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                processsearch(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void processsearch(String query) {

        FirebaseRecyclerOptions<Buses> options =
                new FirebaseRecyclerOptions.Builder<Buses>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Buses").orderByChild("busno").startAt(query).endAt(query+"\uf8ff")
       , Buses.class)
                        .build();
        adapter=new MyAdapter(options);
        adapter.startListening();
        recview.setAdapter(adapter);

    }
}