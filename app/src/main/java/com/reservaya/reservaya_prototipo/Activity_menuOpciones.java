package com.reservaya.reservaya_prototipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_menuOpciones extends AppCompatActivity {

    private TextView menuopciones;
    Button btn_reservas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);

        btn_reservas=findViewById(R.id.btnreservas);
        btn_reservas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_menuOpciones.this,MenuReservas.class));
            }
        });

        menuopciones=findViewById(R.id.btinicio);
        menuopciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_menuOpciones.this,activity_menuPrincipal.class));
            }
        });

    }
}