package es.curso.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import es.curso.modelo.entidad.CompactDisc;

public class DaoCD {
	
	private static List<CompactDisc> listaCD;
	
	//Los bloques estaticos son bloque de codigo que se ejecutan antes
	//de arrancar cualquier aplicacion
	static {
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
