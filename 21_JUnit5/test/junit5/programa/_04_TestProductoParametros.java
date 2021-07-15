package junit5.programa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import programa.Producto;

/**
 * En algunas ocasiones no es suficiente comprobar el resultado con un solo dato, 
 * necesitando enviar una batería de datos para comprobar que el método funciona correctamente.
 * 
 * Mas informacion https://www.baeldung.com/parameterized-tests-junit-5
 */
public class _04_TestProductoParametros {

	@ParameterizedTest
	@ValueSource(doubles = {10.00, 100.00, 200.00})
	public void test(double pvc) {
		Producto prod = new Producto();
		
		//LÓGICA DE LA CLASE
		prod.setPvc(pvc);
		prod.setBeneficio(1.3);
		//RESULTADO ESPERADO
		// ya que el pvp es el Pvc * el beneficio
		double res = pvc * 1.3;

		assertEquals(res, prod.damePvp(), 0.01);
	}
}