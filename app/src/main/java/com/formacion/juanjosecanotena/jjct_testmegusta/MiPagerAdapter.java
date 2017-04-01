package com.formacion.juanjosecanotena.jjct_testmegusta;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by juanjosecanotena on 12/3/17.
 */

public class MiPagerAdapter extends FragmentStatePagerAdapter {


    public MiPagerAdapter(FragmentManager fm) {
        super(fm);
        //Inicializamos datos
        MainActivity.datos = new Datos();
        Log.d(getClass().getCanonicalName(), "INSTANCIADO MiPageAdapter" );
    }

    @Override
    public Fragment getItem(int position) {

        Log.d(getClass().getCanonicalName(), "GET ITEM " + Integer.toString(position) );

        //Instanciamos el Fragmento, que en este caso es siempre el mismo modelo
        Fragment frgCarrusel = new FragmentCarrusel();

        //Adjuntamos a la instancia del Fragmento el dato de la posición
        Bundle bdCarrusel = new Bundle();
        bdCarrusel.putInt("position", position);
        frgCarrusel.setArguments(bdCarrusel);

        return frgCarrusel;
        }


    @Override
    public int getCount() {
        return MainActivity.datos.items.size();
    }
/*
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
  */
}
