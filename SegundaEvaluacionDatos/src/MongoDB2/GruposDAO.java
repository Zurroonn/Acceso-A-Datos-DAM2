package MongoDB2;

import java.util.List;

public interface GruposDAO {
    void agregarEmpleado(Empleado empleado);
    Empleado obtenerEmpleadoPorNIF(String NIF);
    List<Empleado> obtenerTodosLosEmpleados();
    boolean modificarSalario(String NIF, double nuevoSalario);
    boolean eliminarEmpleado(String NIF);
}
