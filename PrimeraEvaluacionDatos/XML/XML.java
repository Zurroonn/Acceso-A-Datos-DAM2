package XML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
public class XML {

	public static void main(String[] args) {
		String ruta= ("./coches.xml");
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File(ruta));
			doc.getDocumentElement().normalize();
			Element root = doc.getDocumentElement();
			NodeList coches = doc.getElementsByTagName("coche");			
			System.out.println();
			for (int i = 0; i < coches.getLength(); i++) {
				Node nNode=coches.item(i);
				if (nNode.getNodeType()==Node.ELEMENT_NODE) {
					Element eElement=(Element)nNode;
					System.out.println("\nCoche id: "+eElement.getAttribute("id"));
					System.out.println("Marca : "
							+eElement.getElementsByTagName("marca").item(0).getTextContent());
					System.out.println("Modelo: "
							+eElement.getElementsByTagName("modelo").item(0).getTextContent());
					System.out.println("Cilindrada: "
							+eElement.getElementsByTagName("cilindrada").item(0).getTextContent());
				}
				
				
				
			}
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
