package com.example.explorekarachi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback  {
    private GoogleMap gMap;
    private LatLng startPoint = new LatLng(30.3753,69.3451);

    MapView mapView;
    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mapView = (MapView) findViewById(R.id.mapView);
//        mapView.onCreate(savedInstanceState);
//        mapView.getMapAsync(this);
//
//        mapView.getMapAsync(new OnMapReadyCallback() {
//
//            @Override
//            public void onMapReady(GoogleMap googleMap) {
//                LatLng coordinates = new LatLng(24.7792947, 67.0896044);
//                googleMap.addMarker(new MarkerOptions().position(coordinates).title("Home"));
//                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 15));
//                mapView.onResume();
//            }
//        });
//        //onMapReady(mapView);
//
        Intent i = new Intent(this,splashScreeen.class);
        startActivity(i);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        System.out.println("hellos");
        map = googleMap;
        map.getUiSettings().setMyLocationButtonEnabled(false);
        map.setMyLocationEnabled(true);
        //map.moveCamera(startPoint);
        map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(30.3753,69.3451)));

    }

    public void OpenImage(View view)
    {
        Intent i = new Intent(this,LocationList.class);
        startActivity(i);
    }
    public void OpenVoice(View view)
    {
        Intent i = new Intent(this,VoiceSearch.class);
        startActivity(i);
    }
}

