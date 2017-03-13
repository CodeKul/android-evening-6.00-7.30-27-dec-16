package com.codekul.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parser parser = new Parser(this);
        for (String lng : parser.langs()) {
            Log.i("@codekul", "Language is "+lng);
        }

        Log.i("@codekul","Name is "+parser.name());
        Log.i("@codekul", " Salary "+parser.tutorSalary());

        Gson gson = new Gson();
        Example ex = gson.fromJson(parser.readFile(), Example.class);
        Log.i("@codekul", "Name - "+ex.getName());
        Log.i("@codekul", "Tut Exp - "+ex.getTut().getExp());
    }
}
