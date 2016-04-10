package org.code_freak.com.distancebetweentwopoints;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.akexorcist.googledirection.DirectionCallback;
import com.akexorcist.googledirection.GoogleDirection;
import com.akexorcist.googledirection.constant.TransportMode;
import com.akexorcist.googledirection.model.Direction;
import com.akexorcist.googledirection.util.DirectionConverter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class TwoLocation extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnCameraChangeListener, DirectionCallback {
    String loccode;
    private GoogleMap mMap;
    private LatLng camera;
    Location location;
    private LatLng myLocation;
    private String destination;
    private String key = "AIzaSyCQpjwyrnETiujlVl3JwGUAbAGa9YWesmE";

    LatLng marathalli = new LatLng(12.9562,77.7019);
    LatLng mgroad = new LatLng(12.9738,77.6119);
    LatLng kormangala = new LatLng(12.9259,77.6229);
    LatLng hal = new LatLng(12.9517,77.6693);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_location);
        Intent cmnintent = getIntent();
        loccode = cmnintent.getStringExtra(List_of_Locations.loccode);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
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
     location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        camera = new LatLng(location.getLatitude(), location.getLongitude());
        myLocation = new LatLng(location.getLatitude(), location.getLongitude());

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
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(camera, 13));
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
        if (loccode.equals("Marathalli")){

            GoogleDirection.withServerKey(key).from(myLocation).to(marathalli)
            .transportMode(TransportMode.DRIVING)
            .execute(this);


        }
        if (loccode.equals("MG Road")){
            GoogleDirection.withServerKey(key).from(myLocation).to(mgroad)
                    .transportMode(TransportMode.DRIVING)
                    .execute(this);
        }
        if (loccode.equals("Koramangala")){
            GoogleDirection.withServerKey(key).from(myLocation).to(kormangala)
                    .transportMode(TransportMode.DRIVING)
                    .execute(this);
        }
        if (loccode.equals("HAL")){
            GoogleDirection.withServerKey(key).from(myLocation).to(hal)
                    .transportMode(TransportMode.DRIVING)
                    .execute(this);
        }

    }

    @Override
    public void onCameraChange(CameraPosition cameraPosition) {
        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(cameraPosition.target).title(cameraPosition.toString()));

    }

    @Override
    public void onDirectionSuccess(Direction direction) {
        if(loccode.equals("Marathalli")) {
            if (direction.isOK()) {

                mMap.addMarker(new MarkerOptions().position(myLocation));
                mMap.addMarker(new MarkerOptions().position(marathalli));

                ArrayList<LatLng> directionPositionList = direction.getRouteList().get(0).getLegList().get(0).getDirectionPoint();
                mMap.addPolyline(DirectionConverter.createPolyline(this, directionPositionList, 5, Color.RED));

            }
        }
            if(loccode.equals("Koramangala")) {
                if (direction.isOK()) {
                    mMap.addMarker(new MarkerOptions().position(myLocation));
                    mMap.addMarker(new MarkerOptions().position(kormangala));

                    ArrayList<LatLng> directionPositionList = direction.getRouteList().get(0).getLegList().get(0).getDirectionPoint();
                    mMap.addPolyline(DirectionConverter.createPolyline(this, directionPositionList, 5, Color.RED));
                }
            }
            if(loccode.equals("HAL")) {
                if (direction.isOK()) {
                    mMap.addMarker(new MarkerOptions().position(myLocation));
                    mMap.addMarker(new MarkerOptions().position(hal));

                    ArrayList<LatLng> directionPositionList = direction.getRouteList().get(0).getLegList().get(0).getDirectionPoint();
                    mMap.addPolyline(DirectionConverter.createPolyline(this, directionPositionList, 5, Color.RED));
                }
            }
            if(loccode.equals("MG Road")) {
                if (direction.isOK()) {
                    mMap.addMarker(new MarkerOptions().position(myLocation));
                    mMap.addMarker(new MarkerOptions().position(mgroad));

                    ArrayList<LatLng> directionPositionList = direction.getRouteList().get(0).getLegList().get(0).getDirectionPoint();
                    mMap.addPolyline(DirectionConverter.createPolyline(this, directionPositionList, 5, Color.RED));
                }
            }
        }


    @Override
    public void onDirectionFailure(Throwable t) {

    }
}
