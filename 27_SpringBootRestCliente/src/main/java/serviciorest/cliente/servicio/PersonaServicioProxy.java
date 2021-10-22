package serviciorest.cliente.servicio;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import serviciorest.cliente.entidad.Persona;

@Service
public class PersonaServicioProxy {

	public static final String URL = "http://localhost:8080/personas/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Persona obtener(int id){
		Persona persona = restTemplate.getForObject(URL + id, Persona.class);
		return persona;
	}
	
	public Persona alta(Persona p){
		Persona pAlta = restTemplate.postForObject(URL, p, Persona.class);
		return pAlta;
	}
	
	public void modificar(Persona p){
		restTemplate.put(URL + p.getId(), p, Persona.class);
	}
	
	public void borrar(int id){
		restTemplate.delete(URL + id);
	}
	
	public List<Persona> listar(){
		ResponseEntity<Persona[]> response =
				  restTemplate.getForEntity(URL,Persona[].class);
		
		Persona[] arrayPersonas = response.getBody();
		
		return Arrays.asList(arrayPersonas);
	}
	
	public List<Persona> listar(String nombre){
		String queryParams = "?nombre=" + nombre;
		
		ResponseEntity<Persona[]> response =
				  restTemplate.getForEntity(URL + queryParams,Persona[].class);
		
		Persona[] arrayPersonas = response.getBody();
		
		return Arrays.asList(arrayPersonas);
	}
}
