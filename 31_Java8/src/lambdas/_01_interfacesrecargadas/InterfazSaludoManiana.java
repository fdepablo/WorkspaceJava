package lambdas._01_interfacesrecargadas;

/*
 * Interfaces recargadas 
 Java SE 8 hace un cambio grande a las interfaces con el fin de que las 
librerías puedan evolucionar sin perder compatibilidad. 
A partir de esta versión, las interfaces pueden proveer métodos con una implementación 
por defecto. Las clases que implementen dichas interfaces heredarán automáticamente 
la implementación por defecto si éstas no proveen una explícitamente:

 Llamados metodos por defecto, metodos virtuales o metodos defensores , son 
especificados e implementados  en  la interface.  Usan  la nueva palabra 
reservada default antes  del tipo  de retorno.
 La implementacion por defecto es usada solo cuando la clase implementadora no 
provee su propia implementacion .
 Desde el punto de vista de quién invoca al método, es un método más de la interface.
 Conflicto cuando se implementen interfaces con métodos por defecto con el mismo nombre.
 */
public interface InterfazSaludoManiana {
	default void saludo(){ 
		System.out.println("Buenos dias");
	}
}
