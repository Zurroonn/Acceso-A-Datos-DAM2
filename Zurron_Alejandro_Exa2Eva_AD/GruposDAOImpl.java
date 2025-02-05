import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;




public class GruposDAOImpl implements GruposDAO{
    private MongoDatabase database;
    private MongoCollection<Document> coleccion;

    public GruposDAOImpl() {
        this.database = MongoDBSingletonBiblioteca.getInstancia().getDatabase();
        this.coleccion = database.getCollection("grupos");
        
        boolean coleccionexiste=database.listCollectionNames().into(new ArrayList<>()).contains("grupos");
        if (!coleccionexiste) {
			database.createCollection("grupos");
			System.out.println("La coleccion grupos fue creada");
		}
    }
	@Override
	public void agregarGrupo(Grupos grupos) {
		// TODO Auto-generated method stub
        Document documento = new Document("grupo", grupos.getGrupo())
                .append("grupo", grupos.getGrupo())
                .append("genero", grupos.getGenero())
                .append("década", grupos.getDecada())
                .append("discos", grupos.getDiscos())
        		.append("giras", grupos.getGiras());

        coleccion.insertOne(documento);
        System.out.println("Grupo añadido con éxito.");
    }
	

	@Override
	public List<Grupos> obtenerTodosLosGrupos() {
		// TODO Auto-generated method stub
		List<Grupos> lista = new ArrayList<>();
        for (Document doc : coleccion.find()) {
            lista.add(new Grupos(
                    doc.getString("grupo"),
                    doc.getString("genero"),
                    doc.getString("década"),
                    doc.getList("discos"),
                    doc.getList("giras") 
                    
            ));
        }
        return lista;
    }

	@Override
	public boolean modificarGrupo(String nombre, String genero) {
		// TODO Auto-generated method stub
        Document resultado = coleccion.findOneAndUpdate(
                Filters.eq("grupo", nombre),
                Updates.set("genero", genero)
        );

        return resultado != null;
    }
	@Override
	public boolean eliminarGrupo(String grupo) {
		// TODO Auto-generated method stub
		Document resultado = coleccion.findOneAndDelete(Filters.eq("grupo", grupo));
		return false;
	}

}
