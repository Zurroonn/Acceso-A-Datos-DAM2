import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ficheros_aleatorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			RandomAccessFile raf= new RandomAccessFile("datos.bin","rw");
			raf.writeInt(123);
			raf.writeDouble(45.67);
			raf.writeUTF("Hola mundo");

			raf.close();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			RandomAccessFile raf= new RandomAccessFile("datos.bin","r");
			
			
			int numero=raf.readInt();
			Double doble=raf.readDouble();
			String texto=raf.readUTF();;
			System.out.println(texto);
			System.out.println(doble);
			System.out.println(numero);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			RandomAccessFile raf= new RandomAccessFile("datos.bin","r");
			raf.seek(4);
			System.out.println(raf.readDouble());
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
