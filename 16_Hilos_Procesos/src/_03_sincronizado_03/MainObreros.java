package _03_sincronizado_03;
/*
 * En este ejemplo se intenta simular como 5 obreros 
 * intentan ponder ladrillos en una valla. No habría
 * ningún problema si no fuera porque los obreros quieren
 * descansar y SOLAMENTE hay una silla para todos los obreros
 * Una de las reglas es que solo puede haber sentado un obrero
 * en la silla al mismo tiempo por lo que puede haber problemas
 * de sincronización
 */
public class MainObreros {
	public static void main(String[] args) {
		
		//Una unica silla para todos los obreros
		//Tambien podemos probarlo dando a cada obrero su silla
		//para ver que no hay problemas de sincronización
		Silla silla = new Silla();
		
		//cada obrero se encarga de poner ladrillos en una
		//valla, cada obrero cubre una porción de una valla
		Obrero obrero1 = new Obrero(1,100,"Pepe");
		obrero1.setSilla(silla);
				
		Obrero obrero2 = new Obrero(101,200,"Luis");
		obrero2.setSilla(new Silla());
		
		Obrero obrero3 = new Obrero(201,300,"Maria");
		obrero3.setSilla(new Silla());
		
		Obrero obrero4 = new Obrero(301,400,"Marta");
		obrero4.setSilla(new Silla());		
		
		Obrero obrero5 = new Obrero(401,500,"Harry potter");
		obrero5.setSilla(new Silla());
		
		obrero1.start();
		obrero2.start();
		obrero3.start();
		obrero4.start();
		obrero5.start();
		
		System.out.println("Muerto el hilo principal");
	}
}
