package com.codekul.login;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnRegisters).setOnClickListener(this::register);
        findViewById(R.id.btnBack).setOnClickListener(this::back);
        findViewById(R.id.btnLogin).setOnClickListener(this::login);
        findViewById(R.id.btnDynamic).setOnClickListener(this::dynamic);
    }

    private void dynamic(View view) {

        LinearLayout layoutDynamic = (LinearLayout)findViewById(R.id.layoutDashboard);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.topMargin = 10;
        TextView textView = new TextView(this);
        textView.setLayoutParams(params);
        textView.setText(String.valueOf(System.currentTimeMillis()));
        textView.setTextSize(30);
        textView.setBackgroundColor(Color.parseColor("#9B507E"));
        textView.setTextColor(Color.WHITE);
        textView.setGravity(Gravity.CENTER);
        textView.setOnClickListener(v -> ((TextView)findViewById(R.id.btnDynamic))
                .setText(((TextView)v).getText().toString()));

        layoutDynamic.addView(textView);
    }

    private void login(View view) {
        String userName = ((EditText)findViewById(R.id.edtUserName)).getText().toString();
        String password = ((EditText)findViewById(R.id.edtPassword)).getText().toString();

        if(userName.equals("android") && password.equals("android")) register(null);
    }

    private void back(View view) {
        findViewById(R.id.layoutLogin).setVisibility(View.VISIBLE);
        findViewById(R.id.layoutRegister).setVisibility(View.GONE);
        findViewById(R.id.layoutDashboard).setVisibility(View.GONE);
    }

    private void register(@Nullable  View view) {

        findViewById(R.id.layoutLogin).setVisibility(View.GONE);
        findViewById(R.id.layoutRegister).setVisibility(View.VISIBLE);
        findViewById(R.id.layoutDashboard).setVisibility(View.GONE);
        if(view == null) {
            findViewById(R.id.layoutDashboard).setVisibility(View.VISIBLE);
            findViewById(R.id.layoutLogin).setVisibility(View.GONE);
            findViewById(R.id.layoutRegister).setVisibility(View.GONE);
            findViewById(R.id.btnRegisters).setVisibility(View.GONE);
        }
    }
}
