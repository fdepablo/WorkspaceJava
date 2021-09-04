package _02_interfaces_estaticas;

public class Main {
	public static void main(String[] args) {
		_01_InterfazMetodoEstatico.holaMundo();
		
		//Pero aunque implemente la interfaz, no hereda los metodos
		//estaticos, la siguiente linea daria error
		//ClaseMetodoEstatico.holaMundo();
	}
}
