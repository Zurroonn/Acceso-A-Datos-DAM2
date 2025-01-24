package AccesoDatosFaciles;

import java.io.Serializable;

public class Usuarios implements Serializable {
	private String NIF;
	private String nombre;
	private String apellidos;
	private int edad;
	private double expeSala;
	

	
	public Usuarios() {
	}
	
	public Usuarios(String nIF, String nombre, String apellidos, int edad, double expeSala) {
		NIF = nIF;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.expeSala = expeSala;
	}
	public String getNIF() {
		return NIF;
	}
	public void setNIF(String nIF) {
		NIF = nIF;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getExpeSala() {
		return expeSala;
	}
	public void setExpeSala(double expeSala) {
		this.expeSala = expeSala;
	}

	@Override
	public String toString() {
		return "Usuarios [NIF=" + NIF + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", expeSala=" + expeSala + "]";
	}
	
	
	
	
}
