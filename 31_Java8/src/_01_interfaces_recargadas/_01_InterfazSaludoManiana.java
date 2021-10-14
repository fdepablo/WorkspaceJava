package _01_interfaces_recargadas;

public interface _01_InterfazSaludoManiana {
	//Este seria el comportamiento por defecto que heredarian las clases
	//lo conseguimos poniendo default al principio del metodo
	default void saludo(){ 
		System.out.println("Buenos dias");
	}
}
