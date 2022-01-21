package com.reservaya.reservaya_prototipo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Se agregan las animaciones
        Animation animacion1= AnimationUtils.loadAnimation( this,R.anim.desplazamiento_arriba);
        Animation animacion2= AnimationUtils.loadAnimation( this,R.anim.desplazamiento_abajo);

        ImageView logoIVDibujo =findViewById(R.id.logoIVDibujo);
        ImageView logoIVnombre = findViewById(R.id.logoIVNombre);

        logoIVDibujo.setAnimation(animacion1);
        logoIVnombre.setAnimation(animacion2);

        //new Handler().postDelayed(new Runnable() {
        //@Override
        //public void run() {
           Intent intent= new Intent(MainActivity.this, activity_pantallaInicial.class);
        //   startActivity(intent);
        //   finish();
        //}
        //}, 4000);




    }
}