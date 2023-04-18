package com.example.mymenu;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.mymenu.modelo.Usuario;

public class LoginActivityViewModel extends AndroidViewModel {
    private Context context;

    private Intent intent;

    private Usuario user;

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
        this.intent=new Intent(context, MainActivity.class);
        this.user=new Usuario("Admin","2665");
    }
    public void login(String usuario, String contra){
        if(usuario.equals(user.getUser()) && contra.equals(user.getPassword())){
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }else{
            Toast.makeText(context,"Usuario o Contraseña Incorrecto",Toast.LENGTH_LONG).show();
        }
    }
}
