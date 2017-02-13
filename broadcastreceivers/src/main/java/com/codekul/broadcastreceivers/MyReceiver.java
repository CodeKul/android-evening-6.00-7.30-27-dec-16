package com.codekul.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            Toast.makeText(context, intent.getBooleanExtra("state", false) ? "Airplane mode enabled" : "Airplane mode disabled", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Custom Broadcast", Toast.LENGTH_SHORT).show();
        }
    }
}
