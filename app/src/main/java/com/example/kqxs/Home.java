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
     }
    }
