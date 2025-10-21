/**
 * Este es mi gestor de procesos el cual se encargara de lanzar diferentes procesos uno detras de otro.
 * Como luego en los procesos hijos el resultado se imprime por consola, el padre recibe directamente esos datos con la tuberia de entrada
 * @author Serguiales
 */

package gestor_procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;  // Importamos las librerias necesarias
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class GestorProcesos {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Que numero quieres que se calcule el cuadrado?: ");
		int numCuadrado = sc.nextInt();
		
		System.out.println("De que numero quieres sacar el factorial?: ");				// Pedimos todos los parametros de entrada
		int numFactorial = sc.nextInt();
		
		System.out.println("Cual numero primo quieres probar?: ");
		int numPrimo = sc.nextInt();
		
		Process p1 = null;
		
		final String CLASSPATH_ROOT = "./bin";  // Aqui estan los .class compilados. (No me dejaba con la carpeta .src y utilize esta)
		
		try {
			
			System.out.println("Empezando el GESTOR DE PROCESOS!!");
			
			ProcessBuilder pb1 = new ProcessBuilder(					// Iniciamos el primer ProcessBuilder diciendole que utilizaremos java y donde se encuentra el proceso a ejecutar
					"java", 
					"-cp", 
					CLASSPATH_ROOT, 
					"gestor_procesos.externos.Cuadrado"
					);
			p1 = pb1.start();
			System.out.println("Iniciando Cuadrado...");
			escribirEnProceso(p1, String.valueOf(numCuadrado));
			
			leerYMostrarResultado(p1);
			
			int exitCode1 = p1.waitFor();		//Aqui esperamos a que termine el proceso para mantener un orden y evitar que se choquen
			System.out.println("El CUADRADO ha TERMINADO");
			
		} catch (Exception e) {
			
			System.out.println("Ha habido un error");
			
		}
		
		Process p2 = null;
		
		try {
			
			ProcessBuilder pb2 = new ProcessBuilder(
			"java", 
			"-cp", 
			CLASSPATH_ROOT, 
			"gestor_procesos.externos.Factorial");
			p2 = pb2.start();
			System.out.println("Iniciando Factorial...");
			escribirEnProceso(p2, String.valueOf(numFactorial));
			leerYMostrarResultado(p2);
			
			int exitCode2 = p2.waitFor();
			System.out.println("El FACTORIAL ha TERMINADO");
			
		} catch (Exception e) {
			
			System.out.println("Ha ocurrido un error");
		}
		
		Process p3 = null;
		
		try {
			
			ProcessBuilder pb3 = new ProcessBuilder(
			"java", 
			"-cp", 
			CLASSPATH_ROOT, 
			"gestor_procesos.externos.Primo");
			p3 = pb3.start();
			System.out.println("Iniciando Primo...");
			escribirEnProceso(p3, String.valueOf(numPrimo));
			leerYMostrarResultado(p3);
			
			int exitCode3 = p3.waitFor();
			System.out.println("El PRIMO ha TERMINADO");
			
		} catch (Exception e) {
			
			System.out.println("Error " + e);
			
		}

	}
	
	/**
	 * 
	 * @param 
	 * @param Le pasamos el parametro de entrada data
	 * 
	 */
	private static void escribirEnProceso(Process process, String data) {
		
		try (OutputStream os = process.getOutputStream();   //Aqui abrimos una especie de tuberia que ira hacia afuera
			PrintWriter writer = new PrintWriter(os)) {
			
			writer.println(data);   //Mandamos la infomacion y cerramos la tuberia
			writer.flush();
			
		} catch (IOException e) {
			
			
		}
		
	}
	
	/**
	 * 
	 * @param Le pasamos un proceso Process
	 * 
	 */
	private static void leerYMostrarResultado(Process process) {
		
		try (InputStream is = process.getInputStream();			//Ahora abrimos una tuberia por la cual recibiremos informacion de fuera(Estara a la escucha)
			BufferedReader br = new BufferedReader(new InputStreamReader(is))) {  //Con esto podremos leer la informacion que viene de fuera
			
			
			String linea;
			
			while ((linea = br.readLine()) != null) {  //Aqui podremos pasar la informacion entrante de datos en memoria a texto que podemos leer
				
				System.out.println(linea);
				
			}
			
		} catch (IOException e) {
			
			System.out.println("ERROR " + e);
		}
		
	}

}
