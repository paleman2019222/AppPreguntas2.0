package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Primera_Pregunta extends AppCompatActivity {
    Button res1,res2,res3,res4;
    int categoria;
    TextView Pregunta;
    //respuestas correctas
    String Respuesta_Juego = "Call of duty";
    String Respuesta_Mate = "1";//
    String Respuesta_Nac = "15 de septiembre";
    String name;//nombre del jugador
    int punteo= 0;
    boolean verificador = false;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pregunta);

        res1 = (Button) findViewById(R.id.bttn_respuesta1);
        res2 = (Button) findViewById(R.id.bttn_respuesta2);
        res3 = (Button) findViewById(R.id.bttn_res3);
        res4 = (Button) findViewById(R.id.bttn_respuesta4);
        Pregunta= (TextView) findViewById(R.id.pregunta1);


        Bundle extras = getIntent().getExtras();
         categoria = extras.getInt("categoria");
         name = extras.getString("name");

         cambio_respuestas(categoria);

    }
    public void cambio_activity()//cambio activity
    {
       Intent i = new Intent(Primera_Pregunta.this,Segunda_Pregunta.class);
       i.putExtra("punteo",punteo);
       i.putExtra("categoria",categoria);
       i.putExtra("name", name);

        startActivity(i);
        finish();
    }
    public void correcto(View view)//metodo para verificar respuesta
    {
        //punteo, por defecto no tiene a menos que conteste bien
        Button boton_press = (Button) findViewById(view.getId());
        String texto = boton_press.getText().toString();

        res1.setEnabled(false);
        res2.setEnabled(false);
        res3.setEnabled(false);
        res4.setEnabled(false);

        if(texto == Respuesta_Juego||texto == Respuesta_Mate||texto == Respuesta_Nac)//verifica si la respuesta es correcta
        {
           punteo= 1;//asigna el punteo
            verificador = true;
            toast("¡Respuesta correcta!", verificador);

        }else{
            verificador=false;
            toast("¡Respuesta incorrecta!", verificador);
        }
        mHandler.postDelayed(delay,2000);
    }

    private void cambio_respuestas(int categoría){
        switch(categoría){
            case 1: //mate
                Pregunta.setText("Un número elevado a la potencia 0, da como resultado");
                res1.setText("El mismo número");
                res2.setText("0");
                res3.setText(Respuesta_Mate);
                res4.setText("Infinito");
                break;
            case 2: //nacional
                Pregunta.setText("¿En qué fecha se celebra la independencia de Guatemala?");
                res1.setText("25 de diciembre");
                res2.setText("10 de mayo");
                res3.setText(Respuesta_Nac);
                res4.setText("16 de febrero");
                break;
            case 3: //juegos
                Pregunta.setText("videojuego que se hizo famoso por la temática parecida a la segunda guerra mundial");
                res1.setText("Free Fire");
                res2.setText(Respuesta_Juego);
                res3.setText("PUG mobile");
                res4.setText("krunkerer");
                break;
        }
    }

    private  Runnable delay = new Runnable() {
        @Override
        public void run() {
            cambio_activity();

        }
    };

    public void toast(String message, Boolean validar){

        if(validar==true){
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.layout_correcto, (ViewGroup) findViewById(R.id.customToast));
            TextView mensaje = view.findViewById(R.id.txtMensajePersonalizado);
            mensaje.setText(message);

            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_HORIZONTAL, 0,0);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(view);
            toast.show();
        }else if(validar==false){
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.layout_incorrecto, (ViewGroup) findViewById(R.id.customToast));
            TextView mensaje = view.findViewById(R.id.txtMensajePersonalizado);
            mensaje.setText(message);

            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_HORIZONTAL, 0,0);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(view);
            toast.show();
        }



    }

}