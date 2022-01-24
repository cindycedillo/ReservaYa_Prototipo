package com.reservaya.reservaya_prototipo;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_menuPrincipal extends AppCompatActivity {

    private TextView mapa;
    private ImageView opciones;
    private TextView mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        mapa=findViewById(R.id.btaceptarmp);
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_menuPrincipal.this,Activity_mapa.class));
            }
        });
        opciones=findViewById(R.id.imglogomp);
        opciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_menuPrincipal.this,Activity_menuOpciones.class));
            }
        });


    }
}