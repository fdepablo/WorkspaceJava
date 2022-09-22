
package _05_join;

//Este ejemplo es para ver el método 'join()', que se utiliza cuando queremos
//que un hilo espere a que otro hilo termine

//Este ejemplo es igual que el del paquete _01_basico pero el hilo main
//esperará a que los otros hilos acaben para continuar
public class _01_MainHiloThread {

	public static void main(String[] args) {
		
		_01_HiloThread hilo1 = new _01_HiloThread("Valor 1");
		hilo1.setName("Hilo1");
		
		_01_HiloThread hilo2 = new _01_HiloThread("Valor 2");
		hilo2.setName("Hilo2");
		
		hilo1.start();		
		hilo2.start();
		
		//Si necesitamos que algun hilo se quede esperando a que otros hilos mueran para
		//poder continuar su ejecución, podemos usar el método join().
		//Este método hace que el hilo que pase por esa línea se quede esperando
		//a que el hilo que invoca el método join() haya muerto
		
		try {
			System.out.println("Hilo Main - Me quedo esperando "
					+ "a que los hilos anteriores acaben");
			
			hilo1.join();//El hilo main espera en esta linea a que hilo1 muera
			hilo2.join();//El hilo main espera en esta linea a que hilo2 muera
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Cuando hilo1 e hilo2 hayan acabado de ejecutar su método run()
		//entonces el hilo main continuara con su ejecución
		System.out.println("Hilo Main - Los hilos ya han acabado, por lo que ya puedo seguir");
	}

}
