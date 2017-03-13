package com.codekul.jsonparsing;

import android.content.Context;
import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by aniruddha on 13/3/17.
 */

public class Parser {

    private final Context context;
    protected String json;

    public Parser(Context context) {
        this.context = context;
        this.json = readFile();
    }

    public String readFile() {
        String fileData = "";
        final AssetManager manager = context.getAssets();
        try {
            InputStream is = manager.open("my.json");
            while (true) {
                int ch = is.read();
                if (ch == -1) break;
                fileData += (char) ch;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileData;
    }

    public String name() {

        String name = "";
        try {
            final JSONObject obj = new JSONObject(json);
            name = obj.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return name;
    }

    public ArrayList<String> langs() {
        final ArrayList<String> langs = new ArrayList<>();

        try {
            final JSONObject obj = new JSONObject(json);
            JSONArray arr = obj.getJSONArray("langs");
            for (int i = 0; i < arr.length(); i++) {
                langs.add(arr.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return langs;
    }

    public Double tutorSalary() {
        Double sal = 0.0d;

        try {
            final JSONObject obj = new JSONObject(json);

            JSONObject tutObj = obj.getJSONObject("tut");
            sal = tutObj.getDouble("sal");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sal;
    }
}
