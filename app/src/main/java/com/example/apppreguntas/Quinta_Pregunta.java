package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quinta_Pregunta extends AppCompatActivity {
    Button res1,res2,res3,res4;
    int categoria, punteo;
    TextView Pregunta;
    //respuestas correctas
    String Respuesta_Juego = "";
    String Respuesta_Mate = "";//
    String Respuesta_Nac = "Miguel Ángel Asturias";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quinta_pregunta);

        res1 = (Button) findViewById(R.id.bttn_respuesta1);
        res2 = (Button) findViewById(R.id.bttn_respuesta2);
        res3 = (Button) findViewById(R.id.bttn_respuesta3);
        res4 = (Button) findViewById(R.id.bttn_respuesta4);
        Pregunta= (TextView) findViewById(R.id.pregunta);


        Bundle extras = getIntent().getExtras();
        categoria = extras.getInt("categoria");
        cambio_respuestas(categoria);
    }

    public void cambio_activity(int punteo)//cambio activity
    {
        Intent i = new Intent(Quinta_Pregunta.this,MainActivity.class);
        i.putExtra("punteo",punteo);
        i.putExtra("categoria",categoria);
        startActivity(i);
    }
    public void correcto(View view)//metodo para verificar respuesta
    {
        int num= 0;//punteo, por defecto no tiene a menos que conteste bien
        Button boton_press = (Button) findViewById(view.getId());
        String texto = boton_press.getText().toString();
        if(texto == Respuesta_Juego||texto == Respuesta_Mate||texto == Respuesta_Nac)//verifica si la respuesta es correcta
        {
            num = 1 + punteo;//asigna el punteo
        }
        cambio_activity(num);//llama al metodo de cambio de activity
    }

    private void cambio_respuestas(int categoría){
        switch(categoría){
            case 1: //mate
                Pregunta.setText("");
                res1.setText("");
                res2.setText("");
                res3.setText("");
                res4.setText("");
                break;
            case 2: //nacional
                Pregunta.setText("¿Qué guatemalteco ganó un premio nobel de literatura?");
                res1.setText("Neto Bran");
                res2.setText("Carlos 'El pescadito' Ruiz");
                res3.setText("Luis Von Ahn");
                res4.setText(Respuesta_Nac);
                break;
            case 3: //juegos
                Pregunta.setText("");
                res1.setText("");
                res2.setText("");
                res3.setText("");
                res4.setText("");
                break;
        }
    }

}