package _04_scanner;

import java.util.Scanner;

public class _02_Scanner {
	public static void main(String[] args) {
		String texto="Rosa López;Miguel de la Parra;Carmen Ruiz;Francisco López;Rosa Morales";
		Scanner lector = new Scanner(texto);
		lector.useDelimiter(";");//el delimitando por defecto seria " "
		while (lector.hasNext()){
			System.out.println(lector.next());
		}	
		
		lector.close();
	}

}

