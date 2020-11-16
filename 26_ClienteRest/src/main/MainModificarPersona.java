package main;

import entidad.Persona;
import persistencia.AccesoRest;

public class MainModificarPersona {

	public static void main(String[] args) throws Exception {
		AccesoRest daoRest = new AccesoRest();
		
		Persona p = new Persona();
		p.setNombre("Son");
		p.setEdad(20);
		p.setApellido("Gohan");
	
		Persona pResultado = daoRest.modificarPersona(p,5);
		System.out.println("Persona modificada: " + pResultado);
	}

}
