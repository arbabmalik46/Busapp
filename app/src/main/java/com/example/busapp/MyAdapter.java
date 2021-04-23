package com.example.busapp;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MyAdapter extends FirebaseRecyclerAdapter<Buses,MyAdapter.myviewholder> {


    String d;
    String t1,t2;
    int mYear, mMonth, mDay, mHour, mMinute;
    public MyAdapter(@NonNull FirebaseRecyclerOptions<Buses> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull Buses model) {

        Button btnTimePicker,btnTimePicker2;

        String d;
        String t1,t2;
        holder.busno.setText("Bus Number  : "+model.getBusno());
        holder.busname.setText("BusName  : "+model.getBusname());
        holder.from.setText("From  : "+model.getDepature());
        holder.to.setText("To   : "+model.getArrival());
        holder.seats.setText("Seats  : "+model.getSeats());
        holder.date.setText("Date  : "+model.getDate());
        holder.depttime.setText("DeptTime   : "+model.getTimedept());
        holder.arrtime.setText("ArrTime  : "+model.getTimearrv());

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  final DialogPlus dialogPlus=DialogPlus.newDialog(holder.busno.getContext())
                          .setContentHolder(new ViewHolder(R.layout.update))
                          .setExpanded(true,1100)
                          .create();

            View myview=dialogPlus.getHolderView();
              EditText  busno=myview.findViewById(R.id.e1);
              EditText  busname=myview.findViewById(R.id.e2);
              EditText from=myview.findViewById(R.id.editText);
                EditText to=myview.findViewById(R.id.editText3);
              EditText time=myview.findViewById(R.id.time);
              EditText  time2=myview.findViewById(R.id.time2);
              EditText datetxt=myview.findViewById(R.id.datetxt);
              EditText   seats=myview.findViewById(R.id.seats);
               Button submit=myview.findViewById(R.id.button6);

                busno.setText(model.getBusno());
               busname.setText(model.getBusname());
               from.setText(model.getDepature());
               to.setText(model.getArrival());
               time.setText(model.getTimedept());
               time2.setText(model.getTimearrv());
               seats.setText(model.getSeats());
               datetxt.setText(model.getDate());
               dialogPlus.show();

               submit.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Map<String,Object> map=new HashMap<>();
                       map.put("busno",busno.getText().toString());
                       map.put("busname",busname.getText().toString());
                       map.put("depature",from.getText().toString());
                       map.put("arrival",to.getText().toString());
                       map.put("seats",seats.getText().toString());
                       map.put("date",datetxt.getText().toString());
                       map.put("timedept",time.getText().toString());
                       map.put("timearr",time2.getText().toString());

                       FirebaseDatabase.getInstance().getReference().child("Buses")
                               .child(getRef(position).getKey()).updateChildren(map)
                               .addOnSuccessListener(new OnSuccessListener<Void>() {
                                   @Override
                                   public void onSuccess(Void aVoid) {
                                       dialogPlus.dismiss();

                                   }
                               })
                               .addOnFailureListener(new OnFailureListener() {
                                   @Override
                                   public void onFailure(@NonNull Exception e) {

                                       dialogPlus.dismiss();
                                   }
                               });
                   }
               });


            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.busno.getContext());
                builder.setTitle("Delete Bus");
                builder.setMessage("Are You Sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("Buses")
                                .child(getRef(position).getKey()).removeValue();

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);

        return new MyAdapter.myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img1,edit,delete;
        TextView busno,busname,from,to,seats,date,depttime,arrtime;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            img1=itemView.findViewById(R.id.img1);
            busno=itemView.findViewById(R.id.busnumber);
            busname=itemView.findViewById(R.id.Busname);
            from=itemView.findViewById(R.id.from);
            to=itemView.findViewById(R.id.to);
            seats=itemView.findViewById(R.id.seats);
            date=itemView.findViewById(R.id.date);
            depttime=itemView.findViewById(R.id.depttime);
            arrtime=itemView.findViewById(R.id.arrtime);

            edit=(ImageView)itemView.findViewById(R.id.edit);
            delete=(ImageView)itemView.findViewById(R.id.delete);


        }
    }


}
