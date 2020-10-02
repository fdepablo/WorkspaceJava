package main;

import entidades.Coche;
import negocio.GestorCoches;

public class MainAlta {
	public static void main(String[] args) {
		Coche coche = new Coche();
		coche.setMatricula("MSD-4567");
		coche.setMarca("Renault");
		coche.setModelo("Megane");
		coche.setKilometros(123000);
		
		GestorCoches gestorCoches = new GestorCoches();
		boolean alta = gestorCoches.alta(coche);
		if(alta){
			System.out.println("La coche se ha dado de alta");
		}else{
			System.out.println("La coche NO se ha dado de alta");
		}
	}
}
