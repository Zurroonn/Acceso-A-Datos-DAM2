package examenprimeraalejandro;

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

public class MainEj3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		try {
			DocumentBuilderFactory documento= DocumentBuilderFactory.newInstance();//CARGA EL DOCUMENTO XML EN MEMORIA
			DocumentBuilder builder= documento.newDocumentBuilder();//PROPORCIONA METODO PARSE PARA CARGAR Y ANALIZAR EL ARCHIVO XML EN UN OBJETO DOCUMENT
			Document doc= builder.parse(new File("hechos.xml"));
			doc.getDocumentElement().normalize();  //ELIMINA ESPACIOS EN BLANCO PARA UNA LECTURA MAS SENCILLA
			Element root = doc.getDocumentElement();
			NodeList hechos = doc.getElementsByTagName("hecho");//SACA TODOS LOS NODOS DE HECHO
			System.out.println("Elemento raíz: "+root);
			for (int i = 0; i < hechos.getLength(); i++) { 	//RECORREMOS TODOS LOS NODOS
				Node nNode=hechos.item(i);
				Element eElement= (Element)nNode;
				System.out.print("Descripción: "+eElement.getAttribute("descripcion"));//SACAMOS EL ATRIBUTOD DESCRIPCION
				System.out.println();

				if (nNode.getNodeType()==Node.ELEMENT_NODE) {
					String fecha=eElement.getElementsByTagName("fecha").item(0).getTextContent();
					String []fecha1=fecha.split("\n");
					
					System.out.println("Fecha:"+fecha1[1]+"/"+fecha1[2]+"/"+fecha1[3]);						
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
