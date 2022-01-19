package entidad;

public class MainCalculo {

	public static void main(String[] args) {
		if(true) {
			Calculo c = new Calculo();
		}
		//Aqui no existe la referencia C
		//c = null
		Calculo c = new Calculo();
		boolean esPrimo = c.calculoPrimo(25);
		if(esPrimo) {
			System.out.println("Es primo");
		}else {
			System.out.println("No es primo");
		}

		esPrimo = c.calculoPrimoVersion1(1001);
		if(esPrimo) {
			System.out.println("Es primo");
		}else {
			System.out.println("El numero no es primo o es superior a 1000");
		}
		
		int resultado = c.calculoPrimoVersion2(234);
		switch (resultado) {
		case 0:
			System.out.println("Es primo");
			break;
		case 1:
			System.out.println("NO es primo");
			break;
		case 2:
			System.out.println("El numero es superior a 1000");
			break;
		}
		
	}

}
