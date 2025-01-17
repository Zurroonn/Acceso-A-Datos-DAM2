package Primertrabajodatos;

import java.io.File;
import java.io.IOException;

public class Tercerejercicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir= new File("nuevo");
		dir.mkdir();
		File archivo1= new File(dir,"fichero1.txt");
		try {
			archivo1.createNewFile();
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("No se pudo crear"+ e.getMessage());
		}
		File archivo2= new File(dir,"fichero2.txt");
		try {
			archivo2.createNewFile();
			archivo2.renameTo(new File (dir,"archivorenombrado.txt"));
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("No se pudo crear"+ e.getMessage());
		}
	}

}
