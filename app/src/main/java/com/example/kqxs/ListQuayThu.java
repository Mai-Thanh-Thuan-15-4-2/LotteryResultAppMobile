package com.example.kqxs;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListQuayThu  extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_quaythu);
        FloatingActionButton fab = findViewById(R.id.listqtBackHome);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListQuayThu.this, Home.class);
                startActivity(intent);
            }
        });
        Button quaythumn = findViewById(R.id.quaythumn);
        quaythumn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListQuayThu.this, ShowQuayThuMn.class);
                startActivity(intent);
            }
        });
        Button btn_tn = findViewById(R.id.quaythumb);
        btn_tn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListQuayThu.this, ShowQuayThuMb.class);
                startActivity(intent);
            }
        });
    }
}
