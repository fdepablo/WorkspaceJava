package modelo.negocio;

import java.util.List;

import modelo.entidad.Persona;
import modelo.persistencia.DaoPersona;

//dentro de esta capa irian nuestras reglas de negocio
public class GestorPersona {
	
	//vamos a meter alguna regla de negocio, supongamos que me dice
	//que el nombre de la persona tiene que tener al menos 3 carateres
	//y la edad debe de ser al menos de 18
	/**
	 * Metodo que da de alta una persona
	 * @param p la persona a dar de alta
	 * @return -1 en caso de que el nombre sea menor de 3 caracteres, -2 en caso
	 * de que la edad sea menor que 18, 0 en caso de error con la bbdd
	 * y un numero positivo que representa el id en caso de que se haya dado de 
	 * alta
	 */
	public int alta(Persona p) {
		//esto serian reglas de negocio
		if(p.getNombre().length() < 3) {
			return -1;
		}
		
		if(p.getEdad() < 18) {
			return -2;
		}
		
		//si llegamos a este punto, debemos de comunicarnos con la capa DAO
		DaoPersona daoPersona = new DaoPersona();
		int id = daoPersona.insertar(p);
		return id;
	}
	
	public List<Persona> listar(){
		//aqui podriamos poner reglas de negocio
		DaoPersona daoPersona = new DaoPersona();
		return daoPersona.listar();
	}
}
