package entidades;

import interfaces.Movible;

public class Persona implements Movible{
	private String nombre;
	private int capacidadMovimiento;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void moverseLento() {
		System.out.println("Soy la persona " + nombre + " y me muevo "
				+ capacidadMovimiento + " metros");
		
	}

	@Override
	public void moverseRapido() {
		System.out.println("Soy la persona " + nombre + " y me muevo "
				+ (capacidadMovimiento * 2) + " metros");
		
	}

	public int getCapacidadMovimiento() {
		return capacidadMovimiento;
	}

	public void setCapacidadMovimiento(int capacidadMovimiento) {
		this.capacidadMovimiento = capacidadMovimiento;
	}

	
}
