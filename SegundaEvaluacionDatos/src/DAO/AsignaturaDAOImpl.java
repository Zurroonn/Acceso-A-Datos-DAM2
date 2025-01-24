package DAO;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	public class AsignaturaDAOImpl implements AsignaturaDAO {
	    private Connection connection;

	    public AsignaturaDAOImpl(Connection connection) {
	        this.connection = connection;
	    }

	    @Override
	    public void addAsignatura(Asignatura Asignatura) {
	        String sql = "INSERT INTO ASIGNATURA (ID, NOMBRE, CREDITOS, TIPO, CURSO, CUATRIMESTRE, ID_GRADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, Asignatura.getId());
	            stmt.setString(2, Asignatura.getNombre());
	            stmt.setDouble(3, Asignatura.getCreditos());
	            stmt.setString(4, Asignatura.getTipo());
	            stmt.setInt(5, Asignatura.getCurso());
	            stmt.setInt(6, Asignatura.getCuatrimestre());
	            stmt.setInt(8, Asignatura.getId_grado());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public Asignatura getAsignaturaById(int id) {
	        String sql = "SELECT * FROM ASIGNATURA WHERE ID = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, id);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return new Asignatura(rs.getInt("ID"),
	                		rs.getString("NOMBRE"),
	                		rs.getDouble("CREDITOS"),
	                		rs.getString("TIPO"),
	                		rs.getInt("CURSO"),
	                		rs.getInt("CUATRIMESTRE"),
	                		rs.getInt("ID_GRADO"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    @Override
	    public List<Asignatura> getAllAsignaturas() {
	        List<Asignatura> employees = new ArrayList<>();
	        String sql = "SELECT * FROM ASIGNATURAS";
	        try (Statement stmt = connection.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            while (rs.next()) {
	                employees.add(new Asignatura(rs.getInt("ID"),
	                		rs.getString("NOMBRE"),
	                		rs.getDouble("CREDITOS"),
	                		rs.getString("TIPO"),
	                		rs.getInt("CURSO"),
	                		rs.getInt("CUATRIMESTRE"),
	                		rs.getInt("ID_GRADO")));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return employees;
	    }

	    @Override
	    public void updateAsignatura(Asignatura Asignatura) {
	        String sql = "UPDATE ASIGNATURAS SET NOMBRE = ?, CREDITOS = ?, TIPO = ?, CURSO= ?, CUATRIMESTRE= ?, ID_GRADO= ? WHERE ID= ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setString(1, Asignatura.getNombre());
	            stmt.setDouble(2, Asignatura.getCreditos());
	            stmt.setString(3, Asignatura.getTipo());
	            stmt.setInt(4, Asignatura.getCurso());
	            stmt.setInt(5, Asignatura.getCuatrimestre());
	            stmt.setInt(6, Asignatura.getId_grado());
	            stmt.setInt(7, Asignatura.getId());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteAsignatura(int id) {
	        String sql = "DELETE FROM ASIGNATURA WHERE ID = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, id);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }



	}



