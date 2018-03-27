package com.romellbolton.googlemapsapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

// Have MapActivity extend FragmentActivity and implement the OnMapReadyCallback interface
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    // Define an instance of GoogleMap
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        // Use the MapFragment's getMapAsync() method to get notified when the map fragment
        // is ready to be used.
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Chicago, Illinois.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        // Instantiate a GoogleMap
        mMap = googleMap;

        // Create a LatLang object, specifying the coordinates of Chicago, IL
        LatLng chicago = new LatLng(41.850033, - 87.6500523);

        // Add a marker in Chicago using the LatLang object and
        // set the title of the marker to "Marker in Chicago"
        mMap.addMarker(new MarkerOptions().position(chicago).title("Marker in Chicago"));

        // Move the camera to the location of the LatLang object, i.e. Chicago
        mMap.moveCamera(CameraUpdateFactory.newLatLng(chicago));
    }
}
