package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Location extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner s1;
    TextView txte;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        s1 = findViewById(R.id.spinner);
        btn = findViewById(R.id.button);
        txte = findViewById(R.id.textView);
        ArrayAdapter<CharSequence> adap = ArrayAdapter.createFromResource(this,R.array.loc, android.R.layout.simple_spinner_item);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adap);
        s1.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position==0)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager frm = getSupportFragmentManager();
                    FragmentTransaction frt = frm.beginTransaction();
                    frt.add(R.id.sq,new mallroad());
                    frt.addToBackStack(null);
                    frt.commit();
                }
            });

        }
        if(position==1)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager frm = getSupportFragmentManager();
                    FragmentTransaction frt = frm.beginTransaction();
                    frt.add(R.id.sq,new samanabad());
                    frt.addToBackStack(null);
                    frt.commit();
                }
            });

        }
        if(position==2)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager frm = getSupportFragmentManager();
                    FragmentTransaction frt = frm.beginTransaction();
                    frt.add(R.id.sq,new gulshanravi());
                    frt.addToBackStack(null);
                    frt.commit();
                }
            });

        }
        if(position==3)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager frm = getSupportFragmentManager();
                    FragmentTransaction frt = frm.beginTransaction();
                    frt.add(R.id.sq,new greentown());
                    frt.addToBackStack(null);
                    frt.commit();
                }
            });

        }
        if(position==4)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager frm = getSupportFragmentManager();
                    FragmentTransaction frt = frm.beginTransaction();
                    frt.add(R.id.sq,new wapdatown());
                    frt.addToBackStack(null);
                    frt.commit();
                }
            });

        }
        if(position==5)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager frm = getSupportFragmentManager();
                    FragmentTransaction frt = frm.beginTransaction();
                    frt.add(R.id.sq,new modeltown());
                    frt.addToBackStack(null);
                    frt.commit();
                }
            });

        }
        if(position==6)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager frm = getSupportFragmentManager();
                    FragmentTransaction frt = frm.beginTransaction();
                    frt.add(R.id.sq,new johartown());
                    frt.addToBackStack(null);
                    frt.commit();
                }
            });

        }
        if(position==7)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager frm = getSupportFragmentManager();
                    FragmentTransaction frt = frm.beginTransaction();
                    frt.add(R.id.sq,new raiwindroad());
                    frt.addToBackStack(null);
                    frt.commit();
                }
            });

        }
        if(position==8)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager frm = getSupportFragmentManager();
                    FragmentTransaction frt = frm.beginTransaction();
                    frt.add(R.id.sq,new emporiummall());
                    frt.addToBackStack(null);
                    frt.commit();
                }
            });

        }
        if(position==9)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager frm = getSupportFragmentManager();
                    FragmentTransaction frt = frm.beginTransaction();
                    frt.add(R.id.sq,new jailroad());
                    frt.addToBackStack(null);
                    frt.commit();
                }
            });

        }
        if(position==10)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager frm = getSupportFragmentManager();
                    FragmentTransaction frt = frm.beginTransaction();
                    frt.add(R.id.sq,new punjabuniversity());
                    frt.addToBackStack(null);
                    frt.commit();
                }
            });

        }
        if(position==11)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager frm = getSupportFragmentManager();
                    FragmentTransaction frt = frm.beginTransaction();
                    frt.add(R.id.sq,new mughalpura());
                    frt.addToBackStack(null);
                    frt.commit();
                }
            });

        }
        if(position==12)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager frm = getSupportFragmentManager();
                    FragmentTransaction frt = frm.beginTransaction();
                    frt.add(R.id.sq,new hasbanspura());
                    frt.addToBackStack(null);
                    frt.commit();
                }
            });

        }
        if(position==13)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager frm = getSupportFragmentManager();
                    FragmentTransaction frt = frm.beginTransaction();
                    frt.add(R.id.sq,new gulberg());
                    frt.addToBackStack(null);
                    frt.commit();
                }
            });

        }
        if(position==14)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager frm = getSupportFragmentManager();
                    FragmentTransaction frt = frm.beginTransaction();
                    frt.add(R.id.sq,new dha());
                    frt.addToBackStack(null);
                    frt.commit();
                }
            });

        }
        if(position==15)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager frm = getSupportFragmentManager();
                    FragmentTransaction frt = frm.beginTransaction();
                    frt.add(R.id.sq,new cantt());
                    frt.addToBackStack(null);
                    frt.commit();
                }
            });

        }
        if(position==16)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager frm = getSupportFragmentManager();
                    FragmentTransaction frt = frm.beginTransaction();
                    frt.add(R.id.sq,new muslimtown());
                    frt.addToBackStack(null);
                    frt.commit();
                }
            });

        }
        if(position==17)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager frm = getSupportFragmentManager();
                    FragmentTransaction frt = frm.beginTransaction();
                    frt.add(R.id.sq,new collegeroad());
                    frt.addToBackStack(null);
                    frt.commit();
                }
            });

        }
        if(position==18)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager frm = getSupportFragmentManager();
                    FragmentTransaction frt = frm.beginTransaction();
                    frt.add(R.id.sq,new township());
                    frt.addToBackStack(null);
                    frt.commit();
                }
            });

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}