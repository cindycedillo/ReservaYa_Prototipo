package com.reservaya.reservaya_prototipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuReservas extends AppCompatActivity {

    Button boton_revisar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_reservas);
        boton_revisar=(Button) findViewById(R.id.boton_revisar);
        boton_revisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MenuReservas.this,ComprobanteReserva.class);
                startActivity(intent);
            }
        });
    }
}