package lambdas._02_interfaces_estaticas;


public class ClaseMetodoEstatico implements InterfazMetodoEstatico{
	public void metodo() {
		//Pero aunque implemente la interfaz, no hereda los metodos
		//estaticos, esto daría error
		//ClaseMetodoEstatico.holaMundo();
	}
}
