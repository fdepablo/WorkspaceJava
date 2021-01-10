package _05_ficheros_objetos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Todos los objetos que queramos guardar en un fichero DEBEN de implemntar la interfaz serializable
//La interfaz serializable es lo que se llama una intermaz de "marcado" y sirve para decirle a
//la JVM que permite salir de la JVM los objetos. 
public class Alumno implements Serializable {

	private static final long serialVersionUID = 7954100877448377269L;
	
	private String nombre;
	private int edad;
	//private transient int edad;//con transient no serializamos este campo, es decir no lo 
								//guardamos en el fichero
	private List<Calificacion> calificaciones;
	
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
	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}
}