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
    String Respuesta_Juego = "Tetris";

    String Respuesta_Mate = "0";

    String Respuesta_Nac = "Miguel Ángel Asturias";
    String name;
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
        punteo = extras.getInt("punteo");
        name = extras.getString("name");
        cambio_respuestas(categoria);
        System.out.println(punteo);
    }

    public void cambio_activity(int punteo)//cambio activity
    {
        Intent i = new Intent(Quinta_Pregunta.this,Puntaje.class);
        i.putExtra("punteo",punteo);
        i.putExtra("categoria",categoria);
        i.putExtra("name", name);
        startActivity(i);
        finish();
    }
    public void correcto(View view)//metodo para verificar respuesta
    {
        int num= 0;//punteo, por defecto no tiene a menos que conteste bien
        Button boton_press = (Button) findViewById(view.getId());
        String texto = boton_press.getText().toString();
        if(texto == Respuesta_Juego||texto == Respuesta_Mate||texto == Respuesta_Nac)//verifica si la respuesta es correcta
        {
            punteo = 1 + punteo;//asigna el punteo
        }
        cambio_activity(punteo);//llama al metodo de cambio de activity
    }

    private void cambio_respuestas(int categoría){
        switch(categoría){
            case 1: //mate
                Pregunta.setText("La derivada de una constante es igual a");
                res1.setText("1");
                res2.setText("Igual a la unidad");
                res3.setText(Respuesta_Mate);
                res4.setText("No aprendí derivadas");
                break;
            case 2: //nacional
                Pregunta.setText("¿Qué guatemalteco ganó un premio nobel de literatura?");
                res1.setText("Neto Bran");
                res2.setText("Carlos 'El pescadito' Ruiz");
                res3.setText("Luis Von Ahn");
                res4.setText(Respuesta_Nac);
                break;
            case 3: //juegos
                Pregunta.setText("Juego de logica y baja calidad, donde su atraccion principal son cuadrados");
                res1.setText("Geometry dash");
                res2.setText("mahjong");
                res3.setText("Minecraft");
                res4.setText(Respuesta_Juego);
                break;
        }
    }

}