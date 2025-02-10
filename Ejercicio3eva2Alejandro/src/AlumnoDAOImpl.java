import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class AlumnoDAOImpl implements AlumnoDAO{
    private MongoDatabase database;
    private MongoCollection<Document> coleccion;

    public AlumnoDAOImpl() {
        this.database = MongoDBConnection.getInstancia().getDatabase();
        this.coleccion = database.getCollection("accesodatos");
        
        boolean coleccionexiste=database.listCollectionNames().into(new ArrayList<>()).contains("empleados");
        if (!coleccionexiste) {
			database.createCollection("accesodatos");
			System.out.println("La coleccion empleados fue creada");
		}
    }

	@Override
	public boolean insertarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		Alumno existente = buscarAlumnoExpediente(alumno.getExpediente());
        if (existente != null) {
            System.out.println("ERROR: Ya existe un alumno con el nombre " + alumno.getNombre());
            return false;
        }


        Document doc = new Document("expediente", alumno.getExpediente())
                .append("nombre", alumno.getNombre())
                .append("apellido", alumno.getApellido())
                .append("notaAD", alumno.getNotaAD());

        coleccion.insertOne(doc);
        System.out.println("Alumno insertado correctamente en la colección.");
        return true;
    }


	@Override
	public Alumno buscarAlumnoExpediente(int expediente) {
		// TODO Auto-generated method stub
		Document doc = coleccion.find(eq("expediente", expediente)).first();
        if (doc != null) {
            return documentToGrupo(doc);
        }
        return null;
    }
	private Alumno documentToGrupo(Document doc) {
		Alumno alum = new Alumno();
        alum.setExpediente(doc.getInteger("expediente"));
        alum.setNombre(doc.getString("nombre"));
        alum.setApellido(doc.getString("apellido"));
        alum.setNotaAD(doc.getInteger("notaAD"));

        return alum;
    }
	@Override
	public List<Alumno> listarTodosAlumnos() {
		List<Alumno> lista = new ArrayList<>();
		 for (Document doc : coleccion.find()) {
	            Alumno alum = documentToGrupo(doc);
	            alum.getNombre();
	            lista.add(alum);
	        }
		return lista;
	}

	@Override
	public boolean actualizarNota(int expediente, int nota) {
		// TODO Auto-generated method stub

		 Alumno alumn =  buscarAlumnoExpediente(expediente);
	        if (alumn == null) {
	            System.out.println("No existe un alumno con el expediente " + alumn);
	            return false;
	        }
	        
	        int notaActual = alumn.getNotaAD();
	        if (notaActual == nota) {
	            System.out.println("La nota es igual al actual. No se ha modificado.");
	            return false;
	        }
	        if (nota<0) {
				System.out.println("La nota no puede ser negativa");
				return false;
			}
	        Bson filtro = eq("expediente", expediente);
	        Bson operacion = set("notaAD", nota);
	        UpdateResult resultado = coleccion.updateOne(filtro, operacion);
	        
	        if (resultado.getMatchedCount() == 0) {
	            System.out.println("No se encontró ningún documento para actualizar.");
	            return false;
	        } else {
	            if (resultado.getModifiedCount() == 0) {
	                System.out.println("La nota no cambió (posiblemente era el mismo).");
	                return false;
	            } else {
	                System.out.println("La nota ha sido modificado correctamente.");
	                return true;
	            }
	        }
	        
	    }

	@Override
	public boolean eliminarAlumno(int expediente) {
		Bson filtro = eq("expediente", expediente);
		DeleteResult resultado = coleccion.deleteOne(filtro);
		if (resultado.getDeletedCount() > 0) {
            System.out.println("Nombre con expediente " + expediente + " eliminado correctamente.");
            return true;
        } else {
            System.out.println("No se encontró ningun expediente " + expediente + " para eliminar.");
            return false;
        }
    }

}
