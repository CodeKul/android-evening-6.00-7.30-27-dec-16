package com.melayer.simplevalueresources;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int someColor = getResources().getColor(R.color.someColor);
        someColor = ContextCompat.getColor(this,R.color.someColor);

        String btnOkay = getResources().getString(R.string.btnOkay);
        Log.i("@codekul","Button Value is "+btnOkay);
    }
}
