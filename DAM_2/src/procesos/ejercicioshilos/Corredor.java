package procesos.ejercicioshilos;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Corredor implements Runnable {

	private String nombre;
	private long tiempoMs;

	public Corredor(String nombre) {
		this.nombre = nombre;
	
	
		
		

	
	
}
	public long getTiempoMs() {
	
	
		return tiempoMs;
		
}

	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public void run() {


		long t0 = System.nanoTime();
		
		for (int i = 0; i<10; i++) {
			
			Random ale = new Random(2000);
			
			int numAleatorio = ale.nextInt();
			int pausa = ThreadLocalRandom.current().nextInt(50, 151);
			
			try {
				
				System.out.println("CHECKPOINT!!");
				Thread.sleep(numAleatorio);
				TimeUnit.MILLISECONDS.sleep(pausa);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		long t1 = System.nanoTime();
		
		tiempoMs = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		
	}
	}
