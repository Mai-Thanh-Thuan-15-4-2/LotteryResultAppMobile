package com.example.kqxs;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class KQXSTicketModel implements Parcelable {
    private String title;
    private String description;
    private String date;

    public KQXSTicketModel(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    protected KQXSTicketModel(Parcel in) {
        title = in.readString();
        description = in.readString();
        date = in.readString();
    }


    public static final Creator<KQXSTicketModel> CREATOR = new Creator<KQXSTicketModel>() {
        @Override
        public KQXSTicketModel createFromParcel(Parcel in) {
            return new KQXSTicketModel(in);
        }

        @Override
        public KQXSTicketModel[] newArray(int size) {
            return new KQXSTicketModel[size];
        }
    };

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(date);
    }

    @Override
    public String toString() {
        return "KQXSTicketModel{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
