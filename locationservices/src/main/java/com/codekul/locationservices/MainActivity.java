package com.codekul.locationservices;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Geocoder geocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        geocoder = new Geocoder(this);

        location("Codekul pune");
        location(18.493027, 73.815499);
    }

    private void location(String loc) {

        try {
            List<Address> addresses = geocoder.getFromLocationName(loc, 5);
            for (Address address : addresses) {
                Log.i("@codekul", "Lng - " + address.getLongitude());
                Log.i("@codekul", "Lat - " + address.getLatitude());
                Log.i("@codekul", "Country Name - " + address.getCountryName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void location(double lat, double lng) {
        try {
            List<Address> addresses = geocoder.getFromLocation(lat, lng, 5);

            for (Address address : addresses) {
                Log.i("@codekul", "Country Name - " + address.getCountryName());
                Log.i("@codekul", "Address - " + address.getAddressLine(0));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
