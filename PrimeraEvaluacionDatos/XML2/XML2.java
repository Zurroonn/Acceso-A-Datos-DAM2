package XML2;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class XML2 {

	public static void main(String[] args) {
		String ruta="./ciudades.xml";
	
		
		try {
			DocumentBuilderFactory documento= DocumentBuilderFactory.newInstance();
			DocumentBuilder builder= documento.newDocumentBuilder();
			Document doc= builder.parse(new File(ruta));
			doc.getDocumentElement().normalize();  //normalizar xml
			// por si necesito usar el root Element root = doc.getDocumentElement(); 
			NodeList ciudades = doc.getElementsByTagName("ciudad");//Saca todos los nodos de ciudad
			for (int i = 0; i < ciudades.getLength(); i++) { 	//Recorrer nodos
				Node nNode=ciudades.item(i);	
				if (nNode.getNodeType()==Node.ELEMENT_NODE) {//Asegurarse que es un nodo
					Element eElement= (Element)nNode;
					System.out.println("Ciudad");
					System.out.println("Nombre : "+eElement.getElementsByTagName("nombre").item(0).getTextContent());
					System.out.println("Continente:"+eElement.getElementsByTagName("pais").item(0).getAttributes().getNamedItem("continente").getTextContent());
					System.out.println(eElement.getElementsByTagName("pais").item(0).getTextContent());	
					System.out.println();
							
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
