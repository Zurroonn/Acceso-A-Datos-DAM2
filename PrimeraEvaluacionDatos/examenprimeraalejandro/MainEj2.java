package examenprimeraalejandro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainEj2 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		File archivo= new File("cfvb.ser");
		crearArchivo(archivo);
		try {
			ObjectInputStream ois= new ObjectInputStream(new FileInputStream(archivo));
			System.out.println("Ciclos formativos leídos desde el archivo:");
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void crearArchivo(File archivo) {
		try {
			
			ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(archivo));
			CFEj2 ciclos= new CFEj2("Técnico en Sistemas Microinformáticos y Redes ","grado medio ",1800);			
			oos.writeObject(ciclos);
			CFEj2 ciclos2= new CFEj2("Técnico Superior en Desarrollo de Aplicaciones Web  ","grado superior ",2000);			
			oos.writeObject(ciclos2);
			CFEj2 ciclos3= new CFEj2("Técnico Superior en Desarrollo de Aplicaciones Multiplataforma  ","grado superior ",2000);			
			oos.writeObject(ciclos3);
			CFEj2 ciclos4= new CFEj2("Técnico Superior en Administración de Sistemas Informáticos en Red Multiplataforma  ","grado medio ",2000);			
			oos.writeObject(ciclos4);
			System.out.println("Ciclos formativos guardados correctamente en el archivo "+archivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
