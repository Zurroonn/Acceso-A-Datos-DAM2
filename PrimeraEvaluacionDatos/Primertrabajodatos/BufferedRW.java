package Primertrabajodatos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;


public class BufferedRW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String rutaFichero = JOptionPane.showInputDialog(null, "Introduce la ruta");
        
        if (rutaFichero == null || rutaFichero.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha introducido ninguna ruta.");
            return;
        }
		Escribir(rutaFichero);
		Leer(rutaFichero);
		
	}
		public static void Escribir (String rutaFichero) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFichero));
			bw.write("El modulo de acceso a datos");
			bw.newLine();
			bw.write("es muy util de aprender");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
		public static void Leer(String rutaFichero) {
		try {
			BufferedReader br= new BufferedReader(new FileReader(rutaFichero));
			String line;
			String contenido="";
			while((line = br.readLine()) != null)  {			
				contenido+=line+"\n";
				
			}
			System.out.println(contenido);
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	

}
