package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Addbuses extends AppCompatActivity implements View.OnClickListener {

    Button btnTimePicker,btnTimePicker2,date,submit;
    EditText time,time2,datetxt,seat;
    EditText busno,busname;
    Spinner busroute,busroute2;
    String d;
    String t1,t2;

    private int mYear, mMonth, mDay, mHour, mMinute;
    DatabaseReference registerDbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbuses);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

        busno=(EditText)findViewById(R.id.e1);
        busname=(EditText)findViewById(R.id.e2);
        time=(EditText)findViewById(R.id.time);
        time2=(EditText)findViewById(R.id.time2);
        datetxt=(EditText)findViewById(R.id.datetxt);
        seat=(EditText)findViewById(R.id.seats);
        busroute=(Spinner) findViewById(R.id.spinner);
        busroute2=(Spinner) findViewById(R.id.spinner2);
        btnTimePicker=(Button)findViewById(R.id.button3);
        btnTimePicker2=(Button)findViewById(R.id.button4);
        date=(Button)findViewById(R.id.date);
        submit=(Button)findViewById(R.id.button6);

        btnTimePicker.setOnClickListener(this);
        btnTimePicker2.setOnClickListener(this);
        date.setOnClickListener(this);
        submit.setOnClickListener(this);
      }

    @Override
    public void onClick(View v) {
        if (v == btnTimePicker) {


            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            t1=hourOfDay + ":" + minute;
                            time.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
        if(v==btnTimePicker2)
        {
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                           t2= hourOfDay + ":" + minute;
//                            String d=String.valueOf(hourOfDay);
//                            String m=String.valueOf(minute);
//                            String combine=d+m;

                            time2.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
        if(v==date)
        {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
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
        if(v==submit)
        {
            String busnumber=busno.getText().toString();
            String Busname=busname.getText().toString();
            String departure=busroute.getSelectedItem().toString();
            String arrival=busroute2.getSelectedItem().toString();
            String Seats=seat.getText().toString();
            String DATE=datetxt.getText().toString();
            String timedept=time.getText().toString();
            String timearrv=time2.getText().toString();

            registerDbRef= FirebaseDatabase.getInstance().getReference().child("Buses");

            Buses information=new Buses(
                    busnumber,
                    Busname,
                    departure,
                    arrival,
                    Seats,
                    d,
                    t1,
                    t2
            );
            registerDbRef.push().setValue(information);

            Toast.makeText(getApplicationContext(),"Record Inserted",Toast.LENGTH_LONG).show();





        }


    }

}