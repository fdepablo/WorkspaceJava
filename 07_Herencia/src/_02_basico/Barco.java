package _02_basico;

public class Barco extends Vehiculo{
	private boolean esPirata;

	public boolean isEsPirata() {
		return esPirata;
	}

	public void setEsPirata(boolean esPirata) {
		this.esPirata = esPirata;
	}

	@Override
	public String toString() {
		return "Barco [esPirata=" + esPirata + ", getMarca()=" + getMarca() + ", getPeso()=" + getPeso()
				+ ", getVelocidad()=" + getVelocidad() + ", getFechaFabricacion()=" + getFechaFabricacion() + "]";
	}
	
	/*
	 * Como la clase barco tiene atributos especificos, vamos a sobrescribir
	 * el método toString() para que nos muestre dichos atributos
	 */

	
}
