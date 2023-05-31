package com.example.kqxs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.method.TimeKeyListener;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuCheckTicket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_check_ticket);

        FloatingActionButton fab = findViewById(R.id.xstheodaiBackHome);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btn_result = findViewById(R.id.btnResult);

        List<TicketModel> listTicket = loadRss();

        List<TicketModel> listTicketResult = new ArrayList<>();

        Set<TicketModel> setList = new HashSet<>();

        if(listTicket != null) for (TicketModel ticket : listTicket) {
            String soTrungThuong = ticket.getSoTrungThuong();
            if (!setList.contains(soTrungThuong)) {
                setList.add(ticket);
            }
        }
        for (TicketModel ticket : setList) {
            listTicketResult.add(ticket);
        }
        listTicket.clear();
        if(setList != null)  for(TicketModel ticketModel : setList){
            listTicket.add(ticketModel);
        }
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuCheckTicket.this, ResultCheckTickets.class);
                intent.putExtra("tickets", (Serializable) listTicketResult);
                startActivity(intent);
            }
        });

        Button btn_add = findViewById(R.id.btnAddTicket);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuCheckTicket.this, InsertTicket.class);
                startActivity(intent);
            }
        });
    }

    private List<TicketModel> loadRss() {
        //List<TicketModel> listTicket = CheckTicketService.getListTicket();
        Database database = new Database(this);
        List<TicketModel> listTicket = database.getAllTickets();
        String rss = "";

        for(TicketModel ticketModel : listTicket){
            if(ticketModel.getLoaiXoSo().equals("Xổ số Cần Thơ")){
                rss ="https://kqxs.net.vn/rss-feed/xo-so-can-tho-xsct.rss";
            }else if(ticketModel.getLoaiXoSo().equals("XSDLK")){
                rss = "https://kqxs.net.vn/rss-feed/xo-so-dak-lak-xsdlk.rss";
            }else if(ticketModel.getLoaiXoSo().equals("Xổ số Đồng Nai")){
                rss = "https://kqxs.net.vn/rss-feed/xo-so-dong-nai-xsdn.rss";
            }else if(ticketModel.getLoaiXoSo().equals("XSDNG")){
                rss = "https://kqxs.net.vn/rss-feed/xo-so-da-nang-xsdng.rss";
            }else if(ticketModel.getLoaiXoSo().equals("XSDNO")){
                rss = "https://kqxs.net.vn/rss-feed/xo-so-dak-nong-xsdno.rss";
            }else if(ticketModel.getLoaiXoSo().equals("XSDT")){
                rss = "https://kqxs.net.vn/rss-feed/xo-so-dong-thap-xsdt.rss";
            }else if(ticketModel.getLoaiXoSo().equals("")){
                rss = "https://kqxs.net.vn/rss-feed/xo-so-gia-lai-xsgl.rss";
            }else if(ticketModel.getLoaiXoSo().equals("XSHCM")){
                rss = "https://kqxs.net.vn/rss-feed/xo-so-tphcm-xshcm.rss";
            }else if(ticketModel.getLoaiXoSo().equals("Xổ số Hậu Giang")){
                rss = "https://kqxs.net.vn/rss-feed/xo-so-hau-giang-xshg.rss";
            }else if(ticketModel.getLoaiXoSo().equals("XSKG")){
                rss = "https://kqxs.net.vn/rss-feed/xo-so-kien-giang-xskg.rss";
            }else if(ticketModel.getLoaiXoSo().equals("XSAG")){
                rss = "https://kqxs.net.vn/rss-feed/xo-so-an-giang-xsag.rss";
            }else if(ticketModel.getLoaiXoSo().equals("XSBD")){
                rss ="https://kqxs.net.vn/rss-feed/xo-so-binh-duong-xsbd.rss";
            }else if(ticketModel.getLoaiXoSo().equals("XSDI")){
                rss ="https://kqxs.net.vn/rss-feed/xo-so-binh-dinh-xsbdi.rss";
            }

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Document rssDocument = Jsoup.connect("https://kqxs.net.vn/rss-feed/xo-so-can-tho-xsct.rss").get();
                        Elements items = rssDocument.select("item");
                        for (Element item : items) {
                            String title = item.selectFirst("title").text();
                            String des = item.selectFirst("description").text();
                            String pubDate = item.selectFirst("pubDate").text();
                            String dateRss = "";
                            String regex = "\\b\\d{2}/\\d{2}\\b";
                            Pattern pattern = Pattern.compile(regex);
                            Matcher matcher = pattern.matcher(title);
                            if (matcher.find()) {
                                dateRss = matcher.group();
                            }
                            String dateTicket = ticketModel.getNgayXoString();
                            if(dateRss.equals(dateTicket)){
                                KQXSTicketModel kqxs = new KQXSTicketModel(title, des, pubDate);
                                ticketModel.setKqxsModel(kqxs);
                                break;
                            }
                        }
                        listTicket.add(ticketModel);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        return listTicket;
    }
}