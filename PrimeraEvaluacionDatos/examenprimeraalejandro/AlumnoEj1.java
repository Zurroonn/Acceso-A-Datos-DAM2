package examenprimeraalejandro;

public class AlumnoEj1 {
String nombre,grupo;
float media,primera,segunda;

public AlumnoEj1(String nombre, String grupo, float media, float primera, float segunda) {
	super();
	this.nombre = nombre;
	this.grupo = grupo;
	this.media = media;
	this.primera = primera;
	this.segunda = segunda;
}
@Override
public String toString() {
	return "AlumnoEj1 [nombre=" + nombre + ", grupo=" + grupo + ", media=" + media + ", primera=" + primera
			+ ", segunda=" + segunda + "]";
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getGrupo() {
	return grupo;
}
public void setGrupo(String grupo) {
	this.grupo = grupo;
}
public float getMedia() {
	return media;
}
public void setMedia(float media) {
	this.media = media;
}
public float getPrimera() {
	return primera;
}
public void setPrimera(float primera) {
	this.primera = primera;
}
public float getSegunda() {
	return segunda;
}
public void setSegunda(float segunda) {
	this.segunda = segunda;
}


}
