package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void  cambio_a_Categorias(View view)
    {
        Intent intent = new Intent(getApplicationContext(),Categorias.class);
        startActivity(intent);
    }
    public void cambio_a_Intrucciones(View view)
    {
        Intent intent = new Intent(getApplicationContext(),Instrucciones.class);
        startActivity(intent);
    }
    public void  cambio_a_AboutUs(View view)
    {
        Intent intent = new Intent(getApplicationContext(), AboutUs.class);
        startActivity(intent);
    }

}