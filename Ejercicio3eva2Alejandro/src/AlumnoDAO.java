import java.util.List;


public interface AlumnoDAO {

	boolean insertarAlumno(Alumno alumno);
	Alumno buscarAlumnoExpediente(int expediente);
    List<Alumno> listarTodosAlumnos();
    boolean actualizarNota(int expediente, int nota);
    boolean eliminarAlumno(int expediente);
	
}
