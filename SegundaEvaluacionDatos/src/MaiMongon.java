import java.util.ArrayList;
import java.util.List;
 
import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
 
public class MaiMongon {
    /**
     * Clase principal para interactuar con la base de datos.
     */
    public static void main(String[] args) {
        // Crear instancia de MongoDBSingleton
        MongoDBSingletonBiblioteca1 dbInstance = MongoDBSingletonBiblioteca1.getInstance();
 
        // Conectar a la base de datos 'mibasededatos'
//        dbInstance.connect("mongodb://localhost:27017", "mibasedatos");
 
        // Obtener la colección 'alumnos'
        MongoCollection<Document> alumnosCollection = dbInstance.getCollection("alumnos");
 
        // Depuración: Contar los documentos en la colección
     long count = alumnosCollection.countDocuments();
     System.out.println("Cantidad de documentos en la colección: " + count);
 
        // Obtener todos los documentos en la colección
        List<Document> alumnos = alumnosCollection.find().into(new ArrayList<Document>());
 
        // Mostrar documentos
        System.out.println("Alumnos en la colección:");
        for (Document alumno : alumnos) {
            String nombre = alumno.getString("nombre");
            String telefono = alumno.getString("teléfono");
            String curso = alumno.getString("curso");
            int nota = alumno.getInteger("nota");
 
            System.out.printf("Nombre: %s, Teléfono: %s, Curso: %s, Nota: %d%n", nombre, telefono, curso, nota);
        }
    }
}
