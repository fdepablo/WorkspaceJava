package _03_sincronizado_01;

public class Fiesta {
	
	private String nombre;
	private String direccion;
	
	public Fiesta(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	//La palabra reservada 'sychronized' hace que solo pueda entrar un hilo a la 
	//vez en este método, hasta que no termina de ejecutar este método el hilo
	//que ha entrado, no puede entrar el siguiente hilo a ejecutarse
	//OJO, al ser un método dinámico afecta a nivel de objeto, es decir, solo bloquea
	//el objeto en cuestión.
	public synchronized void entrar(String nombreAvenger,String saludo, String frase){
		System.out.println(nombreAvenger +" está entrando en la fiesta '" 
				+ this.nombre + "'" + " que se encuentra en la dirección '" 
				+ this.direccion + "'");		
		
		//Nada más entrar en la fiesta, el avenger dice su saludo
		System.out.println(nombreAvenger + " saluda: " + saludo);
		
		try {
			//Simulamos que cuando entra el hilo, dice el saludo y luego 
			//se queda un tiempo posando y recibiendo aplausos, esto sería
			//una tarea de 'larga' duración
			System.out.println(nombreAvenger + " (Está posando para las fotos)");
			System.out.println("---------------------------------------------");
			Thread.sleep(5000);			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Cuando acaba su saludo inicial, dice su frase y acaba su presentación
		System.out.println(nombreAvenger + " dice su frase 'Guay': " + frase);
		System.out.println(nombreAvenger + " Acabe mi presentación! Que pase el siguiente!");
	}
}
