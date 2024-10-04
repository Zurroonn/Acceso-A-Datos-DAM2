package Primertrabajodatos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Tercerejerc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce el nombre del directorio");
		String directorio= sc.nextLine();
		
		File dir= new File(directorio);
		if (dir.exists()) {
            System.out.println("El directorio ya existe");
        } else {
        	dir.mkdir();
        	System.out.println(" Se creó el directorio");
        }
		
		System.out.println("Introduce el nombre del primer fichero");
		String fichero1=sc.nextLine();
		File archivo1= new File(dir,fichero1);
		try {
			if (archivo1.exists()) {
	            System.out.println("El archivo1 ya existe");
	        } else {
	        	archivo1.createNewFile();
	        	System.out.println(" Se creó el archivo "+ archivo1.getName());
	        }//con esto hago que si el fichero ya existe nos lo informe
			
			
			} catch (IOException e) {
			// TODO: handle exception
			System.out.println("No se pudo crear el primer archivo"+ e.getMessage());
		}
		System.out.println("Introduce el nombre del segundo fichero");
		String fichero2=sc.nextLine();
		File archivo2= new File(dir,fichero2);
		try {
			if (archivo2.exists()) {
	            System.out.println("El archivo2 ya existe");
	        } else {
				archivo2.createNewFile();
				System.out.println("Se creo el archivo "+archivo2.getName());

	        }/*con esto hago que si el fichero ya existe nos lo informe, pero si le damos dos veces,
			se creara dos veces ya que renombramos el archivo, asi que no aparecera como que yaexiste
			hasta que no lo hagamos 2 veces*/
			System.out.println("Renombra el fichero");
			String renombre=sc.nextLine();
			archivo2.renameTo(new File (dir,renombre));
        	System.out.println(" Se creó el archivo "+renombre);
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("No se pudo crear el segundo archivo"+ e.getMessage());
		}
		sc.close();
		
	}
	

}
