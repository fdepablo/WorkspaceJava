package main;

import entidades.Coche;
import negocio.GestorCoches;

public class MainModificar {
	public static void main(String[] args) {
		Coche coche = new Coche();
		coche.setId(1);
		coche.setMatricula("MKO-0987");
		coche.setMarca("Peugeot");
		coche.setModelo("308");
		coche.setKilometros(100000);
		
		GestorCoches gc = new GestorCoches();
		
		boolean modificar = gc.modificar(coche);
		if(modificar){
			System.out.println("LA coche se ha modificado");
		}else{
			System.out.println("La coche NO se ha modificado");
		}
	}
}
