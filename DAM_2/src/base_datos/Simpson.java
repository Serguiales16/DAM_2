package base_datos;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;



public class Simpson {

	private static final String RUTA_XML = "simpson.xml";
	
	// Método para crear el fichero XML
	private static void crearXML() {
		Scanner sc = new Scanner(System.in);
		Scanner sci = new Scanner(System.in);
		int opcion;
		
		File fichero = new File(RUTA_XML);
		if(!fichero.exists()) {
			try {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(fichero);
				
				// Obtener el elemento raíz del documento
				Element rootElement = doc.getDocumentElement();
				
				// Pedir los datos del personaje por teclado
				System.out.println("Introduce el nombre del personaje: ");
				String nombre = sc.nextLine();
				System.out.println("Introduce la edad del personaje: ");
				int edad = sci.nextInt();
				System.out.println("Introduce la ocupación del personaje: ");
				String ocupacion = sc.nextLine();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	
	public static void main(String[] args) {
		
		
	
	}
	
	
}