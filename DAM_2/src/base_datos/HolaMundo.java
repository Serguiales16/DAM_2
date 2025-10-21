package base_datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HolaMundo {

	public static void main(String[] args) throws IOException {


		System.out.println("Hola mundo");
		
		String ruta = "C:\\Users\\315142\\Downloads\\holaaa.txt";
		
		File fichero = new File(ruta);
		
		
		if (fichero.createNewFile()) {
			
			System.out.println("El fichero NO existe");
			
		} else {
			
			System.out.println("El fichero SI existe");
			Scanner lector = new Scanner(fichero);
			
			 
			int contador = 0;
			
			BufferedWriter writter = new BufferedWriter(new FileWriter(ruta));
			 while (contador <= 100) {
				
			 	writter.write("Hostia, que ha funcionado!!!");
			 	
			 	contador++;
			 }
			 writter.close();
			 
			 while (lector.hasNextLine()) {
	             String linea = lector.nextLine();
	             System.out.println(linea);
	         }
			
		}
		BufferedReader reader = new BufferedReader(new FileReader(fichero));
		String linea;
		System.out.println("Segunda ronda");
		
		while ((linea = reader.readLine()) != null) {
			
			System.out.println(linea);
			
			
		}
		
		reader.close();
		
		
		
	}

}
