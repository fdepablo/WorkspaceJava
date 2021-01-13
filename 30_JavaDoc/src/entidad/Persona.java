package entidad;

/**
 * 
 * Esta clase representaria una persona con sus atributos y metodos. Esta clase
 * esta destinada a almacenar objetos persona que creen los usuario
 * 
 * @author Felix de Pablo Lobo
 * @version 1.0
 *
 */
public class Persona {
	/**
	 * Este atributo representa el nombre de la persona
	 */
	public String nombre;
	
	/**
	 * Representa la direccion de la persona que es un objeto de tipo Direccion
	 * 
	 * esto sera un enlace a la clase Direccion cuando se genere la documentacion
	 * @see Direccion
	 */
	public Direccion direccion;
	
	/**
	 * La fecha de nacimiento de la persona con formato dd/mm/yyyy
	 */
	public String fechaNacimiento;
}
