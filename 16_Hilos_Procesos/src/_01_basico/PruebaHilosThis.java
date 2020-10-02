package _01_basico;

public class PruebaHilosThis {
	public static void main(String[] args) {
		//notese que no invocamos el metodo start
		//se invocará en el constructor de HiloThis
		new HiloThis("Valor 1","Hilo 1");
		new HiloThis("Valor 2","Hilo 2");
				
		System.out.println("Programa principal parando");
		
		
	}
}
