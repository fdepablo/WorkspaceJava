package modelo.negocio;

import java.util.List;

import modelo.entidad.Persona;
//import modelo.persistencia.PersonaDaoDerby;
import modelo.persistencia.PersonaDaoMySql;
import modelo.persistencia.interfaces.PersonaDao;

//Aquí irian todas las reglas de negocio de nuestra aplicacion, se aplicarian
//antes de llamar a la BBDD. Por ejemplo si la persona tiene que tener al
//menos un nombre con 3 caracteres 

public class GestorPersona {
	
	//Aqui podemos jugar con cambiar el dao que queremos usar
	//podemos usar PersonaDaoDerby o PersonaDaoMySql
	//Gracias a las interfaces solo tenemos que cambiar el objeto
	PersonaDao personaDao = new PersonaDaoMySql();
	
	public boolean alta(Persona p){
		//aplicamos la regla de negocio
		if(p.getNombre().length() >= 3) {
			boolean alta = personaDao.alta(p);
			return alta;
		}
		return false;
	}
	
	public boolean baja(int id){
		boolean baja = personaDao.baja(id);
		return baja;
	}
	
	public boolean modificar(Persona p){
		//aplicamos la regla de negocio
		if(p.getNombre().length() >= 3) {
			boolean modificada = personaDao.modificar(p);
			return modificada;
		}
		return false;
	}
	
	public Persona obtener(int id){
		Persona persona = personaDao.obtener(id);
		return persona;
	}
	
	public List<Persona> listar(){
		List<Persona> listaPersonas = personaDao.listar();
		return listaPersonas;
	}
	
}
