package programa;

/**
 * Una vez que creamos una clase deberiamos de probar que TODOS sus 
 * métodos funcionan adecuadamente, excepto los getters y setters que 
 * suelen ser muy sencillos
 * 
 * Para probar los métodos de una clase debemos de, o leer su JavaDoc
 * para entender lo que hace el método, o meternos en el código y 
 * entender lo que hace dicho método
 * 
 * 
 * @author Tony Stark
 * @version 1.5
 *
 */
public class Persona {
	
	//ATRIBUTOS	
	/**
	 * El nombre de la persona
	 */
	private String nombre;
	private int edad;
	
	/**
	 * Posición de la persona en el eje de las X dentro de una matriz
	 */
	private int posicion;
	
	/**
	 * La direccion de la persona asociada
	 * @see Direccion
	 */
	private Direccion direccion;
	
	/**
	 * Constructor por defecto
	 */
	public Persona() {
		super();
	}
	
	/**
	 * Constructor con parametros
	 * 
	 * @param a representa el nombre de la persona
	 * @param b representa la edad de la persona
	 * @param c representa la posicion de la persona
	 */
	public Persona(String a, int b, int c) {
		super();
		nombre = a;
		edad = b;
		posicion = c;
	}
	
	/**
	 * Constructor con el parametro del nombre
	 * 
	 * @param a representa el nombre de la persona
	 */
	public Persona(String a) {
		super();
		nombre = a;
	}
	
	//GETTER Y SETTER
	//Estos metodos no hace falta probarlos y tampoco hace falta
	//hace javadoc	
	
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
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	//setNombre() en cambio si que haría falta probarlo y documentarlo, ya que 
	//lo hemos cambiado
	
	/**
	 * Este método asiganará el nombre pasado por parámetro a la 
	 * propiedad nombre del objeto, pero únicamente cuando el nombre 
	 * pasado tenga más de 3 caracteres. En caso contrario (menor o 
	 * igual que 3 caracteres) se le pondrá el valor de vacio ("")
	 * 
	 * @param nombre representa el nombre a cambiar en el atibuto nombre
	 */
	public void setNombre(String nombre) {
		if(nombre.length() > 3) {
			this.nombre = nombre;
		}else {
			this.nombre = "";
		}
	}
	
	//METODOS
	
	/**
	 * Método que mueve a la persona un número de metros dado, 
	 * aumentando el atributo posición actual en un número 
	 * entero de metros.
	 * 
	 * @param metros representa el número de metros que queremos 
	 * incrementar
	 */
	public void caminar(int metros) {
		this.posicion += metros;
	}
	
	/**
	 * Metodo que copia la persona atributo por atributo a un
	 * nuevo objeto persona
	 * 
	 * @return el objeto con la persona copiada
	 */
	public Persona copiarPersona() {
		Persona p1 = new Persona();
		p1.setNombre(this.nombre);
		p1.setEdad(this.edad);
		p1.setPosicion(this.posicion);
		
		return p1;
	}
	
	/**
	 * Este método compara la edad de la persona que invoca el método, con la
	 * edad de la persona que se pasa por parámetro, devolviendo la referencia
	 * de la persona que sea de mayor edad de las dos
	 * 
	 * @param p persona pasada por parametro
	 * @return this en caso de que esta persona sea 
	 * mayor. p en caso de que el parametro de entrada p sea la mayor. 
	 * En caso de que sean iguales se devuelve el parametro de entrada
	 */
	public Persona personaMayor(Persona p) {
		if(this.edad > p.edad) {
			return this;
		}else {
			return p;
		}
	}
	
	/**
	 * Calcula la distancia de un objeto persona respecto a una 
	 * posición en metros en valor absoluto.
	 * 
	 * @param posicion representa una posición en el eje de las X, es 
	 * la posición con la que voy a comparar la posición de la persona.
	 * No se admiten números negativos.
	 * 
	 * @return la distancia en metros y absoluta de la posición 
	 * respecto al objeto persona. Devolvemos -1 en caso de que el parámetro 
	 * posición que pasamos sea negativo
	 */
	public int calcularDistancia(int posicion) {
		if(posicion < 0) {
			return -1;//error, no se aceptan posiciones negativas
			//Tambien valdría y sería una mejor opción, arrojar 
			//Excepciones
		}
		
		if(posicion < this.posicion) {
			return this.posicion - posicion;
		}else {
			return posicion - this.posicion;
		}
	}

}
