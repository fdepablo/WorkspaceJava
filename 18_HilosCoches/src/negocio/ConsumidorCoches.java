package negocio;

import entidad.Coche;

public class ConsumidorCoches extends Thread{

	public String nombre;
	public Cola cola;
	
	public ConsumidorCoches(String nombre, Cola cola){
		super();
		this.nombre = nombre;
		this.cola = cola;
	}
	
	public void run(){
		for(int i = 1;i <= 10;i++){
			Coche coche = cola.getMensaje();
			System.out.println(nombre + " ha consumido el mensaje: " + coche);
		}
	}

}
