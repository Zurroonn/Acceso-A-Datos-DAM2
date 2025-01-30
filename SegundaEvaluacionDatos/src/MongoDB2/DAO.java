package MongoDB2;

import java.util.List;

public interface DAO {
    void crearColeccionSiNoExiste();
    boolean agregarEmpleado(Empleado empleado);
    Empleado obtenerEmpleadoPorNIF(String nif);
    List<Empleado> obtenerTodosEmpleados();
    boolean actualizarSalario(String nif, double nuevoSalario);
    boolean eliminarEmpleado(String nif);
}
