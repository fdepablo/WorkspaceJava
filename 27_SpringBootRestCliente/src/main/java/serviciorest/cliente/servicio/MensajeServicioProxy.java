package serviciorest.cliente.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MensajeServicioProxy {

	public static final String URL = "http://localhost:8080/mensaje";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String obtener(){
		String mensaje = restTemplate.getForObject(URL, String.class);
		return mensaje;
	}
}
