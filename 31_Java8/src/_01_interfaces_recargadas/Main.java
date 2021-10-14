package _01_interfaces_recargadas;

public class Main {

	public static void main(String[] args) {
		//La clase ClaseSaludoManiana solo tiene un metodo saludar
		//por lo que no tendrermos problema
		_02_ClaseSaludoManiana csm = new _02_ClaseSaludoManiana();
		csm.saludo();
		
		_01_InterfazSaludoManiana ism = csm;
		ism.saludo();
		
		/*
		_01_InterfazSaludoManiana ism2 = new _01_InterfazSaludoManiana() {

			//puedo seguir creando clases anonimas pero ahora no necesito
			//implementar los metodos
			
			
		};*/
		System.out.println("-------------------------------------");
		_04_ClaseVariosSaludos cvs = new _04_ClaseVariosSaludos();
		cvs.saludo();
	}

}
