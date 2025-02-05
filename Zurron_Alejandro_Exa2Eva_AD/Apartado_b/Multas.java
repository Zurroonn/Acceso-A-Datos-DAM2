package Apartado_b;

import java.sql.Date;

public class Multas {
int codigoMulta;
String descripcion;
int codigoPersona;
int codigoAgente;
double importe;
int puntos;
Date fechamulta;

public Multas() {
	
}
public Multas(int codigoMulta, String descripcion, int codigoPersona, int codigoAgente, double importe, int puntos,
		Date fechamulta) {
	super();
	this.codigoMulta = codigoMulta;
	this.descripcion = descripcion;
	this.codigoPersona = codigoPersona;
	this.codigoAgente = codigoAgente;
	this.importe = importe;
	this.puntos = puntos;
	this.fechamulta = fechamulta;
}
public int getCodigoMulta() {
	return codigoMulta;
}
public void setCodigoMulta(int codigoMulta) {
	this.codigoMulta = codigoMulta;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public int getCodigoPersona() {
	return codigoPersona;
}
public void setCodigoPersona(int codigoPersona) {
	this.codigoPersona = codigoPersona;
}
public int getCodigoAgente() {
	return codigoAgente;
}
public void setCodigoAgente(int codigoAgente) {
	this.codigoAgente = codigoAgente;
}
public double getImporte() {
	return importe;
}
public void setImporte(double importe) {
	this.importe = importe;
}
public int getPuntos() {
	return puntos;
}
public void setPuntos(int puntos) {
	this.puntos = puntos;
}
public Date getFechamulta() {
	return fechamulta;
}
public void setFechamulta(Date fechamulta) {
	this.fechamulta = fechamulta;
}
@Override
public String toString() {
	return "Multas [codigoMulta=" + codigoMulta + ", descripcion=" + descripcion + ", codigoPersona=" + codigoPersona
			+ ", codigoAgente=" + codigoAgente + ", importe=" + importe + ", puntos=" + puntos + ", fechamulta="
			+ fechamulta + "]";
}

}
