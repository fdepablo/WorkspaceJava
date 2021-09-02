package _04_waitnotify;

public class Main {
	public static void main(String[] args) {
		Cola cola = new Cola();
		
		Productor p1 = new Productor("Producto 1",cola);
		Productor p2 = new Productor("Producto 2",cola);
		Productor p3 = new Productor("Producto 3",cola);
		
		Consumidor c1 = new Consumidor("Consumidor 1",cola);
		Consumidor c2 = new Consumidor("Consumidor 2",cola);
		Consumidor c3 = new Consumidor("Consumidor 3",cola);
		
		p1.start();
		p2.start();
		p3.start();
		
		c1.start();
		c2.start();
		c3.start();
	}
}
