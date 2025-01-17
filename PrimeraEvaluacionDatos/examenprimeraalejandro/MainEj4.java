package examenprimeraalejandro;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import XML_SAX.XML_parser;

public class MainEj4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
	            // Crear una instancia de SAXParserFactory
	            SAXParserFactory factory = SAXParserFactory.newInstance();

	            // Crear un parser SAX
	            SAXParser saxParser = factory.newSAXParser();

	            // Crear una instancia del manejador
	            XML_parser handler = new XML_parser();

	            // Analizar el archivo XML
	            saxParser.parse("pom.xml", handler);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}

}
