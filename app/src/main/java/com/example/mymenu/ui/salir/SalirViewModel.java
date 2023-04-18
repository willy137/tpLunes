package com.example.mymenu.ui.salir;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SalirViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<Boolean> mutableDialogoBoton;
    public SalirViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Boolean> getMutableDialogoBoton() {
        if(mutableDialogoBoton== null){
            mutableDialogoBoton=new MutableLiveData<>();
        }
        return mutableDialogoBoton;
    }
    public void dialogoBoton(){
        mutableDialogoBoton.setValue(true);
    }
}