/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.restaurantesmongo;

import entidades.Categoria;
import entidades.Restaurante;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class RestaurantesMongo {

    public static void main(String[] args) {
        
        //Descomenta Para Probar
        
       Metodos m = new Metodos();
////1.- Insertar 3 documentos (restaurantes) más con al menos 2 categorías cada uno:
////Inicio
//       List <Restaurante> listaR= new ArrayList<>();
//       Categoria pizza= new Categoria("Pizza");
//       Categoria sushi= new Categoria("Sushi");
//       Categoria mariscos= new Categoria("Mariscos");
//       Categoria hamburguesa= new Categoria("Hamburguesa");
//       Categoria pollo= new Categoria("Pollo");
//       Categoria pasta= new Categoria("Pasta");
//       
//       Restaurante resta1= new Restaurante("Sushilito",4);
//       resta1.addCategorias(sushi);
//       resta1.addCategorias(mariscos);
//       listaR.add(resta1);
//       
//       Restaurante resta2= new Restaurante("KFC",2);
//       resta2.addCategorias(hamburguesa);
//       resta2.addCategorias(pollo);
//       listaR.add(resta2);
//       
//       Restaurante resta3= new Restaurante("Domino's",5);
//       resta3.addCategorias(pasta);
//       resta3.addCategorias(pizza);
//       listaR.add(resta3);
//       
//       m.insertarMuchosRestaurantes(listaR);
////Fin

////2.- Consultar los restaurantes con más de 4 estrellas de rating:
////Inicio
//      List <Restaurante> listaRConsultaEstrellas= new ArrayList<>();
//      
//       
//      listaRConsultaEstrellas= m.ListaRestaurantesCuatroEstrellasOmas();
//      for (Restaurante r : listaRConsultaEstrellas) {
//            System.out.println(r.getNombre());
//      } 
////Fin

////3.- Consultar los restaurantes que incluyan la categoría pizza:
////Inicio
//      List <Restaurante> listaRConsultaCatPizza= new ArrayList<>();
//      
//       
//      listaRConsultaCatPizza= m.ListaRestaurantesCategoriaPizza();
//      for (Restaurante r : listaRConsultaCatPizza) {
//            System.out.println(r.getNombre());
//      } 
////Fin

////4.- Consultar los restaurantes que incluyan sushi en su nombre:
////Inicio
//      List <Restaurante> listaRsushi= new ArrayList<>();
//      
//       
//      listaRsushi= m.ListaRestaurantesSushi();
//      for (Restaurante r : listaRsushi) {
//            System.out.println(r.getNombre());
//      } 
////Fin

////5.- Agregar una categoría extra al restaurante sushilito:
////Inicio
//      
//      Restaurante r = new Restaurante();
//      r.setNombre("Sushilito");
//      m.agregarCategoria(r, "Pizza");
//      
////Fin

////6.- Eliminar un Restaurante por su identificador
////Inicio
//      //Obviamente es en mi caso este id
//      String Id= "64573befcb4e6fe622269df0";
//      m.eliminarRestaurantePorIdentificador(Id);
////Fin

////7.- Eliminar los Restaurantes por menos de 3 estrellas
////Inicio
//
//    m.eliminarRestauranteTresEstrellasOmenos();
//
////Fin

       
    }
}
