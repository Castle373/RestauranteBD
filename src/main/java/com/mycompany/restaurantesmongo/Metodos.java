/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantesmongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Updates.addToSet;
import static com.mongodb.client.model.Updates.push;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import entidades.Categoria;
import entidades.Restaurante;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author diego
 */
public class Metodos {

    public MongoCollection<Restaurante> collection;

    public Metodos() {
        String BASE_DATOS = "RestauranteBD";
        String HOST = "localhost";
        int PUERTO = 27017;

        //INICIO DE LA CONFIGURACIÓN PARA QUE MONGODRIVE REALICE EL MAPEO DE POJOS AUMATICAMENTE
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());

        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

        ConnectionString cadenaConexion = new ConnectionString("mongodb://" + HOST + "/" + PUERTO);

        MongoClientSettings clientsSettings = MongoClientSettings.builder()
                .applyConnectionString(cadenaConexion)
                .codecRegistry(codecRegistry)
                .build();
        //FIN DE LA CONFIGURACIÓN PARA QUE MONGODRIVE REALICE EL MAPEO DE POJOS AUMATICAMENTE

        // Conectar a la base de datos
        com.mongodb.client.MongoClient mongoClient = MongoClients.create(clientsSettings);
        MongoDatabase baseDatos = mongoClient.getDatabase(BASE_DATOS);

        // Obtener la colección en la que se insertará el documento
        collection = baseDatos.getCollection("Restaurantes", Restaurante.class);
    }

    public boolean insertarMuchosRestaurantes(List<Restaurante> lista) {
        try {
            collection.insertMany(lista);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Restaurante> ListaRestaurantesCuatroEstrellasOmas() {
        List<Restaurante> restaurantes = new ArrayList<>();
        try {
            Bson filtro = Filters.gt("rating", 4);
            MongoCursor<Restaurante> cursor = collection.find(filtro).iterator();

            while (cursor.hasNext()) {
                restaurantes.add(cursor.next());
            }

            cursor.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return restaurantes;
    }

    public List<Restaurante> ListaRestaurantesCategoriaPizza() {
        List<Restaurante> lista = new ArrayList<>();

        Bson filtro = Filters.regex("categorias.nombre", "pizza", "i");
        MongoCursor<Restaurante> cursor = collection.find(filtro).iterator();

        while (cursor.hasNext()) {
            Restaurante restaurante = cursor.next();
            lista.add(restaurante);
        }

        return lista;
    }

    public List<Restaurante> ListaRestaurantesSushi() {
        Pattern regex = Pattern.compile("sushi", Pattern.CASE_INSENSITIVE);
        Bson filter = Filters.regex("nombre", regex);
        List<Restaurante> restaurantes = collection.find(filter).into(new ArrayList<>());
        return restaurantes;
    }

    public boolean agregarCategoria(Restaurante restaurante, String categoriaNueva) {

        Bson filtro = eq("nombre", restaurante.getNombre());

        Categoria nuevaCategoria = new Categoria(categoriaNueva);

        Bson actualizacion = push("categorias", nuevaCategoria);

        UpdateResult resultado = collection.updateOne(filtro, actualizacion);

        return resultado.getModifiedCount() > 0;
    }

    public boolean eliminarRestaurantePorIdentificador(String id) {

        Bson filtro = eq("_id", new ObjectId(id));

        DeleteResult resultado = collection.deleteOne(filtro);

        return resultado.getDeletedCount() > 0;
    }

    public boolean eliminarRestauranteTresEstrellasOmenos() {

        Bson filtro = lte("rating", 3.0);

        DeleteResult resultado = collection.deleteMany(filtro);

        return resultado.getDeletedCount() > 0;
    }

}
