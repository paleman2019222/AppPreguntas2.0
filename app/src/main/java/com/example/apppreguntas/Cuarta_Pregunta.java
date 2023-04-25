package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Cuarta_Pregunta extends AppCompatActivity {

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
        setContentView(R.layout.activity_cuarta_pregunta);
    }




}