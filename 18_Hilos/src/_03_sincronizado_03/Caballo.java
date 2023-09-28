package _03_sincronizado_03;

import java.util.concurrent.ThreadLocalRandom;

public class Caballo implements Runnable {
	
	private String nombre;
	private Meta meta;	
	
	public Caballo(String nombre, Meta meta){
		super();
		this.nombre = nombre;
		this.meta = meta;
	}
	
	public String getNombre(){
		return nombre;
	}

	public void run(){
		//Simulamos que el caballo está corriendo
		for(int a = 0; a<=100;a++){
			System.out.println(a + " : " + nombre);
			try {
				//el caballo se va a dormir aleatoriamente entre 1 y 10 milisegundos
				int randomNum = ThreadLocalRandom.current().nextInt(1, 11);
				Thread.sleep(randomNum);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		//Apuntamos al caballo a la meta cuando termine de correr
		meta.apuntarCaballo(this);
	}


}
