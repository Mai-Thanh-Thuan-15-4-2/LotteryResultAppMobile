package com.example.kqxs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ResultCheckTickets extends AppCompatActivity {
    private ListView listView;
    private ListResultTicketAdapter adapter;
    private CheckTicketService checkTicketService = new CheckTicketService();
    private List<TicketModel> ticketList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_check_tickets);
        listView = findViewById(R.id.listViewResultTicket);

        Intent intent = getIntent();
        List<TicketModel> ticketList = (List<TicketModel>) intent.getSerializableExtra("tickets");

        ticketList = checkTicketService.kiemTraTrungGiai(ticketList);
        adapter = new ListResultTicketAdapter(this, ticketList);
        listView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.xstheodaiBackHome);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}