package procesos.clase.procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;





public class Gestor {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		String[] datos = {"3 5", "10 2", "-5 9", "FIN"};
		
		try {
			
			Process sum = new ProcessBuilder("java", "-cp", ".", "procesos.clase.procesos.ProcesoA", "SUM").start();
			Process mul = new ProcessBuilder("java", "-cp", ".", "procesos.clase.procesos.ProcesoA", "MUL").start();
			
			PrintWriter w1 = new PrintWriter(new OutputStreamWriter(sum.getOutputStream()));
			for(String s: datos) w1.println(s);
			w1.close();
			PrintWriter w2 = new PrintWriter(new OutputStreamWriter(mul.getOutputStream()));
			for(String s: datos) w2.println(s);
			w2.close();

			System.out.println("Resultadod de la suma ");
			
			BufferedReader r1 = new BufferedReader(new InputStreamReader(sum.getInputStream()));
			
			String linea;
			
			while ((linea = r1.readLine()) != null)  {
				
				System.out.println(linea);
				r1.close();
				
				
			}
			
			int exitcode1 = sum.waitFor();
			System.out.println("Resultado de la multi  ");
			
			BufferedReader r2 = new BufferedReader(new InputStreamReader(mul.getInputStream()));
			
			String linea2;
			
			while ((linea2 = r2.readLine()) != null) {
				
				
				System.out.println(linea2);
				r2.close();
				
			}
			
			int exitcode = mul.waitFor();
			
			System.out.println(exitcode + " " + exitcode1);
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
		
		
	}

}
