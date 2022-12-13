package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email, subilect, messange;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.edt_1);
        subilect = findViewById(R.id.edt_2);
        messange = findViewById(R.id.edt_3);
        send = findViewById(R.id.btn_send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String recipent = email.getText().toString().trim();
                String subilec = subilect.getText().toString().trim();
                String messang = messange.getText().toString().trim();

                sende(recipent, subilec, messang);
            }
        });
    }

    @SuppressLint("IntentReset")
    private void sende(String recipent, String subilec, String messang) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto;"));
        intent.setType("text/*");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{recipent});
        intent.putExtra(Intent.EXTRA_SUBJECT, subilec );
        intent.putExtra(Intent.EXTRA_TEXT, messang );

        try {
            startActivity(Intent.createChooser(intent, " Choose an Email Client "));
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}