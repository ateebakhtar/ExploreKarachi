package com.example.explorekarachi;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ViewCompleteeMap extends AppCompatActivity implements OnMapReadyCallback {

    MapView mapView;
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_completee_map);
        //float k = 0.000001;

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        mapView = (MapView) findViewById(R.id.mapView4);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        mapView.getMapAsync(new OnMapReadyCallback() {
            LatLng coordinates;
            @Override
            public void onMapReady(GoogleMap googleMap) {
                for (int i=0;i<Data.mylist.size();i++)
                {
                    final double lat = Double.parseDouble(Data.mylist.get(i).getLongitude());
                    final double lit = Double.parseDouble(Data.mylist.get(i).getLocation());
                    System.out.println( "DATATATA");
                    coordinates = new LatLng(lit, lat);
                    googleMap.addMarker(new MarkerOptions().position(coordinates));
                }

                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 15));
                mapView.onResume();
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        System.out.println("hellos");
//        map = googleMap;
//        map.getUiSettings().setMyLocationButtonEnabled(false);
//        map.setMyLocationEnabled(true);
//        //map.moveCamera(startPoint);
//        map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(30.3753,69.3451)));

    }

}
