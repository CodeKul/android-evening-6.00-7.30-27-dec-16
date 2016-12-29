package com.codekul.demoapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.layoutContent).setOnClickListener(this::clickLayout);
        findViewById(R.id.btnRed).setOnClickListener(this::clickRed);
        findViewById(R.id.btnGreen).setOnClickListener(this::clickGreen);
        findViewById(R.id.btnBlue).setOnClickListener(this::clickBlue);
    }

    private void clickLayout(View view) {
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);

        paintContent(Color.rgb(red,green,blue));
    }

    private void clickBlue(View view) {
        paintContent(Color.BLUE);
    }

    private void clickGreen(View view) {
        paintContent(Color.GREEN);
    }

    private void clickRed(View view) {
        paintContent(Color.RED);
    }

    private void paintContent(int color){
        findViewById(R.id.layoutContent).setBackgroundColor(color);
    }
}
