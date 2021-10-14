package _00_interfaces;

//Cuando nosotros implementamos una interfaz desde una clase estamos
//comprometiendonos a que vamos a implementar todos sus metodos
public class ImprimirPantalla implements Imprimir{

	@Override
	public void imprimir(String cadena) {
		System.out.println(cadena);		
	}

	@Override
	public String getNombreImpresion() {
		return "Imprimir por pantalla";
	}

}
