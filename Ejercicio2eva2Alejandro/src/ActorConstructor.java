import java.sql.Date;

public class ActorConstructor {
int actor_id;
String apellido;
String nombre;
Date actualizacion;
public int getActor_id() {
	return actor_id;
}
public void setActor_id(int actor_id) {
	this.actor_id = actor_id;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Date getActualizacion() {
	return actualizacion;
}
public void setActualizacion(Date actualizacion) {
	this.actualizacion = actualizacion;
}
public ActorConstructor(int actor_id,  String nombre,String apellido, Date actualizacion) {
	super();
	this.actor_id = actor_id;
	this.nombre = nombre;
	this.apellido = apellido;
	this.actualizacion = actualizacion;
}

}
