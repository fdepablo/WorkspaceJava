package _04_basico.vehiculos;

import java.util.Objects;

import _04_basico.interfaz.Movible;

public abstract class VehiculoTerrestre implements Movible{
	private String matricula;
	private double peso;
	private int numeroRuedas;
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public int getNumeroRuedas() {
		return numeroRuedas;
	}
	public void setNumeroRuedas(int numeroRuedas) {
		this.numeroRuedas = numeroRuedas;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehiculoTerrestre other = (VehiculoTerrestre) obj;
		return Objects.equals(matricula, other.matricula);
	}
	
	@Override
	public String toString() {
		return "VehiculoTerrestre [matricula=" + matricula + ", peso=" + peso + ", numeroRuedas=" + numeroRuedas + "]";
	}
	
	
}
