package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Puntaje extends AppCompatActivity {
    int categoria, punteo;
    Button btnMenu;
    TextView puntaje;
    String name="";

    ImageView contento, triste, avergonzado;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntaje);
        btnMenu = (Button) findViewById(R.id.bttn_menu);
        puntaje = (TextView) findViewById(R.id.puntaje);
        contento = (ImageView) findViewById(R.id.imagenContento);
        triste = (ImageView) findViewById(R.id.imagenTriste);
        avergonzado = (ImageView) findViewById(R.id.imagenAvergonzado);
        TextView titulo = (TextView) findViewById(R.id.titulo);


        Bundle extras = getIntent().getExtras();
        punteo = extras.getInt("punteo");

        puntaje.setText(String.valueOf(punteo*1000));
        name = getIntent().getStringExtra("name");
        titulo.setText(name + "\n tus puntos:");
        System.out.println(name);
        mostrar_imagen(punteo*1000);
    }
    public void cambio_activity(View view)//cambio activity
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    public void mostrar_imagen(int punteo){
                if(punteo<=2000){
                    triste.setVisibility(View.VISIBLE);
                }else if(punteo>2000 && punteo<=3000){
                    avergonzado.setVisibility(View.VISIBLE);
                }else{
                    contento.setVisibility(View.VISIBLE);
                }
    }

}