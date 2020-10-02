package entidades;

public class Trabajador extends Empleado {

	@Override
	public double calcularSueldo() {
		return getNomina();
	}

	@Override
	public String toString() {
		return "Trabajador [getNombre()=" + getNombre() + ", getNomina()=" + getNomina() + "]";
	}

	
}
