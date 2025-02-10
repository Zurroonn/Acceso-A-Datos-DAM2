
	import java.util.List;

	public interface ActorDAO {

		ActorConstructor getActorByCodigo(int actor_id);
		void addActor(ActorConstructor actor);
		void updateActor(ActorConstructor actor);
		void deleteActor(int actor_id);
		List<ActorConstructor> getAllActores();
		
		
	}