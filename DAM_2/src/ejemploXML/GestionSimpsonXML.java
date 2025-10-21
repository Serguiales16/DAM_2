package ejemploXML;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GestionSimpsonXML {

	private static final String RUTA_XML = "simpson.xml";
	private static Scanner sc = new Scanner(System.in);
	private static Scanner sci = new Scanner(System.in);
	
	
	// Método para crear el fichero XML
	private static void crearXML() {

		File fichero = new File(RUTA_XML);
		if (!fichero.exists()) {
			try {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.newDocument(); // Aquí tengo almacenado el documento XML

				// Crear el elemento raíz del documento
				Element rootElement = doc.createElement("personajes");
				doc.appendChild(rootElement); // Añadimos al documento el elemento raíz "rootElement"

				// Guardar el XML ("transformar" el código de Java en un fichero XML)
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc); // Alamcenamos el documento en sí para transformarlo luego
				StreamResult result = new StreamResult(new File(RUTA_XML)); // Especificamos el destino del fichero
				transformer.transform(source, result); // Pasamos como parámetro el fichero XML y la ruta del destino

				System.out.println("Fichero XML creado correctamente");

			} catch (Exception e) {
				System.out.println("Error al crear el fichero XML: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	// Agregar personajes al documento
	private static void agregarPersonaje() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File(RUTA_XML)); // Accedemos al fichero

			// Obtener el elemento raíz
			Element rootElement = doc.getDocumentElement();

			// Pedir los datos de los personajes
			System.out.println("Introduce el nombre del personaje: ");
			String nombre = sc.nextLine();
			System.out.println("Introduce la edad del personaje: ");
			int edad = sci.nextInt();
			System.out.println("Introduce la ocupación del personaje: ");
			String ocupacion = sc.nextLine();

			// Crear un nuevo elemento "personaje"
			Element personajeElem = doc.createElement("personaje");

			// Añadir los subelementos
			Element nombreElem = doc.createElement("nombre");
			nombreElem.appendChild(doc.createTextNode(nombre));
			personajeElem.appendChild(nombreElem);

			Element edadElem = doc.createElement("edad");
			edadElem.appendChild(doc.createTextNode(String.valueOf(edad))); // "Convetir" el valor de edad a String
			personajeElem.appendChild(edadElem);

			Element ocupacionElem = doc.createElement("ocupacion");
			ocupacionElem.appendChild(doc.createTextNode(ocupacion));
			personajeElem.appendChild(ocupacionElem);
			
			// Añadimos el personaje al elemento raíz (al super padre)
			rootElement.appendChild(personajeElem);
			
			// Guardar el XML ("transformar" el código de Java en un fichero XML)
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc); // Alamcenamos el documento en sí para transformarlo luego
			StreamResult result = new StreamResult(new File(RUTA_XML)); // Especificamos el destino del fichero
			transformer.transform(source, result); // Pasamos como parámetro el fichero XML y la ruta del destino

			System.out.println("Personaje agregado correctamente");

		} catch (Exception e) {
			System.out.println("Error al agregar personaje: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void listarPersonaje() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File(RUTA_XML));
			
			NodeList listaPersonajes = doc.getElementsByTagName("personaje"); // Almaceno en una lista todos los nodos identificados por la etique "personaje"
			
			System.out.println("Lista de Personajes:");
			for (int i = 0; i < listaPersonajes.getLength(); i++) {
				Node nodo = listaPersonajes.item(i); // Almaceno en nodo cada uno de los nodos de la lista de forma individual
				if(nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element personaje = (Element) nodo;
					
					String nombre = personaje.getElementsByTagName("nombre").item(0).getTextContent();
					/* item(0): Tenemos que indicar desde qué nodo queremos empezar a almacenar la información,
					ponemos 0 para indicarle que empiece desde el primer nodo. Si pusiéramos i, en cada iteración
					cogería el siguiente nodo, por lo tanto no mostraría la informaicón correcta */
					String edad = personaje.getElementsByTagName("edad").item(0).getTextContent();
					String ocupacion = personaje.getElementsByTagName("ocupacion").item(0).getTextContent();
					
					System.out.println("Nombre: " + nombre + ", Edad: " + edad + ", Ocupación: " + ocupacion);
				}
			}
		} catch (Exception e) {
			System.out.println("Error al listar los personajes: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	// Buscar personaje por nombre
	private static void buscarPersonaje() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File(RUTA_XML));
			
			System.out.println("Introduce el nombre del personaje a buscar: ");
			String nombreBuscar = sc.nextLine();
			
			NodeList listaPersonajes = doc.getElementsByTagName("personaje");
			boolean encontrado = false;
			
			for (int i = 0; i < listaPersonajes.getLength(); i++) {
				Node nodo = listaPersonajes.item(i);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element personaje = (Element) nodo;
					
					String nombreLista = personaje.getElementsByTagName("nombre").item(0).getTextContent();
					if (nombreLista.equalsIgnoreCase(nombreBuscar)) {
						String edadLista = personaje.getElementsByTagName("edad").item(0).getTextContent();
						String ocupacionLista = personaje.getElementsByTagName("ocupacion").item(0).getTextContent();
						
						System.out.println("Nombre: " + nombreLista + ", Edad: " + edadLista + ", Ocupación: " + ocupacionLista);
						encontrado = true;
						
					}
				}
				
			}
			
			if (!encontrado) {
				System.out.println("Personaje no encontrado");
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Error al buscar personaje: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		int opcion;
		
		crearXML(); // Llamamos al método para crear el fichero XML
		
		// Menú
		do {
			mostrarMenu();
			opcion = sci.nextInt();
			
			switch(opcion) {
				case 1:
					agregarPersonaje();
					break;
				case 2:
					listarPersonaje();
					break;
				case 3:
					buscarPersonaje();
					break;
				default:
					System.out.println("Opción no válida");
					break;
			}
		} while (opcion != 0);
	

	}
	

	private static void mostrarMenu() {
		System.out.println("Menú Simpson");
		System.out.println("1. Agregar Personaje");
		System.out.println("2. Listar Personaje");
		System.out.println("3. Buscar Personaje por Nombre");
		System.out.println("4. Actualizar edad personaje");
		System.out.println("5. Eliminar Personaje");
		System.out.println("0. Salir");
	}

}