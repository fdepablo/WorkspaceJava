package es.rest.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.rest.modelo.entidad.Persona;
import es.rest.modelo.persistencia.DaoPersona;

//En este ejemplo vamos a realizar un CRUD completo contra la entidad
//Persona. La bbdd esta simulado en memoria.
@RestController
//@CrossOrigin, para evitar probremas CORS.
@CrossOrigin(origins = "*")
public class ControladorPersona {
	
	@Autowired
	private DaoPersona daoPersona;
	
	//"http://localhost:8080/personas/ID" y el metodo a usar seria GET
	@GetMapping(path="personas/{id}",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Persona> getPersona(@PathVariable("id") int id) {
		System.out.println("Buscando persona con id: " + id);
		Optional<Persona> p = daoPersona.findById(id);
		if(p.isPresent()) {
			return new ResponseEntity<Persona>(p.get(),HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
	
	//"http://localhost:8080/personas" y el metodo a usar seria POST
	@PostMapping(path="personas",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> altaPersona(@RequestBody Persona p) {
		System.out.println("altaPersona: objeto persona: " + p);
		daoPersona.save(p);
		return new ResponseEntity<Persona>(p,HttpStatus.CREATED);//201 CREATED
	}
	
	//"http://localhost:8080/personas" y el metodo a usar seria GET
	@GetMapping(path="personas",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> listarPersonas(
			@RequestParam(name="nombre",required=false) String nombre) {
		List<Persona> listaPersonas = null;
		//Si no me viene el nombre, devolvemos toda la lista
		if(nombre == null) {
			System.out.println("Listando las personas");
			listaPersonas = daoPersona.findAll();			
		}else {
			System.out.println("Listando las personas por nombre: " + nombre);
			listaPersonas = daoPersona.findByNombre(nombre);
		}
		System.out.println(listaPersonas);
		return new ResponseEntity<List<Persona>>(listaPersonas,HttpStatus.OK);
	}
	
	//"http://localhost:8080/personas/ID" y el metodo a usar seria PUT
	@PutMapping(path="personas/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> modificarPersona(
			@PathVariable("id") int id, 
			@RequestBody Persona p) {
		System.out.println("ID a modificar: " + id);
		System.out.println("Datos a modificar: " + p);
		p.setId(id);
		Optional<Persona> pUpdate = daoPersona.findById(id);			
		if(pUpdate.isPresent()) {
			p = daoPersona.save(p);
			return new ResponseEntity<Persona>(HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
	
	//"http://localhost:8080/personas/ID" y el metodo a usar seria DELETE
	@DeleteMapping(path="personas/{id}")
	public ResponseEntity<Persona> borrarPersona(@PathVariable("id") int id) {
		System.out.println("ID a borrar: " + id);
		Optional<Persona> p = daoPersona.findById(id);		
		if(p.isPresent()) {
			daoPersona.deleteById(id);
			return new ResponseEntity<Persona>(p.get(),HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
}
