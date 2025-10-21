package ejemploXML;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import org.w3c.dom.Document;



public class Practica {
	
	final static String RUTA_XML = "hola.xml";
	
	public static void crearXML() throws InterruptedException, ParserConfigurationException, TransformerException {
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();
		
		Element raiz = doc.createElement("Minecraft");
		doc.appendChild(raiz);
		
		Element jugador = doc.createElement("jugador");
		jugador.setAttribute("nombre", "steve");
		raiz.appendChild(jugador);
		
		Element nivel = doc.createElement("nvl");
		nivel.setTextContent("50");
		jugador.appendChild(nivel);
		
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer trans = tFactory.newTransformer();
		
		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(RUTA_XML));
		
		trans.transform(source, result);
		
		if (result.getOutputStream() != null) {
	        try {
	            result.getOutputStream().close();
	        } catch (java.io.IOException e) {
	            e.printStackTrace();
	        }
	    }
		
		System.out.println("El fichero ha sido creado!!");
		
	}
	
	public static void main(String[] args) throws InterruptedException, ParserConfigurationException, TransformerException {
		
		try {
			crearXML();
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
	}

}
