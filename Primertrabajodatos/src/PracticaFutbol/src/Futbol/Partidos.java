package Futbol;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Partidos {
	public static void leerarchivos () {
		try {
			
			BufferedReader br= new BufferedReader(new FileReader("partidos.txt"));
			String line;			
			ArrayList <PartidoFutbol>partidos= new ArrayList<>(); 
			while((line = br.readLine()) != null)  {			
				partidos.add(new PartidoFutbol(line));
				
			}
							System.out.printf("%-20s %-5d %-20s %-5d","partidos" );		
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		leerarchivos();
	
	
	
	
	
	
	
	
	}
}