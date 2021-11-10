package modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Libro;

public class DaoLibro {
	private List<Libro> listaLibros;

	public List<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(List<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	
	public Libro buscarPorIsbn(String isbn) {
		Libro libro = null;
		
		for(Libro l : listaLibros) {
			if(l.getISBN().equalsIgnoreCase(isbn)) {
				libro = l;
				break;
			}
		}
		
		return libro;
	}
	
	public Libro buscarPorTitulo(String titulo) {
		Libro libro = null;
		
		for(Libro l : listaLibros) {
			if(l.getTitulo().equalsIgnoreCase(titulo)) {
				libro = l;
				break;
			}
		}
		
		return libro;
	}
	
	public List<Libro> buscarPorAutor(String autor) {
		List<Libro> listaLibros = new ArrayList<Libro>();
		
		for(Libro l : this.listaLibros) {
			if(l.getAutor().equalsIgnoreCase(autor)) {
				listaLibros.add(l);
			}
		}
		
		return listaLibros;
	}
	
	public synchronized boolean addLibro(Libro l) {
		return listaLibros.add(l);
	}
}
