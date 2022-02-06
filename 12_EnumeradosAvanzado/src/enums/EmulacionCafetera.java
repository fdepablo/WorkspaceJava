package enums;

import java.util.Scanner;

public class EmulacionCafetera {
	
	public static void main(String[] args){
		System.out.println(" Bienvenido a nuestra emulacion de una"
				+ "cafetera");
		EmulacionCafetera ec = new EmulacionCafetera();
		ec.opcionesCafe();
		Scanner sc = new Scanner(System.in);
		int opcionCafe = sc.nextInt();
		ec.opcionesTamanio();
		int opcionTamanio = sc.nextInt();
		TipoCafe tipoCafe = TipoCafe.values()[opcionCafe];
		TamanioCafe tamanioCafe = TamanioCafe.values()[opcionTamanio];
		ec.procesandoCafe(tipoCafe,tamanioCafe);
		sc.close();
	}
	
	public void opcionesCafe(){
		System.out.println(" Opciones de Cafe ");
		System.out.println("------------------");
		for(TipoCafe tipoCafe : TipoCafe.values()){
			System.out.println(" " + tipoCafe.ordinal() 
					+ " - " + tipoCafe);
		}
		System.out.println("Seleccione un tipo de cafe");
	}
	
	public void opcionesTamanio(){
		System.out.println(" Tama�o de Cafe ");
		System.out.println("------------------");
		for(TamanioCafe tamanioCafe : TamanioCafe.values()){
			System.out.println(" " + tamanioCafe.ordinal() 
					+ " - " + tamanioCafe 
					+ "(" + tamanioCafe.getCapacidad()
					+ " cl)");
		}
		System.out.println("Seleccione un tama�o de cafe");
	}
	
	public void procesandoCafe(TipoCafe tipoCafe, TamanioCafe tamCafe){
		System.out.println("Gracias por elegir nuestro cafe");
		System.out.println("Disfrute su cafe " + tipoCafe + 
				" de tama�o " + tamCafe);
	}
}
