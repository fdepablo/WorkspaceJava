package es.curso.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import es.curso.modelo.entidad.CompactDisc;

public class DaoCD {
	
	private static List<CompactDisc> listaCD;
	
	//Los bloques estáticos son bloques de código que se ejecutan 
	//la primera vez que se invoca a un objeto de la clase
	//y no se vuelve a ejecutar más durante todo el programa
	static {
		System.out.println("Inicializando bloque static");
		listaCD = new ArrayList<CompactDisc>();
		
		CompactDisc cd = new CompactDisc();
		cd.setArtista("Bob Dylan");
		cd.setTitulo("Empire Burlesque");
		cd.setCiudad("USA");
		
		listaCD.add(cd);
		
		cd = new CompactDisc();
		cd.setArtista("Bonnie Tyler");
		cd.setTitulo("Hide your heart");
		cd.setCiudad("UK");
		
		listaCD.add(cd);
		
		cd = new CompactDisc();
		cd.setArtista("Dolly Parton");
		cd.setTitulo("Greatest Hits");
		cd.setCiudad("USA");
		
		listaCD.add(cd);
	}
	
	public List<CompactDisc> listar(){
		return listaCD;
	}
	
	public boolean add(CompactDisc cd){
		return listaCD.add(cd);
	}
}
