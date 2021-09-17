package _03_sincronizado_02;

public class Carrera {
	public static void main(String[] args) {
		
		Meta meta = new Meta();
		
		Caballo c1 = new Caballo("Rocinante",meta);
		Caballo c2 = new Caballo("Babieca"  ,meta);
		Caballo c3 = new Caballo("Imperioso",meta);
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		Thread t3 = new Thread(c3);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.start();
		t2.start();
		t3.start();
	}
}
