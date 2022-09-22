package _03_sincronizado_01;

public class MainSincronizado {
	public static void main(String[] args){
		Fiesta fiesta = new Fiesta("Blas","Calle Melancolia");
		// Si creáramos varios objetos fiestas, y asignaramos a cada persona
		//una fiesta diferente, no existiria sincronización entre hilos
		//Fiesta fiesta2 = new Fiesta("Thor","Asgard");
		//Fiesta fiesta3 = new Fiesta("Hulk","Nueva york");
		Persona p1 = new Persona("Steve Rogers","Hey", "que tal estáis?",fiesta);
		Persona p2 = new Persona("Tony Stark","Hola!!", "como esta la peña?",fiesta);
		Persona p3 = new Persona("Peter Parker","Buenas!!!!", 
				"un poder implica responsabilidad ;)",fiesta);
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t1.start();
		t2.start();
		t3.start();
	}
}
