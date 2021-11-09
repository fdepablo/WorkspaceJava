package serviciorest.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import serviciorest.modelo.entidad.Persona;

/**
 * Patron DAO (Data Access Object), objeto que se encarga de hacer las consultas
 * a algun motor de persistencia (BBDD, Ficheros, etc). En este caso vamos a 
 * simular que los datos estan guardados en una BBDD trabajando con una lista
 * de objetos cargada en memoria para simplificar el ejemplo.
 * 
 * Hay que tener en cuenta que para simplificar el ejemplo tambien se ha hecho
 * que el ID con el que se dan de alta las personas en la lista coincide exactamente
 * con la posicion del array que ocupan.
 * 
 * Mediante la anotacion @Component, damos de alta un unico objeto de esta clase
 * dentro del contexto de Spring, su ID sera el nombre de la case en notacion
 * lowerCamelCase
 * 
 */
@Component
public class DaoPersona {

	public List<Persona> listaPersonas;
	public int contador;
	
	/**
	 * Cuando se cree el objeto dentro del contexto de Spring, se ejecutara
	 * su constructor, que creara las personas y las metera en una lista
	 * para que puedan ser consumidas por nuestros clientes
	 */
	public DaoPersona() {
		System.out.println("DaoPersona -> Creando la lista de personas!");
		listaPersonas = new ArrayList<Persona>();
		Persona p1 = new Persona(contador++,"STEVE", "ROGERS", 39);//ID: 0
		Persona p2 = new Persona(contador++,"HARRY", "POTTER", 19);//ID: 1
		Persona p3 = new Persona(contador++,"CHIQUITO", "DE LA CALZADA", 79);//ID: 2
		Persona p4 = new Persona(contador++,"BUD", "SPENCER", 85);//ID:3
		Persona p5 = new Persona(contador++,"HARRY", "CALLAHAN", 87);//ID:4
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		listaPersonas.add(p3);
		listaPersonas.add(p4);
		listaPersonas.add(p5);
	}
	
	/**
	 * Devuelve una persona a partir de su posicion del array
	 * @param posicion la posicion del arrya que buscamos
	 * @return la persona que ocupe en la posicion del array, null en caso de
	 * que no exista o se haya ido fuera de rango del array
	 */
	public Persona get(int posicion) {
		try {
			return listaPersonas.get(posicion);
		} catch (IndexOutOfBoundsException iobe) {
			System.out.println("Persona fuera de rango");
			return null;
		}
	}
	
	/**
	 * Metodo que devuelve toda las personas del array
	 * @return una lista con todas las personas del array
	 */
	public List<Persona> list() {
		return listaPersonas;
	}
	
	/**
	 * Metodo que introduce una persona al final de la lista
	 * @param p la persona que queremos introducir
	 */
	public void add(Persona p) {
		p.setId(contador++);
		listaPersonas.add(p);
	}
	
	/**
	 * Borramos una persona de una posicion del array
	 * @param posicion la posicion a borrar
	 * @return devolvemos la persona que hemos quitado del array, 
	 * o null en caso de que no exista.
	 */
	public Persona delete(int posicion) {
		try {
			return listaPersonas.remove(posicion);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("delete -> Persona fuera de rango");
			return null;
		}
	}
	
	/**
	 * Metodo que modifica una persona de una posicion del array
	 * @param p contiene todos los datos que queremos modificar, pero 
	 * p.getId() contiene la posicion del array que queremos eliminar
	 * @return la persona modificada en caso de que exista, null en caso
	 * contrario
	 */
	public Persona update(Persona p) {
		try {
			Persona pAux = listaPersonas.get(p.getId());
			pAux.setNombre(p.getNombre());
			pAux.setApellidos(p.getApellidos());
			pAux.setEdad(p.getEdad());

			return pAux;
		} catch (IndexOutOfBoundsException iobe) {
			System.out.println("update -> Persona fuera de rango");
			return null;
		}
	}
	
	/**
	 * Metodo que devuelve todas las personas por nombre. Como puede
	 * haber varias personas con el mismo nombre (HARRY) tengo que
	 * devolver una lista con todas las encontradas
	 * @param nombre representa el nombre por el que vamos a hacer la
	 * busqueda
	 * @return una lista con las personas que coincidan en el nombre.
	 * La lista estará vacia en caso de que no hay coincidencias
	 */
	public List<Persona> listByNombre(String nombre){
		List<Persona> listaPersonasAux = new ArrayList<Persona>();
		for(Persona p : listaPersonas) {
			if(p.getNombre().equalsIgnoreCase(nombre)) {//contains()
				listaPersonasAux.add(p);
			}
		}
		return listaPersonasAux;
	}
}
