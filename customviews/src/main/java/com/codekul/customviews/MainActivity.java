package com.codekul.customviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //createOurView();
    }

    private void createOurView(){
        OurView ourView = new OurView(this);
        setContentView(ourView);
    }
}
