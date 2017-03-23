package com.codekul.telephonyapi;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.CellLocation;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver receiverSent = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Received", Toast.LENGTH_SHORT).show();
        }
    };

    private BroadcastReceiver sentIntent = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Sent", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filterSent = new IntentFilter();
        filterSent.addAction("com.msg.sent");
        registerReceiver(sentIntent, filterSent);

        IntentFilter filterDelivered = new IntentFilter();
        filterDelivered.addAction("com.msg.delivered");
        registerReceiver(receiverSent, filterDelivered);
    }

    public void send(View view) {
        sendMsg();
    }

    private void imei() {
        TelephonyManager manager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        Log.i("@codekul", " Imei - "+manager.getDeviceId());
        Log.i("@codekul", " Phone Num - "+manager.getLine1Number());
        Log.i("@codekul", " Nw Op name - "+manager.getNetworkOperatorName());
        Log.i("@codekul", " Nw Op  - "+manager.getNetworkOperator());
        Log.i("@codekul", " Country  - "+manager.getSimCountryIso());
        CellLocation loc = manager.getCellLocation();
    }

    private void sendMsg() {
        SmsManager manager = SmsManager.getDefault();

        Intent intentSent = new Intent("com.msg.sent");
        Intent intentDelivered = new Intent("com.msg.delivered");
        manager.sendTextMessage("9762548833",null, "Hello, codekul",
                PendingIntent.getBroadcast(this,8596 ,intentSent,PendingIntent.FLAG_UPDATE_CURRENT),
                PendingIntent.getBroadcast(this,8597 ,intentDelivered,PendingIntent.FLAG_UPDATE_CURRENT));
    }
}
