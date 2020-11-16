package main;

import persistencia.AccesoRest;

public class MainBorrarPersona {

	public static void main(String[] args) throws Exception {
		AccesoRest daoRest = new AccesoRest();
		
		int id = daoRest.borrarPersonas(2);
		System.out.println("Id borrado: " + id);
	}

}
