package entidad;

import java.util.ArrayList;

public class Equipo {
	private String nombre;
	
	//Agregacion
	//Implica una dependencia debil con la clase agregada. 
	//Dicho de otra manera, el ciclo de vida del objeto agregado NO DEPENDE 
	//del objeto que lo agrega. Es decir, el ciclo de vida de cada objeto 
	//es independiente
	
	//Se diferencia con la composicion en que el NEW no se hace aqui
	//tendrá que venir injectado de otra clase
	private ArrayList<Jugador> listaJugadores;
	
	public Equipo() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Jugador> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}
	
	
}
