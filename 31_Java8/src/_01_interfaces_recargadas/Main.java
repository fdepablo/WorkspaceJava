package _01_interfaces_recargadas;

public class Main {

	public static void main(String[] args) {
		//La clase ClaseSaludoManiana solo tiene un metodo saludar
		//por lo que no tendrermos problema
		_02_ClaseSaludoManiana csm = new _02_ClaseSaludoManiana();
		csm.saludo();
		
		_04_ClaseVariosSaludos cvs = new _04_ClaseVariosSaludos();
		cvs.saludo();
	}

}
