package com.codekul.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getCanonicalName();
    private static final String KEY_MY_NAME = "myName";
    public static final String KEY_AGE = "age";
    public static final String KEY_IS_MOBILE_OS = "isMobileOs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { save(); }
        });

        findViewById(R.id.btnRetrieve).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { retrieve(); }
        });
    }

    private void save() {
        SharedPreferences prefs = getSharedPreferences("my",MODE_PRIVATE);

//        prefs = getPreferences(MODE_APPEND);

        SharedPreferences.Editor editor = prefs.edit();
        //editor.clear();
//        editor.remove(KEY_IS_MOBILE_OS);
//        editor.remove(KEY_AGE);

        editor.putString(KEY_MY_NAME,"android");
        editor.putInt(KEY_AGE,10);
        editor.putBoolean(KEY_IS_MOBILE_OS, true);
        editor.apply();
    }

    private void retrieve() {
        SharedPreferences prefs = getSharedPreferences("my",MODE_PRIVATE);

        String name = prefs.getString(KEY_MY_NAME,"none");
        int age = prefs.getInt(KEY_AGE, -10);
        boolean isMobileOs = prefs.getBoolean(KEY_IS_MOBILE_OS, false);

        Log.i(TAG, "Name - "+name + " Age - "+age +" Is Mobile Os "+isMobileOs);
    }
}
