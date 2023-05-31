package com.example.kqxs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class InsertTicket extends AppCompatActivity {
    private EditText textAddTicket;
    private EditText textAmount;
    private Spinner spinnerLoaiVeSo;
    private Button buttonAddTicket;
    private Button buttonChooseDate;
    private Calendar calendar;
    String ticketNumber ;
    int amount;
    String type;
    Date date;

    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_ticket);
        //dãy số
        textAddTicket = findViewById(R.id.textAddTicket);
        //số lượng
        textAmount = findViewById(R.id.textAmount);
        //chọn loại
        spinnerLoaiVeSo = findViewById(R.id.spinnerLoaiVeSo);

        spinnerLoaiVeSo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                type = "";
            }
        });
        //btn chọn ngày
        buttonChooseDate = findViewById(R.id.buttonChooseDate);
        calendar = Calendar.getInstance();

        buttonChooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        database = new Database(this);
        //btn add
        buttonAddTicket = findViewById(R.id.addTicket);
        buttonAddTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticketNumber = String.valueOf(textAddTicket.getText());
                amount = Integer.parseInt(String.valueOf(textAmount.getText()));
                System.out.println(type);
                System.out.println(date);

                int day = date.getDate();
                int month = date.getMonth();
                int year = date.getYear() + 1900;
                Date dateFormat = new Date(year, month, day);
                TicketModel ticket = new TicketModel(ticketNumber, amount, type, dateFormat);
                database.addTicket(ticket);
                Toast.makeText(InsertTicket.this, "Thêm vé số thành công", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void showDatePickerDialog() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                buttonChooseDate.setText(formatDate(calendar.getTime()));
                date = new Date(formatDate(calendar.getTime()));
            }
        };

        // Lấy ngày hiện tại để hiển thị trong DatePickerDialog
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Hiển thị DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);
        datePickerDialog.show();
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
        return sdf.format(date);
    }
}