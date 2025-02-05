package DAO;


import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class  Main{
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            AsignaturaDAO asignaturaDAO = new AsignaturaDAOImpl(connection);
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\n--- Menú de Gestión ---");
                System.out.println("1) Consultar Asignatura");
                System.out.println("2) Añadir Asignatura");
                System.out.println("3) Modificar Asignatura");
                System.out.println("4) Borrar Asignatura");
                System.out.println("5) Listar Asignaturas");
                System.out.println("0) Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1: // Consultar Asignatura
                        System.out.print("Ingrese el ID de la asignatura: ");
                        int asignaturaId = scanner.nextInt();
                        Asignatura asignatura = asignaturaDAO.getAsignaturaById(asignaturaId);
                        if (asignatura != null) {
                            System.out.println("Asignatura encontrada: " + asignatura.getNombre());
                        } else {
                            System.out.println("Asignatura no encontrada.");
                        }
                        break;

                    case 2: // Añadir Asignatura
                        System.out.print("Ingrese ID: ");
                        int nuevaAsignaturaId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Ingrese nombre: ");
                        String asignaturaNombre = scanner.nextLine();
                        System.out.print("Ingrese créditos: ");
                        double asignaturaCreditos = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Ingrese tipo: ");
                        String asignaturaTipo = scanner.nextLine();
                        System.out.print("Ingrese curso: ");
                        int asignaturaCurso = scanner.nextInt();
                        System.out.print("Ingrese cuatrimestre: ");
                        int asignaturaCuatrimestre = scanner.nextInt();
                        System.out.print("Ingrese ID del profesor (0 si no tiene): ");
                        int profesorId = scanner.nextInt();
                        System.out.print("Ingrese ID del grado: ");
                        int gradoId = scanner.nextInt();

                        Asignatura nuevaAsignatura = new Asignatura(nuevaAsignaturaId, asignaturaNombre, asignaturaCreditos, asignaturaTipo, asignaturaCurso, asignaturaCuatrimestre,gradoId);
                        asignaturaDAO.addAsignatura(nuevaAsignatura);
                        System.out.println("Asignatura añadida.");
                        break;

                    case 3: // Modificar Asignatura
                        System.out.print("Ingrese ID de la asignatura a modificar: ");
                        int modificarAsignaturaId = scanner.nextInt();
                        scanner.nextLine();
                        Asignatura asignaturaParaModificar = asignaturaDAO.getAsignaturaById(modificarAsignaturaId);
                        if (asignaturaParaModificar != null) {
                            System.out.print("Ingrese nuevo nombre (actual: " + asignaturaParaModificar.getNombre() + "): ");
                            asignaturaParaModificar.setNombre(scanner.nextLine());
                            System.out.print("Ingrese nuevos créditos (actual: " + asignaturaParaModificar.getCreditos() + "): ");
                            asignaturaParaModificar.setCreditos(scanner.nextDouble());
                            scanner.nextLine();
                            System.out.print("Ingrese nuevo tipo (actual: " + asignaturaParaModificar.getTipo() + "): ");
                            asignaturaParaModificar.setTipo(scanner.nextLine());
                            asignaturaDAO.updateAsignatura(asignaturaParaModificar);
                            System.out.println("Asignatura actualizada.");
                        } else {
                            System.out.println("Asignatura no encontrada.");
                        }
                        break;

                    case 4: // Borrar Asignatura
                        System.out.print("Ingrese ID de la asignatura a borrar: ");
                        int borrarAsignaturaId = scanner.nextInt();
                        asignaturaDAO.deleteAsignatura(borrarAsignaturaId);
                        System.out.println("Asignatura eliminada.");
                        break;

                    case 5: // Listar Asignaturas
                        List<Asignatura> listaAsignaturas = asignaturaDAO.getAllAsignaturas();
                        System.out.println("\nLista de asignaturas:");
                        listaAsignaturas.forEach(a -> System.out.println(a.getId() + " - " + a.getNombre()));
                        break;                    

                    case 6:
                    	
                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                        scanner.close();
                        break;
                }
            } while (opcion != 0);
        } catch (Exception e) {
            e.printStackTrace();     
        }
    }
}