package _01_basico;

public class _03_MainHiloThis {
	public static void main(String[] args) {
		//Nótese que no invocamos el método start
		//se invocará en el constructor de la clase HiloThis
		new _03_HiloThis("Valor 1","Hilo1");
		new _03_HiloThis("Valor 2","Hilo2");
				
		System.out.println("Hilo principal parando");		
	}
}
