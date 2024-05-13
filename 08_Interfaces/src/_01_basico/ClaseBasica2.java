package _01_basico;

public class ClaseBasica2 implements InterfaceBasica1 {

	@Override
	public void metodo1() {
		System.out.println("Este es el metodo1 pero de la clase ClaseBasica2");
	}

	@Override
	public String metodo2(Object o) {
		String cadena = "Este sería el método2 de la clase ClaseBasica2 que invocamos "
				+ "el método toString del objeto object " + o.toString();
		return cadena;
	}

	/**
	 * Operacion multiplciación
	 */
	@Override
	public int operacion(int a, int b) {
		int multiplicacion = a * b;
		return multiplicacion;
	}

}
