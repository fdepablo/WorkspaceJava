package _05_casting;

import java.util.Objects;

/**
 * Todas las clases en JAVA heredan de la clase Object, por lo tanto 
 * todas las clases van a heredar sus métodos.
 * https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html
 * 
 */
public class Persona extends Object{//poner esto no importa, lo pongamos o no
									//la clase hereda de Object
	private String nombre;
	private int edad;
	
	public void presentarse() {
		System.out.println("Hola soy una Persona y me llamo: " + nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}

	/**
	 * Para hacer que dos objetos sean iguales en las condiciones que queramos
	 * debemos de sobrescribir los métodos "equals" y "hascode".
	 * El método "equals" de la clase object por defecto comparar
	 * si las dos referencias apuntan al mismo objeto, es decir, funciona
	 * exactamente igual que el operador "==".
	 * Cuando sobrescribimos el método "equals" decimos que atributos
	 * tienen que ser iguales para que los dos objetos se consideren
	 * iguales
	 * 
	 * Boton derecho -> source -> Generate hashCode() and equals()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre);
	}

	//En este caso hemos elegido que dos objetos son iguales
	//cuando su nombre y su edad tengan el mismo valor
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;//castear la refencia a tipo persona
		return edad == other.edad && Objects.equals(nombre, other.nombre);
	}
	
	
}
