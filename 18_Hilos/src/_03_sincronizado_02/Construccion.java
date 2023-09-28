package _03_sincronizado_02;
/*
 * En este ejemplo se intenta simular como 5 obreros 
 * intentan ponder ladrillos en una valla. 
 * 
 * No habría ningún problema si no fuera porque los obreros 
 * quieren descansar y SOLAMENTE hay una silla para todos los 
 * obreros.
 * 
 * Una de las reglas es que solo puede haber sentado un obrero
 * en la silla al mismo tiempo por lo que puede haber problemas
 * de sincronización si varios obreros intentan sentarse 
 * 'a la vez'.
 */
public class Construccion {
	public static void main(String[] args) {
		
		//Una única silla para todos los obreros
		//Esta es la clave para ver los problemas
		//de sincronización. Es decir, tenemos
		//5 hilos que acceder a un UNICO OBJETO.
		Silla silla = new Silla();
		//También podemos probarlo creando 5 sillas y 
		//dando a cada obrero una silla diferente
		//para ver que no hay problemas de sincronización.
		
		//Cada obrero se encarga de poner ladrillos en una
		//valla y cubre una porción de la valla
		Obrero o1 = new Obrero(1,100,"Pepe");
		o1.setSilla(silla);
				
		Obrero o2 = new Obrero(101,200,"Luis");
		o2.setSilla(silla);
		
		Obrero o3 = new Obrero(201,300,"Maria");
		o3.setSilla(silla);
		
		Obrero o4 = new Obrero(301,400,"Marta");
		o4.setSilla(silla);		
		
		Obrero o5 = new Obrero(401,500,"Harry potter");
		o5.setSilla(silla);
		
		o1.start();
		o2.start();
		o3.start();
		o4.start();
		o5.start();
		
		System.out.println("Muerto el hilo principal");
	}
}
