package com.example.kqxs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

    public class Home extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_home);

            ImageButton imgkqmb = findViewById(R.id.imgkqmb);
            imgkqmb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Home.this, ShowKQXSMB.class);
                    startActivity(intent);
                }
            });

        ImageButton imgkqtd = findViewById(R.id.imgkqd);
            imgkqtd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, ListXSTheoDai.class);
                startActivity(intent);
            }
        });
            ImageButton imgcalender = findViewById(R.id.imgcalender);
            imgcalender.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Home.this, Calender.class);
                    startActivity(intent);
                }
            });
            ImageButton imgdt123 = findViewById(R.id.imgdt123);
            imgdt123.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Home.this, ShowKQXSDT123.class);
                    startActivity(intent);
                }
            });
            ImageButton imgdt636 = findViewById(R.id.imgdt6x36);
            imgdt636.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Home.this, ShowKQXSDT636.class);
                    startActivity(intent);
                }
            });
            ImageButton imgtt4 = findViewById(R.id.imgtt4);
            imgtt4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Home.this, ShowKQXSTT4.class);
                    startActivity(intent);
                }
            });
     }
    }
