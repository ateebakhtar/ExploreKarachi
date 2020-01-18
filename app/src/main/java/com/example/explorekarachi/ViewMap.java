package com.example.explorekarachi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.explorekarachi.directionhelpers.TaskLoadedCallback;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

//import com.google.android.


public class ViewMap extends AppCompatActivity implements OnMapReadyCallback, TaskLoadedCallback {

    private MarkerOptions place1, place2,place3 ;
    Button getDirection;
    private Polyline currentPolyline;


    MapView mapView;
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_map);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        //float k = 0.000001;
        mapView = (MapView) findViewById(R.id.mapView2);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
//        final double lat = Double.parseDouble(Data.latitude);
//        final double lit = Double.parseDouble(Data.longituide);

//        example_items.add(new example_item(R.drawable.food,"TAO","Food","Clifton","24.829955","67.024015","TAO offers you a contemporary Pan-Asian cuisine with the spin of various cooking techniques like grilling, steaming, pan frying all to be enjoyed with our light starters, freshly made salads and comforting soups."));
//        example_items.add(new example_item(R.drawable.food,"Karachi Parsi Institute","Entertainment","Saddar","24.865795","67.038385","Karachi Parsi Institute sports grounds (Parsi Gymkhana was built in 1893)"));
//
//        24.829955","67.024015
//        "24.865795","67.038385"
        place1 = new MarkerOptions().position(new LatLng(24.865795, 67.038385)).title("Location 1");
        place2 = new MarkerOptions().position(new LatLng(24.865795, 67.024015)).title("Location 2");
        place3 = new MarkerOptions().position(new LatLng(24.933455,67.034851)).title("Location 2");

//        place1 = new MarkerOptions().position(new LatLng(27.658143, 85.3199503)).title("Location 1");
//        place2 = new MarkerOptions().position(new LatLng(27.667491, 85.3208583)).title("Location 2");
        mapView.getMapAsync(new OnMapReadyCallback() {

            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng coordinates = new LatLng(24.865795, 67.038385);
                googleMap.addMarker(place1);
                googleMap.addMarker(place2);
                googleMap.addMarker(place3);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 15));
                mapView.onResume();
            }
        });
    }

    @Override
    public void onTaskDone(Object... values) {
        if (currentPolyline != null)
            currentPolyline.remove();
        currentPolyline = map.addPolyline((PolylineOptions) values[0]);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        System.out.println("hellos");
        map = googleMap;
        map.getUiSettings().setMyLocationButtonEnabled(false);
        map.setMyLocationEnabled(true);
        //map.moveCamera(startPoint);
        map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(24.865795, 67.038385)));

    }
    public void karlo(View view)
    {
        new com.example.explorekarachi.directionhelpers.FetchURL(this).execute(getUrl(place1.getPosition(), place2.getPosition(), "driving"), "driving");
    }
    private String getUrl(LatLng origin, LatLng dest, String directionMode) {
        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;
        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;
        // Mode
        String mode = "mode=" + directionMode;
        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + mode;
        // Output format
        String output = "json";
        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key=" + getString(R.string.google_maps_key);
        return url;

    }
    }
