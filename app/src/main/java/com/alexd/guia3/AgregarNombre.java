package com.alexd.guia3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.security.Principal;
import static com.alexd.guia3.ListaAgregados.lstNombres;

public class AgregarNombre extends AppCompatActivity implements View.OnLongClickListener{

    private ProgressBar pBarAgregar;
    private Button btnProc;
    private Button btnReg;
    private EditText edtTexto;
    private String nombre;
    int i = 0;
    Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_nombre);

        this.pBarAgregar= findViewById(R.id.pbarAgregar);
        this.btnProc= findViewById(R.id.btnProcesar);
        this.edtTexto = findViewById(R.id.edtNombre);
        this.btnReg= findViewById(R.id.btnRegresar);

        btnProc.setOnLongClickListener(this);

    }

    public void Mensaje(){
        nombre= edtTexto.getText().toString();
        Toast.makeText(getApplicationContext(),"Nombre guardado con Éxito", Toast.LENGTH_LONG).show();
    }


    public void onClick(View v){
        Intent regresar= new Intent(this, MainActivity.class);
        startActivity(regresar);
    }

    public boolean onLongClick(View v){
        switch (v.getId()){
            case R.id.btnProcesar:
                if(edtTexto.getText().toString().isEmpty()){
                    Toast.makeText(this, "Campo Requerido", Toast.LENGTH_LONG).show();
                }else{
                    final String nombre= edtTexto.getText().toString();

                    Thread carga = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (i<=1000){
                                h.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        pBarAgregar.setProgress(i);
                                    }
                                });
                                try{
                                    Thread.sleep(1000);
                                }catch (InterruptedException e){
                                    e.printStackTrace();
                                }
                                if(i==100){
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            lstNombres.add(nombre);
                                            Mensaje();
                                        }
                                    });
                                }
                                i= i+20;
                            }
                        }
                    });
                    carga.start();
                    pBarAgregar.setProgress(0);
                    i=0;
                }
            break;
        }
        return false;
    }
}
