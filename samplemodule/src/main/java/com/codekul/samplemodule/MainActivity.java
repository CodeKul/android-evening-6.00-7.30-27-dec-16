package com.codekul.samplemodule;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Click click = new Click();

        Button btnOkay = (Button) findViewById(R.id.btnDate);
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView textDate = (TextView) findViewById(R.id.textDate);
                textDate.setText(new Date().toString());
            }
        });
        btnOkay.setOnClickListener(click);

        Button btnMillis = (Button) findViewById(R.id.btnMillis);
        btnMillis.setOnClickListener(click);
        btnMillis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDate = (TextView) findViewById(R.id.textDate);
                textDate.setText(String.valueOf(System.currentTimeMillis()));
            }
        });

        Button btnSayHi = (Button) findViewById(R.id.btnSayHi);
        btnSayHi.setOnClickListener( v -> {
            TextView textDate = (TextView) findViewById(R.id.textDate);
            textDate.setText("Hi");
        });

        Button btnSayHello = (Button) findViewById(R.id.btnSayHello);
        //btnSayHello.setOnClickListener(this::sayHello);

        btnSayHello.setOnClickListener(v -> sayHello(v, 10) );
    }

    private void sayHello(View view, int a) {
        TextView textDate = (TextView) findViewById(R.id.textDate);
        textDate.setText("Hello");
    }

    private class Click implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.btnDate){
                TextView textDate = (TextView) findViewById(R.id.textDate);
                textDate.setText(new Date().toString());
            }
            else if(v.getId() == R.id.btnMillis){
                TextView textDate = (TextView) findViewById(R.id.textDate);
                textDate.setText(String.valueOf(System.currentTimeMillis()));
            }
        }
    }

    private void createUiByCode() {
        LinearLayout.LayoutParams paramsRoot = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout layoutRoot = new LinearLayout(this);
        layoutRoot.setLayoutParams(paramsRoot);
        setContentView(layoutRoot);

        LinearLayout.LayoutParams paramsBtn = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        Button btn = new Button(this);
        btn.setLayoutParams(paramsBtn);
        btn.setText("Okay");
        layoutRoot.addView(btn);
    }
}
