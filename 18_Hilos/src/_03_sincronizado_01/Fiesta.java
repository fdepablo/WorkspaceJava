package _03_sincronizado_01;

public class Fiesta {
	
	private String nombre;
	private String direccion;
	
	public Fiesta(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	//La palabra reservada sychronized hace que solo pueda entrar un hilo a la 
	//vez en este método, hasta que no termina de ejecutar este metodo un hilo, no puede entrar
	//el siguiente hilo a ejecutarse
	//OJO, al ser un metodo dinamico solo afecta a nivel de objeto, es decir, solo bloquea
	//el objeto en cuestion
	public synchronized void entrar(String nombrePersona,String frase1, String frase2){
		System.out.println(nombrePersona +" esta entrando en la fiesta de " + this.nombre + "!!!");
		System.out.println("La fiesta se encuentra en: " + direccion);
		System.out.println(nombrePersona + " is in the house!");
		System.out.println(frase1);
		
		try {
			//Simulamos que entra el hilo dice una frase y luego 
			//se queda un tiempo chocando las manos, esto sería
			//una tarea de larga duracion
			System.out.println("(Chocando manos), (Saludando)");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(frase2);
		System.out.println(nombrePersona + " ha acabado de saludar!");
	}
}
