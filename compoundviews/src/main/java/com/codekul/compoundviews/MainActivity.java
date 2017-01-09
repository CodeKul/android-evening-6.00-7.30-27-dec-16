package com.codekul.compoundviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        //inflater = getLayoutInflater();
        //inflater = LayoutInflater.from(this);

        final LinearLayout layoutRoot = (LinearLayout) findViewById(R.id.layoutRoot);
        layoutRoot.setOrientation(LinearLayout.VERTICAL);

        findViewById(R.id.btnAdd).setOnClickListener(v -> createCompoundView(layoutRoot));
    }

    private void createCompoundView(LinearLayout layoutRoot) {

        Log.i("@codekul","Hello "+System.currentTimeMillis());
        View view = inflater.inflate(R.layout.compound_view,null);
        view.setId((int) System.currentTimeMillis());
        layoutRoot.addView(view);
    }
}
