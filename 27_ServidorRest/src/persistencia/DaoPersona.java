package persistencia;

import java.util.ArrayList;
import java.util.List;

import entidad.Persona;

//Patron DAO (Data Access Object), objeto que se encarga de hacer las consultas
//a algun motor de persistencia (BBDD, Ficheros, incluso en memoria)
public class DaoPersona {

	//Esto lo suyo seria hacer una consulta a la base de datos para obtener las personas
	//pero simulamos una base de datos para simplificar el ejemplo
	public static List<Persona> listaPersonas;
	public static int contador;
	
	//Un bloque static, es un bloque que se ejecuta una unica vez al comienzo
	//de nuestra aplicacion
	static {
		listaPersonas = new ArrayList<Persona>();
		contador = 0;
		Persona p1 = new Persona(contador++,"RODOLFO", "LANGOSTINO", 39);
		Persona p2 = new Persona(contador++,"HARRY", "POTTER", 19);
		Persona p3 = new Persona(contador++,"CHIQUITO", "DE LA CALZADA", 79);
		Persona p4 = new Persona(contador++,"BUD", "SPENCER", 85);
		Persona p5 = new Persona(contador++,"HARRY", "CALAHAN", 87);
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		listaPersonas.add(p3);
		listaPersonas.add(p4);
		listaPersonas.add(p5);
	}
	
	//Devuelve una persona a partir de su posicion del array
	//lo suyo hubiera sido hacer una busqueda a traves de ID
	//pero para simplificar el ejemplo
	public Persona get(int id) {
		return listaPersonas.get(id);
	}
	
	//Este metodo de aquí devueve toda la lista de las personas
	public List<Persona> list() {
		return listaPersonas;
	}
	
	//Este metodo da de alta una persona en nuestra lista, ojo
	//simulo una base de datos poniendole un ID autoincremental
	public void add(Persona p) {
		p.setId(contador++);
		listaPersonas.add(p);
	}
	
	//Borra una persona por posicion, lo suyo tambien sería que la borrara
	//por el campo ID
	public Persona delete(int id) {
		return listaPersonas.remove(id);
	}
	
	//Modifica una persona a partir de un ID
	public Persona update(Persona p) {
		Persona pAux = listaPersonas.get(p.getId());
		if(pAux != null) {
			pAux.setNombre(p.getNombre());
			pAux.setApellido(p.getApellido());
			pAux.setEdad(p.getEdad());
		}
		return pAux;
	}
	
	//Buscamos una persona por un nombre, lo que pasa es que el nombre
	//se puede repetir, por lo que tengo que devolver una lista de personas
	public List<Persona> getByName(String nombre){
		List<Persona> listaPersonasAux = new ArrayList<Persona>();
		for(Persona p : listaPersonas) {
			if(p.getNombre().equalsIgnoreCase(nombre)) {
				listaPersonasAux.add(p);
			}
		}
		return listaPersonasAux;
	}
}
