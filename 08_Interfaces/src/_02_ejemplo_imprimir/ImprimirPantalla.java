package _02_ejemplo_imprimir;

public class ImprimirPantalla implements Imprimible{

	@Override
	public void imprimir(String cadena) {
		System.out.println(cadena);		
	}

}
