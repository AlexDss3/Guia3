package com.alexd.guia3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class misDatos extends AppCompatActivity {

    private ListView listaDatos;
    private String[] Datos = new String[] {"Alex", "Hernández", "HV15-I04-001"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_datos);

        this.listaDatos=findViewById(R.id.listDatos);

        this.listaDatos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.Datos));
    }
}
