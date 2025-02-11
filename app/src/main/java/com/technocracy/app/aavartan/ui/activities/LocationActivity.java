package com.technocracy.app.aavartan.ui.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.technocracy.app.aavartan.R;

import java.util.Objects;

public class LocationActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Reach Us");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        // Add a marker in Sydney and move the camera
        LatLng NITRaipur = new LatLng(21.2494972, 81.6052223);
        googleMap.addMarker(new MarkerOptions().position(NITRaipur).title("NIT Raipur")).showInfoWindow();
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(NITRaipur));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LocationActivity.this, MainActivity.class);
        LocationActivity.this.startActivity(intent);
    }

}