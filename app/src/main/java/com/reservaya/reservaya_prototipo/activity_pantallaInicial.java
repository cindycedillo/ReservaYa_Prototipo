package com.reservaya.reservaya_prototipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class activity_pantallaInicial extends AppCompatActivity {

    private TextView inicioses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallainicial);

        inicioses=findViewById(R.id.btingresar);

        inicioses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_pantallaInicial.this, activity_iniciarSesion.class));
            }
        });
    }
}