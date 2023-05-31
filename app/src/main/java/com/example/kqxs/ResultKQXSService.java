package com.example.kqxs;

import android.widget.Switch;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResultKQXSService{
    private TicketModel ticketModel;
    private String rss;
    private CompletableFuture<Void> rssFuture;
    public ResultKQXSService(TicketModel ticketModel) {
        this.ticketModel = ticketModel;
    }

    public TicketModel getTicketModel() {
        return ticketModel;
    }

    public void setTicketModel(TicketModel ticketModel) {
        this.ticketModel = ticketModel;
    }

    public String getRss() {
        return rss;
    }

    public void setRss(String rss) {
        this.rss = rss;
    }

    public String getSpecialPrize() {
        if(ticketModel.getKqxsModel() == null){
            return "Không xác định";
        }
        return ticketModel.getKqxsModel().getDescription().substring(ticketModel.getKqxsModel().getDescription().indexOf("ĐB:") + 3, ticketModel.getKqxsModel().getDescription().indexOf("1:")).trim();
    }

    public String getFirstPrize() {
        if(ticketModel.getKqxsModel() == null){
            return "Không xác định";
        }
        String firstPrizeString = ticketModel.getKqxsModel().getDescription().substring(ticketModel.getKqxsModel().getDescription().indexOf("1:") + 2, ticketModel.getKqxsModel().getDescription().indexOf("2:")).trim();
        return firstPrizeString;
    }

    public String getSecondPrize() {
        if(ticketModel.getKqxsModel() == null){
            return "Không xác định";
        }
        String secondPrizeString = ticketModel.getKqxsModel().getDescription().substring(ticketModel.getKqxsModel().getDescription().indexOf("2:") + 2, ticketModel.getKqxsModel().getDescription().indexOf("3:")).trim();
        return secondPrizeString;
    }

    public String getThirdPrize() {
        if(ticketModel.getKqxsModel() == null){
            return "Không xác định";
        }
        String thirdPrizeString = ticketModel.getKqxsModel().getDescription().substring(ticketModel.getKqxsModel().getDescription().indexOf("3:") + 2, ticketModel.getKqxsModel().getDescription().indexOf("4:")).trim();
        return thirdPrizeString;
    }

    public String getFourthPrize() {
        if(ticketModel.getKqxsModel() == null){
            return "Không xác định";
        }
        String fourthPrizeString = ticketModel.getKqxsModel().getDescription().substring(ticketModel.getKqxsModel().getDescription().indexOf("4:") + 2, ticketModel.getKqxsModel().getDescription().indexOf("5:")).trim();
        return fourthPrizeString;
    }

    public String getFifthPrize() {
        if(ticketModel.getKqxsModel() == null){
            return "Không xác định";
        }
        String fifthPrizeString = ticketModel.getKqxsModel().getDescription().substring(ticketModel.getKqxsModel().getDescription().indexOf("5:") + 2, ticketModel.getKqxsModel().getDescription().indexOf("6:")).trim();
        return fifthPrizeString;
    }

    public String getSixthPrize() {
        if(ticketModel.getKqxsModel() == null){
            return "Không xác định";
        }
        if(ticketModel.getKqxsModel() == null){
            return "Không xác định";
        }
        String sixthPrizeString = ticketModel.getKqxsModel().getDescription().substring(ticketModel.getKqxsModel().getDescription().indexOf("6:") + 2, ticketModel.getKqxsModel().getDescription().indexOf("7:")).trim();
        return sixthPrizeString;
    }

    public String getSeventhPrize() {
        if(ticketModel.getKqxsModel() == null){
            return "Không xác định";
        }
        String seventhPrizeString = ticketModel.getKqxsModel().getDescription().substring(ticketModel.getKqxsModel().getDescription().indexOf("7:") + 2, ticketModel.getKqxsModel().getDescription().indexOf("8:")).trim();
        return seventhPrizeString;
    }

    public String getEighthPrize() {
        if(ticketModel.getKqxsModel() == null){
            return "Không xác định";
        }
        String eighthPrizeString = ticketModel.getKqxsModel().getDescription().substring(ticketModel.getKqxsModel().getDescription().indexOf("8:") + 2).trim();
        return eighthPrizeString;
    }

    @Override
    public String toString() {
        return "ResultKQXSService{" +
                "ticketModel=" + ticketModel +
                ", rss='" + rss + '\'' +
                ", rssFuture=" + rssFuture +
                '}';
    }
}
