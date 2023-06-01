package com.example.kqxs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ShowVeSo extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BanVSOnlineAdapter adapter;
    private DatabaseVS dbvs;
    private FloatingActionButton fab1;
    private FloatingActionButton fab2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongkesoxo);
        recyclerView = findViewById(R.id.list_view);
        dbvs = new DatabaseVS(this);
        dbvs.insertData(dbvs.getWritableDatabase(), "999999", "TP HCM", "2023-06-01", "10");
        dbvs.insertData(dbvs.getWritableDatabase(), "234567", "Long An", "2023-06-01", "9");
        dbvs.insertData(dbvs.getWritableDatabase(), "456678", "Bình Dương", "2023-06-01", "2");
        dbvs.insertData(dbvs.getWritableDatabase(), "456787", "Đồng Tháp", "2023-06-01", "1");
        dbvs.insertData(dbvs.getWritableDatabase(), "435673", "Vũng Tàu", "2023-06-01", "2");
        dbvs.insertData(dbvs.getWritableDatabase(), "111111", "Sóc Trăng", "2023-06-01", "1");
//       dbvs.deleteAllData();
        adapter = new BanVSOnlineAdapter(dbvs.getAllveso());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        fab1 = findViewById(R.id.tkxsBackHome);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowVeSo.this, Home.class);
                startActivity(intent);
            }
        });
        fab2 = findViewById(R.id.tkxsDH);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowVeSo.this, ThemKH.class);
                startActivity(intent);
            }
        });
    }
}
