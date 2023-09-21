package main;

import java.util.List;

import entidad.Persona;
import persistencia.AccesoRest;

public class MainListarPersonas {

	public static void main(String[] args) throws Exception {
		AccesoRest daoRest = new AccesoRest();
		
		System.out.println("Listado de personas");
		System.out.println("-------------------");
		
		List<Persona> listaPersonas = daoRest.listarPersonas(null);
		System.out.println(listaPersonas);

		
		System.out.println("Listado de personas con nombre");
		System.out.println("------------------------------");
		listaPersonas = daoRest.listarPersonas("HARRY");
		System.out.println(listaPersonas);
	}

}
