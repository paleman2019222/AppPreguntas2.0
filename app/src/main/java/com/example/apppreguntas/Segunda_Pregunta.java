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
import android.widget.TextView;
import android.widget.Toast;

public class Segunda_Pregunta extends AppCompatActivity {

    Button res1, res2, res3, res4;
    int categoria, punteo;
    TextView Pregunta;
    //respuestas correctas
    String Respuesta_Juego = "luigi";
    String Respuesta_Mate = "Isaac Newton";//
    String Respuesta_Nac = "Quetzal";
    String name;//nombre del jugador

    Boolean verificador = false;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pregunta);

        res1 = (Button) findViewById(R.id.bttn_respuesta1);
        res2 = (Button) findViewById(R.id.bttn_respuesta2);
        res3 = (Button) findViewById(R.id.bttn_respuesta3);
        res4 = (Button) findViewById(R.id.bttn_respuesta4);
        Pregunta = (TextView) findViewById(R.id.pregunta);

        Bundle extras = getIntent().getExtras();
        categoria = extras.getInt("categoria");
        punteo = extras.getInt("punteo");
        name = extras.getString("name");
        cambio_respuestas(categoria);
        System.out.println(punteo);
    }

    public void cambio_activity()//cambio activity
    {
        Intent i = new Intent(this, Tercera_Pregunta.class);
        i.putExtra("punteo", punteo);
        i.putExtra("categoria", categoria);
        i.putExtra("name", name);
        startActivity(i);
        finish();
    }

    public void correcto(View view)//metodo para verificar respuesta
    {
        //int num = 0;//punteo, por defecto no tiene amenos que conteste bien
        Button boton_press = (Button) findViewById(view.getId());
        String texto = boton_press.getText().toString();
        res1.setEnabled(false);
        res2.setEnabled(false);
        res3.setEnabled(false);
        res4.setEnabled(false);
        if (texto == Respuesta_Juego || texto == Respuesta_Mate || texto == Respuesta_Nac)//verifica si la respuesta es correcta
        {
            punteo= 1 + punteo;//asigna el punteo
            verificador=true;
            toast("¡Respuesta correcta!", verificador);
        }else{
            verificador=false;
            toast("¡Respuesta incorrecta!", verificador);
        }
        mHandler.postDelayed(delay,2000);//llama al metodo de cambio de activity
    }

    private void cambio_respuestas(int categoría) {
        switch (categoría) {
            case 1: //mate
                Pregunta.setText("Es el creador de tres principios fundamentales sobre el movimiento o mecánica clásica");
                res1.setText("Albert Einstein");
                res2.setText("Nicolás Copernico");
                res3.setText("Isaac Tuiz");
                res4.setText(Respuesta_Mate);
                break;
            case 2: //nacional
                Pregunta.setText("¿Cuál es el ave nacional de Guatemala?");
                res1.setText("Cóndor");
                res2.setText(Respuesta_Nac);
                res3.setText("Zopilote");
                res4.setText("Palomas de zona 1");
                break;
            case 3: //juegos
                Pregunta.setText("¿Cómo se llama el hermano de mario en el videojuego Super Mario Bros?");
                res1.setText("bowser");
                res2.setText("warrio");
                res3.setText("liuyi");
                res4.setText(Respuesta_Juego);
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