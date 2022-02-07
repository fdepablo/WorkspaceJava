package junit5.programa;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import programa.Persona;

public class _01_TestPersona {
	
	private Persona p1;
	
	@BeforeEach
	void setUp() throws Exception {
		//Me interesa antes de cada test tener un objeto persona 
		//limpio (nuevo)
		p1 = new Persona();
		//configuramos todo lo que queramos antes de cada @Test
	}

	@AfterEach
	void tearDown() throws Exception {
		p1 = null;
	}

	/**
	 * En esta prueba unitaria vamos a probar el metodo "setNombre"
	 */
	@Test
	public void testSetNombre(){
		//No hace falta crear el objeto porque  lo creamos en el 
		//metodo anotado con @BeforeEach
		p1.setNombre("Goku");
		//el nombre en el objeto tiene que estar puesto a Goku
		
		//Espero que el nombre sea Goku, y lo compruebo con el nombre 
		//que hay en el objeto
		assertEquals("Goku", p1.getNombre());
		
		p1.setNombre("ana");
		//el nombre tiene que estar puesto a Goku
		
		//Espero que el nombre sea "", y lo compruebo con el nombre 
		//que hay en el objeto
		assertEquals("", p1.getNombre());
		
		//Podemos pasar mas pruebas, no tienen porque estar de m�s
		p1.setNombre("az");
		assertEquals("", p1.getNombre());
		
		p1.setNombre("a");
		assertEquals("", p1.getNombre());
		
		p1.setNombre("Pikolo");
		assertEquals("Pikolo", p1.getNombre());
	}
	
	@Test
	public void testConstructores() {
		Persona p = new Persona("Tony", 23, 45);
		
		assertEquals("Tony", p.getNombre());
		assertEquals(23, p.getEdad());
		assertEquals(45, p.getPosicion());
	}
	
	@Test
	public void testCaminar() {
		p1.setPosicion(0);
		
		p1.caminar(30);
		
		assertEquals(30, p1.getPosicion());
		
		p1.caminar(50);
		
		assertEquals(80, p1.getPosicion());
		
		p1.caminar(100);
		
		assertEquals(180, p1.getPosicion());
	}

	@Test
	public void testCopiaPersona() {
		p1.setNombre("Vegeta");
		p1.setEdad(35);
		p1.setPosicion(100);
		
		Persona p2 = p1.copiarPersona();
		
		assertEquals(p1.getNombre(), p2.getNombre());
		assertEquals(p1.getEdad(), p2.getEdad());
		assertEquals(p1.getPosicion(), p2.getPosicion());
		
		//Para dar por buena la prueba tengo que comprobar que
		//ambos objetos no son el mismo
		
		//System.out.println(p1);
		//System.out.println(p2);
		//No nos valdría el assertNotEquals ya que el metodo equal esta
		//sobreescrito en la clase Persona
		assertNotSame(p1, p2);
	}
	
	@Test
	public void testPersonaMayor() {
		Persona p2 = new Persona();
		
		p1.setEdad(45);	
		p2.setEdad(30);
		
		Persona p3 = p1.personaMayor(p2);
		
		assertEquals(p3, p1);
		
		p1.setEdad(22);
		p2.setEdad(50);
		
		p3 = p1.personaMayor(p2);
		
		assertEquals(p3, p2);
		
		p1.setEdad(30);
		p2.setEdad(30);
		
		p3 = p1.personaMayor(p2);
		
		assertEquals(p3, p2);
	}
	
	@Test
	public void testCalcularDistacia() {
		// Para este test, al menos habría que probar 3 casos
		p1.setPosicion(100);
		
		int distancia = p1.calcularDistancia(-50);
		
		//Primer caso, espero -1
		assertEquals(-1, distancia);
		
		//Vulelvo a probar el primer caso con otro numero negativo
		distancia = p1.calcularDistancia(-100);
		
		//Tambien esperamos -1
		assertEquals(-1, distancia);
		
		//Segundo caso, la posicion pasada es menor que la posicion
		//del objeto
		distancia = p1.calcularDistancia(50);
		assertEquals(50, distancia);// 100 - 50 = 50
		
		//Tercer caso, la posici�n pasada es mayor que la posicion
		//del objeto
		distancia = p1.calcularDistancia(150);
		
		assertEquals(50, distancia);//150 - 100 = 50
		assertNotEquals(-50, distancia);
	}
}
