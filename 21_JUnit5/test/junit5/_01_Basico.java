package junit5;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class _01_Basico {

	/*
	 * Con esto buscamos hacer unas pruebas unitarias
	 * Consisten en probar la correcta funcionalidad del módulo en 
	 * cuestión como si actuara independiente de los demás.
	 * Serían las pruebas más basicas y precederían a las pruebas de 
	 * integración
	 * 
	 * Podemos ejecutarlas con boton derecho -> run as.. -> JUnit Test
	 * Posibles colores al lanzar la prueba
	 * Verde, la prueba ha ido bien
	 * Azul, la prueba ha ido mal, alguna aserción no se ha cumplido
	 * Rojo, ha habido algun error en la prueba
	 */
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Esto se ejecuta UNA sola vez, al PRINCIPIO de todos los test");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Esto se ejecuta UNA sola vez, al FINAL de todo");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Se ejecuta ANTES de cada test");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Se ejecuta DESPUES de cada test");
	}


	//Esta anotación sería un test unitario
	@Test
	public void acabaEnMundoTest() {
		System.out.println("Test 1");
		String cadena = new String("Hola mundo");
		//Las funciones assert son funciones de aceptación
		//para dar por valida una prueba
		//en este caso esperamos que sea cierta una condición
		//En cuanto llegue a un assert se acaba la prueba
		assertTrue(cadena.endsWith("mundo"));
	}
	
	@Test
	public void noAcabaEnHolaTest() {
		System.out.println("Test 2");
		String cadena = new String("Hola mundo");
		//En este caso esperamos que sea falso
		assertFalse(cadena.endsWith("hola"));
	}
	
	@Test
	public void esIgualAHolaMundoTest() {
		System.out.println("Test 3");
		String cadena = new String("Hola mundo");
		//En este caso esperamos que no sean iguales (según el metodo equals())
		assertEquals("Hola mundo",cadena);
		//No solo para String, para todos los primitivos, objetos, etc
	}
	
	@Test
	public void noEsIgualAPepeTest() {
		System.out.println("Test 4");
		String cadena = new String("Hola mundo");
		//Que no sean iguales (según el metodo equals())
		assertNotEquals("Pepe",cadena);
	}

	@Test
	public void esNullTest() {
		System.out.println("Test 5");
		String cadena = null;
		//esperamos que sea nulo
		assertNull(cadena);
	}
	
	@Test
	public void noEsNullTest() {
		System.out.println("Test 6");
		String cadena = new String("Hola mundo");
		//Esperamos que no sea nulo
		assertNotNull(cadena);
	}
	
	//Podemos tambien que ocurra alguna excepcion
	@Test
	public void exceptionTest() {
		System.out.println("Test 7");
		
		String cadena = new String("Hola mundo");
		
		Exception exception = assertThrows(
				IndexOutOfBoundsException.class, 
				() -> cadena.charAt(20));
		
		//la excepcion capturada es Index IndexOutOfBoundsException
		//por lo que el mensaje que tendrá será el siguiente
        assertTrue(exception.getMessage().contains("String index out of range"));
	}
	
	//Tiempo maximo para que se ejecute el test (en ms)
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void timeTest() throws InterruptedException{
		System.out.println("Test 8");
		String cadena = new String("Hola mundo");
		
		//Thread.sleep(150);
		//Si se demora más de 100ms no se ejecuta más codigo
		//se parará la ejecución
		System.out.println("Fin del Test 8");
	}
	
	@Test
	public void assertArrayEqualsTest() throws InterruptedException{
		System.out.println("Test 9");
		List<String> lista1 = new ArrayList<>();
		lista1.add("Pepe");
		lista1.add("Ana");
		List<String> lista2 = new ArrayList<>();
		lista2.add("Pepe");
		lista2.add("Ana");
		//Con esto comprobamos que sean igual y que tengan los mismos
		//elementos 2 arrays
		assertArrayEquals(lista1.toArray(), lista2.toArray());
	}
	
	@Test
	public void assertSameTest() throws InterruptedException{
		System.out.println("Test 10");
		String s1 = new String("Hola");
		//s1 = "Hola";
		String s2 = "Hola";
		//Comprobamos si apuntan al mismo objeto(no invoca a equal, 
		//es si la referencia apunta al mismo objeto)
		assertSame(s1, s2);//este test falla, ya que son objetos diferentes
		//tambien tenemos assertNotSame(s1,s2)
	}
	
	//Podemos usar esta etiqueta si queremos ignorar algun test en un momento
	//dado
	//@Ignore("De momento no la queremos pasar")
	@Test
	public void failTest() throws InterruptedException{
		System.out.println("Test 11");
		//podemos fallar el test bajo alguna cóndición
		if(true) fail("Con esto fallamos");
		System.out.println("Fin del Test 9");
	}

}
