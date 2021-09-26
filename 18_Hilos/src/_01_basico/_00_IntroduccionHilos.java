package _01_basico;

public class _00_IntroduccionHilos {
	public static void main(String[] args) {
		// Aqui nacera el hilo principal, en este caso solamente habrá un hilo

		// Podemos obtener el nombre del hilo		
		System.out.println("Arrancando hilo: " + Thread.currentThread().getName());
		for (int i = 0; i < 20; i++) {
			try {
				//Este metodo sirve para parar X milisegundos el hilo por el que pasamos
				//500 milisegundos en este caso o medio segundo
				Thread.sleep(500);//
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//imprimimos en cada iteracion del hilo la variable de control de bucle
			System.out.println("Hilo: " + Thread.currentThread().getName() 
					+ " , dice: " + i);
		}
		System.out.println("Hilo: " + Thread.currentThread().getName() + " acabado");
		
	}// aqui morira el hilo principal
}
