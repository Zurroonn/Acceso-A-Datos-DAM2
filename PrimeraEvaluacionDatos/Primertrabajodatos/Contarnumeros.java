package Primertrabajodatos;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Contarnumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String rutaFichero = JOptionPane.showInputDialog(null, "Introduce la ruta completa del fichero:");

	        if (rutaFichero == null || rutaFichero.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "No se ha introducido ninguna ruta.");
	            return;
	        }

	        try {
	            // Usamos FileReader para leer el archivo carácter por carácter
	            FileReader fr = new FileReader(rutaFichero);

	            int contador = 0;
	            int c; // Variable para almacenar el carácter leído

	            // Leer el archivo carácter por carácter
	            while ((c = fr.read()) != -1) {
	                // Verificar si el carácter es un dígito
	                if (Character.isDigit((char) c)) {
	                    contador++;
	                }
	            }

	            // Cerrar el FileReader
	            fr.close();

	            // Mostrar el resultado en un cuadro de diálogo
	            JOptionPane.showMessageDialog(null, "El número total de números en el fichero es: " + contador);

	        } catch (FileNotFoundException e) {
	            JOptionPane.showMessageDialog(null, "Archivo no encontrado: " + e.getMessage());
	        } catch (IOException e) {
	            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
	        }
	        
	}

}
