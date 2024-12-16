package CrearProcedimiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CrearProcedimiento {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "OT";
    private static final String PASSWORD = "oracle123";
 
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Llamada al procedimiento almacenado
            String procedureCall = "{CALL insert_order(?, ?, ?, ?)}";
 
            try (CallableStatement callableStatement = connection.prepareCall(procedureCall)) {
                // Asignar valores a los parámetros
                callableStatement.setInt(1, 51); // customer_id
                callableStatement.setString(2, "PENDING"); // status
                callableStatement.setInt(3, 108); // salesman_id
                callableStatement.setDate(4, new java.sql.Date(System.currentTimeMillis())); // order_date
 
                // Ejecutar el procedimiento
                callableStatement.execute();
                System.out.println("Procedimiento ejecutado con éxito: Pedido insertado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}