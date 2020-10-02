package junit4.programa;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import programa.Producto;

/**
 * En algunas ocasiones no es suficiente comprobar el resultado con un solo dato, 
 * necesitando enviar una batería de datos(varios datos)
 * para comprobar que el método funciona correctamente.
 */
//Lo primero que vamos a hacer es decir a JUNIT que esta clase de pruebas
//unitarias se va a ejecutar muchas veces, tantas como bateria de datos tengamos
@RunWith(Parameterized.class)
public class _02_TestProductoParametros {
	//tenemos dos atributos el pvpCalculado y el pvpEsperado
	//el pvpCalculado será el que me devuelve la función dame.Pvp()
	private double pvpCalculado;
	private double pvpEsperado;

	//notese que el constructor tiene dos parametros
	public _02_TestProductoParametros(double pvc, double pvpEsperado) {
		Producto prod = new Producto();
		prod.setPvc(pvc);

		this.pvpCalculado = prod.damePvp();
		this.pvpEsperado = pvpEsperado;
	}

	//Esta etiqueta nos dice que de este metodo van a salir los parametros con
	//la batería de datos. Esta coleccion de datos sera la que entren por el CONSTRUCTOR
	//de la clase, dicho de otra manera, se van a crear tantos objetos de esta clase
	//como objetos haya dentro de esta coleccion, y de cada objeto que se cree, se 
	//ejecutarán todos sus metodos anotados con @Test
	//Podriamos sacar los valores de cualquier parte, un fichero, una bbdd, etc.
	@Parameters
	public static Collection<Object[]> data() {
		//En este caso, crearemos 3 objetos dentro de este array bidimensional
		//el primer valor representará el pvc y el segundo valor representara
		//el pvpEsperado. Por lo tanto la batería de pruebas en este caso
		//constará de 3 pvpCalculados y 3 pvpEsperados, si quisieramos más pruebas, 
		//solamente deberíamos poner mas objetos dentro de este array
		//
		Object[][] data = new Object[][] { 
			{ 10.00, 13.00 }, 
			{ 100.00, 130.00 },
			{ 200.00, 260.00 }
		};
		return Arrays.asList(data);
	}

	//ahora todos los @Test que tengamos se ejecutaran con los pvc y pvpEsperado
	//que entren por el constructor (tantos como datos hayamos creado en el metodo
	//etiquetado con @Parameters
	@Test
	public void test() {
		int cp = 0123;//los numeros en java que empiezan por 0 son en base octal
		System.out.println(cp);
		String codigoPostal = "09PR";
		
		int hexadecimal = 0x72;
		System.out.println(hexadecimal);
		
		//desde la version 1.7 de java se incluyen binarios
		int binario = 0b1111111;
		System.out.println(binario);
		assertEquals(pvpCalculado, pvpEsperado, 0.01);
	}
	
	
}