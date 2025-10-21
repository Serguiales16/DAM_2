package procesos.clase.procesos;

import java.util.Scanner;

public class ProcesoA {
	
public static void main(String[] args) {
		
		
		if (args.length != 1) {
			
			System.out.println("ERRORR");
			return;
		}
		
		boolean sum = args[0].equalsIgnoreCase("SUM");
		boolean mul = args[0].equalsIgnoreCase("MUL");
		
		if (!sum && !mul) {
			
			System.out.println("ERRROR algo no cuadra");
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			
			String linea = sc.nextLine().trim();
			
			if (linea.equalsIgnoreCase("FIN")) break;
				
				
			
			
			if (linea.isEmpty()) continue;
			
			
			String[] partes = linea.split("\\s+");
			
			if(partes.length !=2) {
				
				System.out.println("Errror"); 
				continue;
			}
			
			int a = Integer.parseInt(partes[0]);
			int b = Integer.parseInt(partes[1]);
			
			long res = sum ? (long) a+b : (long) a*b;
			
			System.out.println(res);
			
			
		}
		sc.close();
	}

}
