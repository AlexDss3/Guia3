package com.alexd.guia3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnLista;
    private Button btnNombre;
    private Button btnDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnLista= findViewById(R.id.btnLista);
        this.btnNombre = findViewById(R.id.btnNombre);
        this.btnDatos=findViewById(R.id.btnDatos);
    }

    public void Lista(View v){
        Intent verLista = new Intent(this, ListaAgregados.class);
        startActivity(verLista);
    }

    public void Nombre(View v){
        Intent aggNombre = new Intent(this, AgregarNombre.class);
        startActivity(aggNombre);
    }

    public void Datos(View v){
        Intent misDatos = new Intent(this, misDatos.class);
        startActivity(misDatos);
    }

}
