package examenprimeraalejandro;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class MainEj1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ruta= "alumnos.txt";
		ArrayList<AlumnoEj1> alumnos= new ArrayList<>();
		//LEO EL ARCHIVO Y GUARDO LOS ALUMNOS EN UNA LISTA, LOS SEPARO CON SPLIT PARA AÑADIRLOS
		try {
			BufferedReader br= new BufferedReader(new FileReader("alumnos.txt"));
			String linea;
			StringBuilder contenido= new StringBuilder();
			
			while ((linea=br.readLine())!=null) {
				String []alumno= linea.split("\\s");							
				AlumnoEj1 alum= new AlumnoEj1(alumno[0],alumno[1],Float.parseFloat(alumno[2]),Float.parseFloat(alumno[3]),Float.parseFloat(alumno[4]));
				alumnos.add(alum);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//CREO TODOS LOS CALCULOS QUE NOS PIDE EL EJERCICIOS
		int suspensos1=0;
		float aprobados1=0;
		int todos1=0;
		for (AlumnoEj1 al : alumnos) {
			if (al.getPrimera()<5) {
				suspensos1++;
				
			}else {
				aprobados1=al.getPrimera()+aprobados1;
				todos1++;
			}
		}
		aprobados1=aprobados1/todos1;
		
		System.out.println("Media de aprobados primera evaluacion: "+aprobados1);
		
		int suspensos2=0;
		float aprobados2=0;
		int todos2=0;
		for (AlumnoEj1 al : alumnos) {
			if (al.getSegunda()<5.0) {
				suspensos2++;
			}else {
				aprobados2=al.getSegunda()+aprobados2;
				todos2++;
			}
		}
		aprobados2=aprobados2/todos2;
		System.out.println("Media de aprobados se segunda evaluaci: "+aprobados2);
		System.out.println("Numero de suspensos primera evaluacion: "+suspensos1);
		System.out.println("Numero de suspensos segunda evaluacion: "+suspensos2);
		float media=0;
		int numalum=0;
		for (AlumnoEj1 al : alumnos) {
			media=al.getPrimera()+media;
		numalum++;
		}
		media=media/numalum;
		
		System.out.println("Nota media primera evaluacion"+media);
		float media2=0;
		int numalum2=0;
		for (AlumnoEj1 al : alumnos) {
			media2=al.getSegunda()+media2;
			numalum2++;
		}
		media2=media2/numalum2;
		System.out.println("Nota media segunda evaluacion"+media2);
		
	}

}
