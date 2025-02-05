package MongoDB2;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GruposDAO empleadoDAO = new GruposDAOImpl();

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
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese NIF: ");
                    String nif = scanner.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese apellidos: ");
                    String apellidos = scanner.nextLine();
                    System.out.print("Ingrese salario: ");
                    double salario = scanner.nextDouble();
                    empleadoDAO.agregarEmpleado(new Empleado(nif, nombre, apellidos, salario));
                    break;

                case 2:
                    System.out.print("Ingrese NIF: ");
                    nif = scanner.nextLine();
                    Empleado empleado = empleadoDAO.obtenerEmpleadoPorNIF(nif);
                    System.out.println((empleado != null) ? empleado : "Empleado no encontrado.");
                    break;

                case 3:
                    List<Empleado> empleados = empleadoDAO.obtenerTodosLosEmpleados();
                    empleados.forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Ingrese NIF: ");
                    nif = scanner.nextLine();
                    System.out.print("Ingrese nuevo salario: ");
                    salario = scanner.nextDouble();

                    boolean modificado = empleadoDAO.modificarSalario(nif, salario);
                    System.out.println(modificado ? "Salario actualizado." : "No se encontró el empleado.");
                    break;

                case 5:
                    System.out.print("Ingrese NIF: ");
                    nif = scanner.nextLine();
                    boolean eliminado = empleadoDAO.eliminarEmpleado(nif);
                    System.out.println(eliminado ? "Empleado eliminado." : "No se encontró el empleado.");
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
