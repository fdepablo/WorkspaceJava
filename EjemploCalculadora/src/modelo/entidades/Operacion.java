package modelo.entidades;

import modelo.enumerados.TipoOperacion;

public class Operacion {
	private double operando1;
	private double operando2;
	private TipoOperacion tipoOperacion;
	private double resultado;
	
	public double getOperando1() {
		return operando1;
	}
	public void setOperando1(double operando1) {
		this.operando1 = operando1;
	}
	public double getOperando2() {
		return operando2;
	}
	public void setOperando2(double operando2) {
		this.operando2 = operando2;
	}
	public TipoOperacion getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(TipoOperacion tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public double getResultado() {
		return resultado;
	}
	public void setResultado(double resultado) {
		this.resultado = resultado;
	}
	
	@Override
	public String toString() {
		return "Operacion [operando1=" + operando1 + ", operando2=" + operando2 + ", tipoOperacion=" + tipoOperacion
				+ ", resultado=" + resultado + "]";
	}
	
}
