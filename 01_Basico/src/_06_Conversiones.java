
public class _06_Conversiones {

	public static void main(String[] args) {
		long numeroLargo = 1_000L;
		//podemos igualar siempre variables del mismo tipo
		//sin problema
		long numeroLargo2 = numeroLargo;
		//Java no puede saber cuando ejecuta el programa el 
		//valor de la variable. Por lo que no va a dejar
		//igualar un entero a un long
		int numeroEntero = 0;//Es importante inicializar las variables SIEMPRE
		//int numeroEntero = numeroLargo;//error
		//Si el tipo de dato que queremos guardar es menor
		//que el tipo de datos de la variable, entonces si que 
		//podemos.
		numeroLargo = numeroEntero;
		byte numeroByte = 100;
		numeroEntero = numeroByte;
		//A la inversa, NO podemos
		//numeroByte = numeroEntero;
		
		//Conversión de datos
		//Si queremos convertir un tipo de dato a otro,
		//debemos usar el 'casting'. 
		//Esta tecnica siempre hay que usarla cuando queremos
		//introducir un tipo de dato mas grande en un tipo de
		//dato más pequeño
		//Ej: si queremos introducir un long en un int
		//debemos hacer SIEMPRE un cast. Al reves no haría falta
		numeroLargo = 10_000L;
		//casteamos el numero largo. Para castear se pone el tipo de dato
		//al que queremos cambiarlo entre parentesis justo antes del 
		//tipo tipo de dato que queremos 'castear'
		numeroEntero = (int)numeroLargo;//Casting
		System.out.println(numeroEntero);
		
		//Tipos de datos ordenados de mayor a menor de números enteros
		//long > int > char = short > byte 
		//Tipos de datos ordenados de mayor a menor de números en punto flotante
		//double > float
		
		//Ojo, siempre que hagamos un cast de un numero en punto flotante a 
		//un número vamos a perder la parte decimal
		
		numeroLargo = 2_147_483_648L;//No entra en un entero por 1
		//Ojo, hay que ser responsbles con los casting, porque
		//java va a realizar lo posible para hacer el cast, pero eso
		//no significa que este bien hecho.
		numeroEntero = (int)numeroLargo;//Casting
		//En este caso, java da la vuelta al numero, y empieza
		//a contar desde los negativos.
		System.out.println(numeroEntero);
		
		numeroEntero = (int)numeroLargo * 2;//Casting
		System.out.println(numeroEntero);//volvemos al cero
		
		//Ejemplo con número doble
		double numeroDoble = 20.75;
		//numeroLargo = numeroDoble;//error
		numeroLargo = (long)numeroDoble;//eliminar la parte decimal
		System.out.println(numeroLargo);
		//Ojo con estas cosas porque es posible que se pierda infomación
		numeroDoble = 30.00;
		numeroLargo = (long)numeroDoble;
		System.out.println(numeroLargo);
		
		//Boolean
		boolean bool1 = false;
		//numeroByte = (byte)bool1;//hay veces que no tiene sentido hacer casting
		
		//Cadenas
		String cadenaNumerica = "1";
		//numeroDoble = (int)cadenaNumerica;//Tampoco se puede hacer esto
		//cadenaNumerica = (String)numeroEntero;//Tampoco se puede hacer esto
	}

}
