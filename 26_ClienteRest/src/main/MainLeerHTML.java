package main;

import java.io.IOException;

import persistencia.AccesoRest;

public class MainLeerHTML {
	
	public static void main(String[] args) throws IOException {
		AccesoRest daoRest = new AccesoRest();
		
		String respuesta = daoRest.leerHTML();
		System.out.println("HTML " + respuesta);
	}
}
