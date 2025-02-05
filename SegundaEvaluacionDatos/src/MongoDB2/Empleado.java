package MongoDB2;

public class Empleado {
    private String NIF;
    private String nombre;
    private String apellidos;
    private double salario;

    public Empleado(String NIF, String nombre, String apellidos, double salario) {
        this.NIF = NIF;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.salario = salario;
        
    }

    public String getNIF() {
        return NIF;
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
        return "Empleado{" +
                "NIF='" + NIF + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Apellidos='" + apellidos + '\'' +
                ", Salario=" + salario +
                '}';
    }
    
}
