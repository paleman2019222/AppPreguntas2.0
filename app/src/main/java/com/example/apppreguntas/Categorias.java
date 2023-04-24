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
    public void pregunta(View v)
    {
        Intent i = new Intent(getApplicationContext(),Primera_Pregunta.class);
        startActivity(i);
    }
    public void categoria(View c){


    }
}