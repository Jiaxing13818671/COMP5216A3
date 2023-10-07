package comp5216.sydney.edu.au.mymapsapplication;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.gson.Gson;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import comp5216.sydney.edu.au.mymapsapplication.databinding.ActivityMapsBinding;
import comp5216.sydney.edu.au.mymapsapplication.entity.InfoData;
import comp5216.sydney.edu.au.mymapsapplication.entity.Root;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    Root root;
    private FusedLocationProviderClient mFusedLocationClient;
    private LocationRequest mLocationRequest;
    private LocationCallback mLocationCallback;
    Geocoder geocoder;
    PlacesClient placesClient;
    private InfoData infoData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Places.initialize(MapsActivity.this, "AIzaSyAe-qcsEsZROGX0sHQNXfbu35tS-aKbJWU");
        placesClient = Places.createClient(MapsActivity.this);
        setBar();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Log.e("--------", sha1(this));

        geocoder = new Geocoder(MapsActivity.this, Locale.getDefault());

        binding.rd1.setChecked(true);
        binding.dosearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(binding.edittext.getText().toString())) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                OkHttpClient client = new OkHttpClient();
                                Request request = new Request.Builder()
                                        .url("https://maps.googleapis.com/maps/api/place/textsearch/json?query=Hospital%20in%20" + binding.edittext.getText().toString() + "&key=AIzaSyAe-qcsEsZROGX0sHQNXfbu35tS-aKbJWU")
                                        .build();
                                Response response = client.newCall(request).execute();
                                String responseData = response.body().string();
                                Log.e("------2", responseData);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {

                                        root = gson.fromJson(responseData, Root.class);

                                        if (root.getResults().size() > 0) {

                                            mMap.clear();
                                            for (int i = 0; i < root.getResults().size(); i++) {
                                                LatLng sydney = new LatLng(root.getResults().get(i).getGeometry().getLocation().getLat(), root.getResults().get(i).getGeometry().getLocation().getLng());
                                                mMap.addMarker(new MarkerOptions().position(sydney).title(root.getResults().get(i).getName()));
                                            }
                                            //sydney university
                                            LatLng sydney = new LatLng(root.getResults().get(0).getGeometry().getLocation().getLat(), root.getResults().get(0).getGeometry().getLocation().getLng());
                                            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                                            mMap.setMinZoomPreference(12);
                                            mMap.setMaxZoomPreference(12);
                                            try {
                                                List<Address> fromLocationName = geocoder.getFromLocation(root.getResults().get(0).getGeometry().getLocation().getLat(), root.getResults().get(0).getGeometry().getLocation().getLng(), 1);

                                                //Display information about the first hospital
                                                binding.text1.setText(root.getResults().get(0).getName());
                                                binding.text2.setText(root.getResults().get(0).getFormatted_address());
                                                String placeId = root.getResults().get(0).getPlace_id();
                                                setDetailData(placeId);
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }

                                        } else {
                                            Toast.makeText(MapsActivity.this, "no data", Toast.LENGTH_SHORT).show();
                                        }


                                    }
                                });
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            }
        });


        int REQUEST_CODE_PERMISSION_STORAGE = 100;
        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION};

        for (String str : permissions) {
            if (this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                this.requestPermissions(permissions, REQUEST_CODE_PERMISSION_STORAGE);
                return;
            }
        }
        //When the system is at 11 and above
        // Do not have the file management authority to apply for permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                intent.setData(Uri.parse("package:" + MapsActivity.this.getPackageName()));
                startActivityForResult(intent, 1000);
            }
        }

    }

    private void setBar() {
        Window window = getWindow();
        int uiMode = getApplicationContext().getResources().getConfiguration().uiMode;
        if ((uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES) {
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_VISIBLE);//白色
        } else {
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//黑色

        }
        WindowCompat.setDecorFitsSystemWindows(window, true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        window.setNavigationBarColor(Color.TRANSPARENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            window.setNavigationBarContrastEnforced(false);
        }
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

        //todo   map ready  start location
        initMap();

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {


                for (int i = 0; i < root.getResults().size(); i++) {
                    if (marker.getTitle().equals(root.getResults().get(i).getName())) {
                        try {
                            List<Address> fromLocationName = geocoder.getFromLocation(root.getResults().get(0).getGeometry().getLocation().getLat(), root.getResults().get(0).getGeometry().getLocation().getLng(), 1);

                            //Display information about the first hospital
                            binding.text1.setText(root.getResults().get(i).getName());
                            binding.text2.setText(root.getResults().get(i).getFormatted_address());


                            //https://maps.googleapis.com/maps/api/place/details/json?placeid=ChIJN1t_tDeuEmsRUsoyG83frY4&key=YOUR_API_KEY

                            String placeId = root.getResults().get(i).getPlace_id();
                            setDetailData(placeId);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return false;
            }
        });
    }


    public void setDetailData(String placeid){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("https://maps.googleapis.com/maps/api/place/details/json?placeid="+placeid+"&key=AIzaSyAe-qcsEsZROGX0sHQNXfbu35tS-aKbJWU")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    Log.e("----------3", responseData);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            infoData = gson.fromJson(responseData, InfoData.class);
                            binding.text3.setText(infoData.getResult().getWebsite());
                            binding.text4.setText(infoData.getResult().getFormatted_phone_number());

                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public static String sha1(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), PackageManager.GET_SIGNATURES);
            byte[] cert = info.signatures[0].toByteArray();
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] publicKey = md.digest(cert);
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < publicKey.length; i++) {
                String appendString = Integer.toHexString(0xFF & publicKey[i])
                        .toUpperCase(Locale.US);
                if (appendString.length() == 1)
                    hexString.append("0");
                hexString.append(appendString);
                hexString.append(":");
            }
            String result = hexString.toString();
            return result.substring(0, result.length() - 1);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    private void initMap() {
        // Initialization
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // Configuring Location requests
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        // Configuring callbacks
        mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }


                for (Location location : locationResult.getLocations()) {
                    // Gets the current location
                    // getRequset("https://maps.googleapis.com/maps/api/geocode/json?latlng=" + location.getLatitude() + "," + location.getLongitude() + "&key=AIzaSyAe-qcsEsZROGX0sHQNXfbu35tS-aKbJWU&language=en-US&sensor=false");
                    List<Address> addresses;
                    Geocoder geocoder = new Geocoder(MapsActivity.this, Locale.getDefault());
                    String addStr = null;
                    try {
                        addresses = geocoder.getFromLocation(location.getLatitude()
                                , location.getLongitude(), 1);
                       /* String address = addresses.get(0).getAddressLine(0);
                        String city = addresses.get(0).getLocality();
                        String state = addresses.get(0).getAdminArea();
                        String zipCode = addresses.get(0).getPostalCode();
                        String country = addresses.get(0).getCountryCode();

                        addStr = address + "," + city + "," + state + "," + zipCode + "," + country;
                        Log.e("address---------", addStr);
                        MapsActivity.this.cityString = city;*/


                        LatLng sydney = new LatLng(location.getLatitude(), location.getLongitude());
                        mMap.setMinZoomPreference(10);
                        mMap.setMaxZoomPreference(10);
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

                        //todo  poi search

                        // Gets the current location
                        //https://maps.googleapis.com/maps/api/place/nearbysearch/json？ location=-41.319282,174.818717 ＆ radius=1000 ＆ sensor=true ＆ type=cafe ＆ key=your_api_key
                        getRequset("https://maps.googleapis.com/maps/api/place/textsearch/json?location=" + location.getLatitude() + "," + location.getLongitude() + "&radius=1000&query=Hospital&key=AIzaSyAe-qcsEsZROGX0sHQNXfbu35tS-aKbJWU");

                        mFusedLocationClient.removeLocationUpdates(this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        // Request location information
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
        mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, null);


    }

    private Gson gson = new Gson();

    public void getRequset(String urlString) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url(urlString)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    Log.e("----------1", responseData);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            root = gson.fromJson(responseData, Root.class);

                            for (int i = 0; i < root.getResults().size(); i++) {
                                LatLng sydney = new LatLng(root.getResults().get(i).getGeometry().getLocation().getLat(), root.getResults().get(i).getGeometry().getLocation().getLng());
                                mMap.addMarker(new MarkerOptions().position(sydney).title(root.getResults().get(i).getName()));
                            }

                            try {
                                List<Address> fromLocationName = geocoder.getFromLocation(root.getResults().get(0).getGeometry().getLocation().getLat(), root.getResults().get(0).getGeometry().getLocation().getLng(), 1);

                                //Display information about the first hospital
                                binding.text1.setText(root.getResults().get(0).getName());
                                binding.text2.setText(root.getResults().get(0).getFormatted_address());
                                String placeId = root.getResults().get(0).getPlace_id();
                                setDetailData(placeId);

                            } catch (IOException e) {
                                e.printStackTrace();
                            }


                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}