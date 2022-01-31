package com.reservaya.reservaya_prototipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

public class formularioRegistro extends AppCompatActivity {

    private TextView menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_registro);

        DisplayMetrics medidas= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidas);
        int ancho=medidas.widthPixels;
        int alto= medidas.heightPixels;
        getWindow().setLayout((int)(ancho*0.97),(int)(alto*0.95));

        menu=findViewById(R.id.btregistrar);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(formularioRegistro.this,activity_menuPrincipal.class));
            }
        });
    }
}