package procesoFacil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Proceso {
	
	
	public static void main(String[] args) {
		
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			
			String linea = br.readLine();
			
			if (!linea.isEmpty()) {
				
				System.out.println(linea + "Esto es la polla");
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	public static void recibirDatos(Process p) {
		
		try (InputStream is = p.getInputStream()) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String linea;
			
			if ((linea = br.readLine()) != null) {
				
				System.out.println(linea);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
