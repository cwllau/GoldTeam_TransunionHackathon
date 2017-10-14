package com.example.colle.demomaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        //setUpMapIfNeeded();
    }

    /*private void setUpMapIfNeeded()
    {
        //do a null check to confirm that we have not already instantiated the map
        if (mMap == null)
            //Try to obtain the map from the SupportMapFragment.
            mMap = (((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this));
            //Check if we were successful in obtaining the map
            if (mMap != null)
            {
                setUpMap();
            }
    } */

    private void setUpMap ()
    {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0,0)).title("Banan :)"));
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(21.3002800, -157.8186100);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Holmes Hall UHM"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        //change to hawaii

        mMap.addMarker(new MarkerOptions().position(new LatLng(0,2)).title("Marker"));
    }
}
