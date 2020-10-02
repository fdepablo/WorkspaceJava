package _05_ficheros_objetos;
import java.io.Serializable;
import java.util.ArrayList;

public class Alumno implements Serializable {
	private static final long serialVersionUID = 4854486451470258537L;

	private String nombre;
	private int edad;
	//private transient int edad;//con transient no serializamos este campo, es decir no lo 
								//guardamos en el fichero
	private ArrayList<Calificacion> calificaciones;
	
	public Alumno(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
		this.calificaciones = new ArrayList<Calificacion>();
	}
	
	public void calificar(String asignatura, int nota) {
		this.calificaciones.add(new Calificacion(asignatura, nota));
	}

	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}
}