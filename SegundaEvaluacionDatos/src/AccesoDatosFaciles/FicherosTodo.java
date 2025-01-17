package AccesoDatosFaciles;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FicherosTodo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opc;
		
		do {
			
			System.out.println("Elije una opcion: ");
			System.out.println("1-Crea un fichero");
			System.out.println("2-Leer y escribir un fichero.txt");
			System.out.println("3-leer y escribir un fichero binario");
			System.out.println("4-Ver ficheros de propiedades");
			System.out.println("5-XML DOM");
			System.out.println("6-XML SAX");
			System.out.println("7-Salir");
			opc=sc.nextInt();
			
			switch(opc) {
				case 1:
					crearFichero();
					break;
				
				case 2:
					leerEscribirClaseFut();
					break;
					
				case 3:
					ficherosBinarios();
					break;
					
				case 4:
					ficherosPropiedades();
					break;	
					
				case 5:
					xmlDOM();
					break;
					
				case 6:
					xmlSAX();
					break;
					
				case 7:
					
					System.out.println("Saliendoo....");
					
					break;	
					
				default:
					
					System.out.println("Introduce una opcion válida");
			
			}
			
		}while(opc!=7);
	}









	private static void crearFichero() {
		System.out.println("Introduce la ruta");
		Scanner sc2 = new Scanner(System.in);
		String ruta=sc2.nextLine();
		
		File f = new File(ruta);
		if(ruta.isEmpty()) {
			System.out.println("Introduce la ruta");
			return;
		}
		if(f.exists()) {
			System.out.println("El directorio no se pudo crear, ya existe");
			return;
		}
		
		
		if(f.mkdir()) {
			System.out.println("El directorio se creo en la ruta: "+ruta);
		}
		
		System.out.println("Introduce el nombre del fichero: ");
		String ficherito = sc2.nextLine();
		File fichero = new File(f,ficherito+".txt");
		
		try {
			if(fichero.createNewFile()) {
				System.out.println("El fichero "+ficherito+ " Se creo correctamente");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	private static void leerEscribirClaseFut() {
		Scanner sc3 = new Scanner(System.in);
		/*
		System.out.println("Introduce la ruta con el fichero de los partidos.txt== ");
		String rut = sc3.nextLine();
		*/
		File f = new File("C:\\DAM1\\siu\\PartidoFutbol.txt");
		
		if(!f.exists()||!f.isFile()) {
			System.out.println("El fichero o es un directorio o no existe, introduzcalo bien");
			return;
		}
		
		ArrayList<PatidoDeFutbol> partidos = new ArrayList<PatidoDeFutbol>();
		
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			
			while((line=br.readLine())!=null) {
				
				String[]partes = line.split("-");
				
				String equipoLocal = partes[0];
				int golLocal = Integer.parseInt(partes[1]);
				int golVisi = Integer.parseInt(partes[2]);
				String equipoVisi = partes[3];
				
				PatidoDeFutbol p = new PatidoDeFutbol(equipoLocal, golLocal, golVisi, equipoVisi);
				partidos.add(p);
				
			}
			
			System.out.println("Se han leido los siguientes partidos "+partidos+"\n");
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	private static void ficherosBinarios() {
		
		Scanner sc4= new Scanner(System.in);
		
		File f4 = new File("Usuarios.dat");
		ArrayList<Usuarios> usuarios = new ArrayList<Usuarios>(); 
		
		
		while(true) {
			//NIF, nombre, apellidos. edad, expectativa salarial
			System.out.println("Introduce el NIF: ");
			String NIF = sc4.nextLine();
			
			System.out.println("Introduce el nombre: ");
			String nombre = sc4.nextLine();
			
			System.out.println("Introduce el apellidos: ");
			String apellidos = sc4.nextLine();
			
			System.out.println("Introduce el edad: ");
			int edad = sc4.nextInt();
			sc4.nextLine();						
			
			System.out.println("Introduce el expeSala: ");
			double expeSala = sc4.nextDouble();
			sc4.nextLine();
			
			Usuarios usu = new Usuarios(NIF, nombre, apellidos, edad, expeSala);
			usuarios.add(usu);
			
			System.out.println("Quiere introducir otro S/N");
			String respu = sc4.nextLine();
			if(respu.equalsIgnoreCase("N")) {
				break;
			}
					
			
		}
		
		
		
		try {
			FileOutputStream fos = new FileOutputStream(f4);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			oos.writeObject(usuarios);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//tmb se puede hacer con un bucle for
		
		for(Usuarios u:usuarios) {
			System.out.println("Nombre es: "+u.getNombre()+" \nEl apellido es: "+u.getApellidos()+" \nLa edad es: "+u.getEdad()+" \nExperiencia Salarial es de: "+u.getExpeSala());
		}
		
		System.out.println("Los usuarios guardados son: "+usuarios);
		
		
		
		
		
		
	}
	
	
	
	
	
	private static void ficherosPropiedades() {
		System.out.println("vamos a cargar el fichero de propiedades");
		Properties p = new Properties();
		
		try {
			File f4 = new File("./config.properties");
			if(!f4.exists()) {
				if(f4.createNewFile()) {
					System.out.println("Fichero propiedades creado corectamente");
				}
				
			}else {
				System.out.println("ya existe");
			}
			
			
			FileInputStream fis = new FileInputStream(f4);
			p.setProperty("holii", "es");
			p.load(fis);
			
			p.list(System.out);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
	
	
	private static void xmlDOM() {
		
		String nombre;
		String pais;
		String continente;
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse("./ciudades.xml");
			Element root = d.getDocumentElement();
			
			NodeList nodoCiudad = d.getElementsByTagName("ciudad");
			
			System.out.println("El elemento root es: "+root.getNodeName());
			System.out.println("------------------------------------------");
			System.out.println("");
			
			for(int i = 0;i<nodoCiudad.getLength();i++) {
				Node nodoCiu = nodoCiudad.item(i);
				
				if(nodoCiu.getNodeType()==Node.ELEMENT_NODE) {
					Element elemento = (Element) nodoCiu;
					nombre= elemento.getElementsByTagName("nombre").item(0).getTextContent();
					System.out.println("Ciudad: "+nombre);
					
					Element elementoPais = (Element) elemento.getElementsByTagName("pais").item(0);
					pais=elementoPais.getTextContent();
					continente = elementoPais.getAttribute("continente");
					
					System.out.println("Pais "+pais);
					System.out.println("Continente= "+continente);
					System.out.println("------------------------");
					
				}
				
			}
			
			
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}

	
	
	

	private static void xmlSAX() {
		try {
			
			SAXParserFactory factory = SAXParserFactory.newInstance();
			
			SAXParser saxParser = factory.newSAXParser();
			
			Handler manejador = new Handler();
			
			saxParser.parse("./libros.xml", manejador);
			
		}catch (Exception e) {
			System.out.println("Error."+e.getMessage());
		}
		
	}



	
	
	
}
