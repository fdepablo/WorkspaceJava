package main;

import entidad.Persona;
import persistencia.AccesoRest;

public class MainObtenerPersona {

	public static void main(String[] args) throws Exception {
		AccesoRest daoRest = new AccesoRest();

		Persona p = daoRest.obtenerPersona(2);
		System.out.println(p);
	}

}
