package modelo;

import java.util.ArrayList;

import modelo.entidades.Operacion;
import modelo.enumerados.TipoOperacion;

public class GestorOperaciones {
	
	private ArrayList<Operacion> listaOperaciones = new ArrayList<>();
	
	public double sumar(double operando1,double operando2){
		double resultado = operando1 + operando2;
		
		Operacion operacion = new Operacion();
		operacion.setOperando1(operando1);
		operacion.setOperando2(operando2);
		operacion.setTipoOperacion(TipoOperacion.SUMAR);
		operacion.setResultado(resultado);
		listaOperaciones.add(operacion);
		
		return resultado;
	}
	public double restar(double operando1,double operando2){
		double resultado = operando1 - operando2;
		
		Operacion operacion = new Operacion();
		operacion.setOperando1(operando1);
		operacion.setOperando2(operando2);
		operacion.setTipoOperacion(TipoOperacion.RESTAR);
		operacion.setResultado(resultado);
		listaOperaciones.add(operacion);
		
		return resultado;
	}
	public double multiplicar(double operando1,double operando2){
		double resultado = operando1 * operando2;
		
		Operacion operacion = new Operacion();
		operacion.setOperando1(operando1);
		operacion.setOperando2(operando2);
		operacion.setTipoOperacion(TipoOperacion.MULTIPLICAR);
		operacion.setResultado(resultado);
		listaOperaciones.add(operacion);
		
		return resultado;
	}
	public double dividir(double operando1,double operando2){
		double resultado = operando1 / operando2;
		
		Operacion operacion = new Operacion();
		operacion.setOperando1(operando1);
		operacion.setOperando2(operando2);
		operacion.setTipoOperacion(TipoOperacion.DIVIDIR);
		operacion.setResultado(resultado);
		listaOperaciones.add(operacion);
		
		return resultado;
	}
	
	public ArrayList<Operacion> getListaOperaciones() {
		return listaOperaciones;
	}

}
