
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ActorDAOImpl implements ActorDAO{
	
	private Connection connection;
	
	public ActorDAOImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public ActorConstructor getActorByCodigo(int actor_id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ACTOR WHERE ACTOR_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, actor_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new ActorConstructor(rs.getInt("ACTOR_ID"),
                		rs.getString("FIRST_NAME"),
                		rs.getString("LAST_NAME"),
                		rs.getDate("LAST_UPDATE"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
		
	}

	@Override
	public void addActor(ActorConstructor actor) {
		String sql = "INSERT INTO ACTOR (ACTOR_ID, FIRST_NAME,LAST_NAME,LAST_UPDATE) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, actor.getActor_id());
            stmt.setString(2, actor.getNombre());
            stmt.setString(3, actor.getApellido());
            stmt.setDate(4, actor.getActualizacion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


	@Override
	public void updateActor(ActorConstructor actor) {
		// TODO Auto-generated method stub
		String sql = "UPDATE ACTOR SET ACTOR_ID = ?, FIRST_NAME = ?, LAST_NAME = ?,LAST_UPDATE = ? WHERE ACTOR_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, actor.getActor_id());
            stmt.setString(2, actor.getNombre());
            stmt.setString(3, actor.getApellido());
            stmt.setDate(4, actor.getActualizacion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	

	@Override
	public void deleteActor(int actor_id) {
		 String sql = "DELETE FROM ACTOR WHERE ACTOR_ID = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, actor_id);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	@Override
	public List<ActorConstructor> getAllActores() {
		List<ActorConstructor> actor = new ArrayList<>();
        String sql = "SELECT * FROM ACTOR";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                actor.add(new ActorConstructor(
                		rs.getInt("ACTOR_ID"),
                		rs.getString("FIRST_NAME"),
                		rs.getString("LAST_NAME"),
                		rs.getDate("LAST_UPDATE")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actor;
	}

}
