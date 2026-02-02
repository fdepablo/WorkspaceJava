package _08_visibilidades;

//Con las visibilidades establecemos desde donde podemos acceder a
//nuestros atributos y métodos

//En Java tenemos 4 tipos de visibilidades

//1. private -> solo tenemos visiblidad dentro de la propia clase
//2. (default) -> solo tenemos visibilidad dentro de la propia clase
//y de las clases dentro del mismo paquete
//3. protected -> solo tenemos visibilidad dentro de la propia clase
//, de las clases dentro del mismo paquete y de las clases que hereden
//de esta.
//4. public -> tenemos visibilidad en todas las partes de nuestro
//proyecto

//A efectos prácticos los atributos, normalmente, los atributos
//prácticamente siempre se declaran como private, y se crean 
//sus métodos accesores y modificadores (veremos mas adelante)
public class Estudiante {
	private String nombre;
	int edad;
	protected double peso;
	public String dni;
	
	public Estudiante() {
		super();
	}

	public Estudiante(String nombre, int edad, double peso, String dni) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.dni = dni;
	}
	
	//Normalmente si creamos un atributo private tenemos que darle
	//métodos modificadore y accesores publicos. La ventaja es que en los
	//métodos podemos aplicar logica, mientras que en un atributo
	//no.
	//Es super mega hiper importante seguir los convenios de java
	//para estos métodos
	//Los métodos modificadores empiezan por "set" y luego el nombre
	//del atributo
	public void setNombre(String nombre) {
		if(nombre.length() > 2) {
			this.nombre = nombre;
		}
	}
	
	//Para los métodos accesores, empiezan por la palabra "get" y 
	//luego el nombre del atributo
	public String getNombre() {
		if(this.nombre != null) {//envitamos nullpointers
			return "";
		}
		return convertirNombreAMinuscula();
	}
	
	//podemos aplicar visibilidades a métodos
	private String convertirNombreAMinuscula() {
		return this.nombre.toLowerCase();
	}
	
}
