package _07_propiedades;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuracion {

	private Properties properties;
	
	public void inicializar() {
		try (InputStream url = Configuracion.class.getClassLoader()
				.getResourceAsStream("config.properties");){
			// Cargamos el properties
			// tiene que estar dentro de una ruta de classpath
			properties = new Properties();
			properties.load(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
