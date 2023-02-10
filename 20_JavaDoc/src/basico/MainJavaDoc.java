package basico;

import java.util.Date;

/**
 * Aquí iría una descripción de lo que hace clase, con todo el nivel de detalle 
 * que se precise
 * 
 * En javadoc podemos poner anotaciones
 * 
 * @author Bruce Banner
 * 
 * Esta anotación representaría la version de la clase
 * @version 1.0
 *
 */
public class MainJavaDoc {

	public static void main(String[] args) {
		
		ClaseJavaDoc pd = new ClaseJavaDoc();
		
		// Si pasamos el ratón por encima del método o de las clases nos dara la 
		// información que hayamos establecido en el Javadoc. 
		pd.metodoUno();
		pd.metodoDos(34, new Date());
		pd.metodoTres("texto");
		pd.metodoCuatro("texto2");//sale warning porque está obsoleto
		pd.metodoCinco("texto3");
		
		String cadena = "Esto es un string";
		
		//Lo mismo ocurre cuando pasamos el ratón por una clase que no hemos
		//hecho nosotros pero sus desarrolladores han creado el JavaDoc
		cadena.length();
		cadena.substring(0, 8);
	}

}
