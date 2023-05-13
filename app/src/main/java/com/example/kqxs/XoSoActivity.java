package com.example.kqxs;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
public class XoSoActivity extends AppCompatActivity {

    private Button prize1, prize2, prize3, prize4, prize5, prize6, prize7, prize8;
    private TextView prize1Number, prize2Number, prize3Number, prize4Number, prize5Number, prize6Number, prize7Number, prize8Number;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss);

        prize1 = findViewById(R.id.prize1);
        prize2 = findViewById(R.id.prize2);
        prize3 = findViewById(R.id.prize3);
        prize4 = findViewById(R.id.prize4);
        prize5 = findViewById(R.id.prize5);
        prize6 = findViewById(R.id.prize6);
        prize7 = findViewById(R.id.prize7);
        prize8 = findViewById(R.id.prize8);


        prize1Number = findViewById(R.id.prize1_number);
        prize2Number = findViewById(R.id.prize2_number);
        prize3Number = findViewById(R.id.prize3_number);
        prize4Number = findViewById(R.id.prize4_number);
        prize5Number = findViewById(R.id.prize5_number);
        prize6Number = findViewById(R.id.prize6_number);
        prize7Number = findViewById(R.id.prize7_number);
        prize8Number = findViewById(R.id.prize8_number);



        prize1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = getRandomNumber(6);
                prize1Number.setText(number);
            }
        });

        prize2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = getRandomNumber(5);
                prize2Number.setText(number);
            }
        });

        prize3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "";
                for (int i = 0; i < 2; i++) {
                    number += getRandomNumber(5) + " ";
                }
                prize3Number.setText(number.trim());
            }
        });

        prize4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "";
                for (int i = 0; i < 7; i++) {
                    number += getRandomNumber(5) + " ";
                }
                prize4Number.setText(number.trim());
            }
        });

        prize5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = getRandomNumber(4);
                prize5Number.setText(number);
            }
        });

        prize6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "";
                for (int i = 0; i < 3; i++) {
                    number += getRandomNumber(4) + " ";
                }
                prize6Number.setText(number.trim());
            }
        });

        prize7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = getRandomNumber(3);
                prize7Number.setText(number);
            }
        });

        prize8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = getRandomNumber(2);
                prize8Number.setText(number);
            }
        });
    }

    private String getRandomNumber(int length) {
        Random random = new Random();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < length; i++) {
            number.append(random.nextInt(10));
        }
        return number.toString();
    }
}
