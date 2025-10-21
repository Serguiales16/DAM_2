package procesos.clase.clase1;

import java.util.Random;

public class Corredor implements Runnable {

	private String nombre;
	private long tiempoMs;
	
	
	
	
	public Corredor(String nombre) {
		
		this.nombre = nombre;
		
	}
	
	




	public String getNombre() {
		return nombre;
	}










	public long getTiempoMs() {
		return tiempoMs;
	}










	public void run() {
		
		Random ale = new Random();
		
		long inicio = System.currentTimeMillis();
		
		for (int a = 0; a < 10; a++) {
			
			try {
				
				int aleatorio = ale.nextInt(1000);
				
				Thread.sleep(aleatorio);
				System.out.println(nombre + " ha pasado el tramo n1" + a);
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			long fin = System.currentTimeMillis();
			long tiempoTotal = fin - inicio;
			
			tiempoMs = tiempoTotal;
		}
		
	}
}
