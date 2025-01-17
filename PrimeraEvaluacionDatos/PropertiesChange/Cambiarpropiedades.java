package PropertiesChange;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Cambiarpropiedades {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop= new Properties();
		Scanner sc= new Scanner(System.in);
		// set up new properties object
		FileInputStream propFile;
		boolean boo=true;
		try {
			propFile = new FileInputStream("src\\PropertiesChange\\config.properties");
			prop.load(propFile);
			// set the system properties
			// display new properties
			prop.list(System.out);
			while (boo) {
			System.out.println("Deseas cambiar algo");
			String respuesta=sc.nextLine();
			if (respuesta.equalsIgnoreCase("no")) {
				boo=false;
			}else if (respuesta.equalsIgnoreCase("si")) {
				System.out.println("Introduce propiedad a cambiar");
				String clavecambiar=sc.nextLine();
				System.out.println("Introduce el nuevo valor de "+clavecambiar);
				String valornuevo=sc.nextLine();
				prop.setProperty(clavecambiar, valornuevo);
			}
			
			
			
			
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.store(new FileOutputStream("src\\PropertiesChange\\config.properties"), "");
			System.out.println("Se han cambiado");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
