package negocio;

import java.util.ArrayList;
import java.util.List;

import entidades.Autor;

public class GestorAutores {
	List<Autor> listaAutores = new ArrayList<>();
	
	public void cargarListaAutores(){
		Autor autor = new Autor();
		autor.setNombre("Pablo");
		autor.setApellido("Neruda");
		
		listaAutores.add(autor);
		
		autor = new Autor();
		autor.setNombre("Matilde");
		autor.setApellido("Asensi");
		
		listaAutores.add(autor);
		
		autor = new Autor();
		autor.setNombre("Miguel");
		autor.setApellido("de Cervantes");
		
		listaAutores.add(autor);
		
		autor = new Autor();
		autor.setNombre("Belen");
		autor.setApellido("Esteban");
		
		listaAutores.add(autor);
	}
	
	public List<Autor> getListaAutores(){
		return listaAutores;
	}
}
