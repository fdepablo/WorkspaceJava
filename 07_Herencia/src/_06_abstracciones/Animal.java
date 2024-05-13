package _06_abstracciones;

import java.util.Objects;

/*
 * Las clases abstractas son clases que NO se pueden instanciar.
 * 
 * Las utilizaremos para que otras clases hereden de ellas y
 * tambíen podremos usar sus referencias para poder guardar
 * cualquier objeto que extienda de esta clase y además para 
 * aplicar polimorfismo
 * 
 * Una clase abstracta puede tener o no tener métodos abstractos
 * pero en cuento la clase tenga un solo método abstracto la 
 * clase DEBE ser abstracta
 */
public abstract class Animal {
	private Sexo sexo;
	private double peso;
	private int edad;
	private String nombre;
	
	/**
	 * Los métodos abstractos son métodos que sabemos <b>QUE</b> todos los objetos
	 * que hereden de esta clase lo tendrán, pero el <b>COMO</b> lo van a hacer corresponde
	 * a la implementación del método de la clase hija.
	 * 
	 * En este ejemplo, sabemos <b>QUE</b> todos los animales pueden comer pero lamentablemte
	 * todavia NO sabemos <b>COMO</b>, por lo que correpondera en las clases hijas implementar
	 * dicho método
	 * 
	 * A partir de aquí hacemos documentación:
	 * 
	 * Este método hace que el animal gane peso según la comida que reciba por
	 * parámetro
	 * @param o representa el objeto que se va a comer el animal
	 */
	public abstract void comer(Object o);

	//Una clase abstracta puede tener perfectamente método NO abstractos
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Animal [sexo=" + sexo + ", peso=" + peso + ", edad=" + edad + ", nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre, peso, sexo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return edad == other.edad && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso) && sexo == other.sexo;
	}	
}
