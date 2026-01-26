package _05_arrays;

public class MainObjetosArrays02 {

	public static void main(String[] args) {		
		Restaurante r1 = new Restaurante();
		r1.id = 1;
		r1.nombre = "McDonalds";
		
		double[] pArray = new double[3];
		pArray[0] = 3.0;
		pArray[1] = 4.5;
		pArray[2] = 5.0;
		
		r1.puntuaciones = pArray;
		//Dibujo _05_arrays_02_01
		
		pArray[0] = 2.0;
		System.out.println(r1.puntuaciones[0]);
		//Dibujo _05_arrays_02_02
		
		Restaurante[] arrayRestaurante;
		arrayRestaurante = new Restaurante[3];
		
		arrayRestaurante[0] = r1;
		arrayRestaurante[0].puntuaciones[0] = 1.0;
		System.out.println(pArray[0]);
		//Dibujo _05_arrays_02_03
		
		r1 = new Restaurante();
		r1.puntuaciones = new double[3];
		System.out.println(r1.puntuaciones[0]);
		//Dibujo _05_arrays_02_04
		
		r1.puntuaciones[1] = 3.5;
		System.out.println(arrayRestaurante[0].puntuaciones[1]);
		//Dibujo _05_arrays_02_05
		
		Restaurante r2 = r1;
		Restaurante r3 = r2;
		Restaurante r4 = r1;
		
		r2.puntuaciones[2] = 5.0;
		System.out.println(r2.puntuaciones[2]);
		System.out.println(r3.puntuaciones[2]);
		System.out.println(r4.puntuaciones[2]);
		
		System.out.println("------------------");
		mostrarPuntuacion(r2.puntuaciones[2]);
		mostrarPuntuacion(r3.puntuaciones[2]);
		mostrarPuntuacion(r4.puntuaciones[2]);
		//Dibujo _05_arrays_02_06
	}
	
	public static void mostrarPuntuacion(double p) {
		System.out.println(p);
	}

}
