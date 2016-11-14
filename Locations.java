
package com.findawharf.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Locations extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;

    // Initial Firebase auth
    private String mUsername;
    private String mPhotoUrl;

    // Firebase instance variables
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;

    // private DrawerLayout mDrawerLayout;
    // private String mActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);

//        //Initialize Firebase auth
//        mFirebaseAuth = mFirebaseAuth.getInstance();
//        mFirebaseUser = mFirebaseAuth.getCurrentUser();
//
//        if (mFirebaseUser == null) {
//            // Not signed in, launch the Sign In activity
//            startActivity(new Intent(this, Locations.class));
//            finish();
//            return;
//        } else {
//            mUsername = mFirebaseUser.getDisplayName();
//            mPhotoUrl = mFirebaseUser.getPhotoUrl().toString();
//        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Create Navigation Drawer.
        mDrawerList = (ListView) findViewById(R.id.navList);

        addDrawerItems();

//        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(Locations.this, "MothaFucka Jones", Toast.LENGTH_SHORT).show();
//            }
//        });


//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        mActivityTitle = getTitle().toString();
//
//        addDrawerItems();
//        setupDrawer();
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
    }

    //Maker drawer list
    private void addDrawerItems() {
        String[] navArray = {"Account", "Map", "Logout"};
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, navArray);
        mDrawerList.setAdapter(mAdapter);
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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        // Add a marker in Toronto and move the camera
        LatLng toronto = new LatLng(43.653908, 79.384293);
        mMap.addMarker(new MarkerOptions().position(toronto).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(toronto));
    }

    /**
     * Manipulates the Navigation Drawer
     */

}
