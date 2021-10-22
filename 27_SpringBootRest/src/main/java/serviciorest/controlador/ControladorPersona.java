package serviciorest.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import serviciorest.entidad.Persona;
import serviciorest.persistencia.DaoPersona;

//Damos de alta el objeto en el contexto de spring y se configure para
//recibir y enviar peticiones HTTP
//Los metodos anotados seran endpoints (puntos de entrada a nuetra aplicacion)
//Con la anotacion le diremos principalmente la URL y el verbo con el que
//debe hacer la petion HTTP para poder entrar
@RestController
public class ControladorPersona {
	
	@Autowired
	private DaoPersona daoPersona;
	
	//http://localhost:8080/personas
	@GetMapping(path="personas",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> listarPersonas(
			@RequestParam(name="nombre",required=false) String nombre) {
		List<Persona> listaPersonas = null;
		//En caso de que me pida filtrar por un nombre lo hago, en caso de que
		//no, le devuelvo toda la lista
		if(nombre == null) {
			System.out.println("Listando las personas");
			listaPersonas = daoPersona.list();			
		}else {
			System.out.println("Listando las personas por nombre: " + nombre);
			listaPersonas = daoPersona.listByName(nombre);
		}
		System.out.println(listaPersonas);
		return new ResponseEntity<List<Persona>>(listaPersonas,HttpStatus.OK);
	}
	
	@GetMapping(path="personas/{id}",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Persona> getPersona(@PathVariable("id") int id) {
		System.out.println("Buscando persona con id: " + id);
		Persona p = daoPersona.get(id);
		return new ResponseEntity<Persona>(p,HttpStatus.OK);
	}
	
	//Realmente los metodos tendr�an que responder adecuadamente, por ejemplo
	//cuando creamos un objeto mediante POST deberiamos devolver un "201 CREATED"
	//no un "200 OK". Hay que reponder adecuadamente!
	//esta etiqueta esta relacionada con content-type
								//del cliente, decimos que solo consumimos los
								//mime type que son "application/json"
								//es decir, el cliente tiene que tener la cabecera
								//content-type con valor "application/json"
	@PostMapping(path="personas",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	//la persona la tenemos que enviar en el body del mensaje HTTP
	public ResponseEntity<Persona> altaPersona(@RequestBody Persona p) {
		System.out.println("altaPersona: objeto persona: " + p);
		daoPersona.add(p);
		//por defecto todas las respuestas crean el codigo de respuesta 200
		//creamos el codigo de respuesta 201, metemos la entidad y lo construimos
		return new ResponseEntity<Persona>(p,HttpStatus.CREATED);//201
	}
	
	//En el path le voy a poner el ID y en el body le voy a mandar el nuevo
	//contenido del objeto en formato json
	@PutMapping(path="personas/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> modificarPersona(
			@PathVariable("id") int id, 
			@RequestBody Persona p) {
		System.out.println("ID a modificar: " + id);
		System.out.println("Datos a modificar: " + p);
		p.setId(id);
		daoPersona.update(p);
		return new ResponseEntity<Persona>(HttpStatus.OK);
	}
	
	@DeleteMapping(path="personas/{id}")
	public ResponseEntity<Persona> borrarPersona(@PathVariable int id) {
		System.out.println("ID a borrar: " + id);
		Persona p = daoPersona.delete(id);
		return new ResponseEntity<Persona>(p,HttpStatus.OK);
	}
}
