package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

import beans.GrupoPersonas;
import beans.Persona;

public class FileToObject {
	public static void main(String[] args) {
		File file = new File("Simpson.txt");
		
		try(FileReader fr = new FileReader(file);
		    BufferedReader br = new BufferedReader(fr)){
			String json = br.readLine();
			Gson gson = new Gson();
			GrupoPersonas grupoPersonas = gson.fromJson(json, GrupoPersonas.class);
			//Persona p = gson.fromJson(json, Persona.class);
			for(Persona p : grupoPersonas.getPersonas()) {
				System.out.println(p);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
