package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import beans.Persona;

public class _04_FicheroJsonAListaObjetos {
	public static void main(String[] args) {
		File file = new File("simpson.json");
		
		try(FileReader fr = new FileReader(file);
		    BufferedReader br = new BufferedReader(fr)){
			String json = br.readLine();
			Gson gson = new Gson();
			List<Persona> grupoPersonas = gson.fromJson(json, new TypeToken<List<Persona>>(){}.getType());
			//Persona p = gson.fromJson(json, Persona.class);
			for(Persona p : grupoPersonas) {
				System.out.println(p);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
