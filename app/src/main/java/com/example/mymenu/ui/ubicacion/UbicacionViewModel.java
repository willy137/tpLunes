package com.example.mymenu.ui.ubicacion;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import static androidx.core.app.ActivityCompat.requestPermissions;
import static androidx.core.content.ContextCompat.checkSelfPermission;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build;


import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

public class UbicacionViewModel extends AndroidViewModel {
    public UbicacionViewModel(@NonNull Application application) {
        super(application);
    }

    // TODO: Implement the ViewModel
}