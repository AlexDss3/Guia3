package com.alexd.guia3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaAgregados extends AppCompatActivity {

    private ListView lvNombres;
    public static List<String> lstNombres = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_agregados);
        lvNombres=(ListView)findViewById(R.id.lsvNombres);

        lvNombres.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lstNombres));
    }
}
