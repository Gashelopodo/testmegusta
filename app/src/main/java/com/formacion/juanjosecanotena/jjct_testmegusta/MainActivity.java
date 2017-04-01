package com.formacion.juanjosecanotena.jjct_testmegusta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    public static Datos datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencia de objetos
        ListView lvListado =(ListView)findViewById(R.id.lvListado);
        Button bIniciar = (Button)findViewById(R.id.bIniciar);

        //Inicializo datos sólo la primera vez
        if(datos==null) datos = new Datos();

        //Adaptador de datos
        ItemsAdapter adaptador = new ItemsAdapter(this,datos.items);

        //Asociación al ListView
        lvListado.setAdapter(adaptador);

        //Evento Click en Botón Iniciar
        bIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this ,Visor.class);
                startActivity(intent);
            }
        });

    }
}
