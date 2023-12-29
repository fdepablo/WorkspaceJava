package clases_nativas;

import java.util.Scanner;

public class _01_String {

	public static void main(String[] args) {
		// Las cadenas en java no son tipos primitivos, es una clase llamada "String"
		// Internamente un String en java es un array de caracteres "char"
		
		//Las clases en Java por convención empiezan con MAYÚSCULA
		//Los primitivos enmpiezan por MINÚSCULA
		int numero = 0;
		String cadena = "Steve";
		//Internamente Java creara algo así, pero dentro de un objeto
		char[] cadenaCaractere = {'S','t','e','v','e'};
		
		//Los objetos en java tienen lo que se conoce como MÉTODOS
		//Un método es una funcíón asociada al objeto en cuestión, y se acceden
		//a ellos a traves de la variable y con "."(que realmente se llaman referencias)
		
		//Ejemplo, la clase Scanner tiene métodos asociados que recoger
		//datos del usuario. Para recoger un entero utilizamos el método "nextInt()"
		
		//Aquí estamos creando un objeto de la clase Scanner
		//Los objetos generalmente se crean con la palabra "new"
		Scanner sc = new Scanner(System.in);
		//Usamos el método "nextInt" para recoger un entero por teclado
		//numero = sc.nextInt();
		
		//De igual manera, la clase String tiene muchos métodos asociados
		
		//Método toUpperCase() -> Este método devuelve la cadena en mayusculas
		String cadenaMayusculas = cadena.toUpperCase();
		System.out.println(cadenaMayusculas);
		//OJO! El método NO cambia la cadena original
		System.out.println(cadena);
		
		//Método toLowerCase() -> Este método devuelve la cadena en minúsculas
		System.out.println(cadenaMayusculas.toLowerCase());
		//OJO! La cadena original sigue sin cambiarse
		//NOTA: Las cadenas originales NUNCA CAMBIARAN para ningun método de la
		//clase String
		System.out.println(cadenaMayusculas);
		
		//Método charAt(POSICION) -> Este método devuevle el caracteres en la
		//posición que le pasemos
		System.out.println(cadena.charAt(1));//t
		System.out.println(cadena.charAt(0));//S
		//System.out.println(cadena.charAt(5));//Error en tiempo de ejecución
		
		//Método indexOf(CHAR) -> Este método devuelve la posición del primer
		//caracter que coincida con el.
		int posicion = cadena.indexOf('t');
		System.out.println("La posicion es: " + posicion);
		posicion = cadena.indexOf('e');
		System.out.println("La posicion es: " + posicion);
		//Si el caracter no existe, devuelve '-1'
		System.out.println(cadena.indexOf('x'));
		
		System.out.println("??: " + cadena.charAt(cadena.indexOf('t')));
		
		//Metodo lenght() -> Este método devuelve el tamaño del String
		System.out.println(cadena.length());
		
		//Para imprimir todas las letras de una cadena
		System.out.println("Imprimir todas las letras");
		for(int i = 0; i < cadena.length(); i++) {
			System.out.print(cadena.charAt(i));
			//No ponemos el último "-" en la salida
			if(i != cadena.length() -1) {
				System.out.print("-");
			}
		}
		System.out.println();
		
		//IMPORTANTE: No se deben comparar String con "==" porque no funciona
		//siempre
		String cadena2 = sc.nextLine();
		if(cadena == cadena2) {
			System.out.println("'==' - Cadena y cadena2 tienen el mismo valor");
		}else {
			System.out.println("'==' - Cadena y cadena2 NO tienen el mismo valor");
		}
		
		//Las cadenas en Java SE DEBEN comparar con el método "equals()"
		if(cadena.equals(cadena2)) {
			System.out.println("'equals()' - Cadena y cadena2 tienen el mismo valor");
		}else {
			System.out.println("'equals()' - Cadena y cadena2 NO tienen el mismo valor");
		}
		
		//Existe otro método para comparar dos cadenas sin tener en cuenta
		//mayúsculas y minusculas, el método "equalsIgnoreCase()"
		if(cadena.equalsIgnoreCase(cadena2)) {
			System.out.println("'equalsIgnoreCase()' - Cadena y cadena2 tienen el mismo valor");
		}else {
			System.out.println("'equalsIgnoreCase()' - Cadena y cadena2 NO tienen el mismo valor");
		}
		
		//El método split, parte una cadena en X partes a partir de un caracter
		//Te devuelve un array con cada una de las partes
		String frase = "En un lugar de la mancha";
		System.out.println(frase);
		String[] fraseDividida = frase.split(" ");
		System.out.println(fraseDividida[0]);
		System.out.println(fraseDividida[2]);
		System.out.println("-------------------");
		System.out.println(fraseDividida.length);
		for(String s : fraseDividida) {
			System.out.println(s);
		}
		
		String[] fraseDividida2 = frase.split("e");
		System.out.println("-------------------");
		System.out.println(fraseDividida2.length);
		for(String s : fraseDividida2) {
			System.out.println(s);
		}
		
		String[] fraseDividida3 = frase.split("n");
		System.out.println("-------------------");
		System.out.println(fraseDividida3.length);
		for(String s : fraseDividida3) {
			System.out.println(s);
		}
		
		frase = "En-un-lugar-de-la-mancha";
		String[] fraseDividida4 = frase.split("-");
		System.out.println("-------------------");
		System.out.println(fraseDividida4.length);
		for(String s : fraseDividida4) {
			System.out.println(s);
		}
		
		//Siempre que queráis saber como funciona un métodos es importante
		//consulta la documentación. Por ejemplo poniendo el cursor encima
		//despues del "." del método
		
		//Método trim() -> devuelve una cadena sin los espacios en blanco 
		//del los extremos 
		
		String cadenaConEspacios =  "     cadena con espacios a los extremos       ";
		String cadenaSinEspacios = cadenaConEspacios.trim();
		System.out.println("Cadena sin espacios: "  + cadenaSinEspacios + ":Fin");
		
		
		//Metodo subString(inicio,fin-1) -> ver el método en la documentacion
		frase = "En-un-lugar-de-la-mancha";
		String subCadena = frase.substring(3,6);
		System.out.println("'" + subCadena + "'");
		subCadena = frase.substring(5,frase.length());
		System.out.println(subCadena);
		subCadena = frase.substring(1,9);
		System.out.println(subCadena);
		subCadena = frase.substring(frase.length()-5,frase.length()-1);
		System.out.println(subCadena);
		
		//Metodo subString(inicio) -> ver el método en la documentacion
		subCadena = frase.substring(10);
		System.out.println(subCadena);
		
		//Método constains(cadena) -> devuelve true si la cadena pasada por parametros
		//es contenida en la cadena que invoca el método
		System.out.println(frase.contains("de-"));
		System.out.println(frase.contains("de-la"));
		System.out.println(frase.contains("en-"));
		System.out.println(frase.contains("En "));
		
		//Método repace(charABuscar,charARemplazar) -> Mirar documentacion
		String fraseReemplazada = frase.replace('a', 'e');
		System.out.println(fraseReemplazada);
		
		//Método valueOf(primitivo) -> devuelve un primitivo a formato String
		//Este método es estático, se accede a traves de la clase
		String enteroAString = String.valueOf(6);
		System.out.println("Numero en String: " + enteroAString);
		
		
		//Un objeto de la clase String también se puede crear a partir
		//del constructor de clase
		String frase2 = new String("de cuyo nombre no quiero acordarme");
		//Generalmente esta manera no se usa
		//Cuando recogéis una cadena con la clase Scanner se crean los
		//String de esta manera
	}

}
