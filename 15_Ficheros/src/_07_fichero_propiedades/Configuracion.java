package _07_fichero_propiedades;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuracion {

	private Properties properties;
	
	public void inicializar() {
		try (InputStream ficheroPropiedades = Configuracion.class.getClassLoader()
				.getResourceAsStream("config.properties");){
			// Cargamos el properties
			// tiene que estar dentro de una ruta de classpath
			properties = new Properties();
			properties.load(ficheroPropiedades);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que devuelve un valor de una propiedad a partir de la clave
	 * @param key la clave de la propiedad
	 * @return valor de la propiedad. Null en caso de que no exista.
	 */
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
