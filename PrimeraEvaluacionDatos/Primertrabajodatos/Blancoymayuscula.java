package Primertrabajodatos;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Blancoymayuscula {

	public static void main(String[] args) {
        String rutaFichero = JOptionPane.showInputDialog(null, "Introduce la ruta");
        
        if (rutaFichero == null || rutaFichero.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha introducido ninguna ruta.");
            return;
        }

        StringBuilder contenido = new StringBuilder();
        
        // Leer el contenido del fichero
        try  {
        	
        	FileReader fr = new FileReader(rutaFichero);
            int c;
            while ((c = fr.read()) != -1) {
                contenido.append((char) c);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer el archivo.");
            return;
        }

        // Convertir el contenido a mayúsculas y eliminar espacios
        String contenidoModificado = contenido.toString().toUpperCase().replace(" ", "");
        
        // Sobrescribir el fichero con el contenido modificado
        try  {
        	FileWriter fw = new FileWriter(rutaFichero);
            fw.write(contenidoModificado);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al escribir en el archivo.");
        }
        
        // Mostrar el resultado en consola
        System.out.println(contenidoModificado);
    }
}
