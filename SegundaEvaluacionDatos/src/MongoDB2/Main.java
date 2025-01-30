package MongoDB2;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DAO empleadoDAO = new DAOimpl(); // ✅ Corrección aquí

        while (true) {
            System.out.println("\nGestión de Empleados - MongoDB");
            System.out.println("1. Añadir empleado");
            System.out.println("2. Mostrar empleado por NIF");
            System.out.println("3. Mostrar todos los empleados");
            System.out.println("4. Modificar salario de empleado");
            System.out.println("5. Eliminar empleado por NIF");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("NIF: ");
                    String nif = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellidos: ");
                    String apellidos = scanner.nextLine();
                    System.out.print("Salario: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar buffer
                    empleadoDAO.agregarEmpleado(new Empleado(nif, nombre, apellidos, salario));
                    break;
                case 2:
                    System.out.print("Ingrese NIF: ");
                    Empleado empleado = empleadoDAO.obtenerEmpleadoPorNIF(scanner.nextLine());
                    System.out.println(empleado != null ? empleado : "Empleado no encontrado.");
                    break;
                case 3:
                    List<Empleado> empleados = empleadoDAO.obtenerTodosEmpleados();
                    empleados.forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Ingrese NIF: ");
                    String nifActualizar = scanner.nextLine();
                    System.out.print("Nuevo salario: ");
                    double nuevoSalario = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar buffer
                    empleadoDAO.actualizarSalario(nifActualizar, nuevoSalario);
                    break;
                case 5:
                    System.out.print("Ingrese NIF: ");
                    empleadoDAO.eliminarEmpleado(scanner.nextLine());
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
