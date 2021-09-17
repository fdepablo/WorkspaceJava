package _01_basico;

public class _03_MainHiloThis {
	public static void main(String[] args) {
		//Notese que no invocamos el metodo start
		//se invocará en el constructor de HiloThis
		new _03_HiloThis("Valor 1","Hilo 1");
		new _03_HiloThis("Valor 2","Hilo 2");
				
		System.out.println("Programa principal parando");
		
		
	}
}
