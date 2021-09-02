package _01_basico;

public class _00_IntroduccionHilos {
	public static void main(String[] args) {
		// Aqui nacera el hilo principal, en este caso solamente habrá un hilo

		System.out.println("Arrancando hilo: " + Thread.currentThread().getName());// obtenemos el nombre del hilo
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(1500);// simulacion de tarea que tarda 500 milisegungdos
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 0.5 segundos

			System.out.println("Hilo: " + Thread.currentThread().getName() + " , dice: " + 5 + "ciclo: " + i);
		}
		System.out.println("Hilo: " + Thread.currentThread().getName() + " acabado");
		// aqui morira el hilo principal
	}
}
