package _06_ficheros_array_objetos;

import java.io.Serializable;

public class Persona implements Serializable{
	
	private static final long serialVersionUID = -4213427856846111419L;
	
	private String dni;
	private int edad;
	private double peso;
	
	//Si ponemos algun atributo como 'transient'
	//no se serializara (no se copiará al fichero)
	//transient private double peso;
	//private double peso;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", edad=" + edad + ", peso=" + peso + "]";
	}
	
	
}
