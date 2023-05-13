package com.example.kqxs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import com.example.kqxs.XoSoActivity;

public class MainActivity extends AppCompatActivity {

    private Button rssButton;
    private Button xosoButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rssButton = findViewById(R.id.rssButton);
        rssButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RssActivity.class);
                startActivity(intent);
            }
        });

        xosoButton = findViewById(R.id.xosoButton);
        xosoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, XoSoActivity.class);
                startActivity(intent);
            }
        });
        
    }
}



