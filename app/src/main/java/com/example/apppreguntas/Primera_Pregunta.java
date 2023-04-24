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
    String Respuesta_Mate = "x,x + 1,x + 2";//
    String Respuesta_Nac = "";

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
         cambio_textos(categoria);

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
        int num= 0;
        Button boton_press = (Button) findViewById(view.getId());
        String texto = boton_press.getText().toString();
        if(texto == Respuesta_Juego||texto == Respuesta_Mate||texto == Respuesta_Nac)//verifica si la respuesta es correcta
        {
           num= 1;
            Pregunta.setText("Funciona");//si funciona:)
        }
        cambio_pregunta(num);//llama al metodo de cambio de activity
    }

    private void texto_mate(){
        Pregunta.setText("Tres números naturales consecutivos, traducido a lenguaje algebraico es");
        res1.setText(Respuesta_Mate);
    }


    private void texto_videojuegos()//cambio de Strings a la categoria juegos
    {
        Pregunta.setText("Nombre de personaje que usan para referirse a un link");
        res3.setText(Respuesta_Juego);
    }
    private void cambio_textos(int categoria)//seleccion de categoria
    {
        switch(categoria)
        {
            case 1:
                break;
            case 2:
                break;
            case 3:texto_videojuegos();
                break;

        }
    }

}