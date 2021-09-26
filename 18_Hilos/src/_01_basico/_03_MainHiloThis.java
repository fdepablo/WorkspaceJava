package _01_basico;

public class _03_MainHiloThis {
	public static void main(String[] args) {
		//Notese que no invocamos el metodo start
		//se invocará en el constructor de HiloThis
		new _03_HiloThis("Valor 1","Hilo1");
		new _03_HiloThis("Valor 2","Hilo2");
				
		System.out.println("Hilo principal parando");		
	}
}
