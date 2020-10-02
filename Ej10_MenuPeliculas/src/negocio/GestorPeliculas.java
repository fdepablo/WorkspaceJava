package negocio;

import java.util.ArrayList;

import entidades.Pelicula;


public class GestorPeliculas {
	private ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
	
	public void alta(Pelicula e){
		listaPeliculas.add(e);
	}
	
	public void baja(int id){
		Pelicula peliculaEncontrada = null;
		for(Pelicula pelicula : listaPeliculas){
			if(pelicula.getId() == id){
				peliculaEncontrada = pelicula;
			}
		}
		if(peliculaEncontrada != null){
			listaPeliculas.remove(peliculaEncontrada);
		}
	}

	public ArrayList<Pelicula> getListaEmpleados() {
		return listaPeliculas;
	}

}
