package serviciorest.cliente.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//Con esta anotacion damos de alta un objeto de tipo
//ServicioProxyMensaje dentro del contexto de Spring
@Service
public class ServicioProxyMensaje {

	//La URL base del servicio REST
	public static final String URL = "http://localhost:8080/";
	
	//Inyectamos el objeto de tipo RestTemplate que nos ayudara
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
		String mensaje = restTemplate.getForObject(URL + path, String.class);
		return mensaje;
	}
}
