package junit5.programa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import programa.Producto;

//en junit5 la class no tiene porque se publica
class _02_TestProducto {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testDamePvp(){
		Producto prod = new Producto();
		
		//LÓGICA DE LA CLASE
		prod.setPvc(100.00);
		prod.setBeneficio(1.3);
		//RESULTADO ESPERADO
		// ya que el pvp es el Pvc * el beneficio
		double res = 100.00 * 1.3;

		/* parametros
		 * expected - expected value
		   actual - the value to check against expected
		   delta - the maximum delta between expected and actual for which both numbers are still considered equal.
		 */
		assertEquals(res, prod.damePvp(), 0.01);
	}

	@Test
	public void testDamePvpIva(){
		Producto prod = new Producto();

		//MÉTODO DE PRUEBA
		prod.setPvc(100.00);
		prod.setIva(1.21);
		prod.setBeneficio(1.3);

		//RESULTADO ESPERADO
		//ya que es el pvc * el beneficio * el iva
		double res = 100.00 * 1.3 * 1.21;
		
		assertEquals (res, prod.damePvpIva(), 0.01);
	}

}
