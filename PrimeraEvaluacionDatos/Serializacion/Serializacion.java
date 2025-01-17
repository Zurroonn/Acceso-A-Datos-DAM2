package Serializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Serializacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce el nombre");
		String nom= sc.nextLine();
		System.out.println("Introduce el apellido");
		String ape= sc.nextLine();
		System.out.println("Introduce la nota");
		int nota= sc.nextInt();
		try {
		ObjectOutputStream oos= new ObjectOutputStream (new FileOutputStream("alumno.ser"));
		
		Alumno alum= new Alumno(nom,ape,nota);
		oos.writeObject(alum);
		System.out.println("Alumno creado con exito");
		}catch (IOException ex) {
				ex.getMessage();	
		}
		try {
			ObjectInputStream ois= new ObjectInputStream(new FileInputStream("alumno.ser"));
			Alumno alum=(Alumno) ois.readObject();
			System.out.println(alum);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	

}
