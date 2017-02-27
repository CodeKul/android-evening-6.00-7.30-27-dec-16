package com.codekul.externalstorage;

import android.nfc.Tag;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveOnPublic();
            }
        });

        findViewById(R.id.btnDisplay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFromPublic();
            }
        });
    }

    private void save() {
        try {
            if (isMounted()) {

                File file = new File(getExternalFilesDir("my"), "and.txt");
                FileOutputStream fos = new FileOutputStream(file);
                fos.write("again codekul.com".getBytes());
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void display() {
        try {
            File file = new File(getExternalFilesDir("my"), "and.txt");
            FileInputStream fis = new FileInputStream(file);

            StringBuilder builder = new StringBuilder();

            while(true) {
                int ch = fis.read();
                if(ch == -1) break;
                else builder.append((char)ch);
            }

            Log.i(TAG, "Data is = "+builder.toString() );
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void saveOnPublic() {
        if(isMounted()) {

            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"my.txt");

            Log.i(TAG, "private external "+getExternalFilesDir("my").getAbsolutePath());
            Log.i(TAG, "public external "+file.getAbsolutePath());

            try {
                FileOutputStream fos  = new FileOutputStream(file);
                fos.write("codekul.com on the sdcard".getBytes());
                fos.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        else Log.i(TAG, "Problem in loading sdcard");
    }

    public void readFromPublic() {

        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"my.txt");

        StringBuilder builder = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream(file);
            while(true) {
                int ch = fis.read();
                if(ch == -1) break;
                else builder.append((char)ch);
            }

            Log.i(TAG, builder.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean isMounted() {
        return (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED));
    }
}
