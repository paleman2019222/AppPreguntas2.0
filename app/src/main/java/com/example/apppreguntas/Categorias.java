package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Categorias extends AppCompatActivity {

    EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        nombre = (EditText) findViewById(R.id.et_nombre);
    }
    private void cambiar(int a)// metodo para cambiar activity a la primera pregunta
    {
        Intent i = new Intent(getApplicationContext(), Primera_Pregunta.class);
        i.putExtra("categoria", a);//enviamos el dato para el switch
        i.putExtra("name", nombre.getText().toString());
        startActivity(i);
    }


    public boolean Validar_Nombre()
    {
        boolean retornar = true;
        String dato = nombre.getText().toString();
        if(dato.isEmpty())
        {
            nombre.setError("Es necesario que ingrese su nombre");
            retornar = false;
        }
        return retornar;
    }
    public void Seleccion_Categoria(View v)
    {
        if(Validar_Nombre()) {
            switch (v.getId()) {
                case R.id.bttn_matematicas:
                    cambiar(1);
                    break;
                case R.id.bttn_nacional:
                    cambiar(2);
                    break;
                case R.id.bttn_juegos:
                    cambiar(3);
                    break;
            }
        }
    }
    public void regresar(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

}