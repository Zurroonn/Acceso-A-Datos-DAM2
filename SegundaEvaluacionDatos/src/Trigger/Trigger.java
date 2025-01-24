package Trigger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Trigger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "OT";
        String password = "oracle123";

        int inventoryId = 254; 
        int cantidadNegativa = -10; 

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión exitosa a la base de datos.");
            String updateQuery = "UPDATE inventories SET quantity = ? WHERE product_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                preparedStatement.setInt(1, cantidadNegativa);
                preparedStatement.setInt(2, inventoryId);      
                preparedStatement.executeUpdate();
         
        } catch (SQLException e) {
            if (e.getErrorCode()==20001) {
                System.out.println("Error capturado: " + e.getMessage());
            } else {
                System.out.println("Otro error ocurrió: " + e.getMessage());
            }
        }
    }

}
