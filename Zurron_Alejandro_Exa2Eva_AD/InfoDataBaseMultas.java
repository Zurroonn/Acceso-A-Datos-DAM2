import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoDataBaseMultas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "MULTAS";
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
                 // Claves primarias de cada tabla 
                    System.out.println("### Claves Primarias de la Tabla:"+tableName+"###\n");
                    try (ResultSet primaryKeys = metaData.getPrimaryKeys(null, user.toUpperCase(), tableName)) {
                        while (primaryKeys.next()) {
                            String columnName = primaryKeys.getString("COLUMN_NAME");
                            String pkName = primaryKeys.getString("PK_NAME");
                            System.out.println("Columna: " + columnName + " (Clave Primaria: " + pkName + ")");
                        }
                        
                    }
                  //Claves foraneas de cada tabla  
                    try (ResultSet foreignKeys = metaData.getImportedKeys(null, user.toUpperCase(), tableName)) {
                        while (foreignKeys.next()) {
                            String fkColumn = foreignKeys.getString("FKCOLUMN_NAME");
                            String pkTable = foreignKeys.getString("PKTABLE_NAME");
                            String pkColumn = foreignKeys.getString("PKCOLUMN_NAME");
                            System.out.println("Columna FK: " + fkColumn + " -> Tabla PK: " + pkTable + " (Columna PK: " + pkColumn + ")");
                        }
                    }
                    
                    
                    
                    
                }
            }
            System.out.println("---------------------------------------\n");

            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
