package _10_estaticos;

/*
 * La parte estática de java es una parte de la memoria que 
 * siempre existe. Mientras que los objetos son dinámicos
 * y solo existen cuando se les crea, hay una parte
 * llamada "static" que existe durante todo el ciclo de vida del
 * programa.
 * 
 * Principalmente podemos encontra partes estáticas dentro de
 * atributos y de métodos. Para ello se declaran con la palabra
 * reservada "static"
 * 
 * Para crear métodos y atributos dinámicos no se utiliza ninguna
 * palabra reservada. Dicho de otra manera, prácticamente todo
 * con lo que hemos trabajado hasta ahora ha sido dinamico
 * 
 * A grandes rasgos podemos decir que lo dinámico está relacionado
 * con objetos y lo estático está relacionado con clases
 */
public class _01_MainEstaticos {

	//Este es un atributo dinámico y solo existira cuando exista
	//el objeto. Cada objeto tendrá este atributo y podrá 
	//almancenar un valor diferente. Dicho de otra manera,
	//todos los objetos tendrán asociado este atributo y cada
	//objeto tendrá un valor diferente
	//Para acceder a este atributo necesitamos la referencia
	//a su objeto (a no ser que estemos dentro del objeto)
	public int atributo1;
	//Este atributo es estatico, por lo que su ciclo de vida no
	//esta asociado al objeto. Este atributo existira siempre
	//y estará guardado fuera de los objetos. Dicho de otra maenera,
	//este atributo será COMPARTIDO por todos los objetos
	//Para acceder a este atributo necesimos la clase donde
	//se encuentra (a no ser que estemos dentro de la clase)
	public static int atributo2;
	
	//Las constantes del programa se declaran finales, 
	//estaticas y publicas. También con notación UpperSnakeCase
	public static final String NOMBRE_DEL_PROGRAMA = "ESTATICOS EN JAVA";
	
	//Nótese que el método main es un método estático
	public static void main(String[] args) {
		System.out.println(NOMBRE_DEL_PROGRAMA);
		//Para acceder a un método estatico desde un método estático
		//podemos llamarlo directamente
		presentarse();
		//También podemos llamarlo a traves de la clase
		_01_MainEstaticos.presentarse();

		//En cambio, un método dinamico, NO podemos llamarlo
		//directamente desde un método estatico, porque lo
		//dinámico solo existe cuando se crea el objeto.
		//presentarseDinamicamente();
		//Si queremos invocar un método dinámico desde un 
		//método estático, debemos tener el objeto
		_01_MainEstaticos me = new _01_MainEstaticos();
		me.presentarseDinamicamente();
		
		//Lo mismo con los atributos.
		//atributo1 = 9;
		me.atributo1 = 9;
		
		//Desde una referncia podemos acceder a la parte estática
		//pero no se debe. A lo estático se acceder de manera
		//estática
		//me.presentarse();
		
		atributo2 = 10;
		
		//Esto mismo se aplica si queremos trabajar con otras
		//clases
		Persona p1 = new Persona();
		Persona p2 = new Persona();
		Persona.numeroPersonas = 2;
		
		p1.edad = 45;
		p2.edad = 56;
		
		//Normalmente siempre es mucho más comodo trabajar
		//de manera dinámica. Por ejemplo en estos métodos
		//podemos ver como imprimir edades de manera diferente
		p1.imprimirEdadDinamico();
		p2.imprimirEdadDinamico();
		
		Persona.imprimirEdadEstatico(p1);
		Persona.imprimirEdadEstatico(p2);
	}
	
	public static void presentarse() {
		atributo2 = 89;
		//this.
		System.out.println("Hola parte estatica");
	}
	
	public void presentarseDinamicamente() {
		atributo1 = 9;
		this.atributo1 = 9;
		
		atributo2 = 23;
		_01_MainEstaticos.atributo2 = 34;
		System.out.println("Hola parte dinamica");
	}

}
