package main;

import negocio.GestorCoches;

public class MainBaja {
	public static void main(String[] args) {
		GestorCoches gc = new GestorCoches();
		
		boolean baja = gc.baja(3);
		if(baja){
			System.out.println("La coche se ha dado de baja");
		}else{
			System.out.println("La coche NO se ha dado de baja");
		}
	}
}
