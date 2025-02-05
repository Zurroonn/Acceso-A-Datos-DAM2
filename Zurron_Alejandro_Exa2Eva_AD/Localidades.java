
public class Localidades implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
int codigo;
String nombre;
public Localidades(int codigo, String nombre) {
	super();
	this.codigo = codigo;
	this.nombre = nombre;
}
public int getCodigo() {
	return codigo;
}
public void setCodigo(int codigo) {
	this.codigo = codigo;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
@Override
public String toString() {
	return "Localidades [codigo=" + codigo + ", nombre=" + nombre + "]";
}
public Localidades() {

}

}
