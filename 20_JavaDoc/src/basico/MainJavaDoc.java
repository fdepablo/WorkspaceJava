package basico;

import java.util.Date;

/**
 * Aqui iria una descripcion de lo que hace clase, con todo el nivel de detalle 
 * que se precise
 * 
 * En javadoc podemos poner anotaciones
 * 
 * @author Bruce Banner
 * 
 * Esta anotacion representaria la version de la clase
 * @version 1.0
 *
 */
public class MainJavaDoc {

	public static void main(String[] args) {
		
		ClaseJavaDoc pd = new ClaseJavaDoc();
		
		// Si pasamos el raton por encima del metodo o de las clases nos dara la 
		// información hayamos establecido en el Javadoc. 
		pd.metodoUno();
		pd.metodoDos(34, new Date());
		pd.metodoTres("texto");
		pd.metodoCuatro("texto2");//sale warning porque esta obsoleto
		pd.metodoCinco("texto3");
		
		String cadena = "Esto es un string";
		
		//Lo mismo ocurre cuando pasamos el raton por una clase que no hemos
		//hecho nosotros pero sus desarrolladores han creado el Javadoc
		cadena.length();
		cadena.substring(0, 8);
	}

}
