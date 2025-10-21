package procesos.ejercicioshilos;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class CarreraMain {

public static void main(String[] args)throws InterruptedException {
		
		Corredor tortuga = new Corredor("Tortuga");
		Corredor liebre = new Corredor("Liebre");
		
		Thread t1 = new Thread(tortuga);
		Thread t2 = new Thread(liebre);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		List<Corredor> lista = new ArrayList<>();
		lista.add(tortuga);
		lista.add(liebre);
		
		lista.sort(Comparator.comparingLong(Corredor::getTiempoMs));
		
		 System.out.printf("Tiempo: Tortuga=%d, Liebre=%d%n", tortuga.getTiempoMs(), liebre.getTiempoMs());
		
		System.out.println("Orden de llegada");
		
		for (int i = 0; i < lista.size(); i++) {
			
			 System.out.printf("%d) %s (Tiempo: %d ms)%n",
                     i + 1, 
                     lista.get(i).getNombre(), 
                     lista.get(i).getTiempoMs());
			
		}
	}



}
