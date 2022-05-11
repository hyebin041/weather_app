package com.example.my_application_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.TimePicker;

public class NoticeActivity extends AppCompatActivity {


    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime, rdoWea;
    CalendarView calView;
    TimePicker tPicker;
    TableLayout wt_table;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    int selectYear, selectMonth, selectDay;




    @SuppressLint("SetTextI18n")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice_activity);
        setTitle("시간예약");


        btnEnd = (Button) findViewById(R.id.btnEnd);



        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);
        rdoWea = (RadioButton) findViewById(R.id.rdoWea);

        tPicker = (TimePicker) findViewById(R.id.timePicker1);
        calView = (CalendarView) findViewById(R.id.calendarView1);
        wt_table = (TableLayout) findViewById(R.id.wt_table);

        tvYear =  (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView)findViewById(R.id.tvDay);
        tvHour = (TextView)findViewById(R.id.tvHour);
        tvMinute = (TextView)findViewById(R.id.tvMinute);

        tPicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);
        wt_table.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
                wt_table.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.VISIBLE);
                calView.setVisibility(View.INVISIBLE);
                wt_table.setVisibility(View.INVISIBLE);
            }
        });
        rdoWea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.INVISIBLE);
                wt_table.setVisibility(View.VISIBLE);
            }
        });



        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);
            }
        });

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                selectYear = year;
                selectMonth = month+1;
                selectDay = dayOfMonth;
            }
        });
        tvYear.setText(Integer.toString(selectYear));
        tvMonth.setText(Integer.toString(selectMonth));
        tvDay.setText(Integer.toString(selectDay));

        tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
        tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));


    }
}