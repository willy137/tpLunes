package com.example.mymenu.ui.salir;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Alerta {
    public static void  mostrarDialogoBoton(Context context){

        new AlertDialog.Builder(context)
                .setTitle("Cerrar")
                .setMessage("Desea cerrar la aplicacion?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((AppCompatActivity)context).finishAndRemoveTask();
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"Continuamos",Toast.LENGTH_LONG).show();
                    }
                }).show();

    }
}
