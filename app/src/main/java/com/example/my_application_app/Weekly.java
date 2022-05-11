package com.example.my_application_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class Weekly extends AppCompatActivity {
    TextView location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly);
        setTitle("오늘의 날씨");

        location = (TextView) findViewById(R.id.location);
        SpannableString content = new SpannableString(location.getText().toString());
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        location.setText(content);
    }
}