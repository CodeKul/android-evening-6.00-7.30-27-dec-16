package com.codekul.asynctask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // findViewById(R.id.btnOkay).setOnClickListener(this::runInWorkerThread);
        handler = new Handler(Looper.getMainLooper());

        //findViewById(R.id.btnOkay).setOnClickListener(v -> new MyTask().execute(new Integer[]{0,100}));
        findViewById(R.id.btnOkay).setOnClickListener(v -> workWithHandler());
    }

    private void updateNum(View view) {
        for (int i  = 0 ; i < 100 ;i++) {
            try {
                Thread.sleep(1000); // very bad
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ((TextView) findViewById(R.id.textNumber)).setText(String.valueOf(i));
        }
    }

    int i = 0;
    private void workWithHandler() {

        new Thread(() ->{
            for ( ; i < 100 ;i++) {
                try {
                    Thread.sleep(1000); // very bad
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(() ->  ((TextView) findViewById(R.id.textNumber)).setText(String.valueOf(i)));
            }
        }).start();
    }

    private void runInWorkerThread(View view) {
        new Thread(() -> updateNum(view)).start();
    }

    private class MyTask extends AsyncTask<Integer/*params*/, Integer/*progress*/, Boolean/*Result*/> {

        private ProgressDialog pd;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // UI thread

            pd = ProgressDialog.show(MainActivity.this,"Title","Message");
        }

        @Override
        protected Boolean/*Result*/ doInBackground(/*params*/Integer... params) {
            // worker thread

            for (int i = params[0]; i< params[1]; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i/*progress*/);
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean/*result*/) {
            super.onPostExecute(aBoolean);
            // UI thread

            pd.dismiss();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            ((TextView)findViewById(R.id.textNumber)).setText(String.valueOf(values[0]));
            //UI thread
        }
    }
}
