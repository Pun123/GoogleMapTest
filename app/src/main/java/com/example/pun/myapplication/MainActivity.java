package com.example.pun.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.pun.myapplication.R.id.map;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private Marker _myPositionMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map2);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        float cameraZoom = 17;
        LatLng myPosition = new LatLng(13.7954151, 100.6819924);
        _myPositionMarker = googleMap.addMarker(new MarkerOptions().position(myPosition).title("Hello").draggable(true));
        _myPositionMarker.setTag(0);

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myPosition, cameraZoom));

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

            }
        });
        googleMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                LatLng position = marker.getPosition();
                Toast.makeText(MainActivity.this, "Latitude " + position.latitude + " " + "Longitude " + position.longitude, Toast.LENGTH_LONG).show();




            }
        });

    }
}
