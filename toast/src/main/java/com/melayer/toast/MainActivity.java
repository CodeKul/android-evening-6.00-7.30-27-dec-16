package com.melayer.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnToast).setOnClickListener(this::customToast);
    }

    private void toast(View view) {
        Toast toast = Toast.makeText(this, getResources().getString(R.string.tstMsg), Toast.LENGTH_SHORT);
        toast.show();
    }

    private void customToast(View view) {
        Toast toast = Toast.makeText(this, getResources().getString(R.string.tstMsg), Toast.LENGTH_SHORT);
        Button btn = new Button(this);
        //btn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate)); #not working
        btn.setText(getResources().getString(R.string.tstMsg));
        toast.setView(btn);
        toast.setGravity(Gravity.CENTER, 10, 12);
        toast.show();
    }
}
