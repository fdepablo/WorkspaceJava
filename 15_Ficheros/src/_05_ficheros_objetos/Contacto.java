package _05_ficheros_objetos;
import java.io.Serializable;

public class Contacto implements Serializable {
	private static final long serialVersionUID = -4624046047796483183L;
	
	private String nombre;
	private String telefono;
	
	public Contacto(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}
	public String getTelefono() {
		return telefono;
	}

	@Override
	public String toString() {
		return "Contacto [" + nombre + " - " + telefono + "]";
	}
}