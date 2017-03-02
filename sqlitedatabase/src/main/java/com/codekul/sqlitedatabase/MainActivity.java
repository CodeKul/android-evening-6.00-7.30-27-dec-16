package com.codekul.sqlitedatabase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getCanonicalName();

    private DbHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DbHelper(this, "location", null, 1);

        findViewById(R.id.btnInsert).setOnClickListener(this::insertAgain);
        findViewById(R.id.btnUpdate).setOnClickListener(this::update);
        findViewById(R.id.btnDelete).setOnClickListener(this::delete);
        findViewById(R.id.btnDisplay).setOnClickListener(this::displayOther);
    }

    private void display(View view) {
        final SQLiteDatabase sqDb = helper.getReadableDatabase();

        String table = "loc_tab";
        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        final Cursor cursor = sqDb.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);

        while (cursor.moveToNext()) {
            float lat = cursor.getFloat(0);
            float lng = cursor.getFloat(1);
            String imei = cursor.getString(cursor.getColumnIndex("imei"));
            Log.i(TAG, "Lat - " + lat + " Lng - " + lng + " Imei - " + imei);
        }

        sqDb.close();
    }

    private void displayOther(View view) {

        final SQLiteDatabase sqDb = helper.getReadableDatabase();

        String table = "loc_tab";
        String[] columns = {"lat", "lng"};
        String selection = "imei = ?";
        String[] selectionArgs = {"78798"};
        String groupBy = null;
        String having = null;
        String orderBy = null;

        final Cursor cursor = sqDb.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
        while (cursor.moveToNext()) {
            float lat = cursor.getFloat(0);
            float lng = cursor.getFloat(1);
            Log.i(TAG, "Lat - " + lat + " Lng - " + lng);
        }

        sqDb.close();
    }

    private void delete(View view) {

        final SQLiteDatabase sqDb = helper.getWritableDatabase();

        String table = "loc_tab";
        String whereClause = "imei = ?";
        String[] whereArgs = {"78798"};

        sqDb.delete(table, whereClause, whereArgs);

        sqDb.close();
    }

    private void update(View view) {

        final SQLiteDatabase sqDb = helper.getWritableDatabase();

        String table = "loc_tab";
        ContentValues values = new ContentValues();
        values.put("lat", "45.26");
        values.put("lng", "89.26");

        String whereClause = "imei = ?";
        String[] whereArgs = {"78798"};

        sqDb.update(table, values, whereClause, whereArgs);

        sqDb.close();
    }

    private void insert(View view) {
        final SQLiteDatabase sqDb = helper.getWritableDatabase();
        final ContentValues values = new ContentValues();
        values.put("lat", 56.89);
        values.put("lng", 17.56);
        values.put("imei", "78798");
        sqDb.insert("loc_tab", null, values);
        sqDb.close();
    }

    private void insertAgain(View view) {
        final SQLiteDatabase sqDb = helper.getWritableDatabase();
        sqDb.execSQL("insert into loc_tab values(45.69, 89.99, '78798')");
        sqDb.close();
    }
}
