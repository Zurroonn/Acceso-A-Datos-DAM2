
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;



public class Actor {

	public static void main(String[] args) {
		try (Connection connection = DatabaseConnection.getConnection()) {
            ActorDAO actorDAO = new ActorDAOImpl(connection);
            Scanner scanner = new Scanner(System.in);
            int opcion;
		
		
		do {
			
			System.out.println("\n--- Menú Principal ---");
			System.out.println("1) Consultar actor");
            System.out.println("2) Añadir actor");
            System.out.println("3) Modificar actor");
            System.out.println("4) Borrar actor");
            System.out.println("5) Listar actor");
            System.out.println("0) Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
			
            
            switch (opcion) {
            
            case 1: // Consultar Actor
                System.out.print("Ingrese el ID del actor: ");
                int codactor = scanner.nextInt();
                ActorConstructor actor = actorDAO.getActorByCodigo(codactor);
                if (actor != null) {
                    System.out.println("Actor encontrada: " + actor.getNombre());
                } else {
                    System.out.println("Actor no encontrada.");
                }
                break;
            
            case 2://Crear actor
            	
            	System.out.println("Ingrese el código del actor: ");
            	int nuevocodigoactor = scanner.nextInt();
            	scanner.nextLine();

            	System.out.println("Ingrese el nombre del actor: ");
            	String nuevonombre = scanner.nextLine();
            	
            	System.out.println("Ingrese el apellido del actor  "); 
            	String nuevoapellido = scanner.nextLine();
            	scanner.nextLine();
            	
            	System.out.println("Ingrese la fecha de la actualizacion (YYYY-MM-DD): ");
            	String nuevafecha = scanner.nextLine();
                Date nuevaFechaactualizacion = Date.valueOf(nuevafecha);  
                
                ActorConstructor nuevoactor = new ActorConstructor( nuevocodigoactor,nuevonombre,nuevoapellido, nuevaFechaactualizacion);
            	actorDAO.addActor(nuevoactor);
            	
            	System.out.println("Actor añadido.");
            	break;
            	
            case 3: // Modificar actor
                System.out.print("Ingrese ID del actor a modificar: ");
                int modificarActorID = scanner.nextInt();
                scanner.nextLine();
                ActorConstructor actorAModificar = actorDAO.getActorByCodigo(modificarActorID);
                if (actorAModificar != null) {
                    System.out.print("Ingrese nuevo nombre (actual: " + actorAModificar.getNombre() + "): ");
                    actorAModificar.setNombre(scanner.nextLine());
                    scanner.nextLine();
                    
                    System.out.println("Actor actualizado.");
                } else {
                    System.out.println("Actor no encontrado.");
                }
                break;
                
            case 4: // Borrar actor
                System.out.print("Ingrese ID de la actor a borrar: ");
                int borraractorID = scanner.nextInt();
                actorDAO.deleteActor(borraractorID);
                System.out.println("Actor eliminado.");
                break;

            case 5: // Listar actores
                List<ActorConstructor> listaMultas = actorDAO.getAllActores();
                System.out.println("\nLista de Actores:");
                listaMultas.forEach(a -> System.out.println(a.getActor_id() + " - " + a.getNombre()));
                break;
            	
                
            case 0:
                System.out.println("Saliendo...");
                break;

            default:
                System.out.println("Opción no válida.");
                scanner.close();
                break;
            }
            
            
		} while (opcion != 0);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
