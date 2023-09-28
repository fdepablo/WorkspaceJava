package _03_sincronizado_01;

/*
 * Este objeto intenta simular como varios avengers acceden
 * a una fiesta y lo primero que hacen es presentarse.
 * 
 * Cada superheroe sera un objeto diferente que a su vez será
 * un hilo en ejecución.
 *
 * La fiesta, en cambio, será un objeto único ya que solo tendremos
 * una fiesta en nuestro programa.
 * 
 * Los superheroes cuando entran en la fiesta saludaran, y pasado
 * un pequeño tiempo, dirán una frase "Guay"
 *  
 * La idea es entender como podemos tener problemas cuando varios
 * hilos intentan acceder 'a la vez' a la fiesta, ya que hasta
 * que un superheroe no acabe de hacer su presentación en la fiesta,
 * no debería poder entrar el siguiente.
 * 
 * Hay que tener muy claro que vamos a tener 3 objetos AVENGER (hilos
 * en ejecición), intentando acceder a un ÚNICO objeto FIESTA.
 * 
 * La fiesta se celebra en Nueva York, de ahí el nombre de la clase.
 */
public class NuevaYork {
	public static void main(String[] args){
		//Lo primero de todo creamos una fiesta donde van a ir los vengadores
		Fiesta fiesta = new Fiesta("Blas","37 con la octava");
		
		// Si creáramos varios objetos fiestas, y asignaramos a cada avenger
		//una fiesta diferente, no existiría sincronización entre hilos
		//ya que cada hilo va a una fiesta diferente.
		//Fiesta fiesta2 = new Fiesta("Tomatina","Chinatown");
		//Fiesta fiesta3 = new Fiesta("San Fermin","Little Italy");
		//Habría que asignar a Steve Roger a la fiesta2 y a Peter Parker
		//a la fiesta3 para probar este ejemplo
		
		//Creamos a los avenger con su nombre, su saludo
		//y su frase. A continuación hacemos que todos apunten
		//al MISMO objeto fiesta.
		Avenger p1 = new Avenger("Steve Rogers",
								"Hey!", 
								"Prodría estar haciendo esto todo el día!",
								fiesta);
		Avenger p2 = new Avenger("Tony Stark",
								"Hola!", 
								"La armadura y yo somos uno!",
								fiesta);
		Avenger p3 = new Avenger("Peter Parker",
								"Como vamos!", 
								"Un gran poder conlleva una gran responsabilidad!",
								fiesta);
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t1.start();
		t2.start();
		t3.start();
	}
}
