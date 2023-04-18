package com.example.mymenu.ui.ubicacion;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import static androidx.core.content.ContextCompat.checkSelfPermission;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.mymenu.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class UbicacionFragment extends Fragment {

    private LocationManager manager;

    private Double lat;

    private Double lon;

    private UbicacionViewModel mViewModel;


    public static UbicacionFragment newInstance() {
        return new UbicacionFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_ubicacion, container, false);
        solicitarPermisos();
        Ubicacion();
        SupportMapFragment smf=(SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.fgMapa);
        smf.getMapAsync(new MapaActual());
        return root;
    }
    @SuppressLint("MissingPermission")
    public void Ubicacion() {
        manager= (LocationManager)getContext().getSystemService(Context.LOCATION_SERVICE);
        Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (location!=null){
            this.lat=location.getLatitude();
            this.lon=location.getLongitude();
        }else {
            //probando
            this.lat=-33.2950100;
            this.lon=-66.3356300;
        }

    }
    @SuppressLint("MissingPermission")

    public void solicitarPermisos(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && (checkSelfPermission(getContext(),ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) ||
                (checkSelfPermission(getContext(),ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            requestPermissions(new String[]{ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION}, 1000);
        }
    }



    private class MapaActual implements OnMapReadyCallback {

        @SuppressLint("MissingPermission")
        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                Toast.makeText(getContext(),"cuidado"+lat,Toast.LENGTH_LONG).show();
                LatLng posicion = new LatLng(lat, lon);
                CameraPosition cam = new CameraPosition.Builder()
                        .target(posicion)
                        .zoom(17)
                        .bearing(45)
                        .tilt(70)
                        .build();
                CameraUpdate update = CameraUpdateFactory.newCameraPosition(cam);
                googleMap.animateCamera(update);

        }
    }

}