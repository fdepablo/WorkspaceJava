package doc;
import java.util.Date;

/**
 * Ejemplo de creación de documentación para Javadoc.<br/>
 * Podemos incluir etiquetas HTML para enriquecer el texto.
 * 
 * Aqui deberia ir una descripción de lo que hace la clase
 * 
 * En java doc tenemos además anotaciones, para que cuando generemos
 * la documentación o la veamos mediante un IDE como eclipse este
 * mejor representada.
 * 
 * @author Nombre del autor.
 * @version 1.0
 * @since 25-10-2018.
 *
 */
public class PruebaDoc {
	// PROPIEDADES DE CLASE
	/**
	 * Aqui iria una descripción de lo que representa esta propiedad
	 */
	private String texto;
	/**
	 * Valor numerico entero.
	 */
	private Integer numero;

	// ZONA DE CONSTRUCTORES
	/**
	 * Comentario de metodo simple. Podriamos add información sobre este constructor
	 */
	public PruebaDoc() {

	}

	// ZONA DE LOGICA
	/**
	 * Otro comentario de metodo simple. Al no tener parametros de entrada ni de 
	 * salida, simplemente deberiamos aportar una descripción de este método
	 * lo que hace
	 */
	public void metodoUno() {
		// COMENTARIO DE LINEA, ESTOS COMENTARIOS NO SON DE JAVADOC
		// SEGUNDA LINEA DE COMENTARIO
		/*
		 * COMENTARIOS DE VARIAS LINEAS, NO CONFUNDIR CON JAVADOC
		 */

	}

	/**
	 * Aqui iría una descripción del metodo, pero como además tenemos parametros
	 * de entrada y de salida, deberiamos crear anotaciones que representen y
	 * expliquen los parametros de entrada y los parametros de salida
	 * 
	 * @param numero
	 *            Valor numerico entero.
	 * @param fecha
	 *            Valor fecha.
	 * @return Cadena devuelta.
	 */
	public String metodoDos(Integer numero, Date fecha) {

		return null;
	}

	/**
	 * Aqui iría una descripción del metodo y sus parametros de entrada y de salida
	 * pero como además tenemos una excepción tambien podemos anotarla para explicar
	 * cuando se arroja dicha excepcion
	 * 
	 * @param texto
	 *            Valor texto.
	 * @return Valor numerico.
	 * @throws Exception
	 *             Excepcion dada. {@link Exception#getLocalizedMessage()}
	 */
	public Integer metodoTres(String texto) throws RuntimeException {

		return null;
	}

}