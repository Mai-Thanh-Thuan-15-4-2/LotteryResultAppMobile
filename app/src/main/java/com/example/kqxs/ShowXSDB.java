package com.example.kqxs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ShowXSDB extends AppCompatActivity {

    private RecyclerView recyclerView;
    private KQXSDBAdapter adapter;
    private DatabaseSX dbHelper;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongkesoxo);

        recyclerView = findViewById(R.id.list_view);
        dbHelper = new DatabaseSX(this);
        adapter = new KQXSDBAdapter(dbHelper.getAllKQXS());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        fab = findViewById(R.id.tkxsBackHome);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowXSDB.this, Home.class);
                startActivity(intent);
            }
        });
    }
}
