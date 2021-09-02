package main;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.GestorOperaciones;
import modelo.entidades.Operacion;
import modelo.enumerados.TipoOperacion;

public class Main {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		GestorOperaciones go = new GestorOperaciones();
		
		do{
			TipoOperacion operacion = mostrarMenu();
			double numero1 = pedirNumero("Operando1");
			double numero2 = pedirNumero("Operando2");
			double resultado = 0.0;
			
			switch (operacion) {
			case SUMAR:
				resultado = go.sumar(numero1, numero2);
				mostrarResultado(resultado);
				break;
			case RESTAR:
				resultado = go.restar(numero1, numero2);
				mostrarResultado(resultado);
				break;
			case MULTIPLICAR:
				resultado = go.multiplicar(numero1, numero2);
				mostrarResultado(resultado);
				break;
			case DIVIDIR:
				resultado = go.dividir(numero1, numero2);
				mostrarResultado(resultado);
				break;
			}
			
		}while(continuar());
		
		ArrayList<Operacion> listaOperaciones = go.getListaOperaciones();
		mostrarOperaciones(listaOperaciones);
		
	}
	
	private static void mostrarOperaciones(ArrayList<Operacion> listaOperaciones) {
		System.out.println("Las operaciones han sido:");
		for(Operacion operacion : listaOperaciones){
			System.out.println(operacion);
		}
		
	}

	public static boolean continuar() {
		System.out.println("Desea introducir otros numeros? S/N:");
		
		boolean continuar = false;
		String texto = sc.nextLine();
		if (texto.equalsIgnoreCase("S")) {
			continuar = true;
		}
		return continuar;
	}

	private static void mostrarResultado(double resultado) {
		System.out.println("El resultado de la operacion es: " 
							+ resultado);
		
	}

	private static TipoOperacion mostrarMenu() {
		System.out.println("Seleccione una operacion:");
		int i = 0;
		for(TipoOperacion tp : TipoOperacion.values()){
			System.out.println(i++ + "-" + tp);
		}
		int opcion = sc.nextInt();
		TipoOperacion tp = TipoOperacion.values()[opcion];
		return tp;
	}
	
	public static double pedirNumero(String numero) {
		System.out.println("Introduzca el " + numero + ":");
		double dNumero = sc.nextDouble();
		return dNumero;
	}

}
