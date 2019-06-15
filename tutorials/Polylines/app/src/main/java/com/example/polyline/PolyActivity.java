package com.example.polyline;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import static com.example.polyline.R.id.map;


/**
 * An activity that displays a Google map with polylines to represent paths or routes
 */
public class PolyActivity extends AppCompatActivity
        implements
                OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_maps);

        // Get the SupportMapFragment and request notification when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map when it's available.
     * The API invokes this callback when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        Polyline path = googleMap.addPolyline(new PolylineOptions()
                .add(
                        new LatLng(38.893596444352134, -77.0381498336792),
                        new LatLng(38.89337933372204, -77.03792452812195),
                        new LatLng(38.89316222242831, -77.03761339187622),
                        new LatLng(38.893028615148424, -77.03731298446655),
                        new LatLng(38.892920059048464, -77.03691601753235),
                        new LatLng(38.892903358095296, -77.03637957572937),
                        new LatLng(38.89301191422077, -77.03592896461487),
                        new LatLng(38.89316222242831, -77.03549981117249),
                        new LatLng(38.89340438498248, -77.03514575958252),
                        new LatLng(38.893596444352134, -77.0349633693695)
                )
        );

        // Style the polyline
        path.setWidth(10);
        path.setColor(Color.parseColor("#FF0000"));

        // Position the map's camera
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(38.89399, -77.03659), 16));
    }
}
