package _04_lambdas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class _00_Lambdas {
	
	@FunctionalInterface
	interface Imprimible{
		void imprimir(String cadena);
	}
	
	static class ImprimirPantalla implements Imprimible{

		@Override
		public void imprimir(String cadena) {
			System.out.println(cadena);			
		}
		
	}
	
	public static void main(String[] args) {
		//Antes de Java 8 podiamos hacer funcionalidad parecida a las funciones
		//lambda mediante clases anonimas
		
		//En este caso voy a crearme una clase anonima cuya funcionalidad
		//sera imprimir por fichero
		Imprimible imprimible = new Imprimible() {
			
			@Override
			public void imprimir(String cadena) {
				File fichero = new File("prueba.txt");
	
				try (FileWriter fw = new FileWriter(fichero)){			
					fw.write(cadena);			
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //un fw.close() de manera implicita
				
			}
		};
		
		imprimible.imprimir("Esto es una cadena escrita con una clase anonima");
		
		imprimible = new ImprimirPantalla();
		imprimible.imprimir("Esto es una cadena escrita con una clase anonima");
		
		//Ahora conn funciones lambda
		Imprimible imprimiblePantallaLambda = (cadena) -> System.out.println(cadena);
		Imprimible imprimibleFicheroLambda = (cadena) -> {
			File fichero = new File("prueba.txt");			
			try (FileWriter fw = new FileWriter(fichero)){			
				fw.write(cadena);			
			} catch (IOException e) {
				e.printStackTrace();
			} 
		};
		
		imprimibleFicheroLambda.imprimir("Ahora imprimo con lambda");
		imprimiblePantallaLambda.imprimir("Ahora imprimo con lambda");
	}
}

