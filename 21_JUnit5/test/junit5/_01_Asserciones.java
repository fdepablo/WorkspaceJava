package junit5;

//OJO con la manera de importar los asserts, son metodos estaticos de la clase
//Assert y por tanto hay que importarlos de manera estatica (import static)

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import programa.Persona;

class _01_Asserciones {

	/*
	 * Podemos ejecutarlas con boton derecho -> run as.. -> JUnit Test
	 * 
	 * Posibles colores al lanzar la prueba:
	 * 
	 * 1) Verde, todas las pruebas han ido bien
	 * 2) Azul, alguna prueba ha ido mal, alguna aserción no se ha 
	 * cumplido o se ha ejecutado la función fail()
	 * 3) Rojo, ha habido algun error en la prueba, digamos que no es 
	 * concluyente y se debería revisar
	 * 
	 * Para dar por pasadas las pruebas debería se salir el color verde
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

	@Test
	public void acabaEnMundoTest() {
		System.out.println("Test 1");
		//Este ejemplo es como si la clase String de java no se hubiera
		//probado y la gente de oracle nos encargara que nos asegurarmos
		//que sus metodos funcionan
		String cadena = "hola mundo";
		// Las funciones assert son funciones de aceptación
		
		// Sirven para dar por valida una prueba, si no cumple un assert 
		//la prueba sera fallida
		// Si lo cumple, la prueba sera valida

		// Un assert es determinante para dar por buena una prueba. En 
		//cuanto se ejecute un assert y ese assert de FALLO, se acaba la 
		//prueba
		
		//Si el assert no da fallo, seguiria con la ejecución de la prueba 
		//(pudiendo poner otros asserts)
		
		//Normalmente estos metodos trabajan con clases y metodos del 
		//programa principal para probar su funcionamiento
		
		//Este assert comprueba que el resultado sea "true"
		assertTrue(cadena.endsWith("mundo"));
		//Este ejemplo sería como si yo estuviera testeando la clase
		//String
	}
	
	@Test
	public void noAcabaEnHolaTest() {
		System.out.println("Test 2");
		String cadena = new String("Hola mundo");
		//En este caso esperamos que sea falso
		assertFalse(cadena.endsWith("hola"));//FALSE, dariamos por buena la prueba
	}
	
	@Test
	public void esIgualAHolaMundoTest() {
		System.out.println("Test 3");
		String cadena = "hola mundo";
		//En este caso esperamos que sean iguales 
		//(según el metodo equals())
		
		//Vamos a testear el metodo toUpperCase()
		String resultadoEsperado = "HOLA MUNDO";
		assertEquals(cadena.toUpperCase(),resultadoEsperado);
		//No solo para String, para todos los primitivos, objetos, etc
	}
	
	@Test
	public void noEsIgualAPepeTest() {
		System.out.println("Test 4");
		String cadena = "Hola Mundo";
		//Que no sean iguales (según el metodo equals())
		//Vamos a testear el metodo toLowerCase
		String resultadoNoEsperado = "HOLA MUNDO";
		assertNotEquals(cadena.toLowerCase(), resultadoNoEsperado);
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
	//Hasta aquí los asserts más importantes
	
	
	//Podemos tambien que ocurra alguna excepcion
	@Test
	public void exceptionTest() {
		System.out.println("Test 7");
		
		String cadena = new String("Hola mundo");
		
		//Hay que hacer una funcion lambda
		Exception exception = assertThrows(
				IndexOutOfBoundsException.class, 
				() -> cadena.charAt(20));
		
		//la excepcion capturada es IndexOutOfBoundsException
		//por lo que el mensaje que tendrá será el siguiente
	}
	
	//Tiempo maximo para que se ejecute el test (en ms)
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void timeTest() throws InterruptedException{
		System.out.println("Test 8");
		String cadena = new String("Hola mundo");
		
		Thread.sleep(50);
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
		//Con esto comprobamos que sean igual y que tengan 
		//los mismos elementos 2 arrays
		assertArrayEquals(lista1.toArray(), lista2.toArray());
	}
	
	@Test
	public void assertSameTest() throws InterruptedException{
		System.out.println("Test 10");
		Persona p1 = new Persona();
		//s1 = "Hola";
		Persona p2 = new Persona();
		
		p1 = p2;
		//Comprobamos si apuntan al mismo objeto(no invoca a equal, 
		//es si la referencia apunta al mismo objeto)
		assertSame(p1, p2);//este test falla, ya que son objetos diferentes
		//tambien tenemos assertNotSame(s1,s2)
	}
	
	/*
	@Test
	public void failTest() throws InterruptedException{
		System.out.println("Test 11");
		//podemos fallar el test bajo alguna cóndición, si se llega a ejecutar fail() en algun momento
		//se da por fallada la prueba
		if(true) {
			fail("Con esto fallamos");
		}
		System.out.println("Fin del Test 9");
	}*/

}
