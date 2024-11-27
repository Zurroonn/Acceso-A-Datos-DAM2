package examenprimeraalejandro;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class XmlparserEj4 extends DefaultHandler{

	public class LibroHandler extends DefaultHandler {
	    private boolean esGrupo = false;
	    private boolean esArtefacto = false;
	    private boolean esVersion = false;
	    private boolean esConfiguracion=false;
	    @Override
	    public void startDocument() throws SAXException {
	        System.out.println("Inicio del documento XML.");
	    }

	    @Override
	    public void endDocument() throws SAXException {
	        System.out.println("Fin del documento XML.");
	    }


	    @Override
	    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	        if (qName.equalsIgnoreCase("plugin")) {

	        } else if (qName.equalsIgnoreCase("groupId")) {
	            esGrupo = true;
	        } else if (qName.equalsIgnoreCase("artifactId")) {
	            esArtefacto = true;
	        } else if (qName.equalsIgnoreCase("version")) {
	            esVersion = true;
	        }
	        else if (qName.equalsIgnoreCase("configuration")) {
	            esConfiguracion = true;
	        }
	    }

	    @Override
	    public void endElement(String uri, String localName, String qName) throws SAXException {
	        if (qName.equalsIgnoreCase("libro")) {
	            System.out.println("Fin de libro\n");
	        }
	    }

	    @Override
	    public void characters(char[] ch, int start, int length) throws SAXException {
	        if (esGrupo) {
	            System.out.println("GrupoID: " + new String(ch, start, length));
	            esGrupo = false;
	        } else if (esArtefacto) {
	            System.out.println("ArtifactID: " + new String(ch, start, length));
	            esArtefacto = false;
	        } else if (esVersion) {
	            System.out.println("Version: " + new String(ch, start, length));
	            esVersion = false;
	        }else if (esConfiguracion) {
	            System.out.println("Configuracion: " + new String(ch, start, length));
	            esConfiguracion = false;
	        }
	    }
	}

}
