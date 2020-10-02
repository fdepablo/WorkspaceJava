package modelo.entidades;

public class Jefe extends Empleado{

	private double incentivo;
	
	@Override
	public double calcularSueldo() {
		return getNomina() + getIncentivo();
	}

	public double getIncentivo() {
		return incentivo;
	}

	public void setIncentivo(double incentivo) {
		this.incentivo = incentivo;
	}

	@Override
	public String toString() {
		return "Jefe [incentivo=" + incentivo + ", getNombre()=" + getNombre() + ", getNomina()=" + getNomina() + "]";
	}

	
}
