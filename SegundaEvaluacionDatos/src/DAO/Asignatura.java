package DAO;

public class Asignatura {
int id;
String nombre;
Double creditos;
String tipo;
int curso;
int cuatrimestre;

int id_grado;


public Asignatura() {
	
}
public Asignatura(int id, String nombre, Double creditos, String tipo, int curso, int cuatrimestre,
		int id_grado) {
	
	this.id = id;
	this.nombre = nombre;
	this.creditos = creditos;
	this.tipo = tipo;
	this.curso = curso;
	this.cuatrimestre = cuatrimestre;
	this.id_grado = id_grado;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Double getCreditos() {
	return creditos;
}
public void setCreditos(Double creditos) {
	this.creditos = creditos;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public int getCurso() {
	return curso;
}
public void setCurso(int curso) {
	this.curso = curso;
}
public int getCuatrimestre() {
	return cuatrimestre;
}
public void setCuatrimestre(int cuatrimestre) {
	this.cuatrimestre = cuatrimestre;
}

public int getId_grado() {
	return id_grado;
}
public void setId_grado(int id_grado) {
	this.id_grado = id_grado;
}


}
