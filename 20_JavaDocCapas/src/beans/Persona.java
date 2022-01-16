package beans;

//normalmente los javabeans no hace falta comentarlos tanto

/** 
 * 
 * Clase que encapsula la información de las personas. Las personas tendrán un id y
 * un nombre
 * 
 * @author Felix de Pablo
 * @since 26/11/2018
 * @version 1.0
 * 
 *
 */
public class Persona {
	private int id;
	private String nombre;	
	
	/**
	 * Metodo que devuelve el id de una persona
	 * @author Manuel Hernández
	 * @since 27/11/2018
	 * @return el id del la persona
	 */
	public int getId() {
		return id;
	}
	/**
	 * Este metodo sirve para cambiar el id de una persona
	 * @author Felix de pablo
	 * @since 26/11/2018
	 * @param id el id a establecer en la persona
	 */
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + "]";
	}

	
	
}
