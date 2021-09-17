package negocio;

public class Main {
	public static void main(String[] args) {
		Cola cola = new Cola();
		
		Productor p1 = new Productor("Producto 1",cola);
		Productor p2 = new Productor("Producto 2",cola);
		Productor p3 = new Productor("Producto 3",cola);
		
		ConsumidorCoches c1 = new ConsumidorCoches("Consumidor 1",cola);
		ConsumidorCoches c2 = new ConsumidorCoches("Consumidor 2",cola);
		ConsumidorCoches c3 = new ConsumidorCoches("Consumidor 3",cola);
		
		p1.start();
		p2.start();
		p3.start();
		
		c1.start();
		c2.start();
		c3.start();
	}
}
