package com.reservaya.reservaya_prototipo;

import androidx.annotation.StringDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class activity_eminiciarsesion extends AppCompatActivity {

    private TextView inst;
    private NotificationCompat.MessagingStyle.Message ok;
    private activity_tstinstrucciones in;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eminiciarsesion);
        DisplayMetrics medidas = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidas);

        int ancho=medidas.widthPixels;
        int alto = medidas.heightPixels;

        getWindow().setLayout((int)(ancho*0.97),(int)(alto*0.97));

        Toast.makeText(this,"hola",25);

        inst = findViewById(R.id.btingresar);

        inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_eminiciarsesion.this,activity_tstinstrucciones.class));
            }
        });
    }
}