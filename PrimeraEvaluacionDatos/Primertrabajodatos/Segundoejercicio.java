package Primertrabajodatos;

import java.io.File;
import java.util.Iterator;

public class Segundoejercicio {

	public static void main(String[] args) {
		if (args.length!=1) {
			System.err.println("Numero de argumentos inválidos");
		return;
		
		}
		System.out.println("El argumento pasado es:"+args[0]);
		//Crea un objeto File con el nombre del directorio proporcionado
		File directorio = new File(args[0]);
		if(!directorio.exists()) {
			System.out.println("El directorio no existe");
			
		}else if(!directorio.isDirectory()) {
			System.out.println("el nombre proporcionado no corresponde");
		}
		else {
			//Listar los ficheros del directorio
			File [] ficheros=directorio.listFiles();
			if (ficheros !=null && ficheros.length>0) {
				System.out.println("Ficheros en el directorio"+args[0]+":" );
				for (File fichero : ficheros) {
					System.out.println("Nombre:"+fichero.getName());
					System.out.println("Ruta:"+fichero.getPath());
					System.out.println("Ruta absoluta:"+fichero.getAbsolutePath());
				}
			}else {
					System.out.println("El directorio esta vacio");
				}
			}
		}
		
		/*
		File ruta= new File(args[0]);
		if (!ruta.exists()) {
			System.err.println("Pelele");
		return;
		º
		}
		System.out.printf("%-70s %-70s %-70s","Nombre","Ruta","Ruta absoluta");
		String contenido[]=ruta.list();
		
		for ( File archivo : ruta.listFiles()) {
			System.out.printf(
					"%-70s %-70s %-70s\n",
			archivo.getName(),
			archivo.getPath(),
			archivo.getAbsolutePath());*/
		}
		
	


	