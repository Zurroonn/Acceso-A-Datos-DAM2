import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Main {

	public static void main(String[] args) {
        // Obtener el SessionFactory
        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
        
        // Abrir una sesión
        try (Session session = sessionFactory.openSession()) {
            // Iniciar la transacción (aunque no la necesitamos para solo hacer un SELECT)
            Transaction tx = session.beginTransaction();
 
            // Hacer una consulta para obtener todos los países
            Query<Localidades> query = session.createQuery("FROM Localidades", Localidades.class);  // Recupera todas las localidades
            List<Localidades> localidadesList = query.getResultList();
 
            // Imprimir la lista de localidades
            System.out.println("Lista de localidades:");
            if (localidadesList.isEmpty()) {
                System.out.println("No se encontraron localidades.");
            } else {
                for (Localidades localidades : localidadesList) {
                    System.out.println("ID: " + localidades.getCodigo() + ", Name: " + localidades.getNombre());
                }
            }
 
            // Confirmar la transacción
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Asegurarse de que la sesión se cierre
            sessionFactory.close();
        }
    }
}