package XML_SAX;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Xml_sax {

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
            saxParser.parse("empleados.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
