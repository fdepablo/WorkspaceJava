package _03_sincronizado_01;

public class PruebaHilosSincro {
	public static void main(String[] args){
		DosPalabras dosPalabras = new DosPalabras();
		DosPalabras dosPalabras2 = new DosPalabras();
		DosPalabras dosPalabras3 = new DosPalabras();
		HiloSincronizado hilo1 = new HiloSincronizado("Hola ", "que tal estais?",dosPalabras);
		HiloSincronizado hilo2 = new HiloSincronizado("Muy bien chicos!!", "y vosotros?",dosPalabras2);
		HiloSincronizado hilo3 = new HiloSincronizado("Yo tambien muy bien ", "gracias!!!",dosPalabras3);
		
		Thread t1 = new Thread(hilo1);
		Thread t2 = new Thread(hilo2);
		Thread t3 = new Thread(hilo3);
		t1.setPriority(10);//esto no funciona, o si, vete a saber!
		t2.setPriority(9);//para que funcione necesitamos una mv java preparada
		t3.setPriority(1);//para la programacion en tiempo real, por ejemplo jamaica
		
		t1.start();
		t2.start();
		t3.start();
	}
}
