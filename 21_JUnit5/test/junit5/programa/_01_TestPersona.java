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
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		//Me interesa antes de cada test tener un objeto persona limpio (nuevo)
		p1 = new Persona();
		//configuramos todo lo que queramos antes de cada @Test
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * En esta prueba unitaria debemos de probar que nuestro metodo "setNombre" de la clase
	 * persona funciona adecuadamente. Un metodo funciona adecuadamente cuando hace lo que
	 * tiene que hacer.
	 * 
	 * Para probar que setNombre funciona bien, debemos de pasar por todos los casos del metodo
	 * (o por todas las lineas)
	 * 
	 * Una buena regla para desarrollar código es hacer el metodo, solo la definicion, luego
	 * hacer la documentacion del método (Java doc), luego implementarlo y por ultimo hacer
	 * su prueba unitaria. De hecho esto se retroalimente y es muy probable que al pasar la prueba
	 * tengas que cambiar la documentacion y la implementacion
	 * 
	 * En esta prueba unitaria vamos a probar que si ponemos un nombre de más de tres caracteres
	 * funciona
	 */
	@Test
	public void testSetNombre(){
		p1.setNombre("Goku");
		//el nombre tiene que estar puesto a Goku
		
		//Espero queu el nombre sea Goku, y lo compruebo con el nombre 
		//que hay en el objeto
		assertEquals("Goku", p1.getNombre());
		
		p1.setNombre("ana");
		//el nombre tiene que estar puesto a Goku
		
		//Espero queu el nombre sea "", y lo compruebo con el nombre 
		//que hay en el objeto
		assertEquals("", p1.getNombre());
		
		p1.setNombre("az");
		assertEquals("", p1.getNombre());
		
		p1.setNombre("a");
		assertEquals("", p1.getNombre());
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
		
		//para dar por buena la prueba tengo que comprobar que
		//ambos objetos no son el mismo
		
		//System.out.println(p1);
		//System.out.println(p2);
		assertNotSame(p1, p2);//no nos valdría el assertNotEquals ya que el metodo equal esta
							//sobreescrito en la clase Persona
		
	}
	
	@Test
	public void testPersonaMayor() {
		Persona p2 = new Persona();
		
		p1.setEdad(45);	
		p2.setEdad(30);
		
		Persona p3 = p1.personaMayor(p2);
		
		assertEquals(p3, p1);
		
		p1.setEdad(30);
		p2.setEdad(45);
		
		p3 = p1.personaMayor(p2);
		
		assertEquals(p3, p2);
		
		p1.setEdad(30);
		p2.setEdad(30);
		
		p3 = p1.personaMayor(p2);
		
		assertEquals(p3, p2);
	}
	
	@Test
	public void testCalcularDistacia() {
		p1.setPosicion(100);
		
		int distancia = p1.calcularDistancia(-50);
		
		assertEquals(-1, distancia);
		
		distancia = p1.calcularDistancia(-100);
		
		assertEquals(-1, distancia);
		
		distancia = p1.calcularDistancia(50);
		
		assertEquals(50, distancia);
		
		distancia = p1.calcularDistancia(150);
		
		assertEquals(50, distancia);
		assertNotEquals(-50, distancia);
	}
}
