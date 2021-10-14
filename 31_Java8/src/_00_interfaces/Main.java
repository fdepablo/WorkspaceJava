package _00_interfaces;

public class Main {

	public static void main(String[] args) {
		
		//No podemos instanciar una interfaz, pero java nos da la opcion
		//de crear una clase anonima, es decir, se crea la clase y el 
		//objeto al mismo tiempo, y se llama anonimo porque nunca más
		//se puede reusar
		Imprimir imprimir = new Imprimir() {
			
			@Override
			public void imprimir(String cadena) {
				System.err.println(cadena);
				
			}
			
			@Override
			public String getNombreImpresion() {
				return "Imprimir por consola de error";
			}
		};
		
		imprimir.imprimir("Esto es una prueba de impresion");
		imprimir.getNombreImpresion();
		
		imprimir = new ImprimirPantalla();
		imprimir.imprimir("Esto es una prueba de impresion");
		imprimir.getNombreImpresion();
		
		imprimir = new ImprimirFichero("fichero_prueba.txt");
		imprimir.imprimir("Esto es una prueba de impresion");
		imprimir.getNombreImpresion();
		
		ImprimirFichero ifichero = (ImprimirFichero)imprimir;
		System.out.println(ifichero.getNombreFichero());

	}

}
