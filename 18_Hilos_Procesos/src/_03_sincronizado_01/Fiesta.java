package _03_sincronizado_01;

public class Fiesta {
	
	//La palabra reservada sychronized hace que solo pueda entrar un hilo a la 
	//vez en este método, hasta que no termina de ejecutar este metodo un hilo, no puede entrar
	//el siguiente hilo a ejecutarse
	//OJO, al ser un metodo dinamico solo afecta a nivel de objeto, es decir, solo bloquea
	//el objeto en cuestion
	public synchronized void entrar(String palabra1, String palabra2){
		System.out.println("Entrando en la fiesta!!");
		System.out.println(palabra1);
		
		try {
			//Simulamos que entra el hilo dice una palabra y luego 
			//se queda un tiempo chocando las manos, esto sería
			//una tarea de larga duracion
			System.out.println("(Chocando manos)");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(palabra2);
		System.out.println("Acabando de saludar!");
	}
}
