package Scanner_fichero;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class notasuspenso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File archivos= new File("C:\\Users\\Manana\\Desktop\\Datos\\Proyectos datos\\src\\Scanner_fichero\\notas.txt");
		Scanner sc;
		Scanner sc2=new Scanner(System.in);
		ArrayList<Integer> aprobados= new ArrayList<>();
		ArrayList<Integer> suspensos= new ArrayList<>();
		try {
			sc = new Scanner(archivos);
			
				while(sc.hasNextInt()) {
				int num=sc.nextInt();
				if(num>=5) {				
				aprobados.add(num);
				}
				if(num<5) {				
				suspensos.add(num);
				}

		} 
				System.out.println("Los suspensos son");
				for (Integer inte : suspensos) {
					System.out.print(inte+",");
				}
				System.out.println();
				System.out.println("Los aprobados son");
				for (Integer inte : aprobados) {
					System.out.print(inte+",");
				}
				sc.close();
				sc2.close();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}


	}

