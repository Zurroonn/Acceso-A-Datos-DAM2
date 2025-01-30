package MongoDB2;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class DAOimpl implements DAO {
    private final MongoCollection<Document> collection;

    public DAOimpl() {
        this.collection = MongoDBSingletonBiblioteca.getInstance().getCollection("empleados");
    }

    @Override
    public void crearColeccionSiNoExiste() {
        // No es necesario, MongoDB crea la colección automáticamente al insertar documentos
    }

    @Override
    public boolean agregarEmpleado(Empleado empleado) {
        if (obtenerEmpleadoPorNIF(empleado.getNif()) != null) {
            System.out.println("Error: Ya existe un empleado con este NIF.");
            return false;
        }
        if (empleado.getSalario() < 0) {
            System.out.println("Error: El salario no puede ser negativo.");
            return false;
        }
        Document doc = new Document("NIF", empleado.getNif())
                .append("Nombre", empleado.getNombre())
                .append("Apellidos", empleado.getApellidos())
                .append("Salario", empleado.getSalario());
        collection.insertOne(doc);
        return true;
    }

    @Override
    public Empleado obtenerEmpleadoPorNIF(String nif) {
        Document doc = collection.find(eq("NIF", nif)).first();
        if (doc != null) {
            return new Empleado(doc.getString("NIF"), doc.getString("Nombre"),
                    doc.getString("Apellidos"), doc.getDouble("Salario"));
        }
        return null;
    }

    @Override
    public List<Empleado> obtenerTodosEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        for (Document doc : collection.find()) {
            empleados.add(new Empleado(doc.getString("NIF"), doc.getString("Nombre"),
                    doc.getString("Apellidos"), doc.getDouble("Salario")));
        }
        return empleados;
    }

    @Override
    public boolean actualizarSalario(String nif, double nuevoSalario) {
        if (nuevoSalario < 0) {
            System.out.println("Error: El salario no puede ser negativo.");
            return false;
        }
        Document empleado = collection.find(eq("NIF", nif)).first();
        if (empleado != null && empleado.getDouble("Salario") != nuevoSalario) {
            collection.updateOne(eq("NIF", nif), set("Salario", nuevoSalario));
            return true;
        }
        System.out.println("El salario no ha cambiado.");
        return false;
    }

    @Override
    public boolean eliminarEmpleado(String nif) {
        if (collection.deleteOne(eq("NIF", nif)).getDeletedCount() > 0) {
            return true;
        }
        System.out.println("Empleado no encontrado.");
        return false;
    }
}
