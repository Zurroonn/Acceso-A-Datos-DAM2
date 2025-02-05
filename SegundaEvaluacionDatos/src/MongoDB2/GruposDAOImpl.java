package MongoDB2;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class GruposDAOImpl implements GruposDAO {
    private MongoDatabase database;
    private MongoCollection<Document> coleccion;

    public GruposDAOImpl() {
        this.database = MongoDBSingletonBiblioteca.getInstancia().getDatabase();
        this.coleccion = database.getCollection("empleados");
        
        boolean coleccionexiste=database.listCollectionNames().into(new ArrayList<>()).contains("empleados");
        if (!coleccionexiste) {
			database.createCollection("empleados");
			System.out.println("La coleccion empleados fue creada");
		}
    }

    @Override
    public void agregarEmpleado(Empleado empleado) {
        if (obtenerEmpleadoPorNIF(empleado.getNIF()) != null) {
            System.out.println("El empleado con NIF " + empleado.getNIF() + " ya existe.");
            return;
        }

        if (empleado.getSalario() < 0) {
            System.out.println("El salario no puede ser negativo.");
            return;
        }

        Document documento = new Document("NIF", empleado.getNIF())
                .append("nombre", empleado.getNombre())
                .append("apellidos", empleado.getApellidos())
                .append("salario", empleado.getSalario());

        coleccion.insertOne(documento);
        System.out.println("Empleado añadido con éxito.");
    }

    @Override
    public Empleado obtenerEmpleadoPorNIF(String NIF) {
        Document documento = coleccion.find(Filters.eq("NIF", NIF)).first();
        if (documento != null) {
            return new Empleado(
                    documento.getString("NIF"),
                    documento.getString("nombre"),
                    documento.getString("apellidos"),
                    documento.getDouble("salario")
            );
        }
        return null;
    }

    @Override
    public List<Empleado> obtenerTodosLosEmpleados() {
        List<Empleado> lista = new ArrayList<>();
        for (Document doc : coleccion.find()) {
            lista.add(new Empleado(
                    doc.getString("NIF"),
                    doc.getString("nombre"),
                    doc.getString("apellidos"),
                    doc.getDouble("salario")
            ));
        }
        return lista;
    }

    @Override
    public boolean modificarSalario(String NIF, double nuevoSalario) {
        if (nuevoSalario < 0) {
            System.out.println("El salario no puede ser negativo.");
            return false;
        }

        Document resultado = coleccion.findOneAndUpdate(
                Filters.eq("NIF", NIF),
                Updates.set("salario", nuevoSalario)
        );

        return resultado != null;
    }

    @Override
    public boolean eliminarEmpleado(String NIF) {
        Document resultado = coleccion.findOneAndDelete(Filters.eq("NIF", NIF));
        return resultado != null;
    }
}

