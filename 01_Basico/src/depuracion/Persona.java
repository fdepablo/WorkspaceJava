package depuracion;

public class Persona {
	private String nombre;
	private Integer edad;
	private double peso;
	
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
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public boolean esMayorDeEdad() {
		if(edad >= 18) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean tieneMismoNombre(Persona p) {
		if(this.nombre.equals(p.nombre)) {
			return true;
		}else {
			return false;
		}
	}

}
