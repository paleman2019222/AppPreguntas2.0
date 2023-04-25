package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tercera_Pregunta extends AppCompatActivity {
    Button res1,res2,res3,res4;
    int categoria, punteo;
    TextView Pregunta;
    //respuestas correctas
    String Respuesta_Juego = "zelda";
    String Respuesta_Mate = "Tiene un ángulo recto";//
    String Respuesta_Nac = "Alejandro Giammattei";
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera_pregunta);

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
        System.out.println(punteo+"3ra");
    }

    public void cambio_activity(int punteo)//cambio activity
    {
        Intent i = new Intent(Tercera_Pregunta.this,Cuarta_Pregunta.class);
        i.putExtra("punteo",punteo);
        i.putExtra("categoria",categoria);
        i.putExtra("name", name);
        startActivity(i);
        finish();
    }
    public void correcto(View view)//metodo para verificar respuesta
    {
        //int num= 0;//punteo, por defecto no tiene a menos que conteste bien
        Button boton_press = (Button) findViewById(view.getId());
        String texto = boton_press.getText().toString();
        if(texto == Respuesta_Juego||texto == Respuesta_Mate||texto == Respuesta_Nac)//verifica si la respuesta es correcta
        {
            punteo= 1 + punteo;//asigna el punteo
        }
        cambio_activity(punteo);//llama al metodo de cambio de activity
    }

    private void cambio_respuestas(int categoría){
        switch(categoría){
            case 1: //mate
                Pregunta.setText("Un triángulo rectángulo se llama así porque");
                res1.setText("Está formado por rectas");
                res1.setTextSize(24);
                res2.setText(Respuesta_Mate);
                res2.setTextSize(24);
                res3.setText("Tiene todos sus ángulos rectos");
                res3.setTextSize(24);
                res4.setText("Así lo quiso Dios");
                res4.setTextSize(24);
                break;
            case 2: //nacional
                Pregunta.setText("¿Quién es el actual presidente de Guatemala?");
                res1.setText("Tekun Uman");
                res2.setText("Álvaro Colom");
                res3.setText("Ricardo Arjona");
                res4.setText(Respuesta_Nac);
                break;
            case 3: //juegos
                Pregunta.setText("personaje que es confundido con un 'link'(hipervinculo)");
                res1.setText(Respuesta_Juego);
                res2.setText("link");
                res3.setText("ganon");
                res4.setText("Hyper");
                break;
        }
    }
}