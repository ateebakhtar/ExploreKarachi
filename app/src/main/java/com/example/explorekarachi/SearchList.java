package com.example.explorekarachi;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class SearchList extends AppCompatActivity implements OnMapReadyCallback{


    MapView mapView;
    GoogleMap map;
    float DEFAULTZOOM = 15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);

        mapView = (MapView) findViewById(R.id.mapView3);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        mapView.getMapAsync(new OnMapReadyCallback() {

            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng coordinates = new LatLng(24.7792947, 67.0896044);
                googleMap.addMarker(new MarkerOptions().position(coordinates).title("Home"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 15));
                mapView.onResume();
            }
        });
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

    private void gotoLocation(double lat, double lng, float zoom)
    {
        LatLng ll = new LatLng(lat,lng);
        map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(ll.latitude,ll.longitude)));
        //CameraUpdate update = CameraUpdate.newLatLngZoom(ll,zoom);
        ///map.moveCamera(update);
    }

    public void geoLocate(View v) throws IOException
    {
        hideSoftKeyboard(v);
        EditText et = (EditText) findViewById(R.id.editText7);
        String location = et.getText().toString();

        Geocoder gc = new Geocoder(this);
        List<Address> list = gc.getFromLocationName(location,10);
//        List<Address> list = gc.getFromLocation(24.8607,67.0011 ,1);
        if(list.isEmpty())
        {
            System.out.println("Null");
            Toast.makeText(this, "List is empty", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Address add = list.get(0);
//            Address add1 = list.get(1);
//            Address add2 = list.get(2);
//            System.out.println("thing"+add.getLocality()+add2.getLocality()+add1.getLocality());
            String locality = add.getLocality();
            System.out.println(locality);
//            locality = "Defense";
            Toast.makeText(this,locality,Toast.LENGTH_LONG).show();

            double lat = add.getLatitude();
            double lng = add.getLongitude();

            gotoLocation(lat,lng, DEFAULTZOOM);
        }

    }

    private void hideSoftKeyboard(View v)
    {
        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(),0);
    }
}
