package com.melayer.rxapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private CompositeDisposable disposables;
    private Disposable forLoopDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        disposables = new CompositeDisposable();
    }

    @Override
    protected void onStart() {
        super.onStart();

        //final ProgressDialog pd = ProgressDialog.show(this,"Title","Mmessae");
        forLoopDisposable =  ObservableFactory.forLoop().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .doOnNext(integer -> ((TextView) findViewById(R.id.textNum)).setText(String.valueOf(integer)))
                .doOnComplete(() -> {
                    Log.i("@codekul","On Complete");
//                    pd.dismiss();
                })
                .doOnError(throwable -> Log.i("@codekul","Error "+throwable))
                .subscribe();

        disposables.add(forLoopDisposable);
    }

    @Override
    protected void onStop() {
        disposables.delete(forLoopDisposable);
        disposables.clear();
        super.onStop();
    }
}
