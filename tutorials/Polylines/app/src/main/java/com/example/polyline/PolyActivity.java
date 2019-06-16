package com.example.polyline;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;

import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.LineString;
import com.mapbox.mapboxsdk.style.layers.LineLayer;
import com.mapbox.mapboxsdk.style.layers.PropertyFactory;

import java.util.ArrayList;
import java.util.List;

public class PolyActivity extends AppCompatActivity {
    private MapView mapView;
    private List<Point> routeCoordinates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, "pk.eyJ1IjoiYWdyYWViZSIsImEiOiJjand2MmNtc2wwcGR6M3lxejk1aDd0amo3In0.LneM6wuauNA7ArbZVn__2w");
        setContentView(R.layout.activity_maps);
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull MapboxMap mapboxMap) {
                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {

                        initRouteCoordinates();

                        // Create the LineString from the list of coordinates and then make a GeoJSON
                        // FeatureCollection so we can add the line to our map as a layer
                        style.addSource(new GeoJsonSource("line-source",
                                FeatureCollection.fromFeatures(new Feature[] {Feature.fromGeometry(
                                        LineString.fromLngLats(routeCoordinates)
                                )})));

                        // The layer properties for our line
                        style.addLayer(new LineLayer("linelayer", "line-source").withProperties(
                                PropertyFactory.lineWidth(3f),
                                PropertyFactory.lineColor(Color.parseColor("#FF0000"))
                        ));
                    }
                });
            }
        });
    }

    private void initRouteCoordinates() {
        routeCoordinates = new ArrayList<>();
        routeCoordinates.add(Point.fromLngLat(-77.0381498336792,38.893596444352134));
        routeCoordinates.add(Point.fromLngLat(-77.03792452812195,38.89337933372204));
        routeCoordinates.add(Point.fromLngLat(-77.03761339187622, 38.89316222242831));
        routeCoordinates.add(Point.fromLngLat(-77.03731298446655, 38.893028615148424));
        routeCoordinates.add(Point.fromLngLat(-77.03691601753235, 38.892920059048464));
        routeCoordinates.add(Point.fromLngLat(-77.03637957572937, 38.892903358095296));
        routeCoordinates.add(Point.fromLngLat(-77.03592896461487, 38.89301191422077));
        routeCoordinates.add(Point.fromLngLat(-77.03549981117249, 38.89316222242831));
        routeCoordinates.add(Point.fromLngLat(-77.03514575958252, 38.89340438498248));
        routeCoordinates.add(Point.fromLngLat(-77.0349633693695, 38.893596444352134));
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}