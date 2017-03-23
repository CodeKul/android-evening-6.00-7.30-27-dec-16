package com.codekul.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {


    private static final int REQUEST_ENABLE_BT = 1235;
    private BluetoothAdapter adapter;

    private BroadcastReceiver receiverDiscovery = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            BluetoothDevice device =
                    intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            Log.i("@codekul", "Address - "+device.getAddress());
            Log.i("@codekul", "Name - "+device.getName());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isHwAvalable()) {
            if (!adapter.isEnabled())
                startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), REQUEST_ENABLE_BT);
        }

        registerReceiver(receiverDiscovery, new IntentFilter(BluetoothDevice.ACTION_FOUND));
    }

    private Boolean isHwAvalable() {
        adapter = BluetoothAdapter.getDefaultAdapter();
        return adapter != null;
    }

    private void pairedDevices() {

        Set<BluetoothDevice> bondedDevices = adapter.getBondedDevices();
        for (BluetoothDevice bondedDevice : bondedDevices) {
            Log.i("@codekul", "Address - "+bondedDevice.getAddress());
            Log.i("@codekul", "Name - "+bondedDevice.getName());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_ENABLE_BT) {
            if(resultCode == RESULT_OK) {

            }
        }
    }

    public void paired(View view) {
        pairedDevices();
    }

    public void discovering(View view) {
        adapter.startDiscovery();
    }

    public void visibility(View view) {
        Intent discoverableIntent =
                new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
        startActivity(discoverableIntent);
    }
}
