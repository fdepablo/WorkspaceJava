package basico;
import java.util.Date;

/**
 * Ejemplo de creación de documentación para Javadoc.
 * <br>
 * Aqui deberia ir una descripción de lo que hace la clase y sus objetivos.
 * <br>
 * Podemos usar HTML para mejorar la calidad de la documentacion
 * <br>
 * <b>Atributos de la clase</b>
 * <ul>
 * <li>texto</li>
 * <li>numero</li>
 * </ul>
 * 
 * Luego irian las anotaciones que estimemos necesarias:
 * 
 * @author Nombre del autor.
 * @version 2.0
 *
 */
public class ClaseJavaDoc {
	// ATRIBUTOS DE CLASE
	/**
	 * Aqui iria una descripción de lo que representa esta propiedad
	 */
	private String texto;
	/**
	 * Valor numerico entero.
	 */
	private Integer numero;

	// CONSTRUCTORES
	/**
	 * Comentario de metodo simple. Podriamos add información sobre este constructor
	 */
	public ClaseJavaDoc() {

	}

	// SETTER Y GETTER. 
	// Normalmente no se documentan
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	// METODOS
	
	/**
	 * Otro comentario de metodo simple. Al no tener parametros de entrada ni de 
	 * salida, simplemente deberiamos aportar una descripción de lo que hace 
	 * este método
	 */
	public void metodoUno() {
		// AQUI IRIA EL CODIGO DEL METODO
		// ESTOS COMENTARIOS NO SON JAVADOC, SON COMENTARIOS NORMALES
	}

	/**
	 * Aquí iría una descripción del metodo, pero como además tenemos parametros
	 * de entrada y de salida, deberiamos crear anotaciones que representen y
	 * expliquen los parametros de entrada y el parametro de salida
	 * 
	 * @param numero aquí deberiamos explicar lo que representa este parametro
	 * @param fecha idem anterior
	 * @return explicar lo que devolvemos o los posibles valores de retorno
	 */
	public String metodoDos(Integer numero, Date fecha) {
		//AQUI IRIA EL CODIGO DEL METODO
		return null;
	}

	/**
	 * Aqui iría una descripción del metodo y sus parametros de entrada y de salida
	 * pero como además tenemos una excepción tambien podemos anotarla para explicar
	 * cuando se arroja dicha excepcion
	 * 
	 * @param texto en String.<a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html">Ver la clase</a>

	 * @return Valor numerico.
	 * 
	 * @throws RuntimeException Cuando el texto es null (por ejemplo...) 
	 * @since 1.2 (en este caso, este método esta desde la versión 1.2 de la 
	 * clase. Actualmente la clase esta en la versión 2.0)
	 */
	public Integer metodoTres(String texto) throws RuntimeException {
		//AQUI IRIA EL CODIGO DEL METODO
		return null;
	}
	
	/**
	 * Aqui iría una descripción del metodo y sus parametros de entrada y de salida
	 * 
	 * @param texto
	 *            Valor texto.
	 * @return Valor numerico.
	 * @since 1.0
	 * @deprecated Establecemos como obsoleto el método, lo cual aparecera tachado.
	 * Hay veces que se suelen mantener por retrocompatibilidad, pero siempre que 
	 * veamos un método obsoleto, quiere decir que seguramente haya otro método
	 * mejor para usar y hacer la funcionalidad. Metodo reemplazado por
*              {@link #metodoCinco(String)}
	 */
	public Integer metodoCuatro(String texto){
		//AQUI IRIA EL CODIGO DEL METODO
		return null;
	}
	
	/**
	 * Aqui iría una descripción del metodo y sus parametros de entrada y de salida
	 * 
	 * @since 2.0
	 * @param texto el valor en String
	 * @return valor numerico
	 */
	public Integer metodoCinco(String texto){
		//AQUI IRIA EL CODIGO DEL METODO
		return null;
	}
}