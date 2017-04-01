package com.formacion.juanjosecanotena.jjct_testmegusta;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by juanjosecanotena on 12/3/17.
 */

public class FragmentCarrusel extends Fragment {

    private int position;


    private void enviarPreferencia(){
        ArrayList<Item> arrayList = Datos.getItems();
        PreferenciasUsuario pu = new PreferenciasUsuario(arrayList);

        Gson gson = new Gson();
        String preferencia_json = gson.toJson(pu);

        EnviarPreferencias enviarPreferencias = new EnviarPreferencias();
        enviarPreferencias.execute(preferencia_json);

        Log.d(getClass().getCanonicalName(), "MENSAJ JSON : " + preferencia_json);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Inflamos el Fragmento con su layout correspondiente
        View carrusell = inflater.inflate(R.layout.fragment_carrusel,container,false);

        //Recuperamos los datos anexados a la instancia del Fragmento
        Bundle args=getArguments();
        position = args.getInt("position",0);

        //Referencias a los objetos
        ImageView imgFotoCarrusel = (ImageView) carrusell.findViewById(R.id.imgFotoCarrusel);
        TextView tvNombreCarrusel = (TextView) carrusell.findViewById(R.id.tvNombreCarrusel);
        ImageButton ibNoMeGustaCarrusel = (ImageButton) carrusell.findViewById(R.id.ibNoMeGustaCarrusel);
        ImageButton ibMeGustaCarrusel = (ImageButton) carrusell.findViewById(R.id.ibMeGustaCarrusel);

        //Ponemos la imagen y el nombre correspondientes a la posición
        imgFotoCarrusel.setImageResource(MainActivity.datos.items.get(position).imagen);
        tvNombreCarrusel.setText(MainActivity.datos.items.get(position).nombre);

        //Eventos en los botones MeGusta y NoMeGusta
        ibNoMeGustaCarrusel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.datos.items.get(position).setValoracion(R.mipmap.ic_no_me_gusta);

                    enviarPreferencia();

                    if(position ==  MainActivity.datos.items.size()-1){
                        Intent intent = new Intent(FragmentCarrusel.super.getContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    else Visor.vpCarrusel.setCurrentItem(position+1);
                }
            });

        ibMeGustaCarrusel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.datos.items.get(position).setValoracion(R.mipmap.ic_me_gusta);

                    enviarPreferencia();

                    if(position ==  MainActivity.datos.items.size()-1){
                        Intent intent = new Intent(FragmentCarrusel.super.getContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    else Visor.vpCarrusel.setCurrentItem(position+1);
                }
            });

        return  carrusell;
    }
}
