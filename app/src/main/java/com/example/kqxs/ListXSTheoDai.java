package com.example.kqxs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListXSTheoDai extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_xstheodai);
        FloatingActionButton fab = findViewById(R.id.xstheodaiBackHome);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, Home.class);
                startActivity(intent);
            }
        });
        Button btn_ag = findViewById(R.id.kqxsag);
        btn_ag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSAG.class);
                startActivity(intent);
            }
        });
    }
}
