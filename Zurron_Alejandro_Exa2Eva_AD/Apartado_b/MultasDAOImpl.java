package Apartado_b;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MultasDAOImpl implements MultasDAO{
	 private Connection connection;

	    public MultasDAOImpl(Connection connection) {
	        this.connection = connection;
	    }
	@Override
	public Multas getMultas(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM MULTA WHERE CODMULTA = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Multas(rs.getInt("CodMulta"),
                		rs.getString("Descripcion"),
                		rs.getInt("CodPersonaMultada"),
                		rs.getInt("CodAgente"),
                		rs.getDouble("ImporteSancion"),
                		rs.getInt("PuntosSancion"),
                		rs.getDate("FechaMulta"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
		
	}

	@Override
	public void addMultas(Multas multas) {
		String sql = "INSERT INTO MULTA (CODMULTA, DESCRIPCION, CODPERSONALIZADO, CODAGENTE, IMPORTESANCION, PUNTOSSANCION, FECHAMULTA) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, multas.getCodigoMulta());
            stmt.setString(2, multas.getDescripcion());
            stmt.setDouble(3, multas.getCodigoPersona());
            stmt.setInt(4, multas.getCodigoAgente());
            stmt.setDouble(5, multas.getImporte());
            stmt.setInt(6, multas.getPuntos());
            stmt.setDate(8, multas.getFechamulta());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void updateMultas(Multas multas) {
		// TODO Auto-generated method stub
		String sql = "UPDATE MULTA SET CODMULTA = ?, DESCRIPCION = ?, CODPERSONAMULTADA = ?, CODAGENTE= ?, IMPORTESANCION= ?, PUNTOSSANCION= ? FECHAMULTA=?, WHERE CODMULTA=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, multas.getCodigoMulta());
            stmt.setString(2, multas.getDescripcion());
            stmt.setDouble(3, multas.getCodigoPersona());
            stmt.setInt(4, multas.getCodigoAgente());
            stmt.setDouble(5, multas.getImporte());
            stmt.setInt(6, multas.getPuntos());
            stmt.setDate(8, multas.getFechamulta());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	

	@Override
	public void deleteMultas(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM MULTA WHERE CODMULTA = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	

	@Override
	public List<Multas> getAllMultas() {
		// TODO Auto-generated method stub
		List<Multas> multass = new ArrayList<>();
        String sql = "SELECT * FROM MULTA";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	multass.add(new Multas(rs.getInt("CodMulta"),
                		rs.getString("Descripcion"),
                		rs.getInt("CodPersonaMultada"),
                		rs.getInt("CodAgente"),
                		rs.getDouble("ImporteSancion"),
                		rs.getInt("PuntosSancion"),
                		rs.getDate("FechaMulta")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return multass;

}
}
