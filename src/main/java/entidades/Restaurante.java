/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class Restaurante {
    public String nombre;
    public float rating;
    public List<Categoria> categorias;
    
    public Restaurante(){
        categorias = new ArrayList<Categoria>();
    }

    public Restaurante(String nombre, float rating) {
        this.nombre = nombre;
        this.rating = rating;
         categorias = new ArrayList<Categoria>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }
    public void addCategorias(Categoria categorias){
       this.categorias.add(categorias);
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    
}
