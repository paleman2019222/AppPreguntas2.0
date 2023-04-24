package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Segunda_Pregunta extends AppCompatActivity {

    int categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pregunta);

        TextView tv = (TextView)findViewById(R.id.pregunta);

        Bundle extras = getIntent().getExtras();
        categoria = extras.getInt("punteo");

       tv.setText(String.valueOf(categoria));
    }
}