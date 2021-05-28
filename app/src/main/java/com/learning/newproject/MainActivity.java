package com.learning.newproject;


import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;

import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;


import android.location.Address;
import android.location.Geocoder;
import android.location.Location;


import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;

import android.text.TextUtils;
import android.util.Log;

import android.view.View;

import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;


import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


//23.84351779643744,90.40333289329871
public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    private DrawerLayout drawerLayout;

    RecyclerView recyclerView;
    ActivityAdapter activityAdapter;


    GoogleMap map;
    SupportMapFragment supportMapFragment;
    SearchView searchView;

    double currentLatitude = 45.6854019165;
    double currentLongitude = 4.7614173889;

    PlaceHolderApi placeHolderApi;


    private LocationRequest locationRequest;
    private LocationCallback locationCallback;

    FusedLocationProviderClient fusedLocationProviderClient;
    private Location currentLocation;
    LocationManager locationManager;


    List<Datum> datumList;


    Marker shopMarker;

    boolean isFirstLoad = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);

        drawerLayout = findViewById(R.id.drawer_layout);

        recyclerView = findViewById(R.id.nav_bar_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        activityAdapter = new ActivityAdapter();


        getWindow().getDecorView().findViewById(R.id.mainFilter);
        getWindow().getDecorView().findViewById(R.id.navigation_bar);


        searchView = findViewById(R.id.searchView);


        datumList = new ArrayList<>();

        placeHolderApi = RetrofitClientInstance.getInstance().create(PlaceHolderApi.class);

        buildLocationRequest();

        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {


                currentLocation = locationResult.getLastLocation();
                addMarkerAndMoveCamera(locationResult.getLastLocation());


            }
        };


        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);


        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);

        supportMapFragment.getMapAsync(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            requestNearByShop();
        }
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper());








    }

    public void Search(View view) {
      switch (view.getId())
      {
          case R.id.searchIB:
              EditText addressField = findViewById(R.id.searchET);
              String address = addressField.getText().toString();

              List<Address> addressList = null;
              MarkerOptions userMarker = new MarkerOptions() ;

              if (!TextUtils.isEmpty(address))
              {
                  Geocoder geocoder = new Geocoder(this);
                  try {
                      addressList = geocoder.getFromLocationName(address,6);
                      if (addressList != null)
                      {
                          for (int i = 0; i<addressList.size(); i++)
                          {
                              Address userAddress = addressList.get(i);
                              LatLng userLatLng = new LatLng(userAddress.getLatitude(), userAddress.getLongitude());
                              userMarker.position(userLatLng);
                              userMarker.title(address);
                              map.addMarker(userMarker);
                              CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(userLatLng, 15f);
                              map.animateCamera(yourLocation);


                          }
                      }
                      else {
                          Toast.makeText(this, "Location not found", Toast.LENGTH_SHORT).show();
                      }
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }else {
                  Toast.makeText(this, "Please,Enter a location name", Toast.LENGTH_SHORT).show();
              }

              break;




      }


    }

    private void requestNearByShop() {
        Call<List<Pointers>> call = placeHolderApi.getPoints();
        call.enqueue(new Callback<List<Pointers>>() {
            @Override
            public void onResponse(Call<List<Pointers>> call, Response<List<Pointers>> response) {


                List<Pointers> pointers = response.body();

                for (int i = 0; i < pointers.size(); i++) {


                    Double latitude = Double.valueOf(pointers.get(i).getLatitude().toString());
                    Double longitude = Double.valueOf(pointers.get(i).getLongitude().toString());

                    map.addMarker(new MarkerOptions()
                            .position(new LatLng(latitude, longitude))
                            .snippet(pointers.get(i).getAddress())
                            .title(new StringBuilder()
                                    .append(pointers.get(i).getId())
                                    .append(".")
                                    .append(pointers.get(i).getName()).toString()));


                }

            }


            @Override
            public void onFailure(Call<List<Pointers>> call, Throwable t) {
                Log.d("Response", t.getMessage());

            }
        });

    }


    private void addMarkerAndMoveCamera(Location lastLocation) {

        if (shopMarker != null) {
            shopMarker.remove();

            LatLng userLatLng = new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude());
            shopMarker = map.addMarker(new MarkerOptions().position(userLatLng));
            CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(userLatLng, 15f);
            map.animateCamera(yourLocation);


        }

    }

    private void buildLocationRequest() {

        locationRequest = new LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setSmallestDisplacement(10);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;



        googleMap.getUiSettings().setZoomControlsEnabled(true);


        map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                marker.getTitle().substring(0, marker.getTitle().indexOf("."));


            }
        });


    }


    public void ClickMenu(View view) {

        openDrawer(drawerLayout);
        getActivities();

    }

    private static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    private void getActivities() {
        Call<Activities> callActivities = placeHolderApi.getActivities();
        callActivities.enqueue(new Callback<Activities>() {
            @Override
            public void onResponse(Call<Activities> call, Response<Activities> response) {

                if (response.isSuccessful()) {
                    Activities activities = response.body();
                    Log.d("Activity", activities.getData().get(0).getActivityName());

                    datumList = new ArrayList<>(activities.getData());


                    for (int i = 0; i < datumList.size(); i++) {

                        activityAdapter.setData(datumList, getBaseContext());
                        recyclerView.setAdapter(activityAdapter);
                    }


                }


            }

            @Override
            public void onFailure(Call<Activities> call, Throwable t) {
                Log.d("activity", t.getMessage());

            }
        });
    }


//    public void clickImageA(View view) {
//        Toast.makeText(this, "Image A clicked", Toast.LENGTH_SHORT).show();
//    }
//
//    public void clickImageB(View view) {
//        Toast.makeText(this, "Image B clicked", Toast.LENGTH_SHORT).show();
//    }
//
//    public void clickImageC(View view) {
//        Toast.makeText(this, "Image C clicked", Toast.LENGTH_SHORT).show();
//    }
//
//    public void clickImageD(View view) {
//        Toast.makeText(this, "Image D clicked", Toast.LENGTH_SHORT).show();
//    }
//
//    public void clickImageE(View view) {
//        Toast.makeText(this, "Image E clicked", Toast.LENGTH_SHORT).show();
//    }
//
//    public void clickImageF(View view) {
//        Toast.makeText(this, "Image F clicked", Toast.LENGTH_SHORT).show();
//    }


    public void ClickFilter(View view) {

        openFilter(drawerLayout);

    }

    private void openFilter(DrawerLayout drawerLayout) {

        drawerLayout.openDrawer(GravityCompat.END);

    }


}
