package com.codekul.webservices;

import android.app.ProgressDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Gson gson;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gson = new Gson();
        findViewById(R.id.btnJoke).setOnClickListener(this::jokeClick);
    }

    private void postJoke(String joke) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("joke", joke);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Q.q(this).add(new JsonObjectRequest("https://digital-shelter-153912.firebaseio.com/my.json", obj, this::onPostSuccess, this::onJokeError));
    }

    private void jokeClick(View view) {

        dialog = ProgressDialog.show(this, "Joke", "Fetching new Joke ");
        Q.q(this).add(new StringRequest("http://api.icndb.com/jokes/random",
                this::onJokeSuccess, this::onJokeError));
    }

    private void onPostSuccess(JSONObject obj) {

    }


    private void onJokeError(VolleyError volleyError) {
        dialog.dismiss();
    }

    private void onJokeSuccess(String s) {
        Joke joke = gson.fromJson(s, Joke.class);
        ((TextView) findViewById(R.id.txtJok)).setText(joke.getValue().getJoke());

        postJoke(joke.getValue().getJoke());

        dialog.dismiss();
    }
}
