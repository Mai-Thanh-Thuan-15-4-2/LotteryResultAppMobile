package com.example.kqxs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ShowKQXSKH extends AppCompatActivity {

    private ArrayList<KQXSModel> rssItems;
    private RecyclerView recyclerView;
    private KQXSKHAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_kqxs);


        rssItems = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new KQXSKHAdapter(rssItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.xsBackHome);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowKQXSKH.this, ListXSTheoDai.class);
                startActivity(intent);
            }
        });
        loadRssAG();
    }

    private void loadRssAG() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document rssDocument = Jsoup.connect("https://kqxs.net.vn/rss-feed/xo-so-khanh-hoa-xskh.rss").get();
                    Elements items = rssDocument.select("item");
                    for (Element item : items) {
                        String title = item.selectFirst("title").text();
                        String des = item.selectFirst("description").text();
                        String pubDate = item.selectFirst("pubDate").text();
                        KQXSModel kqxsag = new KQXSModel(title, des, pubDate);
                        rssItems.add(kqxsag);
                    }

                    System.out.println("KQXS AG: " + rssItems);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

