package com.codekul.contentprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       readOurData();
    }

    private void readContacts() {
        ArrayList<String> dataSet = new ArrayList<>();

        ContentResolver resolver = getContentResolver();

        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] projection = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;

        Cursor cursor = resolver.query(uri, projection, selection, selectionArgs, sortOrder);

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            dataSet.add(name + "\n" + number);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataSet);
        ((ListView)findViewById(R.id.listContacts)).setAdapter(adapter);
    }

    private void readOurData() {
        ArrayList<String> dataSet = new ArrayList<>();

        ContentResolver resolver = getContentResolver();

        Uri uri = Uri.parse("content://com.codekul.cutom.provider");
        String[] projection = null;
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;

        Cursor cursor = resolver.query(uri, projection, selection, selectionArgs, sortOrder);

        while (cursor.moveToNext()) {
            Float lat = cursor.getFloat(cursor.getColumnIndex("lat"));
            Float lng = cursor.getFloat(cursor.getColumnIndex("lng"));
            String imei = cursor.getString(cursor.getColumnIndex("imei"));
            dataSet.add(""+lat + ", " + lng +"\n"+imei);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataSet);
        ((ListView)findViewById(R.id.listContacts)).setAdapter(adapter);
    }
}
