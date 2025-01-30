package Pruebas;




import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "OT";
        String password = "oracle123";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            DatabaseMetaData metaData = connection.getMetaData();

            // Información del producto de la base de datos
            System.out.println("### Información del Producto de la Base de Datos ###\n");
            System.out.println("Nombre del Producto: " + metaData.getDatabaseProductName());
            System.out.println("Versión del Producto: " + metaData.getDatabaseProductVersion());
            System.out.println("Nombre del Driver: " + metaData.getDriverName());
            System.out.println("Versión del Driver: " + metaData.getDriverVersion());
            System.out.println("URL de Conexión: " + metaData.getURL());
            System.out.println("Usuario Actual: " + metaData.getUserName());
            System.out.println("---------------------------------------\n");

            // Listado de tablas con columnas
            System.out.println("### Listado de Tablas del Usuario OT ###\n");
            try (ResultSet tables = metaData.getTables(null, user.toUpperCase(), "%", new String[]{"TABLE"})) {
                while (tables.next()) {
                    String tableName = tables.getString("TABLE_NAME");
                    String tableType = tables.getString("TABLE_TYPE");
                    System.out.println("Tabla: " + tableName + " (Tipo: " + tableType + ")\n");

                    // Obtener columnas de cada tabla
                    System.out.println("  Columnas:\n");
                    try (ResultSet columns = metaData.getColumns(null, user.toUpperCase(), tableName, "%")) {
                        while (columns.next()) {
                            String columnName = columns.getString("COLUMN_NAME");
                            String columnType = columns.getString("TYPE_NAME");
                            int columnSize = columns.getInt("COLUMN_SIZE");
                            System.out.println("    - " + columnName + " (Tipo: " + columnType + ", Tamaño: " + columnSize + ")");
                        }
                    }
                    System.out.println();
                }
            }
            System.out.println("---------------------------------------\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
