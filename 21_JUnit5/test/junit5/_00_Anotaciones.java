package junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Felix
 *
 * Esta clase seria un ejemplo de auto generada
 * (boton derecho -> new -> other -> JUnit Test Case
 * Aunque se pueden llamar como quieran los metodos, estos serian los 
 * nombres recomendados
 *
 */
class _00_Anotaciones {

	// Tenemos metodos que se ejecutaran en distinto momentos del ciclo de vida 
	//de una clase de pruebas
	
	// El ciclo de vida de una clase de pruebas, sera la ejecución de todos
	//los metodos anotados con "@Test". 
	// Pero tambien tenemos otras anotaciones que se ejecutaran
	
	// Si quereis que algun metodo no haga nada, simplemente lo dejais vacio
	
	// Este metodo con la anotacion @BeforeAll se va a ejecutar ANTES de TODOS 
	//los Test (metodos anotados con @Test). Esta anotacion es unica
	//Ejemplo, se ejecutara antes del test1 y solo esa vez
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		// Aqui suelen inicializarse valores o objetos que vayan a ser 
		//utilizados por todo nuestros casos de prueba, como puede ser
		//una conexión a la BBDD
		
		System.out.println("Este metodo se ejecuta una unica vez y al principio");
	}

	// Este método con la anotacion @AfterAll sera ejecutado DESPUES de TODOS 
	//los test
	//Ejemplo, se ejecutara despues del test2 y solo esa vez
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		//Cerrar conexiones con BBDD, cerrar ficheros,...
		System.out.println("Este metodo se ejecuta una unica vez y al final");		
	}

	// Este método con la anotacion @BeforeEach sera ejecutado ANTES de cada 
	//UNO de los TEST
	//Ejemplo, se ejecutara antes de test1 y antes de test2 (2 veces)
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Este metodo se ejecuta una vez antes de cada test");
	}

	// Este método con la anotacion @AfterEach sera ejecutado DESPUES de cada 
	//UNO de los TEST
	//Ejemplo, se ejecutara despues del test1 y despues del test2
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Este metodo se ejecuta una vez despues de cada test");
	}

	//Luego irian todos los test unitarios.
	
	//Estos serian los metodos que ejecutaran las pruebas unitarios, 
	//son metodos con la anotacion @Test, y podemos tener todos los 
	//metodos que queramos con esta anotacion
	@Test
	void test1() {
		System.out.println("Esto es una prueba unitaria de palo :P");
	}

	@Test
	void test2() {
		System.out.println("·Esto es otro prueba unitaria de palo :)");
	}
	
	//Ejemplo de ejecucion para esta clase
	//boton derecho sobre la clase -> Run us -> JUnit Test
	
	/*
	 * 1 BeforeAll
	 * 2 BeforeEach
	 * 3 test1
	 * 4 AfterEach
	 * 5 beforeEach
	 * 6 test2
	 * 7 afterEach
	 * 8 afterAll
	 */
	
}
