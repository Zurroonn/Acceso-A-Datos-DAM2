

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;




public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        AlumnoDAO alumnoDao = new AlumnoDAOImpl();

        int opcion;
        do {
        	
        	System.out.println("\nMenú");
            System.out.println("1. Añadir Alumno");
            System.out.println("2. Mostrar alumno");
            System.out.println("3. Listar Alumno");
            System.out.println("4. Modificar Nota Alumno");
            System.out.println("5. Borrar Alumno por expediente");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
            
            case 1:
                System.out.println("\n=== AÑADIR ALUMNO ===");
                Alumno nuevo = new Alumno();

                System.out.print("Num expediente: ");
                nuevo.setExpediente(sc.nextInt());
                System.out.print("Nombre: ");
                nuevo.setNombre(sc.nextLine());   
                nuevo.setNombre(sc.nextLine());              
                System.out.print("Apellido: ");			//COMO EL SCANNER SE PETA TENGO QUE PONERLO DOS VECES PARA QUE ME GUARDE LOS DATOS 
                nuevo.setApellido(sc.nextLine()); 
                System.out.print("Nota AD: ");
                nuevo.setNotaAD(sc.nextInt());

                boolean creado = alumnoDao.insertarAlumno(nuevo);
                if (creado) {
                    System.out.println("Alumno añadido correctamente.");
                } else {
                    System.out.println("No se pudo añadir el alumno.");
                }
                break;
            case 2:
                System.out.print("Ingrese expediente: ");
                int expediente = sc.nextInt();
                Alumno alum = alumnoDao.buscarAlumnoExpediente(expediente);
                System.out.println((alum != null) ? alum.getNombre() : "Alumno no encontrado.");
                break;
            case 3:
            	
            	System.out.println("\n=== MOSTRAR TODOS LOS ALUMNOS ===");
                List<Alumno> lista = alumnoDao.listarTodosAlumnos();
                System.out.println("\nLista de Actores:");
                lista.forEach(a -> System.out.println(a.getNombre()));

            
            break;
            case 4:
            	System.out.println("\n=== MODIFICAR NOTA DEL ALUMNO ===");
                System.out.print("Ingrese el expediente: ");
                int expedienteMod = sc.nextInt();
                System.out.print("Ingrese la nueva nota: ");
                int nuevaNota = sc.nextInt();
                boolean modificado = alumnoDao.actualizarNota(expedienteMod, nuevaNota);
                if (modificado) {
                    System.out.println("Nota actualizado correctamente.");
                } else {
                    System.out.println("No se pudo actualizar la nota.");
                }
                break;
            case 5:
            	System.out.println("\n=== ELIMINAR ALUMNO POR EXPEDIENTE ===");
                System.out.print("Ingrese el expediente: ");
                int expedienteEliminar = sc.nextInt();
                boolean eliminado = alumnoDao.eliminarAlumno(expedienteEliminar);
                if (eliminado) {
                    System.out.println("Alumno eliminado correctamente.");
                } else {
                    System.out.println("No se encontró un alumno con ese expediente para eliminar.");
                }
                break;

    

    case 6:
        System.out.println("Saliendo del programa...");
        break;

    default:
        System.out.println("Opción inválida. Intente de nuevo.");
        break;
        }
    } while (opcion != 5);


}
}

