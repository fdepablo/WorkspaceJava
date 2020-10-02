package _02_demonio;

public class Demonio implements Runnable {

	private boolean encendido = true;
	
	@Override
	public void run() {
		System.out.println("Arrancado Demonio: " + Thread.currentThread().getName());
		int contador = 0;
		while(encendido){
			System.out.println("Demonio: " + Thread.currentThread().getName()+ " dice: " + contador);
			contador++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Domonio parado");
	}
	
	public void apagarDemonio(){
		this.encendido = false;
		System.out.println("Apagando demonio...");
	}

}
