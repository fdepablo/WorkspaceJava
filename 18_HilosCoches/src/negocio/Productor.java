package negocio;

import entidad.Coche;

public class Productor extends Thread{

	public String nombre;
	public Cola cola;
	
	public Productor(String nombre, Cola cola){
		super();
		this.nombre = nombre;
		this.cola = cola;
	}
	
	public void run(){
		GeneradorCoches gc = new GeneradorCoches();
		for(int i = 1;i <= 10;i++){
			Coche coche = gc.generarCoche();
			System.out.println(nombre + " ha producido el coche " + coche);
			cola.addMensaje(coche);
		}
	}

}
