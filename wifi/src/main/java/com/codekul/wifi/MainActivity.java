package com.codekul.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WifiManager manager;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            List<ScanResult> scanResults = manager.getScanResults();
            for (ScanResult scanResult : scanResults) {
                Log.i("@codekul", ""+scanResult.SSID);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (WifiManager) getSystemService(WIFI_SERVICE);

        registerReceiver(receiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
    }

    private void configured() {
        List<WifiConfiguration> configuredNetworks = manager.getConfiguredNetworks();
        for (WifiConfiguration configuredNetwork : configuredNetworks) {
            Log.i("@codekul", "SSID - "+configuredNetwork.SSID);
            Log.i("@codekul", "BSSID - "+configuredNetwork.BSSID);
        }
    }

    public void scan(View view) {
        manager.startScan();
    }

    public void connect(View view) {
        WifiConfiguration wifiConfig = new WifiConfiguration();
        wifiConfig.SSID = String.format("\"%s\"", "YourCodekul");
        wifiConfig.preSharedKey = String.format("\"%s\"", "#code.KUL123#");

        int netId = manager.addNetwork(wifiConfig);
        manager.disconnect();
        manager.enableNetwork(netId, true);
        manager.reconnect();
    }
}
