package main;

import com.google.gson.Gson;

import beans.Persona;

public class _02_JsonAObjeto {
	public static void main(String[] args) {
		String personaJson = "{'idPersona':5,'nombre':'Montgomery','apellido':'Burns','edad':80}";
		
		//si yo quiero convertir ese string a un objeto java, tendria que empezar a hacer
		//splits, creaciones de objetos, etc.
		
		//mejor utilizar la librería GSON
		Gson gson = new Gson();
		//le pasamos el string que queremos y la clase de la cual queremos que nos cree el objeto
		Persona persona = gson.fromJson(personaJson, Persona.class);
		System.out.println(persona);
	}
}
