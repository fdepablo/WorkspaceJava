package _01_condicionales;

public class _03_OperadorTernario {
	public static void main(String[] args) {
		//OPERADOR TERNARIO
		//-----------------
		//Con este operador buscamos hacer una sentancia "IF-ELSE" de una manera
		//rápida y en una sola línea
		
		//La estructura es la siguiente:
		//(EXPRESION_BOOLEAN) ? CASO_VERDADERO : CASO_FALSO;
		//El caso será lo que devuelva la expresión, que normalmente lo almacenaremos
		//en una variable
		
		//Ejemplo
		int numero = 6;
		String cadena = (numero <= 5) ? "Menor o igual que 5" : "Mayor que 5";
		System.out.println(cadena);
		
		//Equivalente al ternario
		if(numero <= 5) {
			System.out.println("Menor o igual que 5");
		}else {
			System.out.println("Mayor que 5");
		}
		
		//Otro ejemplo
		String texto = (numero % 2 == 0) ? "El número es par" : "El número es impar";
		System.out.println(texto);
		
		//Otro ejemplo
		//Las variales booleanas normalmente empiezan por "es" o por "is",
		//tambien pueden empezar por "tiene" o por "has"
		boolean esPar = (numero % 2 == 0) ? true : false;
		//OJO! no se recomiendo llamar a las variables "negadas"
		//Ej: es mejor tomar el nombre "esPar" que llamarla "noEsPar"
		
		//El mismo ejemplo anterior pero con sentencia "IF-ELSE"
		if(esPar) {
			System.out.println("La variable es par");
		}else {
			System.out.println("La variable es impar");
		}
		
		//Si queremos usar la negación mejor usar el operador "!"
		if(!esPar) {
			System.out.println("La variable es impar");
		}else {
			System.out.println("La variable es par");			
		}
	}
}
