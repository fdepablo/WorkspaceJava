package main;

import com.google.gson.Gson;

import beans.Persona;

public class _01_ObjetoAJson {
	public static void main(String[] args) {
		Persona p1 = new Persona();
		p1.setIdPersona(3);
		p1.setNombre("Harry");
		p1.setEdad(18);
		p1.setApellido("Potter");
		
		//Podriamos convertir el json a mano... (estás flipando...)		
		//System.out.println("{\"idpersona\" : " + p1.getIdPersona() + 
		//		",\"nombre\" : " + p1.getEdad());
		
		//Mejor usar la librerias de GSON que hace eso por nosotros
		Gson gson = new Gson();
		String json = gson.toJson(p1);
		System.out.println(json);
	}
}
