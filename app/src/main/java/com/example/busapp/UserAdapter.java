package com.example.busapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class UserAdapter extends FirebaseRecyclerAdapter<Register,UserAdapter.myviewholder> {

    public UserAdapter(@NonNull FirebaseRecyclerOptions<Register> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull Register model) {

        holder.pid.setText("Passenger No  "+model.getPessangerno());
        holder.fullname.setText("Full Name  "+model.getFullname());
        holder.phone.setText("Phone Number  "+model.getPhone());
        holder.user.setText("Email Address  "+model.getUser());
        holder.bus.setText("Bus Route  "+model.getBus());

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.pid.getContext())
                        .setContentHolder(new ViewHolder(R.layout.updateuser))
                        .setExpanded(true,1350)
                        .create();

                View myview=dialogPlus.getHolderView();

                EditText passengerid=myview.findViewById(R.id.pid);
                EditText fullname=myview.findViewById(R.id.name);
                EditText phonenumber=myview.findViewById(R.id.phonenumber);
                EditText email=myview.findViewById(R.id.UsernameSignup);
                EditText route=myview.findViewById(R.id.editText);
                Button submit=myview.findViewById(R.id.b1);

                passengerid.setText(model.getPessangerno());
                fullname.setText(model.getFullname());
                email.setText(model.getUser());
                phonenumber.setText(model.getPhone());
                route.setText(model.getBus());
                dialogPlus.show();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map=new HashMap<>();
                        map.put("pessangerno",passengerid.getText().toString());
                        map.put("fullname",fullname.getText().toString());
                        map.put("user",email.getText().toString());
                        map.put("phone",phonenumber.getText().toString());
                        map.put("bus",route.getText().toString());



                        FirebaseDatabase.getInstance().getReference().child("Register")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        dialogPlus.dismiss();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
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
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.pid.getContext());
                builder.setTitle("Delete User");
                builder.setMessage("Are You Sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("Register")
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
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowuser,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img1,edit,delete;
        TextView pid, fullname,phone,user,bus;

        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            pid=(TextView)itemView.findViewById(R.id.pid);
            fullname=(TextView)itemView.findViewById(R.id.fullname);
            phone=(TextView)itemView.findViewById(R.id.phone);
            user=(TextView)itemView.findViewById(R.id.user);
            bus=(TextView)itemView.findViewById(R.id.bus);

            edit=(ImageView)itemView.findViewById(R.id.edit);
            delete=(ImageView)itemView.findViewById(R.id.delete);
        }


    }


}
