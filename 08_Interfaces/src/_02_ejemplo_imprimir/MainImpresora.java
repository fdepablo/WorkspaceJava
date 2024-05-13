package _02_ejemplo_imprimir;

public class MainImpresora {

	public static void main(String[] args) {
		//Con una referencia de una interfaz puedo apuntar a
		//cualquier objeto que implemente la interfaz
		
		//DE HECHO, se considera una buena práctica de programación
		//el orientar tu código siempre que se pueda a interfaces
		//así como utilzar referencias de la interfaz
		//Usar interfaces para apuntar a objetos hacen que las
		//dependencias de tú código sean dependecias DEBILES
		//mientras que usar las refencias propias del objeto
		//hacen que sean dependencias FUERTES
		
		Imprimible impPantalla = new ImprimirPantalla();
		Imprimible impFichero = new ImprimirFichero();
		Imprimible impImpresora = new ImprimirImpresora();
		
		String cadena = "Hola interfaz";
		impPantalla.imprimir(cadena);
		impFichero.imprimir(cadena);
		impImpresora.imprimir(cadena);
		
		//Invocamos los métodos concretos
		//Esta manera NO Estaria bien hecha ya que es mejor
		//utilizar el código orientado a interfaces
		/*
		metodoImprimirPantalla(impPantalla);
		metodoImprimirImpresora(impImpresora);
		metodoImprimirFichero(impFichero);*/
		
		//Invocamos el metodo con la interfaz
		metodoImprimir(impPantalla);
		metodoImprimir(impImpresora);
		metodoImprimir(impFichero);
	}

	public static void metodoImprimirPantalla(ImprimirPantalla ip) {
		ip.imprimir("Manolo cabezabolo");
	}
	
	public static void metodoImprimirFichero(ImprimirFichero ip) {
		ip.imprimir("Manolo cabezabolo");
	}
	
	public static void metodoImprimirImpresora(ImprimirImpresora ip) {
		ip.imprimir("Manolo cabezabolo");
	}
	
	//Aplicando polimorfismo
	public static void metodoImprimir(Imprimible i) {
		i.imprimir("El chivi");
	}
}
