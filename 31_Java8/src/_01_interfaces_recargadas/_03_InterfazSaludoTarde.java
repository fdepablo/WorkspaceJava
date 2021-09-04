package _01_interfaces_recargadas;

//Creamos otra interfaz con la misma firma de metodo que la interfaz de SaludoManiana
public interface _03_InterfazSaludoTarde {
	default void saludo(){ 
		System.out.println("Buenas tardes");
	} 
}
