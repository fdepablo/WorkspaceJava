package modelo.entidades;

import java.util.ArrayList;

public class Directivo extends Empleado {

	private ArrayList<Empleado> listaEmpleadosACargo;
	public static final double EXTRA = 100;
	
	@Override
	public double calcularSueldo() {
		double sueldo = getNomina() + 
				(listaEmpleadosACargo.size() * EXTRA);
		return sueldo;
	}

	public ArrayList<Empleado> getListaEmpleadosACargo() {
		return listaEmpleadosACargo;
	}

	public void setListaEmpleadosACargo(ArrayList<Empleado> listaEmpleadosACargo) {
		this.listaEmpleadosACargo = listaEmpleadosACargo;
	}

	@Override
	public String toString() {
		return "Directivo [listaEmpleadosACargo=" + listaEmpleadosACargo + ", getNombre()=" + getNombre()
				+ ", getNomina()=" + getNomina() + "]";
	}

	
}
