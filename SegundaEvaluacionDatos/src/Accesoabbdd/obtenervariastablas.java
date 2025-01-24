package Accesoabbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class obtenervariastablas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "OT";
		System.out.println("Introduce la contraseña del usuario '" + user + "':");
		String password = sc.nextLine(); // Con Scanner.
		
		
		try(Connection conexion = DriverManager.getConnection(url, user, password);
			
			Statement consulta = conexion.createStatement()) {
			String sentenciasql = "SELECT DISTINCT "
					+ "p.product_name, "
					+ "pc.category_name, "
					+ "oi.unit_price "
					+ "FROM "
					+ "order_items oi "
					+ "INNER JOIN products p ON oi.product_id = p.product_id "
					+ "INNER JOIN product_categories pc ON p.category_id=pc.category_id";
			ResultSet resultadoConsulta = consulta.executeQuery(sentenciasql);
			
            while (resultadoConsulta.next()) {
                String nombre = resultadoConsulta.getString("product_name");
                String apellido = resultadoConsulta.getString("category_name");
                double unit=resultadoConsulta.getDouble("unit_price");
                System.out.println("Nombre:" + nombre + ". Categoria:" + apellido+ ". Precio"+unit);
            }
			
		resultadoConsulta.close();
		conexion.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}