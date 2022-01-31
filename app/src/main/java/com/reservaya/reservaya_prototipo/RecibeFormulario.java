package com.reservaya.reservaya_prototipo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RecibeFormulario extends AppCompatActivity {

    TextView txtxrecibemensaje;

    ImageView imageViewcaptura;
    ImageButton buttonCamara1;

    private static final int REQUEST_PERMISSION_CAMERA= 100;
    private static final int REQUEST_IMAGE_CAMERA= 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibe_formulario);
        txtxrecibemensaje = findViewById(R.id.txtxrecibemensaje);

        String datos = "Usuario: " + getIntent().getStringExtra("txtusuariocliente")+ "\nNombre: "+ getIntent().getStringExtra("txtnombrecliente")
                + "\nApellido: "+ getIntent().getStringExtra("txtapellidocliente")+ "\nNumero: "+ getIntent().getStringExtra("txtnumerocliente")
                + "\nDireccion: "+ getIntent().getStringExtra("txtdireccioncliente")+ "\nEstablecimiento: "+ getIntent().getStringExtra("cmbx_establecimientio");
        txtxrecibemensaje.setText(datos);
        buttonCamara1 = findViewById(R.id.buttonCamara);
        buttonCamara1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(ActivityCompat.checkSelfPermission(RecibeFormulario.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
                        goToCamara();

                    }else{
                        ActivityCompat.requestPermissions(RecibeFormulario.this,new String[]{Manifest.permission.CAMERA},REQUEST_PERMISSION_CAMERA);
                    }

                }else{
                    goToCamara();
                }

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_PERMISSION_CAMERA){
            if(permissions.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                goToCamara();

            }else{
                Toast.makeText(this,"Nesesita Dar Permiso",Toast.LENGTH_SHORT).show();
            }

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_IMAGE_CAMERA){
            if(resultCode == Activity.RESULT_OK){

                Bitmap bitmap =(Bitmap) data.getExtras().get("data");
                imageViewcaptura.setImageBitmap(bitmap);
                Log.i("TAG","Result=>" + bitmap);


            }

        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    private void goToCamara(){
        Intent camaraIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(camaraIntent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(camaraIntent,REQUEST_IMAGE_CAMERA);

        }

    }

    public void irActivity2( View view){
        //creo el enlace con el segundo activity
        Intent intent = new Intent(this,ComprobanteReserva.class);
        //iniciamos la siguiente activity
        startActivity(intent);

    }
}