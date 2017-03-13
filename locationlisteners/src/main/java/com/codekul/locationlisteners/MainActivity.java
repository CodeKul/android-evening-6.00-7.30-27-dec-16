package com.codekul.locationlisteners;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int PER_LOC_ID = 1223;
    private LocationManager manager;

    private LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            Log.i("@codekul", "Lat - " + location.getLatitude());
            Log.i("@codekul", "Lng - " + location.getLongitude());

            ((TextView)findViewById(R.id.textLocs)).setText("Lat - "+ location.getLatitude() +" Lng - "+location.getLongitude());
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        findViewById(R.id.btnOkay).setOnClickListener(v -> myLocation());

        myLocation();
    }

    private void providers() {

        List<String> providers = manager.getAllProviders();
        for (String provider : providers) {
            Log.i("@codekul", "Provider is " + provider);
        }


        /*manager.getProvider(LocationManager.PASSIVE_PROVIDER);
        manager.getProvider(LocationManager.GPS_PROVIDER);
        manager.getProvider(LocationManager.NETWORK_PROVIDER);*/
    }

    private void provider() {
        Criteria criteria = new Criteria();
        criteria.setAltitudeRequired(true);
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        criteria.setCostAllowed(true);

        String provider = manager.getBestProvider(criteria, false);
        Log.i("@codekul", "Provider is - " + provider);
    }

    private void myLocation() {

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                new AlertDialog.Builder(this)
                        .setTitle("Permission")
                        .setMessage("Need Permission to access your locations")
                        .setPositiveButton(R.string.btnOkay, (di, btn) -> requestPer())
                        .show();
            } else requestPer();
        } else {

            /*Location loc = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (loc != null) {
                Log.i("@codekul", "Lat - " + loc.getLatitude());
                Log.i("@codekul", "Lng - " + loc.getLongitude());
            }*/

            manager.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 1000, 0.2f, listener);
        }
    }

    private void requestPer() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                PER_LOC_ID);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PER_LOC_ID) {
            if (grantResults.length > 0) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    myLocation();
                }
            }
        }
    }
}
