package _02_demonio;

public class PruebaDemonio {
	public static void main(String[] args){
		Demonio demonio = new Demonio();//implementa la interfaz Runnable
		Thread hilo = new Thread(demonio);//le pasemos un objeto Runnable
		hilo.start();
		
		try {
			Thread.sleep(15000);//duermo al hilo principal 15 seg
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Podemos parar el demonio cuando queramos
		demonio.apagarDemonio();
	}
}
