import java.util.List;


public interface GruposDAO {
    void agregarGrupo(Grupos grupos);
    List<Grupos> obtenerTodosLosGrupos();
    boolean modificarGrupo(String nombre, String genero);
    boolean eliminarGrupo(String grupo);
}
