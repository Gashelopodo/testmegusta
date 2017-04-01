package com.formacion.juanjosecanotena.jjct_testmegusta;

import java.util.ArrayList;

/**
 * Created by juanjosecanotena on 12/3/17.
 */

public class Datos {

    static ArrayList<Item> items;

    public Datos() {
        items=new ArrayList<Item>();
        items.add(new Item("Carmena",R.drawable.carmena,R.mipmap.ic_help));
        items.add(new Item("Cospedal",R.drawable.cospedal,R.mipmap.ic_help));
        items.add(new Item("Felipe VI",R.drawable.felipe,R.mipmap.ic_help));
        items.add(new Item("Iglesias",R.drawable.iglesias,R.mipmap.ic_help));
        items.add(new Item("Mas",R.drawable.mas,R.mipmap.ic_help));
        items.add(new Item("Rajoy",R.drawable.rajoy,R.mipmap.ic_help));
        items.add(new Item("Revilla",R.drawable.revilla,R.mipmap.ic_help));
        items.add(new Item("Rivera",R.drawable.rivera,R.mipmap.ic_help));
        items.add(new Item("Sánchez",R.drawable.sanchez,R.mipmap.ic_help));
        items.add(new Item("Urkullu",R.drawable.urkullu,R.mipmap.ic_help));

    }

    public static ArrayList<Item> getItems() {
        return items;
    }
}
