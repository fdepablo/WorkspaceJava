package anotaciones;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * La anotación @Retention(RetentionPolicy.RUNTIME) 
 * permite que la anotación @Autor esté disponible en 
 * tiempo de ejecución.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Autor {
	/*
	 * La anotación cuenta con los atributos o datos nombre 
	 * y direccion cuyos valores predeterminados son 
	 * "Teléfonica" y "Distrito Telefónica".
	 */
	String nombre() default "Telefónica";
	String direccion() default "Distrito Telefónica";
}
