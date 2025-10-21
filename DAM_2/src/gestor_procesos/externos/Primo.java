/**
 * @author Serguiales
 */

package gestor_procesos.externos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Primo {
	
	/**
	 * @param num
	 * @return TRUE si es primo | FALSE si no es primo
	 */
	public static boolean esPrimo(int num) {
		
		if (num <= 1) {
			
			return false;
			
		}
		
		for (int a = 2; a * a <= a; a++) {
			
			if (num % a == 0) {
				
				return false;
				
			}
			
		}
		return true;
	}

	public static void main(String[] args) {


		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			
			String resultado = "";
			String linea = br.readLine();
			int numero = 0;
			
			if (linea != null ) {
				
				numero = Integer.parseInt(linea);
				
				if (esPrimo(numero)) {
					
					resultado = "El numero es primo";				//Recibimos los parametros, los pasamos a un formato legible y los usamos para calcular
																	//Luego los resultados se mandan de vuelta
					
				} else {
					
					resultado = "el numero NO es primo";
				}
				
			}
			
			System.out.println("El numero " + numero + " -- " + resultado);
			
   		} catch (Exception e) {
			System.out.println("Errorrr");
		}
 
	}

}
