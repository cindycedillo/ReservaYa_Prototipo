package com.reservaya.reservaya_prototipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

public class activity_iniciarSesion extends AppCompatActivity {

    private TextView instrucciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        DisplayMetrics medidas= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidas);

        int ancho=medidas.widthPixels;
        int alto= medidas.heightPixels;

        getWindow().setLayout((int)(ancho*0.90),(int)(alto*0.90));

        instrucciones=findViewById(R.id.btaceptar);

        instrucciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_iniciarSesion.this, activity_instrucciones.class));
            }
        });
    }
}