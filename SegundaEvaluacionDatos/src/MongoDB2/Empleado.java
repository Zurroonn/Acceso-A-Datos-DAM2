package MongoDB2;

public class Empleado {
    private String nif;
    private String nombre;
    private String apellidos;
    private double salario;

    public Empleado(String nif, String nombre, String apellidos, double salario) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.salario = salario;
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "NIF: " + nif + ", Nombre: " + nombre + " " + apellidos + ", Salario: " + salario;
    }
}
