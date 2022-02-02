package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Persona;

public interface DaoPersona {
	/**
	 * Metodo que da de alta una persona en la BBDD. Se generará el ID de manera
	 * automática.
	 * @param p la persona a dar de alta
	 * @return true en caso de que se haya dado de alta. false en caso de error
	 * con la BBDD.
	 */
	boolean alta(Persona p);
	boolean baja(int id);
	/**
	 * Metodo que modifica una persona en la BBDD. La modificación será a partir
	 * del ID que contenga la persona.
	 * @param p la persona a modificar
	 * @return true en caso de que se haya modificado. False en caso de error
	 * con la BBDD.
	 */
	boolean modificar(Persona p);
	Persona obtener(int id);
	List<Persona> listar();
}
