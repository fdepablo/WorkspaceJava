package modelo.negocio;

import java.util.List;

import modelo.entidad.Persona;
import modelo.persistencia.DaoPersonaDerby;
//import modelo.persistencia.PersonaDaoDerby;
import modelo.persistencia.DaoPersonaMySql;
import modelo.persistencia.interfaces.DaoPersona;

//Aquí irian todas las reglas de negocio de nuestra aplicacion, se aplicarían
//antes de llamar a la BBDD. Por ejemplo si la persona tiene que tener al
//menos un nombre con 3 caracteres 

public class GestorPersona {
	
	//Aquí podemos jugar con cambiar el dao que queremos usar
	//podemos usar PersonaDaoDerby o PersonaDaoMySql
	//Gracias a las interfaces solo tenemos que cambiar el objeto
	private DaoPersona daoPersona = new DaoPersonaMySql();
	
	/**
	 * Método que da de alta una persona en base de datos. El nombre de la persona
	 * debe de tener al menos 3 caracteres.
	 * @param p la persona a dar de alta
	 * @return 0 en caso de que hayamos dado de alta la persona, 1 en caso
	 * de algun error de conexión con la bbdd y 2 en caso de que la persona
	 * tenga menos de 3 caracteres
	 */
	public int alta(Persona p){
		if(p.getNombre().length() >= 3) {
			boolean alta = daoPersona.alta(p);
			if(alta) {
				return 0;
			}else {
				return 1;
			}
		}else {
			return 2;
		}
	}
	
	public boolean baja(int id){
		boolean baja = daoPersona.baja(id);
		return baja;
	}
	
	/**
	 * Método que da modifica una persona en base de datos. El nombre de la persona
	 * debe de tener al menos 3 caracteres. La modificarci�n sera a partir del 
	 * id de la persona
	 * @param p la persona a modificar. Dentro tiene que tener el id
	 * @return 0 en caso de que hayamos modificado la persona, 1 en caso
	 * de algun error de conexi�n con la bbdd y 2 en caso de que la persona
	 * tenga menos de 3 caracteres
	 */
	public int modificar(Persona p){
		//aplicamos la regla de negocio
		if(p.getNombre().length() >= 3) {
			boolean modificada = daoPersona.modificar(p);
			if(modificada) {
				return 0;
			}else {
				return 1;
			}
		}
		return 2;
	}
	
	public Persona obtener(int id){
		Persona persona = daoPersona.obtener(id);
		return persona;
	}
	
	public List<Persona> listar(){
		List<Persona> listaPersonas = daoPersona.listar();
		return listaPersonas;
	}
	
}
