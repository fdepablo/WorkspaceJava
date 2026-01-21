package _05_arrays;

public class MainObjetosArrays01 {
	public static void main(String[] args) {
		Restaurante r1 = new Restaurante();
		r1.id = 1;
		r1.nombre = "Burguer";
		r1.puntuaciones = new double[3];
		
		r1.puntuaciones[0] = 2;
		r1.puntuaciones[1] = 3;
		r1.puntuaciones[2] = 4;
		
		System.out.println(r1.nombre);
		for(double puntuacion : r1.puntuaciones) {
			System.out.println("El restaurante " + r1.nombre + " tiene "
					+ "como puntuacion " + puntuacion);
		}
		
		//Como tenemos sobre escrito el metodo toString()
		System.out.println(r1);
		
		System.out.println("La media del restaurante es: " + r1.calcularMedia());
		
		//Otra manera sería
		double[] puntuacionesFoster = {2,3,4.5,5.0,3.0};
		Restaurante r2 = new Restaurante(2, "Foster", puntuacionesFoster);
		System.out.println("La media del foster es: " + r2.calcularMedia());
		//Ver dibujo _05_arrays_01.jpg
	}
}
