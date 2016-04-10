package org.code_freak.com.marker_map;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
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
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        MarkerOptions zooMarker  = new MarkerOptions();
        zooMarker.title("Sakkar bagh ZooLogical Park");
        LatLng zoo = new LatLng(21.5420,70.4650);
        zooMarker.position(zoo);
        zooMarker.icon(BitmapDescriptorFactory.fromResource(R.drawable.zoo));
        mMap.addMarker(zooMarker);

        MarkerOptions imperialMarker = new MarkerOptions();
        imperialMarker.title("Imperial Palace");
        LatLng imperial = new LatLng(22.3039,70.8022);
        imperialMarker.position(imperial);
        imperialMarker.icon(BitmapDescriptorFactory.fromResource(R.drawable.imperial));
        mMap.addMarker(imperialMarker);

        MarkerOptions khandheriMarker = new MarkerOptions();
        khandheriMarker.title("Khandheri Cricket Association");
       LatLng khandheri = new LatLng(22.3020,70.7890);
        khandheriMarker.position(khandheri);
        khandheriMarker.icon(BitmapDescriptorFactory.fromResource(R.drawable.khandheri));
        mMap.addMarker(khandheriMarker);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(imperial, 15));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener(){

            @Override
            public boolean onMarkerClick(Marker marker) {
                Intent markerIntent;
                switch ((marker.getTitle())){
                    case "Sakkar bagh ZooLogical Park":
                        markerIntent = new Intent(getBaseContext(),Instagram_App.class);
                        startActivity(markerIntent);
                        break;
                    case "Imperial Palace":
                        markerIntent = new Intent(getBaseContext(),Imperial_Images.class);
                        startActivity(markerIntent);
                        break;
                    case "Khandheri Cricket Association":
                        markerIntent = new Intent(getBaseContext(),Khandheri_Images.class);
                        startActivity(markerIntent);
                        break;
                }
                return false;
            }
        });





    }
}
