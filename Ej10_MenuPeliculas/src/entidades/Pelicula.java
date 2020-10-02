package entidades;

import java.util.ArrayList;

public class Pelicula {
	private int id;
	private String titulo;
	private String genero;
	private ArrayList<Actor> listaActores;
	private static int contador = 0;
	
	public Pelicula(){
		this.id = contador++;
	}
	
	public int getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public ArrayList<Actor> getListaActores() {
		return listaActores;
	}
	public void setListaActores(ArrayList<Actor> listaActores) {
		this.listaActores = listaActores;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", listaActores=" + listaActores
				+ "]";
	}
	
	
}
