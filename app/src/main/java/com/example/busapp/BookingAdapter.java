package com.example.busapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.List;
import java.util.Random;

public class BookingAdapter extends FirebaseRecyclerAdapter<Buses,BookingAdapter.viewholder> {

    private List<Buses> mList;
    private Activity mactivity;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    public BookingAdapter(@NonNull FirebaseRecyclerOptions<Buses> options)
    {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull Buses model) {

        holder.busno.setText("BusNo"+model.getBusno());
        holder.busname.setText("BusName  "+model.getBusname());
        holder.from.setText("From "+model.getDepature());
        holder.to.setText("To  "+model.getArrival());
        holder.seats.setText("Seats  "+model.getSeats());
        holder.date.setText("Date  "+model.getDate());
        holder.depttime.setText("Dept Time "+model.getTimedept());
        holder.arrtime.setText("Arrival Time  "+model.getTimearrv());

        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.busno.getContext())
                        .setContentHolder(new ViewHolder(R.layout.activity_ticket))
                        .setExpanded(true,1350)
                        .create();
                Random r = new Random();
                int random_no = r.nextInt((9999999 - 10)+ 9999999);
                View myview=dialogPlus.getHolderView();

                TextView ticketno=myview.findViewById(R.id.random_ticket);
                TextView dept=myview.findViewById(R.id.textView14);
                TextView depttime=myview.findViewById(R.id.textView15);
                TextView date=myview.findViewById(R.id.textView16);
                TextView busno=myview.findViewById(R.id.textView17);
               TextView rand = myview.findViewById(R.id.random_ticket);

                Button feedback=myview.findViewById(R.id.button3);

                rand.setText("#"+random_no);
                busno.setText(model.getBusno());
                dept.setText(model.getDepature());
                date.setText(model.getDate());
                depttime.setText(model.getTimedept());

                dialogPlus.show();

                feedback.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {




                        Toast.makeText(v.getContext(), "Your Ticket has been Confirmed Now Enjoy your Journey", Toast.LENGTH_SHORT).show();


                    }
                });

            }
        });


    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.displaybooking,parent,false);
        return new viewholder(view);
    }


    class viewholder extends RecyclerView.ViewHolder
    {
        ImageView img1;
        Button book;
        TextView busno,busname,from,to,seats,date,depttime,arrtime;
        public viewholder(@NonNull View itemView)
        {
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

            book=itemView.findViewById(R.id.book);

        }

    }


}
