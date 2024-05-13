package _03_patron_fabrica;

import java.util.Scanner;

import _02_ejemplo_imprimir.Imprimible;


public class MainFabricaImprimibles {
	public static void main(String[] args) {
		FabricaImprimibles fi = new FabricaImprimibles();
		Scanner sc = new Scanner(System.in);
		System.out.println("Elija un objeto que quiere crear");
		System.out.println("1- Pantalla");
		System.out.println("2- Fichero");
		System.out.println("3- Impresora");
		String objeto = sc.nextLine();
		
		Imprimible ip = fi.crearImprimible(objeto);
		
		System.out.println("Introduzca la frase a imprimir");
		String frase = sc.nextLine();
		ip.imprimir(frase);
	}
}
