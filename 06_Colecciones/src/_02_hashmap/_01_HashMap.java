package _02_hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class _01_HashMap {
	public static void main(String[] args) {
		//Tenemos otro tipo de estructuras MUY importantes que son
		//las llamadas estructuras hash, diccionarios o arrays asociacivos,
		//según el lenguaje que estemos usando
		
		//Este tipo de estructuras se caracterizan por tener una clave
		//y un valor asociados, es decir, a partir de una clave podemos
		//acceder o modificar un valor
		
		//Solamente puede haber UNA clave, en caso de que se pongan dos
		//claves iguales, el valor se sobreescribe
		
		//Para crear una estructura de tipo hash, podemos usar la clase
		//HastMap
		
		HashMap<String, Double> hashmapCiudadTemperatura =
				new HashMap<>();
		
		//podemos establecer claves y valores con el método put(clave,valor)
		hashmapCiudadTemperatura.put("Madrid", 10.0);
		hashmapCiudadTemperatura.put("Barcelona", 11.0);
		
		//podemos acceder a los valores con el método get(clave) 
		Double temperatura = hashmapCiudadTemperatura.get("Madrid");
		System.out.println(temperatura);
		temperatura = hashmapCiudadTemperatura.get("Barcelona");
		System.out.println(temperatura);
		//Si accedemos a una clave que NO exite te devuelve NULL
		temperatura = hashmapCiudadTemperatura.get("Zaragoza");
		System.out.println(temperatura);
		
		//Las clave son CASE SENSITIVE
		//No es lo mismo "Madrid" que "MADRID"
		temperatura = hashmapCiudadTemperatura.get("MADRID");
		System.out.println(temperatura);
		
		//Podemos saber si una clave existe con el método containsKey()
		//que devuelve true o false
		System.out.println(hashmapCiudadTemperatura.containsKey("Madrid"));
		System.out.println(hashmapCiudadTemperatura.containsKey("MADRID"));		
		
		//El objetivo de los hashmap es diferente a de los arrays
		//siven para hacer busquedas rápidas, no suelen servir
		//para recorrerlos
		
		//Si se quiere recorrer los mejor es una funcion lambda
		hashmapCiudadTemperatura.forEach((k,v) -> {
			System.out.print("clave: " + k.toString());
			System.out.println(" valor: " + v.toString());
		});
		
		ArrayList<String> listaNombres = new ArrayList<String>();
		listaNombres.add("Gallego");
		listaNombres.add("Marquitos");
		listaNombres.add("Guillermo");
		
		//con funciones
		listaNombres.forEach( v -> System.out.println("Nombre: " + v));
		
		//Si ponemos la misma clave, se sobrescribe el valor
		hashmapCiudadTemperatura.put("Madrid", (double)7);
		System.out.println(hashmapCiudadTemperatura.get("Madrid"));
		
		//Java soporta la inferencia de tipos
		//Esta caracteristica permite definir el tipo de la variable
		//en el momento de asiganar el primer valor, pero OJO!!!
		//el tipo de la variable SIEMPRE sera del tipo del valor, 
		//NO se puede cambiar. No confundar con los lenguajes NO
		//TIPADOS
		var numero1 = 34.0;//el tipo de esta variable será Double 
							//y siempre los sera
		System.out.println(numero1);
		//numero1 = true;//no podemos apuntar con un Double a un boolean
		numero1 = 45.0;
		var numero2 = 100;//El tipo será Integer y no podrá ser de otro tipo
		//numero2 = 45.0;
		
		//los tipos inferidos solo solo para las variables, no se pueden
		//usar en los atributos de clase
		
	}
}
