package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class Primera_Pregunta extends AppCompatActivity {
    Button res1,res2,res3,res4;
    int categoria;
    TextView Pregunta;
    //respuestas correctas
    String Respuesta_Juego = "zelda";
    String Respuesta_Mate = "1";//
    String Respuesta_Nac = "Quetzal";

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
         cambio_pregunta(categoria);

    }
    public void cambio_pregunta(int punteo)//cambio activity
    {
       Intent i = new Intent(Primera_Pregunta.this,Segunda_Pregunta.class);
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
           num= 1;//asigna el punteo
        }
        cambio_pregunta(num);//llama al metodo de cambio de activity
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
                Pregunta.setText("Nombre de personaje que usan para referirse a un link");
                res1.setText("Cóndor");
                res2.setText("Quetzal");
                res3.setText("Zopilote");
                res4.setText("Palomas de zona 1");
                break;
            case 3: //juegos
                Pregunta.setText("¿Cuál es el ave nacional de Guatemala?");
                res1.setText("Cóndor");
                res2.setText("Quetzal");
                res3.setText("Zopilote");
                res4.setText("Palomas de zona 1");
                break;
        }
    }

}