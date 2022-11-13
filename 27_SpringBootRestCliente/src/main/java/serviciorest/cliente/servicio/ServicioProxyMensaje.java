package serviciorest.cliente.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//Con esta anotación damos de alta un objeto de tipo
//ServicioProxyMensaje dentro del contexto de Spring
@Service
public class ServicioProxyMensaje {

	//La URL base del servicio REST
	public static final String URL = "http://localhost:8080/";
	
	//Inyectamos el objeto de tipo RestTemplate que nos ayudará
	//a hacer las peticiones HTTP al servicio REST
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * Metodo que consume el servicio rest hubicado en "http://localhost:8080/"
	 * En funcion del path devolvera el mensaje normal o el mensaje HTML
	 * @param path, el path del mensaje que queremos acceder, dos posibles
	 * valores. "mensaje" que nos devuelve el mensaje en texto y "mensajeHTML"
	 * que nos devuelve un mensaje en HTML
	 * @return string con la cadena en texto plano o en texto html en función
	 * del parametro de entrada
	 */
	public String obtener(String path){
		//Con el método getForObject del objeto restTemplate podemos hacer
		//peticiones HTTP a un servicio REST. Tenemos que pasarle la URL
		//Y el tipo que nos va a devolver (String)
		//URL Ej: http://localhost:8080/mensajeHTML
		//Este método usara el verbo GET para hacer la request
		//de manera implicita
		String pathFinal = URL + path;
		System.out.println("obtener -> Ruta final: " + pathFinal);
		String mensaje = restTemplate.getForObject(pathFinal, String.class);
		return mensaje;
	}
}
