//Esto es un comentario en Java.
//Los comentarios son explicaciones que ponemos en nuestro código
//para aclarar ciertas partes del mismo.

//Son muy útiles para nosotros y para los futuros desarrolladores que lean
//nuestro código.

//Los comentarios en Java empiezan por "//"

//Las líneas en Java no se recomiendan que pasen de 80 caracteres

/*
 * Poniendo los comentarios con este formato podemos poner comentarios
 * de varias líneas sin necesidad
 * de estar poniendo todo el rato '//'
 */
// El formato sería "/* */"

//Java es un lenguaje de programación orientado a objetos, por lo que 
//tenemos que usar clases para poder arrancar nuestro programa.
//Las clases se escriben con notación UpperCamelCase. Es muy importante
//seguir las convenciones de código en Java

//Nótese que las clases siempre tienen bloques asociados, los bloques de 
//una clase están delimitados por los simbolos "{ }"

//Las clases tienen que llamar igual que el nombre del fichero donde se
//encuentran

public class _01_PrincipiosFundamentales {

//Para hacer que un programa sea ejecutable, tenemos que crear una clase
//y dentro de la clase tenemos que poner el método "main", es un método
//que tiene que llamarse excatamente igual a como sigue.

//Al crear la clase con el editor de Java podemos seleccionar la casilla
	//de "crear el método main" para que nos lo cree.

	//En caso de que se nos olvide. Podemos escribir la palabran "main" y a
	//continuación pulsar "ctrl + spacio" para que la ayuda de eclipse nos
	//ayude a completarlo.
	public static void main(String[] args) {
		// Un programa en java empieza en la línea siguiente al método "main"
		// y acaba cuando salga de dicho método. Nótese que los metodos siempre
		// tienen bloques asociados, los bloques de un método están delimitados
		// por los simbolos "{ }"

		// Los programas en java se ejecutan de manera SECUENCIAL (bueno, y en todos)
		// es decir, van línea a línea ejecutando las sentencias que se van encontrando
		// Una sentencia es un comando, una orden o una instrucción que le damos
		// al programa.

		// La sentencia más simple que podemos ejecutar en java, es la de imprimir
		// por pantalla
		// OJO!! Las sentencias en Java acaban con ";"
		System.out.println("Este literal se imprimirá por pantalla cuando lo ejecutemos");
		System.out.println("Hola hola caracola");
		// Nótese que la sentencia de arriba imprime por pantalla y LUEGO hace un salto
		// de línea
		// Si queremos imprimir por pantalla SIN hacer salto de línea, usaremos la
		// sentencia:
		System.out.print("Esto sería imprimir sin salto de linea");
		System.out.println(" Podemos observar como lo imprime seguido");
		System.out.println("Ahora lo imprimimos seguido");

		// Es muy importante que seáis ordenados en el código FUNDAMENTAL, debéis
		// de respetar la tabulaciones, los saltos lineas, etc.

		// Eclipse tiene una manera para ayudaros a mantener el orden, siempre que
		// el código no contenga errores.
		// Para ello seleccionamos todo el código que queremos poner el orden, con el ratón
		// o también podemos pulsar "ctrl + a", a continuaciones pulsamos botón derecho 
		// y vamos a "source" y luego a "format"

		//Ojo!!! Siempre que cambiemos algo de nuestro código debemos de guardalo para que
		//el compilador de Java se de cuenta de dichos cambios. Podemos guardar los cambios
		//con "ctrl + s"
		
		//Importante! Si cometemos un error al escribir código, nos dará un error en tiempo
		//de compilación, y probablemente no se permita la ejecución del programa
		// Por ejemplo, si no ponemos ";" al final de una sentencia, o escribimos mal el nombre
		// de una sentencia... Hay muchas maneras de cometer estor errores.
		// Poniendo el cursor del ratón sobre el error, podemos intentar sacar información 
		// del mismo.
		//System.out.println("Esto sería un error por no poner ';' al final")
	
	}// Fin del método "main". Aquí acabaría nuestro programa de Java
	
	//Las sentencias van siempre dentro de métodos! Si ponéis sentencias fuera de los métodos
	//no van a funcionar
	//System.out.println("Ahora lo imprimimos seguido");//Esto daría error!!
} // Fin de la clase
