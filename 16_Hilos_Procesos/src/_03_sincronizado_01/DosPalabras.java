package _03_sincronizado_01;

public class DosPalabras {
	
	public synchronized void escribir(String palabra1, String palabra2){
		System.out.println(palabra1);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(palabra2);
	}//hilo1 //hilo3//hilo2 
}
