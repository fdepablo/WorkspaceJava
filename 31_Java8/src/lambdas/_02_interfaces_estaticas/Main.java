package lambdas._02_interfaces_estaticas;

public class Main {
	public static void main(String[] args) {
		InterfazMetodoEstatico.holaMundo();
		
		//Pero aunque implemente la interfaz, no hereda los metodos
		//estaticos, esto daría error
		//ClaseMetodoEstatico.holaMundo();
	}
}
