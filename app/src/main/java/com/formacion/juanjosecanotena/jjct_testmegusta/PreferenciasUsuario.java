package com.formacion.juanjosecanotena.jjct_testmegusta;

import java.util.ArrayList;

/**
 * Created by cice on 1/4/17.
 */

public class PreferenciasUsuario {

    private String usuario;
    private boolean[] array_gustos;


    public PreferenciasUsuario(ArrayList<Item> arrayList) {

        usuario = "MAC";
        array_gustos = new boolean[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++){
            array_gustos[i] = (arrayList.get(i).valoracion == R.mipmap.ic_me_gusta);
        }

    }
}
