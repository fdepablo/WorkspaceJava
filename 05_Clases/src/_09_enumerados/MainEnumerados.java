package _09_enumerados;

import java.util.Scanner;

public class MainEnumerados {

	public static void main(String[] args) {
		//Los enumerados nos van a ayudar a normalizar
		//resultados. Ej, si queremos poner calle, la podemos
		//poner de muchas maneras.
		
		//Direccion d1 = new Direccion();
		//d1.setTipoVia("calla");
		//d1.setTipoVia("CALLE");
		//d1.setTipoVia("c\\");//c\
		
		//Para acceder a un enumerado en concreto lo haremos
		//a traves de su clase, con un "." y luego el nombre
		//del enumerado
		System.out.println(TipoVia.CALLE);
		System.out.println(TipoVia.AVENIDA);
		
		//Podemos recorrer todos los tipos como un array
		//accediendo a el método "values()"
		System.out.println("Recorriendo el array");
		for(int i = 0; i < TipoVia.values().length;i++) {
			System.out.println(TipoVia.values()[i]);
		}
		
		//Mejor ForEach
		System.out.println("Recorriendo el array con un for each");
		for(TipoVia tv : TipoVia.values()) {			
			System.out.println(tv);
		}
		
		//Podemos utilizar los enumerados para mostrarlos al usuario
		Scanner sc = new Scanner(System.in);
		System.out.println("Seleccione el tipo de via que quiere seleccionar");	
		for(int i = 0; i < TipoVia.values().length;i++) {
			System.out.println(i + "-" +TipoVia.values()[i]);
		}
		
		int seleccion = sc.nextInt();
		TipoVia tv = TipoVia.values()[seleccion];
		System.out.println("Usted a seleccionado: " + tv);
		
		//Trabajando con enumerados dentro de clases
		Direccion d1 = new Direccion();
		Persona p1 = new Persona();
		//Ya no podemos poner lo que queramos, tenemos que 
		//ceñirnos a un enumerado (vease el principio del main)
		d1.setTipoVia(TipoVia.AVENIDA);		
		p1.setDireccion(d1);
		
		System.out.println(p1);
		
		d1.setTipoVia(TipoVia.CAÑADA_REAL);
		
		System.out.println(p1);
		sc.close();	
	}

}
