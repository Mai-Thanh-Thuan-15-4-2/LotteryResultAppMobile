package com.example.kqxs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class Calender extends AppCompatActivity {

    private DatePicker datePicker;

    private String getXSMNtheongay(Calendar calendar) {
        String location = "";
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.MONDAY) {
            location = "TP.HCM, Đồng Tháp, Cà Mau";
        } else if (dayOfWeek == Calendar.TUESDAY) {
            location = "Bến Tre, Vũng Tàu, Bạc Liêu";
        } else if (dayOfWeek == Calendar.WEDNESDAY) {
            location = "Đồng Nai, Cần Thơ, Sóc Trăng";
        } else if (dayOfWeek == Calendar.THURSDAY) {
            location = "Tây Ninh, An Giang, Bình Thuận";
        } else if (dayOfWeek == Calendar.FRIDAY) {
            location = "Vĩnh Long, Bình Dương, Trà Vinh";
        } else if (dayOfWeek == Calendar.SATURDAY) {
            location = "TP.HCM, Long An, Bình Phước, Hậu Giang";
        } else {
            location = "Tiền Giang, Kiên Giang, Đà Lạt";
        }
        return location;
    }
    private String getXSMTtheongay(Calendar calendar) {
        String location = "";
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.MONDAY) {
            location = "Phú Yên, Thừa Thiên Huế";
        } else if (dayOfWeek == Calendar.TUESDAY) {
            location = "Đắc Lắc, Quảng Nam";
        } else if (dayOfWeek == Calendar.WEDNESDAY) {
            location = "Đà Nẵng, Khánh Hòa";
        } else if (dayOfWeek == Calendar.THURSDAY) {
            location = "Bình Định, Quảng Trị, Quảng Bình";
        } else if (dayOfWeek == Calendar.FRIDAY) {
            location = "Gia Lai, Ninh Thuận";
        } else if (dayOfWeek == Calendar.SATURDAY) {
            location = "Đà Nẵng, Quảng Ngãi, Đắk Nông";
        } else {
            location = "Kon Tum, Khánh Hòa, Thừa Thiên Huế";
        }
        return location;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendarview);

        datePicker = findViewById(R.id.datePicker);

        FloatingActionButton btnbh = findViewById(R.id.calenderBackHome);
        btnbh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calender.this, Home.class);
                startActivity(intent);
            }
        });

        // Lấy ngày hôm nay và đặt nó trên DatePicker
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year, month, dayOfMonth, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newCalendar = Calendar.getInstance();
                newCalendar.set(year, monthOfYear, dayOfMonth);
                String newMN = getXSMNtheongay(newCalendar);
                String newMT = getXSMTtheongay(newCalendar);
                TextView miennam = findViewById(R.id.tendaimiennam);
                TextView mientrung = findViewById(R.id.tendaimientrung);
                miennam.setText(newMN);
                mientrung.setText(newMT);
            }
        });

        // Hiển thị thông tin vùng miền ban đầu
        TextView miennam = findViewById(R.id.tendaimiennam);
        String tentinhMN = getXSMNtheongay(calendar);
        if (!tentinhMN.isEmpty()) {
            miennam.setText(tentinhMN);
        }
        TextView mientrung = findViewById(R.id.tendaimientrung);
        String tentinhMT = getXSMTtheongay(calendar);
        if (!tentinhMT.isEmpty()) {
            mientrung.setText(tentinhMT);
        }
    }
}
