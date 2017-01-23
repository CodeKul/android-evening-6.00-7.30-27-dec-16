package com.melayer.statusbarnotifications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        ((TextView)findViewById(R.id.textData)).append("\n");
        ((TextView)findViewById(R.id.textData)).append(getIntent().getStringExtra("notiData"));
    }
}
