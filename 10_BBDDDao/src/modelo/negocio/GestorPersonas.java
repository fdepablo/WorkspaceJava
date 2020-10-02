package modelo.negocio;

import java.util.List;

import modelo.entidad.Persona;
import modelo.persistencia.PersonaDaoDerby;
import modelo.persistencia.PersonaDaoMySql;
import modelo.persistencia.interfaces.PersonaDao;

public class GestorPersonas {
	
	//aqui podemos jugar con cambiar el dao que queremos usar
	//podemos usar PersonaDaoDerby o PersonaDaoMySql
	//Gracias a las interfaces solo tenemos que cambiar el objeto
	PersonaDao personaDao = new PersonaDaoMySql();
	
	public boolean alta(Persona p){
		//PersonaDao personaDao = new PersonaDaoMySql();
		boolean alta = personaDao.alta(p);
		return alta;
	}
	
	public boolean baja(int id){
		//PersonaDao personaDao = new PersonaDaoMySql();
		boolean baja = personaDao.baja(id);
		return baja;
	}
	
	public boolean modificar(Persona p){
		//PersonaDao personaDao = new PersonaDaoMySql();
		boolean modificar = personaDao.modificar(p);
		return modificar;
	}
	
	public Persona obtener(int id){
		//PersonaDao personaDao = new PersonaDaoMySql();
		Persona persona = personaDao.obtener(id);
		return persona;
	}
	
	public List<Persona> listar(){
		//PersonaDao personaDao = new PersonaDaoMySql();
		List<Persona> listaPersonas = personaDao.listar();
		return listaPersonas;
	}
	
}
