package procesos.clase.clase1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {


		Corredor rata = new Corredor("rata");
		Corredor pato = new Corredor("pato");
		
		Thread t1 = new Thread(rata);
		Thread t2 = new Thread(pato);
		
		
		t1.start();
		t2.start();
		
		
		
		t1.join();
		t1.join();
		
		
		
		List<Corredor> lista = new ArrayList<Corredor>();
		lista.add(pato);
		lista.add(rata);
		
		

	}

}
