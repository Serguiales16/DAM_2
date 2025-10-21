/**
 * @author Serguiales
 */

package gestor_procesos.externos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cuadrado {

	public static void main(String[] args) {


		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) { //Recibimos los parametros a traves de la tuberia
			
			String linea = br.readLine(); //Los pasamos a texto legible
			
			if (linea != null && !linea.trim().isEmpty()) {
				
				int numero = Integer.parseInt(linea.trim()); //Mientras siga recibeindo parametros los ira pasando de texto a integro para hacer los calculos
				
				if (numero >= 1) {
					
					double resultado = numero * numero;
					
					System.out.println("El numero es " + numero + " y el cuadrado es " + resultado);
					
				} else {
					
					System.out.println("El lado del cuadrado no es valido!!");
					
				}
				
				
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio un error " + e);
		}

	}

}
