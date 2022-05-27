package junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Felix
 *
 * Para generar una clase de pruebas, boton derecho | new | other | JUnit Test Case
 * 
 * El nombre de los métodos es arbitrario pero se recomienda que sea
 * representativo, lo importante es la anotación que lleve el método.
 *
 */
class _00_Anotaciones {
	
	//Este método con la anotacion @BeforeAll se va a ejecutar ANTES de TODOS 
	//los TEST (métodos anotados con @Test). Solo se pone una vez esta anotación

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Este metodo se ejecuta una unica vez y al principio");
	}

	//Este método con la anotacion @AfterAll sera ejecutado DESPUES de TODOS 
	//los TEST
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Este metodo se ejecuta una unica vez y al final");		
	}

	//Este método con la anotacion @BeforeEach sera ejecutado ANTES de cada 
	//UNO de los TEST
	//Ejemplo, se ejecutara antes de test1 y antes de test2 (2 veces)
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Este metodo se ejecuta una vez antes de cada test");
	}

	//Este método con la anotacion @AfterEach sera ejecutado DESPUES de cada 
	//UNO de los TEST
	//Ejemplo, se ejecutara despues del test1 y despues del test2
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Este metodo se ejecuta una vez despues de cada test");
	}
	
	//Estos serían los metodos que ejecutaran las pruebas unitarias
	//Son metodos con la anotacion @Test, y podemos tener todos los 
	//metodos que queramos con esta anotacion
	@Test
	void test1() {
		System.out.println("Test1. Esto es una prueba unitaria de palo :P");
	}

	//Con la anotación @DisplayName podemos cambiar el nombre por defecto
	//del nombre del test (por defecto, el nombre del método)
	@Test
	@DisplayName("Descripción del test que estamos pasando")
	void test2() {
		System.out.println("Test2. Esto es otra prueba unitaria de palo :)");
	}
	
	//Ejemplo de ejecucion para esta clase
	//boton derecho sobre la clase | run us | JUnit Test
	
	//El ciclo de vida sería el siguiente
	/*
	 * 1 BeforeAll
	 * 2 BeforeEach
	 * 3 Test1
	 * 4 AfterEach
	 * 5 BeforeEach
	 * 6 Test2
	 * 7 AfterEach
	 * 8 AfterAll
	 */	
}
