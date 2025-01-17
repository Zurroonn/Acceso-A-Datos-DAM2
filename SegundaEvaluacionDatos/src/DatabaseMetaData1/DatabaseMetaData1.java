package DatabaseMetaData1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMetaData1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "OT";
        String password = "oracle123";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            DatabaseMetaData metaData = connection.getMetaData();

            // Información de la base de datos
            System.out.println("### Información de la Base de Datos ###\n");
            System.out.println("Producto: " + metaData.getDatabaseProductName());
            System.out.println("Versión del Producto: " + metaData.getDatabaseProductVersion());
            System.out.println("Driver JDBC: " + metaData.getDriverName());
            System.out.println("Versión del Driver: " + metaData.getDriverVersion());
            System.out.println("URL de Conexión: " + metaData.getURL());
            System.out.println("Usuario Actual: " + metaData.getUserName());
            System.out.println("---------------------------------------\n");

            // Listado de tablas
            System.out.println("### Listado de Tablas ###\n");
            try (ResultSet tables = metaData.getTables(null, user.toUpperCase(), "%", new String[]{"TABLE"})) {
                while (tables.next()) {
                    String tableName = tables.getString("TABLE_NAME");
                    String tableType = tables.getString("TABLE_TYPE");
                    System.out.println("Tabla: " + tableName + " (Tipo: " + tableType + ")");
                }
            }
            System.out.println("---------------------------------------\n");

            // Información de columnas para la tabla CUSTOMERS
            System.out.println("### Columnas de la Tabla: CUSTOMERS ###\n");
            try (ResultSet columns = metaData.getColumns(null, user.toUpperCase(), "CUSTOMERS", "%")) {
                while (columns.next()) {
                    String columnName = columns.getString("COLUMN_NAME");
                    String columnType = columns.getString("TYPE_NAME");
                    int columnSize = columns.getInt("COLUMN_SIZE");
                    System.out.println("Columna: " + columnName + " (Tipo: " + columnType + ", Tamaño: " + columnSize + ")");
                }
            }
            System.out.println("---------------------------------------\n");

            // Claves primarias de la tabla CUSTOMERS
            System.out.println("### Claves Primarias de la Tabla: CUSTOMERS ###\n");
            try (ResultSet primaryKeys = metaData.getPrimaryKeys(null, user.toUpperCase(), "CUSTOMERS")) {
                while (primaryKeys.next()) {
                    String columnName = primaryKeys.getString("COLUMN_NAME");
                    String pkName = primaryKeys.getString("PK_NAME");
                    System.out.println("Columna: " + columnName + " (Clave Primaria: " + pkName + ")");
                }
            }
            System.out.println("---------------------------------------\n");

            // Claves foráneas de la tabla ORDERS
            System.out.println("### Claves Foráneas de la Tabla: ORDERS ###\n");
            try (ResultSet foreignKeys = metaData.getImportedKeys(null, user.toUpperCase(), "ORDERS")) {
                while (foreignKeys.next()) {
                    String fkColumn = foreignKeys.getString("FKCOLUMN_NAME");
                    String pkTable = foreignKeys.getString("PKTABLE_NAME");
                    String pkColumn = foreignKeys.getString("PKCOLUMN_NAME");
                    System.out.println("Columna FK: " + fkColumn + " -> Tabla PK: " + pkTable + " (Columna PK: " + pkColumn + ")");
                }
            }
            System.out.println("---------------------------------------\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
