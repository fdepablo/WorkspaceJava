package _01_interfaces_recargadas;

public interface _01_InterfazSaludoManiana {
	default void saludo(){ //Este seria el metodo por defecto que heredarian las clases
		System.out.println("Buenos dias");
	}
}
