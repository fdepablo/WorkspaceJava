package main;

//La parte de implements mejor dejarla para cuando se vea interfaces
public class Persona implements Comparable<Persona>{
	private String nombre;
	private int edad;
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + edad;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (edad != other.edad)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	//return entero
	//Si devolvemos un numero negativo, quiere decir
	//que este objeto es menor que el objeto "p"
	//Si devolviesemos 0 quiere decir que son iguales
	//Si devolviesemos un numero positivo, quiere decir
	//que este objeto es mayor que el objeto "p"
	@Override
	public int compareTo(Persona p) {
		return this.edad - p.edad;
		//return this.nombre.compareTo(p.nombre);
	}
	
	
	
}
