
public class _01_String {
	public static void main(String[] args) {
		//Manera habitual y recomendable de trabajar con String
		String s1 = "Hola esto es un String";
		
		//Otra manera menos recomendable es:
		String s2 = new String("Hola esto es un String");
		
		String s3 = "Hola esto es un String";
		
		String s4 = new String("Hola esto es un String");
		
		if(s2 == s4){
			System.out.println("Los strings son iguales???? ");
		}else{
			System.out.println("Los strings son diferentes");
		}
		
		if(s1 == s3){
			System.out.println("Los strings son iguales???? ");
		}else{
			System.out.println("Los strings son diferentes");
		}
		
		if(s1.equals(s2)){
			System.out.println("Los strings son iguales");
		}
		
		String s5 = "PEPE";
		String s6 = "pepe";
		if(s5.equalsIgnoreCase(s6)){
			System.out.println("Son iguales al margen de las "
					+ "mayusculas y minusculas");
		}
		//nos dice el tamaño
		System.out.println(s6.length());
		String s7 = "Juan-Maria-Antonio-Pedro";
		String arrayStrings[] = s7.split("-");
		for(String cadena : arrayStrings){
			System.out.println("El nombre es: " + cadena);
		}
		
		String s8 = s7.replace("-", " ");
		System.out.println(s8);
		arrayStrings = s8.split(" ");
		int i = 0;
		for(String cadena : arrayStrings){
			System.out.println("El nombre es: " + cadena + ", en la "
					+ "posicion " + ++i);
		}
		//pasamos todos los caracteres a mayusculas
		System.out.println(s8.toUpperCase());
		//pasamos todos los caracteres a minusculas
		System.out.println(s8.toLowerCase());
		
		//Para coger trozos de un String
		//desde la posicion 0, hasta la posicion 4 sin incluir
		String s9 = s8.substring(0,4);//Juan
		System.out.println("Substring: " + s9);
		
		String s10 = "10";
		int iNumero = Integer.parseInt(s10);
		System.out.println(iNumero + 20);
		
		String s11 = "10.10";
		double dNumero = Double.parseDouble(s11);
		System.out.println(dNumero + 45.11);
		
		//Caracteres
		String s12 = "abc";
		char c1 = s12.charAt(0);
		System.out.println(c1);//a
		int i1 = c1;//convertir a su valor ascii
		System.out.println("El valor ascii de a es: " + i1);
		
		//indexof
		int i2 = s12.indexOf('a');
		System.out.println(i2);//la posicion de a, la 0
		
	}
}
