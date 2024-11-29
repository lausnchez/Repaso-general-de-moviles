package com.example.practicarecycleview;

import java.util.ArrayList;

public class Comercios {
    private ArrayList<Comercio> comercios;
    private static Comercios instance;

    public Comercios(){
        this.comercios = new ArrayList<>();
        agregarComercio(new Comercio("Bar Manolo", "665849251", "Calle Mayor"));
        agregarComercio(new Comercio("Casa Carmen", "665849251", "Calle Mayor"));
        agregarComercio(new Comercio("Aluminios Paco", "665849251", "Calle Mayor"));
        agregarComercio(new Comercio("Drogueria Gertrudis", "665849251", "Calle Mayor"));
        agregarComercio(new Comercio("Panadería Segismundo", "665849251", "Calle Mayor"));
        agregarComercio(new Comercio("Sastre María de las Mercedes", "665849251", "Calle Mayor"));
        instance = this;
    }

    // Devuelve true si lo ha agregado correctamente
    public boolean agregarComercio(Comercio comercio){
        try {
            this.comercios.add(comercio);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    // Recoge la instancia - Patrón Singleton
    public static Comercios cogerInstancia(){
           if(instance == null){
               Comercios.instance = new Comercios();
           }
           return instance;
    }

    // Si no elimina te devuelve false
    public Boolean eliminarComercio(Comercio comercio){
        return this.comercios.remove(comercio);
    }

    // Para acceder al listado de comercios
    public ArrayList<Comercio> recogerTodosLosComercios(){
        return this.comercios;
    }
}
