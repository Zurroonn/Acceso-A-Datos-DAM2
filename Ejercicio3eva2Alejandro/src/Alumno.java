
public class Alumno {
int expediente;
String nombre;
String apellido;
int notaAD;
public Alumno(int expediente, String nombre, String apellido, int notaAD) {
	super();
	this.expediente = expediente;
	this.nombre = nombre;
	this.apellido = apellido;
	this.notaAD = notaAD;
}
public int getExpediente() {
	return expediente;
}
public void setExpediente(int expediente) {
	this.expediente = expediente;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nomnbre) {
	this.nombre = nomnbre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public int getNotaAD() {
	return notaAD;
}
public void setNotaAD(int notaAD) {
	this.notaAD = notaAD;
}
public Alumno() {
	super();
}

}
