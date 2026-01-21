package array;

public class _01_Arrays {

	public static void main(String[] args) {
		// Un array en java es una estructura de datos que nos permite
		//almacenar una colección de datos de un mismo tipo.

		// Podemos entender un array como tener muchas variables
		//de un mismo tipo declaradas en una estructura.
		
		//Ejemplo, si queremos almacenar 5 números en memoria
		//necesitariamos 5 variables de tipo int
		int n1 = 1;
		int n2 = 2;
		int n3 = 3;
		int n4 = 4;
		int n5 = 5;
		
		//Si quisieramos imprimirlo, tendriamos que ir 1 a 1
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
		System.out.println(n4);
		System.out.println(n5);
		
		//¿Te imaginas que te dijera que tienes que almacenar 500 números
		//metidos por el usuario? Tendrías que crearte 500 variables a mano...
		
		// Los arrays nos permiten almacenar muchas variables
		//dentro de una misma estructura
		
		//Podemos declarar un array de la siguiente manera
		int[] arrayNumeros = new int[5];
		//Con "[]" decimos que la variable será de tipo array
		//Un array siempre tiene que inicializarse con un tamaño fijo
		//se hace poniendo la palabra reservada "new" y luego el tamaño
		//del array entre corchetes junto con el tipo.
		//En este caso, hemos creado un array de enteros de tamaño 5
		//es decir, podemos almacenar 5 valores de tipo entero.
		
		//En cada posición del array podemos almacenar un valor del tipo
		//del array. La primera posición de un array NO es la posición 1
		//es la posición 0. En el array anterior las posiciones irían
		//desde la posición 0 a la posición 4.
		
		// Para modificar una posición del array, debemos de usar
		//la variable y dentro de los corchetes pondremos la posición
		//que queremos modificar
		
		System.out.println("------------ Arrays -----------------");
		
		// Los arrays enteros por defecto se inicializan todas las posiciones
		//a 0.
		arrayNumeros[0] = 1;
		arrayNumeros[1] = 2;
		arrayNumeros[2] = 3;
		arrayNumeros[3] = 4;
		arrayNumeros[4] = 5;
		
		//Para acceder a una posición del array se hace de la misma manera
		System.out.println(arrayNumeros[0]);//Esta seria la primera posición del array
		System.out.println(arrayNumeros[1]);
		System.out.println(arrayNumeros[2]);
		System.out.println(arrayNumeros[3]);
		System.out.println(arrayNumeros[4]);//Esta sería la última posición del array
		
		//El orden de las posiciones de los elementos en un array se conoce 
		//como índice o index.
		
		//Ojo, si accedéis o modificais una posición o indice que no existe, da error
		//en tiempo de ejecución, concretamente ArrayIndexOutOfBoundsException
		//arrayNumeros[5] = 6;//No da error en tiempo de compilación, pero si en ejecución
		
		//Una vez creado el array, NO se puede modificar el tamaño. Es por esto que este
		//tipo de array en java se conoce como "array estático"
		
		//Podemos conocer el tamaño de un array gracias a la propiedad "length"
		System.out.println("El tamaño del array es: " + arrayNumeros.length);//5
		
		//Ejemplo, guardar los primeros 1000 numeros en variables
		int[] arrayMilNumeros = new int[1000];
		//arrayMilNumeros[0] = 1;
		//arrayMilNumeros[1] = 2;
		//arrayMilNumeros[2] = 3;
		//Esto es inviable....
		
		//Gracias a que un array es una colección de variables se puede recorrer
		//con bucles
		for(int i = 0; i < 1000; i++) {//i <= 999;
			arrayMilNumeros[i] = i + 1;
		}
		//Iteración 1
		//i = 0;
		//arrayMilnumeros[0] = 1
		//Iteración 2
		//i = 1;
		//arrayMilnumeros[1] = 2
		//Iteración 3
		//i = 2;
		//arrayMilnumeros[2] = 3
		//Iteración 4
		//i = 3;
		//arrayMilnumeros[3] = 4
		//....
		
		System.out.println("Ahora imprimimos el bucle");
		for(int i = 0; i < 1000; i++) {
			System.out.println(arrayMilNumeros[i]);
		}
		/*
		a) Te imprime los numeros del 1 al 1000
		b) Te imprime los numeros del 0 al 1000
		c) Te imprime los numeros del 0 al 999
		d) Error en tiempo de ejecución
		*/
		
		//Normalmente para recorrer un array se usa como condición de parada
		//la propiedad "length"
		for(int i = 0; i < arrayMilNumeros.length; i++) {
			System.out.println(arrayMilNumeros[i]);
		}
		
		//Se pueden hacer arrays de cualquier tipo de dato
		double[] arrayDoubles = new double[5];
		arrayDoubles[0] = 34.56;
		
		boolean[] arrayBooleans = new boolean[3];
		arrayBooleans[2] = false;
		//arrayBooleans[3] = true;//Error en tiempo de ejecución
		
		//Podemos declarar arrays e inicializarlos al mismo tiempo
		char[] arrayCaracteres = {'F','e','l','i','x'};
		//El tamaño de este array es 5
		//El numero de posiciones de este array van de la 0 a la 4
		//o dicho de otra manera, el indice va del 0 al 4
		//La primera posición del array tiene de valor: F
		//La última posición del array tiene de valor: x
		//La posición 5 del array tiene de valor: NO EXISTE
		//La posición 4 del array tiene de valor: x
		//La posición 3 del array tiene de valor: i
		
		int[] arrayNumerico2 = {2,4,5,6,7,8};
		//El tamaño de este array es 6
		//El numero de posiciones de este array van de la 0 a la 5
		//La primera posición del array tiene de valor: 2
		//La última posición del array tiene de valor: 8
		//La posición 5 del array tiene de valor: 8
		//La posición 6 del array tiene de valor: NO EXISTE
		//La posición 4 del array tiene de valor: 7
	}

}
