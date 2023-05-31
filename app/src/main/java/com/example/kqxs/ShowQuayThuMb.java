package com.example.kqxs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class ShowQuayThuMb extends AppCompatActivity {

    private Button buttonQuayThu;
    private Button buttonXemThu;
    private TextView textViewG8;
    private TextView textViewG7;
    private TextView textViewG6;
    private TextView textViewG5;
    private TextView textViewG4;
    private TextView textViewG3;
    private TextView textViewG2;
    private TextView textViewG1;
    private TextView textViewGDB;
    private FloatingActionButton fab;
    private boolean isStopped = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quaythumb);

        buttonQuayThu = findViewById(R.id.button);
        buttonXemThu = findViewById(R.id.button2);

        textViewG7 = findViewById(R.id.textViewG7);
        textViewG6 = findViewById(R.id.textViewG6);
        textViewG5 = findViewById(R.id.textViewG5);
        textViewG4 = findViewById(R.id.textViewG4);
        textViewG3 = findViewById(R.id.textViewG3);
        textViewG2 = findViewById(R.id.textViewG2);
        textViewG1 = findViewById(R.id.textViewG1);
        textViewGDB = findViewById(R.id.textViewGDB);
        fab = findViewById(R.id.quaythumbBackHome);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowQuayThuMb.this, ListQuayThu.class);
                startActivity(intent);
            }
        });
        buttonQuayThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quayThu();
            }
        });

        buttonXemThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isStopped = true;
                buttonQuayThu.setEnabled(true);
                buttonXemThu.setEnabled(false);
            }
        });
    }

    private void quayThu() {
        isStopped = false;
        buttonQuayThu.setEnabled(false);
        buttonXemThu.setEnabled(true);

        Random random = new Random();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isStopped) {
                    // Giải 7
                    for (int i = 0; i < 4; i++) {
                        int numberG7 = random.nextInt(100);
                        final int finalI = i;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (finalI == 0) {
                                    textViewG7.setText(String.format("%02d", numberG7));
                                } else {
                                    textViewG7.append("-" + String.format("%02d", numberG7));
                                }
                            }
                        });
                    }

                    // Giải 6
                    for (int i = 0; i < 3; i++) {
                        int numberG6 = random.nextInt(1000);
                        final int finalI = i;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (finalI == 0) {
                                    textViewG6.setText(String.format("%03d", numberG6));
                                } else {
                                    textViewG5.append("-" + String.format("%03d", numberG6));
                                }
                            }
                        });
                    }

                    // Giải 5
                    for (int i = 0; i < 6; i++) {
                        int numberG5 = random.nextInt(1000);
                        final int finalI = i;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (finalI == 0) {
                                    textViewG5.setText(String.format("%04d", numberG5));
                                } else {
                                    textViewG5.append("-" + String.format("%04d", numberG5));
                                }
                            }
                        });
                    }

                    // Giải 5
                    for (int i = 0; i < 6; i++) {
                        int numberG5 = random.nextInt(10000);
                        final int finalI = i;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (finalI == 0) {
                                    textViewG5.setText(String.format("%05d", numberG5));
                                } else {
                                    textViewG5.append("-" + String.format("%05d", numberG5));
                                }
                            }
                        });
                    }

                    // Giải 4
                    for (int i = 0; i < 4; i++) {
                        int numberG4 = random.nextInt(10000);
                        final int finalI = i;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (finalI == 0) {
                                    textViewG4.setText(String.format("%04d", numberG4));
                                } else {
                                    textViewG4.append("-" + String.format("%04d", numberG4));
                                }
                            }
                        });
                    }

                    // Giải 3
                    for (int i = 0; i < 6; i++) {
                        int numberG3 = random.nextInt(100000);
                        final int finalI = i;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (finalI == 0) {
                                    textViewG3.setText(String.format("%05d", numberG3));
                                } else {
                                    textViewG3.append("-" + String.format("%05d", numberG3));
                                }
                            }
                        });
                    }

                    // Giải 2
                    for (int i = 0; i < 2; i++) {
                        int numberG2 = random.nextInt(100000);
                        final int finalI = i;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (finalI == 0) {
                                    textViewG2.setText(String.format("%05d", numberG2));
                                } else {
                                    textViewG2.append("-" + String.format("%05d", numberG2));
                                }
                            }
                        });
                    }

                    // Giải 1
                    int numberG1 = random.nextInt(100000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textViewG1.setText(String.format("%05d", numberG1));
                        }
                    });

                    // Giải đặc biệt
                    int numberGDB = random.nextInt(100000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textViewGDB.setText(String.format("%05d", numberGDB));
                        }
                    });

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        buttonQuayThu.setEnabled(true);
                        buttonXemThu.setEnabled(false);
                    }
                });
            }
        }).start();
    }
}
