package _07_relaciones;

//Esta clase tendra como atributos los valores que queriamos
//poner si fuera una cadena
public class Direccion {
	String tipoVia;
	String nombreVia;
	String ciudad;
	String cp;
	
	@Override
	public String toString() {
		return "Direccion [tipoVia=" + tipoVia + ", nombreVia=" + nombreVia + ", ciudad=" + ciudad + ", cp=" + cp + "]";
	}
	
	
}
