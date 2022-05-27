package junit5;

//OJO con la manera de importar los asserts, son metodos estaticos de 
//la clase Assert y por tanto hay que importarlos de manera 
//estatica (import static)

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import programa.Persona;

class _01_Asserciones {

	/*
	 * Podemos ejecutarlas con boton derecho | run as | JUnit Test
	 * 
	 * En este caso no vamos a crear el resto de metodos del ciclo de vida
	 */
	
	@Test
	public void acabaEnMundoTest() {
		System.out.println("Test 1");
		//Este ejemplo es como si la clase String de java no se hubiera
		//probado y la gente de oracle nos encargara de asegurarnos
		//de que sus metodos funcionan. Para ello debemos de leer su
		//documentación.
		String cadena = "hola mundo";
		assertTrue(cadena.endsWith("mundo"));
	}
	
	@Test
	public void noAcabaEnHolaTest() {
		System.out.println("Test 2");
		String cadena = new String("Hola mundo");
		//En este caso esperamos que sea falso
		assertFalse(cadena.endsWith("hola"));//FALSE, dariamos por buena la prueba
		
		//Probamos que cuando sea cadena vacia devuelve true
		assertTrue(cadena.endsWith(""));
	}
	
	@Test
	public void esIgualTest() {
		System.out.println("Test 3");
		String cadena = "hola mundo";
		
		//Vamos a testear el metodo toUpperCase() de String
		String resultadoEsperado = "HOLA MUNDO";
		String resultadoObtenido = cadena.toUpperCase();
		assertEquals(resultadoEsperado,resultadoObtenido);
		//No solo para String, para todos los primitivos, objetos, etc
	}
	
	@Test
	public void noEsIgualTest() {
		System.out.println("Test 4");
		String cadena = "Hola Mundo";
		String resultadoNoEsperado = "HOLA MUNDO";
		String resultadoObtenido = cadena.toLowerCase();
		assertNotEquals(resultadoNoEsperado,resultadoObtenido);
	}

	@Test
	public void esNullTest() {
		System.out.println("Test 5");
		String cadena = null;

		assertNull(cadena);
	}
	
	@Test
	public void noEsNullTest() {
		System.out.println("Test 6");
		String cadena = new String("Hola mundo");

		assertNotNull(cadena);
	}
	
	//Podemos tambien que ocurra alguna excepcion
	@Test
	public void exceptionTest() {
		System.out.println("Test 7");
		
		String cadena = new String("Hola mundo");
		
		//Hay que hacer una funcion lambda sobre el metodo que
		//queremos probar si lanza una excepción concreta.
		assertThrows(
				IndexOutOfBoundsException.class, 
				() -> cadena.charAt(20));
		
		assertThrows(
				IndexOutOfBoundsException.class, 
				() -> cadena.charAt(-1));
		
		char caracterEsperado = 'o';
		char caracterObtenido = cadena.charAt(1);
		assertEquals(caracterEsperado, caracterObtenido);
	}
	
	//Tiempo maximo para que se ejecute el test (en ms)
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void timeTest() throws InterruptedException{
		System.out.println("Test 8");
				
		Thread.sleep(50);
		//Si se demora más de 100ms el test no será valido
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
		//Con esto comprobamos que dos arrays tengan los mismos elementos
		//y sean iguales
		assertArrayEquals(lista1.toArray(), lista2.toArray());
	}
	
	@Test
	public void assertSameTest() throws InterruptedException{
		System.out.println("Test 10");
		Persona p1 = new Persona();
		p1.setNombre("Tony");
		Persona p2 = new Persona();
		p2.setNombre("Tony");
		
		p1 = p2;
		//Comprobamos si apuntan al mismo objeto(no invoca al método "equal"), 
		//es decir, que ambas referencias apunten al mismo objeto.
		assertSame(p1, p2);//este test falla, ya que son objetos diferentes
	}
	
	
	@Test
	public void failTest() throws InterruptedException{
		System.out.println("Test 11");
		//Podemos hacer fallar el test bajo alguna cóndicion
		boolean vacio = "".isEmpty();
		if(!vacio) {
			fail("Test Fallado!");
		}

	}
}
