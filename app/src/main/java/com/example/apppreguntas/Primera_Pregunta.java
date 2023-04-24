package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Primera_Pregunta extends AppCompatActivity {
    Button prg1,prg2,prg3,prg4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pregunta);

        prg1 = (Button) findViewById(R.id.bttn_respuesta1);
        prg2 = (Button) findViewById(R.id.bttn_respuesta2);
        prg3 = (Button) findViewById(R.id.bttn_respuesta3);
        prg4 = (Button) findViewById(R.id.bttn_respuesta4);
    }
    private void cambio_pregunta()
    {
       Intent i = new Intent(getApplicationContext(),Segunda_Pregunta.class);
       startActivity(i);
    }
}