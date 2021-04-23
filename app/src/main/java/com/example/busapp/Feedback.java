package com.example.busapp;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Feedback extends AppCompatActivity {

    EditText recipient,subject,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));


        Button button = (Button) findViewById(R.id.button);
        recipient = (EditText) findViewById(R.id.recipient);
        subject = (EditText) findViewById(R.id.subject);
        message = (EditText) findViewById(R.id.message);

        recipient.setText("sheryarjutt225@gmail.com");
        recipient.setEnabled(false);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String a = recipient.getText().toString();
                String b = subject.getText().toString();
                String c = message.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"+ a));
                intent.putExtra(Intent.EXTRA_SUBJECT,b);
                intent.putExtra(Intent.EXTRA_TEXT,c);
                startActivity(intent);
//                 sendEmail();
            }
        });
    }
}
