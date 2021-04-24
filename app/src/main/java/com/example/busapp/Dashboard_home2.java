package com.example.busapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Dashboard_home2 extends Fragment {

    Button aboutus,onlinebooking;
    ImageView menubtn;
    TextView headerrollnumber;
    FirebaseAuth firebaseAuth;
    DrawerLayout drawerLayout;
    private FragmentActivity myContext;
    View v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.activity_dashboard_home2, container, false);

        firebaseAuth = FirebaseAuth.getInstance();
        menubtn = v.findViewById(R.id.menubtn);
        onlinebooking = v.findViewById(R.id.WhyOnlineBookingbtn);
        aboutus = v.findViewById(R.id.aboutus);
        drawerLayout = v.findViewById(R.id.drawerlayout);

        onlinebooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), whyonlinebooking.class);
                startActivity(intent);
            }
        });
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Aboutus.class);
                startActivity(intent);
            }
        });
        menubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView;
        navigationView = v.findViewById(R.id.sidenavview);
        navigationView.bringToFront();
        Menu menu = navigationView.getMenu();

        View headerview = navigationView.getHeaderView(0);
        headerrollnumber = headerview.findViewById(R.id.usernameonmenubtn);

        FirebaseUser mfirebaseUser = firebaseAuth.getCurrentUser();
        if (mfirebaseUser == null) {
            startActivity(new Intent(getActivity(), Login.class));

        } else {


            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                Fragment selectFragment = null;

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.booking:
                            startActivity(new Intent(getActivity(), Booking.class));
                            break;
                        case R.id.profile:
                            selectFragment = new Register_Class();
                            break;
                        case R.id.contactus:
                            startActivity(new Intent(getActivity(), Aboutus.class));
                            break;
                        case R.id.feedbaack:
                            startActivity(new Intent(getActivity(), Feedback.class));
                            break;
                        case R.id.logout:
                            logout();
                    }
                    drawerLayout.closeDrawers();
                    if (selectFragment != null) {
                        drawerLayout.closeDrawers();
                        myContext.getSupportFragmentManager().beginTransaction().replace(R.id.fragmant_container, selectFragment).commit();

                    }
                    return true;
                }

                private void logout() {
 final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
    builder.setMessage("Are you sure you want to log out?").setCancelable(true).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            AlertDialog alertDialog=builder.create();
            alertDialog.show();

            firebaseAuth.signOut();
            startActivity(new Intent(getActivity(), Login.class));

        }
    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
        }
    });
    AlertDialog alertDialog=builder.create();
    alertDialog.show();
                }

            });


        }
        return v;
    }
        @Override
        public void onAttach (Activity activity){
            myContext = (FragmentActivity) activity;
            super.onAttach(activity);
        }

}