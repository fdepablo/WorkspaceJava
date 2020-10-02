package lambdas._01_interfacesrecargadas;

public interface InterfazSaludoTarde {
	default void saludo(){ 
		System.out.println("Buenas tardes");
	} 
}
