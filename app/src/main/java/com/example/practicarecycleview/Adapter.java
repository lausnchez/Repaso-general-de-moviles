package com.example.practicarecycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Item> {
    private ArrayList<Comercio> comercios;

    // setData de David, actualiza la lista que le pasamos al recyclerView
    public void actualizarListado(ArrayList<Comercio> comercios){
        this.comercios = comercios;
    }

    // Asigna al atributo la instancia de Comercios
    public Adapter(){
        this.comercios = Comercios.cogerInstancia().recogerTodosLosComercios();
    }

    @NonNull
    @Override
    public Item onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new Item(view);
    }

    // RecyclerView llama a este método para asociar un ViewHolder con data
    // Recoge cada item y su posición y le asignamos a cada lbl su valor
    @Override
    public void onBindViewHolder(@NonNull Item holder, int position) {
        holder.txt_nombre_resultado.setText(comercios.get(position).getNombre());
        holder.txt_direccion_resultado.setText(comercios.get(position).getDireccion());
        holder.txt_telefono_resultado.setText(comercios.get(position).getTelefono());
    }

    // Devuelve el tamaño de el array que tenemos como atributo (es decir, calcula la cantidad de items)
    @Override
    public int getItemCount() {
        return comercios.size();
    }

    public static class Item extends ViewHolder {
        public TextView txt_nombre_resultado;
        public TextView txt_telefono_resultado;
        public TextView txt_direccion_resultado;

        public Item(@NonNull View itemView) {
            super(itemView);
            txt_nombre_resultado = itemView.findViewById(R.id.lbl_nombre_res);
            txt_telefono_resultado = itemView.findViewById(R.id.lbl_telefono_res);
            txt_direccion_resultado = itemView.findViewById(R.id.lbl_direccion_res);
        }
    }
}
