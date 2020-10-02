package refactor;

//Para informacion de lo que podemos refactorizar
//https://dzone.com/articles/java-eclipse-code-refactoring-shortcuts-and-tips
//https://www.baeldung.com/eclipse-refactoring
public class ClaseRefactor {

	private static final String BIENVENIDOS_A_MI_PROGRAMA = "Bienvenidos a mi programa";
	private static int numero_convertido_a_atibuto;

	public static void main(String[] args) {

		//Aqui hemos hecho un "Extract local variable"
		String nombre = "Pepe";
		
		System.out.println(nombre);
		System.out.println(nombre);
		
		if(nombre.length() == 4) {
			System.out.println("La longitud de Pepe es: 4");
		}else {
			System.out.println("La longitud de Pepe no es 4");
		}

		//Esta la hemos convertido en una constante
		System.out.println(BIENVENIDOS_A_MI_PROGRAMA);
		
		//esta variable la hemos convertido a atributo
		//antes era, int numero = 5;
		numero_convertido_a_atibuto = 5;
		System.out.println(numero_convertido_a_atibuto);
	}
	
	//Extracion de metodos
	//funcion original
	/*
	public static void operarOpcion(int operacion) {
		if(operacion == 0) {
			System.out.println("Damos alta al objeto, opcion elegida " + operacion);
			System.out.println("Dando de alta...");
		}else if(operacion == 2) {
			System.out.println("Damos de baja el objeto, opcion elegida " + operacion);
			System.out.println("Dando de baja...");
		}
	}*/

	public static void operarOpcion(int operacion) {
		if(operacion == 0) {
			alta(operacion);
		}else if(operacion == 2) {
			baja(operacion);
		}
	}

	private static void baja(int operacion) {
		System.out.println("Damos de baja el objeto, opcion elegida " + operacion);
		System.out.println("Dando de baja...");
	}

	private static void alta(int operacion) {
		System.out.println("Damos alta al objeto, opcion elegida " + operacion);
		System.out.println("Dando de alta...");
	}
}
