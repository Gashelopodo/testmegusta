package com.formacion.juanjosecanotena.jjct_testmegusta;

/**
 * Created by juanjosecanotena on 12/3/17.
 */

public class Item {

    String nombre;
    int imagen;
    int valoracion;

    public Item(String nombre, int imagen, int valoracion) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.valoracion = valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
}
