package clases_nativas;

import java.text.DecimalFormat;
import java.util.Random;

public class _03_Math {

	public static void main(String[] args) {

		//La clase Math nos va a servir para realizar operaciones matemáticas
		//https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Math.html
		
		//Esta clase todos sus métodos son ESTATICOS, es decir, NO es necesario
		//crear objetos de la clase MATH para invocar sus métodos.
		
		//Ejemplo
		//Si queremos usar la clase RANDOM tenemos que crear un objeto de la
		//clase, y eso se hace con la palabra reservada "new"
		Random rd = new Random();
		rd.nextDouble(1, 100);
		
		//En la clase MATH al ser sus métodos ESTÁTICOS debemos invocarlos
		//directamente desde la clase
		//Ejemplo para obtener una potencia
		double potencia = Math.pow(2, 3);
		//NÓTESE como no hago NEW de la clase MATH
		
		//Podemos obtener el número PI o el número E
		final double constantePI = Math.PI;
		System.out.println(Math.PI);
		
		
		//Returns the largest (closest to positive infinity) double value 
		//that is less than or equal to theargument and is equal to a 
		//mathematical integer
		System.out.println(Math.floor(4.99));
		System.out.println(Math.floor(4.01));
		
		//Returns the smallest (closest to negative infinity) double value 
		//that is greater than or equal to theargument and is equal to a 
		//mathematical integer.
		System.out.println(Math.ceil(4.99));
		System.out.println(Math.ceil(4.01));
		
		//Returns the closest long to the argument, with tiesrounding 
		//to positive infinity. 
		System.out.println(Math.round(4.99));
		System.out.println(Math.round(4.51));
		System.out.println(Math.round(4.5));
		System.out.println(Math.round(4.49));
		System.out.println(Math.round(4.01));
		
		System.out.println(Math.abs(3));
		System.out.println(Math.abs(-3));
		
		//Otra manera de calcular aleatorios.
		//En este caso te devuelve un número aleatorio entre el 0 y el 1
		System.out.println(Math.random());
		
		//Donde N es el valor máximo. Esto nos genera un número aleatorio
		//entre el 1 y N
		//int numeroAletorio = (int) (Math.random() * n) + 1;
		int numeroAletorio = (int) (Math.random() * 10) + 1;
		System.out.println(numeroAletorio);
		
		//Raiz cuadrada
		System.out.println(Math.sqrt(49));
		
		//Si queremos quedarnos con un número de decimales
		//debemos usar la clase DecimalFormat
		DecimalFormat df = new DecimalFormat("0.000");
		System.out.println(df.format(Math.PI));
		
		//Podemos convertir cadenas a numeros
		//MUY IMPORTANTE cuando leemos datos de ficheros, bases de datos, etc.
		int numero = Integer.parseInt("50");
		double numero2 = Double.parseDouble("50.67");
		System.out.println(numero);
		System.out.println(numero2);
	}

}
