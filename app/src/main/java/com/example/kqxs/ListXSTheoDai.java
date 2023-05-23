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
        Button btn_tn = findViewById(R.id.kqxstn);
        btn_tn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSTNh.class);
                startActivity(intent);
            }
        });
        Button btn_tth = findViewById(R.id.kqxstth);
        btn_tth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSTTH.class);
                startActivity(intent);
            }
        });
        Button btn_tv = findViewById(R.id.kqxstv);
        btn_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSTV.class);
                startActivity(intent);
            }
        });
        Button btn_vl = findViewById(R.id.kqxsvl);
        btn_vl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSVL.class);
                startActivity(intent);
            }
        });
        Button btn_vt = findViewById(R.id.kqxsvt);
        btn_vt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSVT.class);
                startActivity(intent);
            }
        });
        Button btn_kt = findViewById(R.id.kqxskt);
        btn_kt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSKT.class);
                startActivity(intent);
            }
        });
        Button btn_la = findViewById(R.id.kqxsla);
        btn_la.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSLA.class);
                startActivity(intent);
            }
        });
    }
}
