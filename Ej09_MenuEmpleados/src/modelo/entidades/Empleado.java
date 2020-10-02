package modelo.entidades;

public abstract class Empleado {
	private String nombre;
	private double nomina;
	
	public abstract double calcularSueldo();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNomina() {
		return nomina;
	}

	public void setNomina(double nomina) {
		this.nomina = nomina;
	}
	
	
}
