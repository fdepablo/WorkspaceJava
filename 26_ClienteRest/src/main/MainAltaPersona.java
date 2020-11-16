package main;

import entidad.Persona;
import persistencia.AccesoRest;

public class MainAltaPersona {

	public static void main(String[] args) throws Exception {
		AccesoRest daoRest = new AccesoRest();
		
		Persona p = new Persona();
		p.setNombre("Son");
		p.setEdad(40);
		p.setApellido("Goku");
	
		Persona pResultado = daoRest.altaPersona(p);
		System.out.println("Persona dada de alta: " + pResultado);
	}

}
