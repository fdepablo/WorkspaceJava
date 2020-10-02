package negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entidades.Autor;
import entidades.Libro;

public class GestorLibros {
	
	List<Libro> listaLibros = new ArrayList<>();
	
	public void alta(Libro libro){
		listaLibros.add(libro);
	}
	
	public void baja(Libro libro){
		listaLibros.remove(libro);
	}
	
	public List<Libro> getListaLibros(){
		return listaLibros;
	}
	
	public Libro buscarPorTitulo(String titulo){
		Libro libro = null;
		for(Libro l : listaLibros){
			if(l.getTitulo().equals(titulo)){
				libro = l;
			}
		}
		return libro;
	}
	
	public List<Libro> buscarPorAutor(Autor autor){
		List<Libro> listaLibrosEncontrados = new ArrayList<>();
		
		for(Libro l : listaLibros){
			if(l.getAutor().equals(autor)){
				listaLibrosEncontrados.add(l);
			}
		}
		
		return listaLibrosEncontrados;
	}
	
	public List<Libro> ordenarLibros(){
		Collections.sort(listaLibros);
		return listaLibros;
	}
}
