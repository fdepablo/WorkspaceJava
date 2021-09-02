package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entidad.Coche;
import negocio.GeneradorCoches;

class TestGeneradorCoches {

	@Test
	void testMarca() {
		GeneradorCoches gc = new GeneradorCoches();
		for(int i = 0; i < 1000 ; i++) {
			String s = gc.generarMarca();
			assertNotNull(s);
			System.out.println(s);
		}
	}
	
	@Test
	void testModelo() {
		GeneradorCoches gc = new GeneradorCoches();
		for(int i = 0; i < 1000 ; i++) {
			String s = gc.generarModelo();
			assertNotNull(s);
			System.out.println(s);
		}
	}
	
	@Test
	void testKm() {
		GeneradorCoches gc = new GeneradorCoches();
		for(int i = 0; i < 1000 ; i++) {
			int mynum = gc.generarKm();
			assertTrue(0 <= mynum && mynum <= 10000);
			System.out.println(mynum);
		}
	}
	
	@Test
	void testCoche() {
		GeneradorCoches gc = new GeneradorCoches();
		for(int i = 0; i < 999 ; i++) {
			Coche coche = gc.generarCoche();
			assertNotNull(coche);
			System.out.println(coche);
		}
	}

}
