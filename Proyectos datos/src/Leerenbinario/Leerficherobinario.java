package Leerenbinario;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
			try {
				
			while(true) {
				
			dni=das.readUTF();
			nombre=das.readUTF();			
			apellidos=das.readUTF();
			edad=das.readInt();
			expectativa=das.readInt();
			System.out.println("Usuario: "+usuario);
			System.out.println(nombre);
			System.out.println(dni);
			System.out.println(apellidos);
			System.out.println(edad);
			System.out.println(expectativa);
			usuario++;
			}
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
