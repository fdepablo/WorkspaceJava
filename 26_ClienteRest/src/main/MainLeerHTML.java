package main;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import persistencia.DaoRest;

public class MainLeerHTML {
	
	public static void main(String[] args) throws IOException {
		DaoRest daoRest = new DaoRest();
		
		String respuesta = daoRest.leerHTML();
		System.out.println("HTML " + respuesta);
	}
}
