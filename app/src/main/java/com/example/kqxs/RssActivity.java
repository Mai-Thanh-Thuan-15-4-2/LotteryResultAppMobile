package com.example.kqxs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class RssActivity extends AppCompatActivity {

    private ArrayList<RssItem> rssItems;
    private RecyclerView recyclerView;
    private RssAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss);

        rssItems = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new RssAdapter(rssItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rssItems.clear();
                adapter.notifyDataSetChanged();
                loadRss();
            }
        });

        loadRss();
    }

    private void loadRss() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document rssDocument = Jsoup.connect("https://ketqua247vn.com/rss/xsmb-thu-2.rss").get();
                    Elements items = rssDocument.select("item");
                    for (Element item : items) {
                        String title = item.selectFirst("title").text();
                        String pubDate = item.selectFirst("pubDate").text();

                        RssItem rssItem = new RssItem(title, pubDate);
                        rssItems.add(rssItem);
                    }

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
