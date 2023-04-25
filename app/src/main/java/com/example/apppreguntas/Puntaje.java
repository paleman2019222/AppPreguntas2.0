package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Puntaje extends AppCompatActivity {
    int categoria, punteo;
    Button btnMenu;
    TextView puntaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntaje);
        btnMenu = (Button) findViewById(R.id.bttn_menu);
        puntaje = (TextView) findViewById(R.id.puntaje);
        Bundle extras = getIntent().getExtras();
        categoria = extras.getInt("´punteo");
        puntaje.setText(punteo);
    }
    public void cambio_activity(View view)//cambio activity
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}