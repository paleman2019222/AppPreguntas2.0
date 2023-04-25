package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Segunda_Pregunta extends AppCompatActivity {

    Button res1, res2, res3, res4;
    int categoria, punteo;
    TextView Pregunta;
    //respuestas correctas
    String Respuesta_Juego = "luigi";
    String Respuesta_Mate = "Isaac Newton";//
    String Respuesta_Nac = "Quetzal";

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
        cambio_respuestas(categoria);
    }

    public void cambio_activity(int punteo)//cambio activity
    {
        Intent i = new Intent(Segunda_Pregunta.this, Tercera_Pregunta.class);
        i.putExtra("punteo", punteo);
        i.putExtra("categoria", categoria);
        startActivity(i);
    }

    public void correcto(View view)//metodo para verificar respuesta
    {
        int num = 0;//punteo, por defecto no tiene amenos que conteste bien
        Button boton_press = (Button) findViewById(view.getId());
        String texto = boton_press.getText().toString();
        if (texto == Respuesta_Juego || texto == Respuesta_Mate || texto == Respuesta_Nac)//verifica si la respuesta es correcta
        {
            num = 1;//asigna el punteo
        }
        cambio_activity(num + punteo);//llama al metodo de cambio de activity
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
                Pregunta.setText("Nombre de personaje que usan para referirse a un link");
                res1.setText("Cóndor");
                res2.setText(Respuesta_Nac);
                res3.setText("Zopilote");
                res4.setText("Palomas de zona 1");
                break;
            case 3: //juegos
                Pregunta.setText("¿como se llama el hermano de mario en el videojuego Super Mario Bros?");
                res1.setText("bowser");
                res2.setText("warrio");
                res3.setText("liuyi");
                res4.setText(Respuesta_Juego);
                break;
        }
    }
}