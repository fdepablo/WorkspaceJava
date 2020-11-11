package persistencia;

import java.util.ArrayList;
import java.util.List;

import entidades.Persona;

//Patron DAO (Data Access Object), objeto que se encarga de hacer las consultas
//a algun motor de persistencia (BBDD, Ficheros, incluso algun otro servicio)
public class DaoPersona {

	//esto lo suyo seria hacer una consulta a la base de datos para obtener las personas
	//pero simulamos una base de datos para simplificar el ejemplo
	public static List<Persona> listaPersonas;
	public static int contador;
	
	static {
		listaPersonas = new ArrayList<Persona>();
		contador = 1;
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
	
	public Persona get(int id) {
		return listaPersonas.get(id);
	}
	
	public List<Persona> list() {
		return listaPersonas;
	}
	
	public void add(Persona p) {
		p.setId(contador++);
		listaPersonas.add(p);
	}
	
	public Persona delete(int id) {
		return listaPersonas.remove(id);
	}
	
	public Persona update(Persona p) {
		Persona pAux = listaPersonas.get(p.getId());
		if(pAux != null) {
			pAux.setNombre(p.getNombre());
			pAux.setApellido(p.getApellido());
			pAux.setEdad(p.getEdad());
		}
		return pAux;
	}
	
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
