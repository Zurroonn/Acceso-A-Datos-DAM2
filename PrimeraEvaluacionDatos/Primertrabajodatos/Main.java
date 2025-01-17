package Primertrabajodatos;



import java.io.File;
public class Main {

	public static void main(String[] args) {
	String dir=".";//Directorio actual   ..= directorio padre
	File f= new File(dir);
	String []archivos =f.list();//sirve para guardar los files en un archivo
	System.out.printf("Ficheros en el directorio actual %d ",archivos.length);// d:para decimales s:para caracteres b:para booleans y evite usar if
	/*for (int i = 0; i < archivos.length; i++) {
		File f2= new File(f,archivos[i]);
		System.out.printf("Nombre: %s es fichero: %b es directorio?: %b \n",archivos[i],f2.isFile(),f2.isDirectory());
		//:? hace que no necesitemos if y se use lo de detras suyo para las distintas posibilidades que hay

	}*/
	for (File archivo: f.listFiles()) { //lo mismo que el for pero en for each
		System.out.printf("Nombre: %s es fichero:) %b es directorio?: \n" ,archivo.getName(),archivo.isDirectory());
		
	}
        }
	}

