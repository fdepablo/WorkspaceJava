package junit4.programa;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import programa.Producto;

public class _01_TestProducto {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDamePvp(){
		Producto prod = new Producto();
		
		//LÓGICA DE LA CLASE
		prod.setPvc(100.00);
		prod.setBeneficio(1.3);
		//RESULTADO ESPERADO
		// ya que el pvp es el Pvc * el beneficio
		double res = 100.00 * 1.3;//130

		/* parametros assertEquals, para tipo double se debe poner un delta
		 * expected - expected value
		   actual - the value to check against expected
		   delta - the maximum delta between expected and actual for 
		   		which both numbers are still considered equal.
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
		
		//hay veces que queremos o necesitamos pasar más de una prueba
		//a la misma funcion, ya sea porque queremos asegurarnos que 
		//funciona adecuadamente. Por lo tanto, es posible que queramos
		//pasarle varias pruebas
		prod.setPvc(200);
		prod.setIva(1.21);
		prod.setBeneficio(1.3);

		res = 200.00 * 1.3 * 1.21;
		
		//en cuanto falle algún assert, la prueba falla
		assertEquals (res, prod.damePvpIva(), 0.01);
		
	}

}
