package main;

import com.google.gson.Gson;

import beans.Persona;

public class JsonToObject {
	public static void main(String[] args) {
		String personaJson = "{'idPersona':5,'nombre':'Montgomery','apellido':'Burns','edad':80}";
		Gson gson = new Gson();
		Persona persona = gson.fromJson(personaJson, Persona.class);
		System.out.println(persona);
	}
}
