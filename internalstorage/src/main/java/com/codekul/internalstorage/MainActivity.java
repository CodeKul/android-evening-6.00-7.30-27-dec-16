package com.codekul.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getCanonicalName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { save(); }
        });

        findViewById(R.id.btnDisplay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display();
            }
        });

        findViewById(R.id.btnMore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                more();
            }
        });
    }

    private void display() {

        try {
            FileInputStream fis = openFileInput("my.txt");
            StringBuilder builder = new StringBuilder();
            while(true) {
                int ch = fis.read();
                if(ch == -1) break;
                else builder.append((char)ch);
            }
            Log.i(TAG, ""+builder.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void save() {

        try {
            FileOutputStream fos = openFileOutput("my.txt", MODE_PRIVATE );
            fos.write("codekul.com".getBytes());
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void more() {

        File file = new File(getFilesDir(), "our.txt");
        Log.i(TAG, "Path - "+file.getAbsolutePath());

        for (String fileName : fileList()) {
            Log.i(TAG , "File Name - "+fileName);
        }
    }
}
