package main;

import entidad.Persona;
import persistencia.AccesoRest;

public class MainModificarPersona {

	public static void main(String[] args) throws Exception {
		AccesoRest accesoRest = new AccesoRest();
		
		Persona p = new Persona();
		p.setNombre("Son");
		p.setEdad(20);
		p.setApellido("Gohan");
	
		Persona pResultado = accesoRest.modificarPersona(p,3);
		System.out.println("Persona modificada: " + pResultado);
	}

}
