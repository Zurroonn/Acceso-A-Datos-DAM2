package Accesoabbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class preparedStatement {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		System.out.println("Introduce usuario");
		String user = sc.nextLine();
		System.out.println("Introduce contraseña");
		String password = sc.nextLine();
		try (Connection conexion = DriverManager.getConnection(url, user, password)) {
			String sentenciasql = """
							            SELECT
							                c.name AS customer_name,
							                SUM(oi.quantity * oi.unit_price) AS total_sales
							            FROM
							                orders o
							            INNER JOIN customers c ON o.customer_id = c.customer_id
							            INNER JOIN order_items oi ON o.order_id = oi.order_id
							            GROUP BY
							                c.name
							            HAVING
							                SUM(oi.quantity * oi.unit_price) > ?
							            ORDER BY
							                total_sales DESC
					""";

			PreparedStatement ps = conexion.prepareStatement(sentenciasql);
			ps.setDouble(1, 10000); 
			ResultSet resultadoConsulta = ps.executeQuery();
			System.out.println("Clientes:");
			while (resultadoConsulta.next()) {
				String customerNombre = resultadoConsulta.getString("customer_name");
				double totalVentas = resultadoConsulta.getDouble("total_sales");
				System.out.println("Nombre Cliente: " + customerNombre + ", Total Ventas: " + totalVentas);
			}

			resultadoConsulta.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

}