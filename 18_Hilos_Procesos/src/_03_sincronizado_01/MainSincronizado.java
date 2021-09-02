package _03_sincronizado_01;

public class MainSincronizado {
	public static void main(String[] args){
		Fiesta fiesta = new Fiesta();
		//Fiesta fiesta2 = new Fiesta();
		//Fiesta fiesta3 = new Fiesta();
		Persona p1 = new Persona("Hey", "que tal estais?",fiesta);
		Persona p2 = new Persona("Hola!!", "como esta la peña?",fiesta);
		Persona p3 = new Persona("Buenas!!!!", "llego el alma de la party!!!",fiesta);
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.start();
		t2.start();
		t3.start();
	}
}
