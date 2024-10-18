package Binario;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Escribirenbinario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean boo= true;
		
		DataOutputStream dos;
		try {
			dos = new DataOutputStream(new FileOutputStream("usuarios.dat"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
			return;
			
		}
		Scanner sc= new Scanner(System.in);
		do {
			System.out.println("Quieres introducir un usuario");
			String respuesta=sc.nextLine();
			if (respuesta.equalsIgnoreCase("S") ||respuesta.equalsIgnoreCase("s")) {
				int eleccion=0;
				try {
					
					do {										
						System.out.println("1Introducir un usuario");
						System.out.println("2.Salir");
				    eleccion=sc.nextInt();
					sc.nextLine();
					switch (eleccion) {
					
					case 1:
						System.out.println("1.Introduce el dni");
						String dni=sc.nextLine();	
						dos.writeUTF(dni);
						System.out.println("2.Introduce el nombre");
						String nombre=sc.nextLine();
						dos.writeUTF(nombre);
						System.out.println("3.Introduce los apellidos");
						String apellidos=sc.nextLine();
						dos.writeUTF(apellidos);
						System.out.println("4.Introduce la edad");
						int edad=sc.nextInt();					
						dos.writeInt(edad);
						System.out.println("5.Introduce la expectativa salarial");
						int expectativa_salarial=sc.nextInt();
						dos.writeInt(expectativa_salarial);
						break;
					case 2:
						System.out.println("Saliendo");
						break;
						

					default:
						break;
					}
					}while(eleccion!=2)			;		
					System.out.println("Usuario introducido");
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if(respuesta.equalsIgnoreCase("N")||respuesta.equalsIgnoreCase("n")) {
				
				boo=false;
				System.out.println("Cerrando aplicacion");
				break;
			}
			
			
			
		}while(boo);
		sc.close();
		try {
			dos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
