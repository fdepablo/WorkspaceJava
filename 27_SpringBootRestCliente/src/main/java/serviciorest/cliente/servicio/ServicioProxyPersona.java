package serviciorest.cliente.servicio;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import serviciorest.cliente.entidad.Persona;

//Con esta anotacion damos de alta un objeto de tipo
//ServicioProxyPersona dentro del contexto de Spring
@Service
public class ServicioProxyPersona {

	//La URL base del servicio REST de personas
	public static final String URL = "http://localhost:8080/personas/";
	
	//Inyectamos el objeto de tipo RestTemplate que nos ayudara
	//a hacer las peticiones HTTP al servicio REST
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * Metodo que obtiene una persona del servicio REST a partir de un id
	 * En caso de que el id no exita arrojaria una expcepcion que se captura
	 * para sacar el codigo de respuesta
	 * 
	 * @param id que queremos obtener
	 * @return retorna la persona que estamos buscando, null en caso de que la
	 * persona no se encuentre en el servidor (devuelva 404) o haya habido algun
	 * otro error.
	 */
	public Persona obtener(int id){
		try {
			ResponseEntity<Persona> re = restTemplate.getForEntity(URL + id, Persona.class);
			HttpStatus hs= re.getStatusCode();
			if(hs == HttpStatus.OK) {				
				return re.getBody();
			}else {
				System.out.println("Respuesta no contemplada");
				return null;
			}
		}catch (HttpClientErrorException e) {
			System.out.println("obtener -> La persona NO se ha encontrado, id: " + id);
		    System.out.println("obtener -> Codigo de respuesta: " + e.getStatusCode());
		    return null;
		}
	}
	
	/**
	 * Metodo que da de alta una persona en el servicio REST
	 * 
	 * @param p la persona que vamos a dar de alta
	 * @return la persona con el id actualizado que se ha dado de alta en el
	 * servicio REST. Null en caso de que no se haya podido dar de alta
	 */
	public Persona alta(Persona p){
		try {
			ResponseEntity<Persona> re = restTemplate.postForEntity(URL, p, Persona.class);
			System.out.println("alta -> Codigo de respuesta " + re.getStatusCode());
			return re.getBody();
		} catch (HttpClientErrorException e) {
			System.out.println("alta -> La persona NO se ha dado de alta, id: " + p);
		    System.out.println("alta -> Codigo de respuesta: " + e.getStatusCode());
		    return null;
		}
	}
	
	/**
	 * 
	 * Modifica una persona en el servicio REST
	 * 
	 * @param p la persona que queremos modificar, se hara a partir del 
	 * id por lo que tiene que estar relleno.
	 * @return true en caso de que se haya podido modificar la persona. 
	 * false en caso contrario.
	 */
	public boolean modificar(Persona p){
		try {
			restTemplate.put(URL + p.getId(), p, Persona.class);
			return true;
		} catch (HttpClientErrorException e) {
			System.out.println("modificar -> La persona NO se ha modificado, id: " + p.getId());
		    System.out.println("modificar -> Codigo de respuesta: " + e.getStatusCode());
		    return false;
		}
	}
	
	/**
	 * 
	 * Borra una persona en el servicio REST
	 * 
	 * @param id el id de la persona que queremos borrar.
	 * @return true en caso de que se haya podido borrar la persona. 
	 * false en caso contrario.
	 */
	public boolean borrar(int id){
		try {
			restTemplate.delete(URL + id);
			return true;
		} catch (HttpClientErrorException e) {
			System.out.println("borrar -> La persona NO se ha borrar, id: " + id);
		    System.out.println("borrar -> Codigo de respuesta: " + e.getStatusCode());
		    return false;
		}
	}
	
	/**
	 * Metodo que devuelve todas las personas o todas las personas filtradas
	 * por nombre del web service
	 * 
	 * @param nombre en caso de ser distinto de null, devolvera el listado
	 * filtrado por el nombre que le hayamos pasado en este parametro. En caso
	 * de que sea null, el listado de las personas sera completo
	 * @return el listado de las personas segun el parametro de entrada o 
	 * null en caso de algun error con el servicio REST
	 */
	public List<Persona> listar(String nombre){
		String queryParams = "";		
		if(nombre != null) {
			queryParams += "?nombre=" + nombre;
		}
		
		try {
			ResponseEntity<Persona[]> response =
					  restTemplate.getForEntity(URL + queryParams,Persona[].class);
			Persona[] arrayPersonas = response.getBody();
			return Arrays.asList(arrayPersonas);
		} catch (HttpClientErrorException e) {
			System.out.println("listar -> Error al obtener la lista de personas");
		    System.out.println("listar -> Codigo de respuesta: " + e.getStatusCode());
		    return null;
		}
	}
}
