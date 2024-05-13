package _01_basico;

/**
 * En java no se puede realizar herencia multiple entre clases
 * Pero, una manera de implementar la herencia multiple en java
 * es mediante Interfaces
 * 
 * Aunque una clase en java SOLO puede extender de UNA SOLA
 * clase, puede implentar N interfaces. 
 * 
 * De hecho puede extender de una clase e implementar N
 */
public class ClaseBasica3 extends Object implements InterfaceBasica1, InterfaceBasica2{

	@Override
	public void metodo4() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void metodo5() {
		// TODO Auto-generated method stub
		
	}

	//No hay ningun problema porque este método este
	//en dos interfaces, ya que en ninguna esta implementado
	@Override
	public void metodo1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String metodo2(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int operacion(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

}
