package Aleatorio_Productos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;

public class Aleatorio_Productos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			RandomAccessFile raf= new RandomAccessFile("archivo.bin","rw");
			double precio=100;
			for (int i = 1; i < 6; i++) {	
			raf.writeInt(i); //4bytes
			raf.writeUTF("Electrodo"+ i); //12bytes
			precio=precio+100;
			raf.writeDouble(precio);//8bytes
			if (i%2!=0) {
				raf.writeBoolean(true); //1byte
				
			}else {
				raf.writeBoolean(false);//1byte
			}
			char tipo1='A';
			char tipo2='B';
			if (i%2==0) {
				raf.writeChar(tipo1);//2bytes
			}else {
			raf.writeChar(tipo2);//2bytes
			}
			
			}
			System.out.println("Se ha escrito");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			RandomAccessFile raf= new RandomAccessFile("archivo.bin","r");
			raf.seek(27);
			System.out.println("ID:"+raf.readInt());
			System.out.println("Nombre:"+raf.readUTF());
			System.out.println("Precio:"+raf.readDouble());
			System.out.println("Tiene descuento:"+raf.readBoolean());
			System.out.println("Tipo="+raf.readChar());
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
