package serviciorest.cliente.servicio;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import serviciorest.cliente.entidad.Persona;

//Con esta anotación damos de alta un objeto de tipo
//ServicioProxyPersona dentro del contexto de Spring
@Service
public class ServicioProxyPersona {

	//La URL base del servicio REST de personas
	public static final String URL = "http://localhost:8080/personas/";
	
	//Inyectamos el objeto de tipo RestTemplate que nos ayudará
	//a hacer las peticiones HTTP al servicio REST
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * Método que obtiene una persona del servicio REST a partir de un id
	 * En caso de que el id no exita arrojaria una expcepción que se captura
	 * para sacar el codigo de respuesta
	 * 
	 * @param id que queremos obtener
	 * @return retorna la persona que estamos buscando, null en caso de que la
	 * persona no se encuentre en el servidor (devuelva 404) o haya habido algún
	 * otro error.
	 */
	public Persona obtener(int id){
		try {
			//Como el servicio trabaja con objetos ResponseEntity, nosotros 
			//tambien podemos hacerlo en el cliente
			//Ej http://localhost:8080/personas/1 GET
			ResponseEntity<Persona> re = restTemplate.getForEntity(URL + id, Persona.class);
			HttpStatus hs= re.getStatusCode();
			if(hs == HttpStatus.OK) {	
				//Si la persona existe, la persona viene en formato JSON en el body
				//Al ser el objeto ResponseEntity de tipo Persona, al obtener el 
				//body me lo convierte automaticamente a tipo Persona
				//(Spring utiliza librerías por debajo para pasar de JSON a objeto)
				return re.getBody();
			}else {
				System.out.println("obtener -> Respuesta no contemplada");
				return null;
			}
		}catch (HttpClientErrorException e) {//Errores 4XX
			System.out.println("obtener -> La persona NO se ha encontrado, id: " + id);
		    System.out.println("obtener -> Codigo de respuesta: " + e.getStatusCode());
		    return null;
		}
	}
	
	/**
	 * Método que da de alta una persona en el servicio REST
	 * 
	 * @param p la persona que vamos a dar de alta
	 * @return la persona con el id actualizado que se ha dado de alta en el
	 * servicio REST. Null en caso de que no se haya podido dar de alta
	 */
	public Persona alta(Persona p){
		try {
			//Para hacer un post de una entidad usamos el metodo postForEntity
			//El primer parametro la URL
			//El segundo parametros la persona que ira en body
			//El tercer parametro el objeto que esperamos que nos envie el servidor
			ResponseEntity<Persona> re = restTemplate.postForEntity(URL, p, Persona.class);
			System.out.println("alta -> Codigo de respuesta " + re.getStatusCode());
			return re.getBody();
		} catch (HttpClientErrorException e) {//Errores 4XX
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
			//El metodo put de Spring no devuelve nada
			//si no da error se ha dado de alta y si no daria una 
			//excepcion
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
			//El metodo delete tampoco devuelve nada, por lo que si no 
			//ha podido borrar el id, daría un excepcion
			//Ej http://localhost:8080/personas/1 DELETE
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
			//Ej http://localhost:8080/personas?nombre=harry GET
			ResponseEntity<Persona[]> response =
					  restTemplate.getForEntity(URL + queryParams,Persona[].class);
			Persona[] arrayPersonas = response.getBody();
			return Arrays.asList(arrayPersonas);//convertimos el array en un ArrayList
		} catch (HttpClientErrorException e) {
			System.out.println("listar -> Error al obtener la lista de personas");
		    System.out.println("listar -> Codigo de respuesta: " + e.getStatusCode());
		    return null;
		}
	}
}
