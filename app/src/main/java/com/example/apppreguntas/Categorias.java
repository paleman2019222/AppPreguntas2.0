package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Categorias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
    }
    private void cambiar(int a)// metodo para cambiar activity a la primera pregunta
    {
        Intent i = new Intent(getApplicationContext(),Primera_Pregunta.class);
        i.putExtra("categoria",a);//enviamos el dato para el switch
        startActivity(i);

    }
    public void Seleccion_Categoria(View v)
    {
        switch(v.getId())
        {
            case R.id.bttn_matematicas: cambiar(1);
                break;
            case R.id.bttn_nacional:cambiar(2);
                break;
            case R.id.bttn_juegos:cambiar(3);
                break;
        }
    }

}