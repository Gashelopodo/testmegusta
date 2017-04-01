package com.formacion.juanjosecanotena.jjct_testmegusta;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by juanjosecanotena on 12/3/17.
 */

public class Visor extends AppCompatActivity {

    public static ViewPager vpCarrusel;
    private MiPagerAdapter miPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visor);

        Log.d(getClass().getCanonicalName(), "INICIO VISOR" );

        vpCarrusel = (ViewPager)findViewById(R.id.vpCarrusel);
        miPagerAdapter = new MiPagerAdapter(getSupportFragmentManager());
        vpCarrusel.setAdapter(miPagerAdapter);

    }

}
