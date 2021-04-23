package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class SearchBus extends AppCompatActivity implements View.OnClickListener {

    TextView datetxt;
    TextView e1,e2;
    Spinner busroute,busroute2;
    private FirebaseAuth firebaseAuth;
    Button b1,b2;
    private int mYear, mMonth, mDay;
    String d;
    private ProgressDialog progressDialog;
    private DatabaseReference databaseReference;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bus);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));


        e1=(TextView)findViewById(R.id.editText);
        e2=(TextView) findViewById(R.id.editText3);
        busroute=(Spinner) findViewById(R.id.spinner);
        busroute2=(Spinner) findViewById(R.id.spinner2);
        datetxt=(TextView)findViewById(R.id.editTextTextPersonName3);
        b1=(Button)findViewById(R.id.button5);
        b2=(Button)findViewById(R.id.button7);
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, Login.class));
        }
       b1.setOnClickListener(this);
        b2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==b1)
        {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(SearchBus.this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth){

                            d=dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                            datetxt.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }

        if(v==b2) {
            searchBus();
        }
    }

    private void searchBus() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
            firebaseAuth = FirebaseAuth.getInstance();
            progressDialog = new ProgressDialog(this);

            progressDialog.setMessage("Searching Buses Please Wait...");
            progressDialog.show();


            String arrival = busroute2.getSelectedItem().toString();

            BookingDetails bookingDetails = new BookingDetails(

                    arrival

            );
//  FirebaseUser register = firebaseAuth.getCurrentUser();

 databaseReference.child("Buses").orderByChild("arrival").equalTo(arrival);
//

        Intent search2 = new Intent(SearchBus.this, Booking.class);

            search2.putExtra("To", arrival);
            startActivity(search2);
            progressDialog.dismiss();

        }


    }
