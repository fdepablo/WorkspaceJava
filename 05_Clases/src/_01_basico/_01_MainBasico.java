package _01_basico;

public class _01_MainBasico {

	public static void main(String[] args) {
		// A partir de una clase podremos crear los objetos.
		// Un objeto es una instancia de una clase.
		
		// Los objetos se crean en la JVM en un espacio de memoria
		// llamado 'heap'
		
		// Para crear un objeto en Java usaremos la palabra reservada "new"
		// Un programa Java tendrá (a priori) tantos objetos como 
		// "news" hayamos hechos.
		
		//Normalmente necesitamos una variable para apuntar al objeto
		//creado. Las variables de clase se llaman "referencias"
		//IMPORTANTE:
		//- Una variable contiene el valor
		//Ej: una variable de tipo "int" contiene el valor "5"
		//- Una referencia contiene la posición de memoria de donde
		//se encuentra el objeto.
		//Ej: una referencia de tipo String contiene la posición de memoria
		//"0x123EAF" y en esa memoria estará el objeto de tipo String (con 
		//su valor)
		
		//Las variables se crean en un espacio de memoria llamado "stack"
		int numero = 5;
		
		//Las referencias se crean tambien en el "stack", pero el objeto
		//se crea en el "heap"
		String cadena = new String("Pepe");
		
		//Cuando creamos un objeto, por defecto, los primitivos se inicializan
		//a "0" (booleanos a "false), y las referencias a "null"
		Persona p1 = new Persona();
		//ver dibujo "dibujos/_01_basico_01_variable_referencia"
		
		//podemos acceder a las propiedades de un objeto mediante la referencia
		//y un "."
		System.out.println(p1.nombre);
		System.out.println(p1.edad);
		System.out.println(p1.peso);
		System.out.println(p1.estaCasado);
		
		
		//Podemos tambien modificar los valores de los atributos de un objeto
		p1.nombre = "Thor";
		p1.edad = 167;
		p1.peso = 105.6;
		p1.estaCasado = true;
		
		//Se llama "estado de un objeto" al valor de los atributos en un
		//instante de tiempo.
		
		//Si imprimimos la referencia, en principio nos da su direccion de
		//memoria
		System.out.println(p1);
		//ver dibujo "dibujos/_01_basico_01_variable_referencia_persona"
	}

}
