package com.melayer.statemanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_TEXT_INFO = "textInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mt("onCreate");
        findViewById(R.id.btnOkay).setOnClickListener(v -> ((TextView) findViewById(R.id.textInfo))
                .setText(String.valueOf(System.currentTimeMillis())));
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        mt("onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();

        mt("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        mt("onResume");
    }

    @Override
    protected void onPause() {
        mt("onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        mt("onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mt("onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        mt("onSavedInstanceState");
        outState.putString(KEY_TEXT_INFO, ((TextView) findViewById(R.id.textInfo)).getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        ((TextView) findViewById(R.id.textInfo)).setText(savedInstanceState.getString(KEY_TEXT_INFO));
    }

    private void mt(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
