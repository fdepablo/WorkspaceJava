package _02_interfaces_estaticas;


public class _02_ClaseMetodoEstatico implements _01_InterfazMetodoEstatico{
	public void metodo() {
		//Pero aunque implemente la interfaz, no hereda los metodos
		//estaticos, esto daria error
		//ClaseMetodoEstatico.holaMundo();
	}
}
