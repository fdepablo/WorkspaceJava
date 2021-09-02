package _01_interfaces_recargadas;

public interface InterfazSaludoTarde {
	default void saludo(){ 
		System.out.println("Buenas tardes");
	} 
}
