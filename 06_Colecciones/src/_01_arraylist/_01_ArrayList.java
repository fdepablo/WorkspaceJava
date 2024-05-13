package _01_arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class _01_ArrayList {

	//Clase sobre los array list de la semana del 22/02
	public static void main(String[] args) {
		//Los arrays "normales" en java tienen un problema y es que son
		//estaticos, es decir, una vez creado el array, el tamaño no
		//puede cambiar nunca. Si creamos un array de 5 elementos
		//solo podra tener 5 elementos.
		
		String[] arrayStrings1 = new String[5];
		//aunque no tenga ningún elemento el array si pregunto
		//por su tamaño, me dice 5
		System.out.println(arrayStrings1.length);

		//Normalmente este tipo de array NO se suele utilizar
		//En su lugar se utilizan arrays dinamicos, es decir
		//arrays que se amplia el tamaño en tiempo de ejecución
		//dicho de otra menera, nunca se llenan.
		
		//La clase ArrayList se tiene que parametrizar, esto es,
		//se pone entre <> el tipo de dato que queremos que contenga
		//el ArraList. A los arraylist yo los llamos listas
		ArrayList<String> listaString1 = new ArrayList<String>();
		//Si preguntamos por el tamaño del array
		System.out.println(listaString1.size());
		
		//Con arrays normales tenemos que tener siempre en cuenta
		//la posición del array que estamos usando
		arrayStrings1[0] = "Tom Sawyer";
		arrayStrings1[1] = "Scooby Doo";
		
		//Con arraylist no necesitamos controlar ultima posición
		//usada, podemos usar el método "add" que añade automáticamente
		//a la última posición libre del array
		listaString1.add("Son Goku");
		listaString1.add("Vegeta");
		
		//Para recorrer array lo posemos igual, pero vemos diferencias
		System.out.println("imprimiendo array");
		for(String s : arrayStrings1) {
			System.out.println(s);
		}
		
		System.out.println("imprimiendo arraylist");
		for(String s : listaString1) {
			System.out.println(s);
		}
		
		//Accediendo a elementos concretos
		System.out.println(arrayStrings1[0]);
		System.out.println(listaString1.get(0));
		
		//Estas dos sentencias dan Exceptiones
		//System.out.println(arrayStrings1[5]);//ArrayIndexOutOfBoundsException
		//System.out.println(listaString1.get(2));//IndexOutOfBoundsException
		
		//Podemos rellenar posicones concretas
		listaString1.set(1, "Broly");
		
		//Notese la diferencia de imprimir directamente un array y un arraylist
		System.out.println(arrayStrings1);
		System.out.println(listaString1);
		System.out.println(Arrays.toString(arrayStrings1));
		
		//Podemos añadir un elemento a una posición dada y desplazaría
		//los demas
		listaString1.add(1, "Freezer");
		System.out.println(listaString1);//[Son Goku, Freezer, Broly]
		//ver _01_ArrayList_01_arrays_vs_arraylist.jpg

		//La parametrización de los arraylist NO admiten primitivos
		//pero afortunadamente Java invento los tipo "Wrapper" de los
		//primitivos. Dicho de otra manera todos los primitivos
		//tienen su equivalente a objeto.
		
		int numero1 = 5;
		//Integer numeroObjeto = new Integer(5);
		//Normalmente esta el concepto "auto wrapper" que hace
		//que Java convierta directamente un primitivo a un objeto
		Integer numeroObjeto = 5;//Esto creo un objeto con el valor 5 internamente
		//Los objetos de tipo wrapper son "inmutables". Un objeto inmutable
		//se define como un objeto el cual no se puede cambiar NUNCA el valor
		//de sus atributos (también llamado estado)
		numeroObjeto = 6;
		
		//La clase String tambien es inmutable
		String s = "Sherlock";
		//Aquí lo que estamos cambiando es la referencia de sitio,
		//pero valor del objeto no se cambia (permanece inmutable)
		s = "Dr. Wattson";
		
		String s2 = "Sherlock";
		//ver _01_ArrayList_02_wrappers.jpg
		
		//Existen tipos wrappper para todos los primitivos
		//que se suelen llamar igual que el primitivo pero
		//con la primera letra en mayuscula
		double d1 = 4.5;
		Double d2 = 5.6;
		Boolean b1 = true;
		Float f1 = 5.6F;
		Character c1 = 'f';
		Byte byte1 = 23;
		
		//ArrayList<int> listaEnteros = new ArrayList<>();
		ArrayList<Integer> listaEnteros = new ArrayList<>();
		//Operador diamente, desde la 1.7, y dice que no es
		//necesario crear el objeto con la parametrización,
		//automáticamente coge el de la referencia
		ArrayList<Double> listaDobles = new ArrayList<Double>();
		
		
	}

}
