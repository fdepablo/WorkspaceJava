package _01_basico;

/**
 * Para que una clase implemente una interface debemos de usar
 * la palabra reservada "implements"
 */
public class ClaseBasica1 implements InterfaceBasica1{

	@Override
	public void metodo1() {
		System.out.println("Esto sería el método 1");
		
	}

	@Override
	public String metodo2(Object o) {
		String cadena = "Esto es el metodo 2 invocando al toString del objeto pasado "
				+ o.toString();
		return cadena;
	}

	/**
	 * Implementamos la operacion suma
	 */
	@Override
	public int operacion(int a, int b) {
		int resultado = a + b;
		return resultado;
	}

}
