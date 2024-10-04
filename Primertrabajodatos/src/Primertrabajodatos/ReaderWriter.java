package Primertrabajodatos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriter {

	public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("contarnumeros.txt")) {
            writer.write("Los alumnos de 2º de DAM están haciendo esta\n");
            writer.write("  práctica en 2024.\n"); //
        } catch (IOException e) {
            e.printStackTrace();
        }
        String contenido="";
		try (FileReader reader = new FileReader("contarnumeros.txt")) { //pongo la direccion para que se envie donde quiera y lo ultimo es el nombre que le dou
			 //utizo open resources para crear el filereader 
			
	            int data;
	            while ((data = reader.read()) != -1) {
	            	contenido+=(char)data;
	                
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

		System.out.println(contenido);
		
 
	}

}
