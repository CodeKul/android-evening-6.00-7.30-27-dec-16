package com.melayer.interfragmentcommunication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(R.id.frameMax, MaxFragment.getInstance(R.drawable.ic_roulette));
        loadFragment(R.id.frameMin, MinFragment.getInstance());
    }

    public void loadFragment(int frameId, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction txn = manager.beginTransaction();
        txn.replace(frameId,fragment);
        txn.commit();
    }
}
