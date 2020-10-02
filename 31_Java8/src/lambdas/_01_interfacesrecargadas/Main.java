package lambdas._01_interfacesrecargadas;

public class Main {

	public static void main(String[] args) {
		//La clase ClaseSaludoManiana solo tiene un metodo saludar
		//por lo que no tendrermos problema
		ClaseSaludoManiana csm = new ClaseSaludoManiana();
		csm.saludo();
		
		ClaseVariosSaludos cvs = new ClaseVariosSaludos();
		cvs.saludo();
	}

}
