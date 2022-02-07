package junit5.programa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import programa.Brujo;

public class _02_TestBrujo {

	/**
	 * Para el metodo setPoder al menos hay que probar 2 casos, uno cuando
	 * le pasamos un poder positivo o cero, y otro para cuando le pasamos
	 * un poder negativo
	 */
	
	@Test
	public void testPoderPositivo(){
		Brujo brujo = new Brujo();
		brujo.setPoder(50);
		
		int resultadoEsperado = 50;
		int resultado = brujo.getPoder();
		
		assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	public void testPoderNegativo(){
		Brujo brujo = new Brujo();
		brujo.setPoder(-20);
		
		int resultadoEsperado = 0;
		int resultado = brujo.getPoder();
		
		assertEquals(resultadoEsperado, resultado);
	}
	
	/** 
	 * Este no sería 100% necesario, ya que realmente estaria incluido en el 
	 * metodo testPoderPositivo, pero en las pruebas podemos probar todos
	 * los casos que se nos ocurran, no hay un limite
	 */
	@Test
	public void testPoderCero(){
		Brujo brujo = new Brujo();
		brujo.setPoder(0);
		
		int resultadoEsperado = 0;
		int resultado = brujo.getPoder();
		
		assertEquals(resultadoEsperado, resultado);
	}

	/**
	 * Para el metodo estaMuerto al menos debemos de probar 3 casos
	 * ya que hay 3 opciones por las que tenemos que pasar
	 * 
	 * En este caso simplemente vamos a probar que si el brujo
	 * no tiene vida, el brujo esta muerto
	 */
	@Test
	public void testEstaMuertoVidaNegativa(){		
		Brujo brujo = new Brujo();
		brujo.setVida(-5);
		
		//Ahora el resultado esperado es que el brujo este muerto
		assertTrue(brujo.estaMuerto());		
		
	}

	/**
	 * Aqui vamos a probar que el brujo tenga la vida positiva
	 * pero no tengan alma. Según la documentación, el brujo
	 * tiene que estar muerto
	 */
	@Test
	public void testEstaMuertoVidaPositivaSinAlma(){
		Brujo brujo = new Brujo();
		brujo.setVida(5);
		brujo.setTieneAlma(false);
		
		//Ahora el resultado esperado es que el brujo este muerto
		assertTrue(brujo.estaMuerto());		
	}
	
	/**
	 * Aqui vamos a probar que el brujo tenga la vida positiva
	 * y tengan alma, ya que según la documentaci�n el brujo
	 * tiene que estar vivo
	 */
	@Test
	public void testEstaMuertoVidaPositivaConAlma(){

		Brujo brujo = new Brujo();
		brujo.setVida(5);
		brujo.setTieneAlma(true);		
		
		//Ahora el resultado esperado es que el brujo NO este muerto
		assertFalse(brujo.estaMuerto());		
	}
	
	/**
	 * En este caso no estaría tampoco de más probar que el brujo
	 * con vida negativa y alma esta muerto tambien
	 */
	@Test
	public void testEstaMuertoVidaNegativaConAlma(){
		Brujo brujo = new Brujo();
		brujo.setVida(-5);
		brujo.setTieneAlma(true);		
		
		//Ahora el resultado esperado es que el brujo NO este muerto
		assertTrue(brujo.estaMuerto());		
	}
}
