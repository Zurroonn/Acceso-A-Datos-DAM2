package Leerenbinario;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Leerficherobinario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduce una expectativa salarial");
		try {
			DataInputStream das= new DataInputStream(new FileInputStream("usuarios.dat"));
			String nombre="";
			String dni="";
			String apellidos="";
			int edad=0;
			int expectativa=0;
			int usuario=1;
			
			Scanner sc= new Scanner(System.in);
			int filtroSalario=sc.nextInt();
			try {
				
			
			System.out.println("Usuarios con expectativa salarial mayor que \n" + filtroSalario + ":");
            while (das.available() > 0) {
                 dni = das.readUTF();
                 nombre = das.readUTF();
                 apellidos = das.readUTF();
                 edad = das.readInt();
                 expectativa = das.readInt();
                
                if (expectativa > filtroSalario) {
                    System.out.println("DNI: " + dni + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", Edad: " + edad + ", Expectativa Salarial: " + expectativa);
                }
                
            }
			usuario++;
			}
			
			
			catch(EOFException eo) {
				System.out.println("No hay mas usuarios");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
