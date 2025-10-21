/**
 * @author Serguiales
 */

package gestor_procesos.externos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Factorial {
	
	/**
	 * 
	 * @param num
	 * @return factorial de dicho numero
	 */
	public static double calcularFactorial(int num) {
		
		double resultado = 1;
		
		
		for (int a = 1; a <= num; a++) {
			
			resultado *= a;
			
			
		}
		return resultado;
		
	}
	
	public static void main(String[] args) {
		
		double resultado = 0;
		int numero = 0;
		String resultadoS = "";
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			
			String linea = br.readLine();
			
			if (linea != null) {									//Recibimos los parametros, los pasamos a un formato legible y los usamos para calcular
																	//Luego los resultados se mandan de vuelta
				numero = Integer.parseInt(linea.trim());
				
			}
			
			resultado = calcularFactorial(numero);
			resultadoS = String.valueOf(resultado);
			
			System.out.println("El FACTORIAL de " + numero + " es " + resultadoS);
			
			
		} catch (Exception e) {
			System.out.println("Ha habido un error");
		}
		
	}

}
