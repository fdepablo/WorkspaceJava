import java.util.Scanner;

public class _07_EntradaSalida {

	public static void main(String[] args) {
		// Es muy habitual en las app tener entradas de datos del usuario
		// y salidas de datos una vez procesada la información
		
		//En java tenemos dos maneras de presentar la información:
		//1. System.out -> Salida estandar de consola
		//2. System.err -> Saiida de errores de consola
		
		//Una vez que trabajemos con una salida, podemos usar algún método
		//para imprimir por ella, como por ejemplo el método "println"
		System.out.println("Salida estandar de consola");
		System.err.println("Salida de errores de consola (sale en rojo)");//syserr + ctrl y espacio
		
		//Ojo: System.out y System.err trabajan con flujos diferentes
		//de salidas, por lo tanto si dos sentencias estan muy juntas
		//puede que salgan de manera diferente
		
		//En java tenemos una manera de recoger información a traves de 
		//la consola, y es mediante "System.in"
		//Lamentablemente debemos de apoyarnos en otras clases para
		//poder recoger la información a partir de este "System.in"
		//El caso más habitual es mediante la clase "Scanner"
		
		//Para ello debemos de crearnos una variable de tipo Scanner y 
		//su correspondiente Objeto, diciendole que lea de "System.in"
		//Para utilizar esta clase debemos de importar el paquete donde
		//se encuentra, y las importaciones de paquetes se ponen al
		//principio de la clase
		//Ej: import java.util.Scanner;
		//El concepto de paquete es muy similar al concepto de directorio
		Scanner sc = new Scanner(System.in);
		//Si ponemos "Scan" y pulsamos "ctrl + space", nos debe importar
		//automáticamente la clase
		
		//Una vez creada la variable y el objeto pudemos empezar a usar
		//métodos del objeto para capturar la información. Los métodos
		//son funcionalidades que puedes aplicar los objetos.
		//Invocamos un método de un objeto mediante el operador "."
		
		//Mediante el método "nextLine()" (nótese como hay parentesis al fina),
		//El programa se quedará parado en esa línea hasta que el usuario
		//introduzca una frase para leer y pulse "Enter".
		//Nota: podemos observar como el programa sigue en ejecución
		//porque hay un cuadrado rojo en Eclipse en la pantalla de la consola
		System.out.println("Introduzca una frase para leer:");
		//Normalmente, el valor que introduzca el usuario debemos
		//de almacenarla en algún lugar, como puede ser una variable.
		//En este caso como queremos leer una frase, vamos a utilizar
		//un "String"
		//El método "nextLine()" devuelve un String, es por ello que usamos
		//una variable "String" para almacenar el resultado.
		String frase = sc.nextLine();
		System.out.println("El usuario a introducido la frase: " + frase);
		
		//Una vez creado el "Scanner" no es necesario crearlo más
		System.out.println("Introduzca otra frase para leer:");
		frase = sc.nextLine();
		System.out.println("La segunda frase introducida por el usuario es: " + frase);
		
		System.out.println("Introduzca un número:");
		String s1 = sc.nextLine();
		System.out.println("Introduzca otro número:");
		String s2 = sc.nextLine();
		String s3 = s1 + s2;//Concatenando
		System.out.println("La concatenación de s1 y s2 es: " + s3);
		
		//La clase "Scanner" tiene métodos para recoger distintos tipos de datos.
		//Si queremos recoger un entero, debemos utilizar "nextInt()"
		//No podemos guardar un "int" en una variable "String"
		//String s4 = 4;//Error
		System.out.println("Introduzca un número:");
		int n1 = sc.nextInt();
		System.out.println("Introduzca otro número:");
		int n2 = sc.nextInt();
		int n3 = n1 + n2;//Suma
		System.out.println("El resultado de la suma de n1 y n2 es: " + n3);
		
		//Otros métodos
		System.out.println("Introduzca un long:");
		long l1 = sc.nextLong();
		System.out.println("El número long es: " + l1);
		
		//Ojo, por teclado se pone el punto flotante por ','
		//pero en java se guarda con '.'
		System.out.println("Introduzca un double (la coma flotante va separada por ','):");
		double d1 = sc.nextDouble();
		System.out.println("El número double es: " + d1);
		
		//Tenemos un método para cada uno de los tipos primitivos
		//float f1 = sc.nextFloat();
		
		//OJO!! Si recojes un tipo de dato y lo guardas en otro diferente
		//puede dar error
		System.out.println("Introduzca un número entero, ojo! un número entero!");
		//Si decís a java que queréis recoger un número y es un String
		//daria una excepción en tiempo de ejecición, concretamente
		//"java.util.InputMismatchException"
		//Puede también ocurrir si poneís un "nextInt()" y poneis un "double"
		int n4 = sc.nextInt();//IMPORTANTE: solo podemos poner por teclado un "int"
		System.out.println("El número es : " + n4);
		
		//OJO!!! IMPORTANTE!!! ALERTA!!!
		//La clase escaner tiene un pequeño problema. Siempre que queramos recoger
		//una cadena despues de haber recogido cualquier dato que no sea cadena
		//Ejemplo, recogemos un int y luego una cadena
		//Ejemplo, recogemos un double y luego una cadena
		//En este caso, debemos de recoger dos veces la cadena para que no de
		//problemas
	
		System.out.println("Introduzca la cadena a recoger: ");
		//Como el último dato que recogimos con Scanner fue un 'int'
		//ahora debemos de hacer 2 nextLint() para que el segundo funcione
		sc.nextLine();
		String cadena = sc.nextLine();
		System.out.println("La cadena recogida es: " + cadena);
	}

}
