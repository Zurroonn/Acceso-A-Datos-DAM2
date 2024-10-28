package Serializacion;

import java.io.Serializable;

public class Alumno implements Serializable{
    private static final long serialVersionUID = 1L;
	private String nombre,apellidos;
	private int NotaAD;
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
	public int getNotaAD() {
		return NotaAD;
	}
	public void setNotaAD(int notaAD) {
		NotaAD = notaAD;
	}
	public Alumno(String nombre, String apellidos, int notaAD) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		NotaAD = notaAD;
	}
    @Override
    public String toString() {
        return "Persona{nombre=" + nombre + ", apellidos=" + apellidos +", nota"+NotaAD +"}";
    }

}
