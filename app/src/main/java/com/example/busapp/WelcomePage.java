package com.example.busapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class WelcomePage extends AppCompatActivity {
    ImageView img;
    private BottomNavigationView bootom;
    Fragment selectFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

        bootom = findViewById(R.id.bottom_navigation_menu);
        bootom.setOnNavigationItemSelectedListener(ButtonNavMethod);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener ButtonNavMethod = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    img = (ImageView) findViewById(R.id.img2);
                    switch (item.getItemId()) {
                        case R.id.bottom_navigation_home:
                            img.setVisibility(View.INVISIBLE);
                            selectFragment = new Dashboard_home2();
                            break;
                        case R.id.BookingTab:
                            startActivity(new Intent(WelcomePage.this, SearchBus.class));
                            break;
                        case R.id.profiletab:
                            startActivity(new Intent(WelcomePage.this, Profile.class));
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmant_container, selectFragment).commit();
                    return true;

                }

            };
}



