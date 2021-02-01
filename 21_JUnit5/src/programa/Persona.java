package programa;

//Una vez que creamos una clase deberiamos de probar que TODOS sus metodos funcionan
//adecuadamente (excepto los getters y setters que son muy sencillos)
public class Persona {
	
	//ATRIBUTOS	
	private String nombre;
	private int edad;
	/**
	 * Posicion en el eje de las X
	 */
	private int posicion;
	
	//GETTER Y SETTER
	//Estos metodos no hace falta probarlos
	public String getNombre() {
		return nombre;
	}
	
	//Este en cambio si haría falta, ya que lo hemos cambiado
	public void setNombre(String nombre) {
		if(nombre.length() >= 3)
			this.nombre = nombre;
		else
			this.nombre = "";
	}
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
		
	//METODOS
	
	public void caminar(int metros) {
		this.posicion += metros;
	}
	
	public Persona copiarPersona() {
		Persona p1 = new Persona();
		p1.setNombre(this.nombre);
		p1.setEdad(this.edad);
		p1.setPosicion(this.posicion);
		
		return p1;
	}
	
	public Persona personaMayor(Persona p) {
		if(this.edad > p.edad) {
			return this;
		}else {
			return p;
		}
	}
	
	public int calcularDistancia(int posicion) {
		if(posicion < 0) {
			return -1;//error, no se aceptan posiciones negativas
		}
		
		if(posicion < this.posicion) {
			return this.posicion - posicion;
		}else {
			return posicion - this.posicion;
		}
	}
}
