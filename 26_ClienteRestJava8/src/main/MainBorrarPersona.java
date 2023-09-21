package main;

import entidad.Persona;
import persistencia.AccesoRest;

public class MainBorrarPersona {

	public static void main(String[] args) throws Exception {
		AccesoRest daoRest = new AccesoRest();
		
		Persona p = daoRest.borrarPersonas(3);
		System.out.println("Persona borrada: " + p);
	}

}
