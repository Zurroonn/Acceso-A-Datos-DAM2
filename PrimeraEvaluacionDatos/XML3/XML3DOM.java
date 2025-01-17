package XML3;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XML3DOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			DocumentBuilderFactory factoria=  DocumentBuilderFactory.newInstance();
			DocumentBuilder builder= factoria.newDocumentBuilder();
			Document doc= builder.newDocument();
			Element rootElement = doc.createElement("empleados");
			doc.appendChild(rootElement);
			Element empleado = doc.createElement("empleado");
			empleado.setAttribute("id","1");
			rootElement.appendChild(empleado);
			Element nombre = doc.createElement("nombre");
			nombre.appendChild(doc.createTextNode("Juan Perez"));
			empleado.appendChild(nombre);
			Element apellido = doc.createElement("apellido");
			apellido.appendChild(doc.createTextNode("Zurron"));
			nombre.appendChild(apellido);
			Element departamento = doc.createElement("departamento");
			departamento.appendChild(doc.createTextNode("IT"));
			empleado.appendChild(departamento);
			Element salario = doc.createElement("salario");
			salario.appendChild(doc.createTextNode("5000"));
			empleado.appendChild(salario);
			Element empleado2 = doc.createElement("empleado");
			empleado2.setAttribute("id","2");
			rootElement.appendChild(empleado2);
			Element nombre2 = doc.createElement("nombre");
			nombre2.appendChild(doc.createTextNode("Ana Garcia"));
			empleado2.appendChild(nombre2);
			Element departamento2 = doc.createElement("departamento");
			departamento2.appendChild(doc.createTextNode("HR"));
			empleado2.appendChild(departamento2);
			Element salario2 = doc.createElement("salario");
			salario2.appendChild(doc.createTextNode("4500"));
			empleado2.appendChild(salario2);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("empleados.xml"));
		    transformer.transform(source, result);
		    System.out.println("Archivo XML guardado como empleados.xml");

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}

}
