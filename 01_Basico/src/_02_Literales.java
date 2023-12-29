
public class _02_Literales {

	//Un proyecto java puede tener varias clases con
	//metodos "main". El main que se ejecutará será
	//sobre aquel fichero que hagamos el "Run us"
	public static void main(String[] args) {
		System.out.println("Literales en java");

		//En java, como en todos los lenguajes de programción, tenemos
		//lo que llamamos literales
		
		//Una literal es un valor constante formado por una secuencia de caracteres. 
		//Cualquier declaración en Java que defina un valor constante 
		//-un valor que no pueda ser cambiado durante la ejecución del programa- 
		//es un literal.
		
		//Tenemos los siguientes tipos de literales en java
		//Literales de cadena de texto, van entre comillas dobles
		System.out.println("Esto es un literal de cadena");
		
		//Literales de caracter, van entre comillas simpres y solo puede haber uno
		System.out.println('a');
		
		//Literales booleanos, pueden ser de dos tipos, verdadero (true)
		//y falso (false). Se utilizan las palabras reservadas 'true' y 'false'
		//respectivamente
		System.out.println(true);
		System.out.println(false);
		
		//Literales de numeros enteros (int), son literales númericos que van desde
		//–2,147,483,648 a 2,147,483,647
		//los numeros enteros van sin coma y sin punto
		System.out.println(2147483647);
		//Podemos utilizar "_" para separar los numeros y leerlo mejor
		System.out.println(1000000000);
		System.out.println(1_000_000_000);//equivalente a la anterior, pero se lee mejor
		
		//Literales de numeros enteros largos (long), el rango es mucho mayor
		//Se ponen con una 'L' mayuscula o minuscula al final.
		System.out.println(2147483648L);
		System.out.println(2_147_483_648L);
		
		//Literales de numero decimales grandes (double), la parte decimal se separa
		//de la parte entera con un '.'
		//Este tipo de literal es el más usado para hacer números decimales en java
		System.out.println(1200.235);
		System.out.println(1_200.235);
		
		//Literales de números decimales pequeños (float), se tratan igual que los
		//'double' pero se pone una 'F' mayúscula o minúscula al final.
		//La diferencia con los double es que el rango es mas pequeño.
		//Apenas se usan hoy en día, es mejor usar siempre 'double' para los números
		//decimales
		System.out.println(1200.235F);
		System.out.println(1_200.235F);
	}

}
