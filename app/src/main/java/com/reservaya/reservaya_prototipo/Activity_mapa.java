package com.reservaya.reservaya_prototipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_mapa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
    }
    public void irActivity2( View view){
        //creo el enlace con el segundo activity
        Intent intent = new Intent(this,Formulario.class);
        //iniciamos la siguiente activity
        startActivity(intent);

    }
}