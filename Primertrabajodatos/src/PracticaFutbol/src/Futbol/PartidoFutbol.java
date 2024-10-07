package Futbol;


public class PartidoFutbol {
String local;
String visitante;
int golL;
int golV;

public PartidoFutbol(String local, String visitante, int golL, int golV) {
	super();
	this.local = local;
	this.visitante = visitante;
	this.golL = golL;
	this.golV = golV;
}
public PartidoFutbol(String PartidoFurbo) {
	String [] campos=PartidoFurbo.split("-");
	this.local =campos[0] ;
	this.visitante = campos[1];
	this.golL = Integer.parseInt(campos[2]);
	this.golV = Integer.parseInt(campos[3]);
	
}
public String getLocal() {
	return local;
}
public void setLocal(String local) {
	this.local = local;
}
public String getVisitante() {
	return visitante;
}
public void setVisitante(String visitante) {
	this.visitante = visitante;
}
public int getGolL() {
	return golL;
}
public void setGolL(int golL) {
	this.golL = golL;
}
public int getGolV() {
	return golV;
}
public void setGolV(int golV) {
	this.golV = golV;
}
}
