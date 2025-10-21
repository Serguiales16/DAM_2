package procesoFacil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

public class Gestor {
	
	
	public static void main(String[] args) throws IOException {
		
		
		String linea = "Buenos dias";
		
		
		ProcessBuilder pb = new ProcessBuilder("java", "-cp", "./bin", "procesoFacil.Proceso");
		
		Process p1 = pb.start();
		
		enviarDatos(p1, linea);
		String respuesta = recibirDatos(p1);
		
		System.out.println(respuesta);
		
	}
	
	
	public static void enviarDatos(Process p, String data) throws IOException {
		
		try(OutputStream os = p.getOutputStream()) {
			
			PrintWriter pw = new PrintWriter(os);
			
			pw.print(data);
			pw.flush();
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("El dato se ha enviado...");
		
	}
	
	
	
	public static String recibirDatos(Process p) {
		
		try(InputStream is = p.getInputStream()) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String linea = br.readLine();
			
			if (!linea.isEmpty()) {
				
				return linea;
				
			} else {
				
				return "No hay datos";
			}
			
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		return "No ha pasado nada";
		
	}

}
