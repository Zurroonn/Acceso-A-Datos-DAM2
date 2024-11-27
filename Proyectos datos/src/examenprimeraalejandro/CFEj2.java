package examenprimeraalejandro;

import java.io.Serializable;

public class CFEj2 implements Serializable{
String nombre,grado;
int horas;

public CFEj2(String nombre, String grado, int horas) {
	super();
	this.nombre = nombre;
	this.grado = grado;
	this.horas = horas;
}
@Override
public String toString() {
	return "Ciclos Formativos: " + nombre + ", Grado:" + grado + ", Horas:" + horas ;
}

}
