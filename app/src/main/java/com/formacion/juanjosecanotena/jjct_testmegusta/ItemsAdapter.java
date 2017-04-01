package com.formacion.juanjosecanotena.jjct_testmegusta;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.resource;

/**
 * Created by juanjosecanotena on 12/3/17.
 */

public class ItemsAdapter extends ArrayAdapter<Item>{


    public ItemsAdapter(Context context, ArrayList<Item> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Item item = getItem(position);

        //Inflamos si no está ya creada
        if ( convertView==null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fila,parent,false);

        //Asignación de objetos
        TextView tvNombre=(TextView)convertView.findViewById(R.id.tvNombre);
        ImageView imgItem=(ImageView) convertView.findViewById(R.id.imgItem);
        ImageView imgValor=(ImageView) convertView.findViewById(R.id.imgValor);

        //Valores del elemento
        tvNombre.setText(item.nombre);
        imgItem.setImageResource(item.imagen);
        imgValor.setImageResource(item.valoracion);

        return convertView;

    }
}
