package com.codekul.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    private IntentFilter fltrFltMd;

    private BroadcastReceiver rcvrFltMod = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getBooleanExtra("state", false)){
                //enabled
                findViewById(R.id.imgPln).setVisibility(View.VISIBLE);

                Animation animation = AnimationUtils.loadAnimation(context, R.anim.rozo);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        findViewById(R.id.imgPln).setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                findViewById(R.id.imgPln).startAnimation(animation);
            }
            else {
                Animation animation = AnimationUtils.loadAnimation(context, R.anim.rozor);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        findViewById(R.id.imgPln).setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                findViewById(R.id.imgPln).startAnimation(animation);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fltrFltMd = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(rcvrFltMod, fltrFltMd);
    }

    @Override
    protected void onDestroy() {

        unregisterReceiver(rcvrFltMod);
        super.onDestroy();
    }

    public void broadcast(View v ){
        sendBroadcast(new Intent("com.codekul.CUSTOM_BROADCAST"));
    }
}
