package com.reservaya.reservaya_prototipo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Formulario extends AppCompatActivity {

    EditText txtusuariocliente,txtnombrecliente,txtapellidocliente,txtnumerocontacto,txtdireccioncliente;
    Spinner cmbx_establecimientio;


    private Button btnenviar;
    private PendingIntent pendingIntent;
    private final static String CHANNEL_ID = "Notificacion";
    private final static int NOTIFICACION_ID = 0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        txtusuariocliente = findViewById(R.id.txtusuariocliente);
        txtnombrecliente = findViewById(R.id.txtnombrecliente);
        txtapellidocliente = findViewById(R.id.txtapellidocliente);
        txtnumerocontacto = findViewById(R.id.txtnumerocontacto);
        cmbx_establecimientio = findViewById(R.id.cmbx_establecimientio);
        txtdireccioncliente = findViewById(R.id.txtdireccioncliente);


        btnenviar = findViewById(R.id.btnenviar);

        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPendingIntent();
                createNotificationChannel();
                createNotification();

                if(txtusuariocliente.getText().toString().equals("")|| txtnombrecliente.getText().toString().equals("")|| txtapellidocliente.getText().toString().equals("")){
                    Toast.makeText(Formulario.this,"Debe ingresar su Nombre y Apellido",Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(Formulario.this,RecibeFormulario.class);

                    intent.putExtra("txtusuariocliente",txtusuariocliente.getText().toString());
                    intent.putExtra("txtnombrecliente",txtnombrecliente.getText().toString());
                    intent.putExtra("txtapellidocliente",txtapellidocliente.getText().toString());
                    intent.putExtra("txtnumerocliente",txtnumerocontacto.getText().toString());
                    intent.putExtra("cmbx_establecimientio",cmbx_establecimientio.getSelectedItem().toString());
                    intent.putExtra("txtdireccioncliente",txtdireccioncliente.getText().toString());

                    startActivity(intent);


                }
            }
        });
    }
    private void setPendingIntent(){
        Intent intent = new Intent(this, ComprobanteReserva.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(ComprobanteReserva.class);
        stackBuilder.addNextIntent(intent);
        pendingIntent = stackBuilder.getPendingIntent(1, PendingIntent.FLAG_UPDATE_CURRENT);

    }

    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Notificacion";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void createNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_baseline_business_24);
        builder.setContentTitle("Notificacion Reserva");
        builder.setContentText("Su reserva esta Lista");
        builder.setColor(Color.BLUE);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setDefaults(Notification.DEFAULT_SOUND);

        builder.setContentIntent(pendingIntent);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(NOTIFICACION_ID, builder.build());
    }







}