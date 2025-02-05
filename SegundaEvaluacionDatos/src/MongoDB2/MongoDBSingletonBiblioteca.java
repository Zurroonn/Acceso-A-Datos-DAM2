package MongoDB2;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBSingletonBiblioteca {
    private static MongoDBSingletonBiblioteca instancia;
    private MongoClient cliente;
    private MongoDatabase database;

    private MongoDBSingletonBiblioteca() {
        cliente = MongoClients.create("mongodb://localhost:27017");
        database = cliente.getDatabase("mibasedatos");
    }

    public static MongoDBSingletonBiblioteca getInstancia() {
        if (instancia == null) {
            instancia = new MongoDBSingletonBiblioteca();
        }
        return instancia;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void cerrarConexion() {
        if (cliente != null) {
            cliente.close();
        }
    }
    public MongoCollection<Document> getCollection(String collectionName){
    	return database.getCollection(collectionName);
    }
}
