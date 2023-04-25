package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cuarta_Pregunta extends AppCompatActivity {

    Button res1, res2, res3, res4;

    int categoria, punteo;

    TextView Pregunta;

    //respuestas correctas
    String Respuesta_Juego = "puño";
    String Respuesta_Mate = "Aurelio Baldor";//
    String Respuesta_Nac = "Dr Ricardo Bressani";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuarta_pregunta);

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
        Intent i = new Intent(this, Quinta_Pregunta.class);
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
            num = 1 + punteo;//asigna el punteo
        }
        cambio_activity(num);//llama al metodo de cambio de activity
    }

    private void cambio_respuestas(int categoría) {
        switch (categoría) {
            case 1: //mate
                Pregunta.setText("Álgebra de baldor es un libro del matemático y profesor cubano llamado");
                res1.setText(Respuesta_Mate);
                res2.setText("Jorge Baldor");
                res3.setText("Vladimir Baldor");
                res4.setText("Baldor Constantino");
                break;
            case 2: //nacional
                Pregunta.setText("¿Quién inventó la incaparina?");
                res1.setText("Mi abuelita");
                res2.setText("Corporación MUltiInversiones");
                res3.setText(Respuesta_Nac);
                res4.setText("Dr Manuel Villacorta");
                break;
            case 3: //juegos
                Pregunta.setText("¿Con que parte del cuerpo, mario golpea los ladrillos en el videojuego Super Mario Bros?");
                res1.setText("cabeza");
                res2.setText(Respuesta_Juego);
                res3.setText("caparazon");
                res4.setText("pierna");
                break;
        }
    }
}