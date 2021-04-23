package com.example.busapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class BookingAdapter extends FirebaseRecyclerAdapter<Buses,BookingAdapter.viewholder> {
    Context context;
    private List<Buses> mList;
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
                String busno=model.getBusno();
                String busname=model.getBusname();
                String from=model.getDepature();
                String to=model.getArrival();
                String seats=model.getSeats();
                String date=model.getDate();
                String depttime=model.getTimedept();
                String arrtime=model.getTimearrv();

                Buses buses=new Buses(busno,
                        busname,
                        from,
                        to,
                        seats,
                        date,
                        depttime,
                        arrtime
                );
                FirebaseUser user1=firebaseAuth.getCurrentUser();
                databaseReference.child(user1.getUid()).child("Buses").setValue(buses);
                Intent intent=new Intent(context.getApplicationContext(),Ticket_Class.class);
                intent.putExtra("from",from);
                intent.putExtra("to",to);
                intent.putExtra("date",date);
                intent.putExtra("Dept time",depttime);
                intent.putExtra("Arrical Time",arrtime);
                context.startActivity(intent);

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
