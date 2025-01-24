package Scanner_fichero;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class notacorte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File archivos= new File("C:\\Users\\Manana\\Desktop\\Datos\\Proyectos datos\\src\\Scanner_fichero\\notas.txt");
		Scanner sc;
		Scanner sc2=new Scanner(System.in);
		System.out.println("Cual es la nota de corte");
		int corte= sc2.nextInt();
		
		try {
			sc = new Scanner(archivos);
			
				while(sc.hasNextInt()) {
				int num=sc.nextInt();
				if(num>=corte) {
				System.out.println(num);	
				}
			
		} 
				sc.close();
				sc2.close();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}


	}


