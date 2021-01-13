package doc;

import java.util.Date;

/*
 * El objetivo de javadoc es el de proporcionar informacion a otro desarrolladores de como tienen
 * que utilizar nuestros clases y metodos. Esta documentacion no es para nosotros (que tambien)
 * es principalmente para los programadores que usen nuestro codigo.
 */
public class PruebaDocMain {

	public static void main(String[] args) {
		
		PruebaDoc pd = new PruebaDoc();
		//Si pasamos el raton por encima del metodo nos dara la información
		//en java doc. Hay que tener claro que javadoc sirve para que
		//la gente que use nuestras clases sepa como usarlas sin necesidad
		//de entender el codigo
		pd.metodoDos(34, new Date());
		pd.metodoTres("texto");
		
		String cadena = "Esto es un string";
		cadena.length();
		cadena.substring(0, 8);
	}

}
