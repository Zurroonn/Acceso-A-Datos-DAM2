package Accesoabbdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class insertar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		System.out.println("Introduce usuario");
		String user = sc.nextLine();
		System.out.println("Introduce contraseña");
		String password = sc.nextLine();
		String continuar;
		do {

			System.out.print("Introduce el nombre del empleado: ");
			String nombre = sc.nextLine();

			System.out.print("Introduce el apellido del empleado: ");
			String apellido = sc.nextLine();

			System.out.print("Introduce el correo electrónico del empleado: ");
			String correo = sc.nextLine();

			System.out.print("Introduce el número de teléfono del empleado: ");
			String tlf = sc.nextLine();

			System.out.print("Introduce la fecha de contratación (formato YYYY-MM-DD): ");
			String fechac = sc.nextLine();
			Date fecha = Date.valueOf(fechac);

			System.out.print("Introduce el ID del manager (o deja vacío si no tiene manager): ");
			String idmanagerInput = sc.nextLine();
			Integer managerId = idmanagerInput.isEmpty() ? null : Integer.parseInt(idmanagerInput);

			System.out.print("Introduce el título del trabajo del empleado: ");
			String tituloTrabajo = sc.nextLine();

			String sql = "INSERT INTO EMPLOYEES (FIRST_NAME, LAST_NAME, EMAIL, PHONE, HIRE_DATE, MANAGER_ID, JOB_TITLE)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

			try (Connection conexion = DriverManager.getConnection(url, user, password);
					PreparedStatement ps = conexion.prepareStatement(sql)) {

				ps.setString(1, nombre);
				ps.setString(2, apellido);
				ps.setString(3, correo);
				ps.setString(4, tlf);
				ps.setDate(5, fecha);

				if (managerId != null) {
					ps.setInt(6, managerId);
				} else {
					ps.setNull(6, java.sql.Types.INTEGER);
				}

				ps.setString(7, tituloTrabajo);

				int filasInsertadas = ps.executeUpdate();
				System.out.println("Empleado insertado correctamente. Filas afectadas: " + filasInsertadas);

			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.print("\n Continuar");
			continuar = sc.nextLine().trim().toLowerCase();

		} while (continuar.equals("si"));
		sc.close();

	}

}