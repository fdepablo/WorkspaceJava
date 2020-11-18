package main;

import entidad.Persona;
import persistencia.AccesoRest;

public class MainObtenerPersona {

	public static void main(String[] args) throws Exception {
		AccesoRest accesoRest = new AccesoRest();

		Persona p = accesoRest.obtenerPersona(2);
		System.out.println(p);
	}

}
