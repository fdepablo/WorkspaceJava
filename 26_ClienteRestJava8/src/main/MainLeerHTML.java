package main;

import java.io.IOException;

import persistencia.AccesoRest;

public class MainLeerHTML {
	
	public static void main(String[] args) throws IOException {
		AccesoRest accesoRest = new AccesoRest();
		
		String respuesta = accesoRest.leerHTML();
		System.out.println("HTML " + respuesta);
	}
}
