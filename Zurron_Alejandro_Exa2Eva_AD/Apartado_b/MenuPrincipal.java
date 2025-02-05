package Apartado_b;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;


import java.sql.Date;
public class MenuPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection connection = DatabaseConnection.getConnection()) {
            MultasDAO multasDAO = new MultasDAOImpl(connection);
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\n--- Menú de Gestión ---");
                System.out.println("1) Consultar Multa");
                System.out.println("2) Añadir Multa");
                System.out.println("3) Modificar Multa");
                System.out.println("4) Borrar Multa");
                System.out.println("5) Listar Multas");
                System.out.println("0) Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1: // Consultar Multa
                        System.out.print("Ingrese el cod de la multa: ");
                        int multacod = scanner.nextInt();
                        Multas multa = multasDAO.getMultas(multacod);
                        if (multa != null) {
                            System.out.println("Multa no encontrada: " + multa.getCodigoMulta());
                        } else {
                            System.out.println("Multa no encontrada.");
                        }
                        break;

                    case 2: // Añadir Asignatura
                    	System.out.print("Ingrese codmulta: ");
                        int codmulta = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Ingrese descripcion: ");
                        String descripcion = scanner.nextLine();
                        System.out.print("Ingrese codigopersona: ");
                        int codigopersona = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Ingrese codigoagente: ");
                        int codigoagente = scanner.nextInt();
                        System.out.print("Ingrese importe: ");
                        double importe = scanner.nextDouble();
                        System.out.print("Ingrese puntos: ");
                        int puntos = scanner.nextInt();
                        System.out.print("Ingrese ID del grado: ");
                        String fechamulta = scanner.nextLine();
                        Date fecha=Date.valueOf(fechamulta);
                        Multas nuevaAsignatura = new Multas(codmulta, descripcion, codigopersona, codigoagente, importe,puntos,fecha);
                        multasDAO.addMultas(nuevaAsignatura);
                        System.out.println("Asignatura añadida.");
                        
                        break;

                    case 3: // Modificar Multa
                        System.out.print("Ingrese el codmulta : ");
                        int modificarAsignaturaId = scanner.nextInt();
                        scanner.nextLine();
                        Multas multaupdate = multasDAO.getMultas(modificarAsignaturaId);
                        if (multaupdate != null) {
                            System.out.print("Ingrese nuevo importe (actual: " + multaupdate.getImporte() + "): ");
                            multaupdate.setImporte(scanner.nextDouble());
                            System.out.println("Multa actualizada.");
                        } else {
                            System.out.println("Multa no encontrada.");
                        }
                        break;

                    case 4: // Borrar Asignatura
                        System.out.print("Ingrese codmulta a eliminar: ");
                        int borrarmulta = scanner.nextInt();
                        multasDAO.deleteMultas(borrarmulta);
                        System.out.println("Asignatura eliminada.");
                        break;

                    case 5: // Listar Asignaturas
                        List<Multas> listaAsignaturas = multasDAO.getAllMultas();
                        System.out.println("\nLista de asignaturas:");
                        listaAsignaturas.forEach(a -> System.out.println(a.getCodigoAgente()));
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