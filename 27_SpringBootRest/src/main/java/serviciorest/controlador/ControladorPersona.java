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

import serviciorest.modelo.entidad.Persona;
import serviciorest.modelo.persistencia.DaoPersona;

//En este ejemplo vamos a realizar un CRUD completo contra la entidad
//Persona. La bbdd esta simulado en memoria.
@RestController
public class ControladorPersona {
	
	//Hay que tener en cuenta que normalmente tenemos objetos que dependen
	//de otros para hacer su trabajo. En este caso, el objeto de tipo
	//ControladorPersona que hemos dado de alta en el contexto de Spring
	//mediante la anotacion @RestController NECESITA un objeto de tipo
	//DaoPersona para realizar su trabajo (y que dimos de alta previamente
	//con la anotacion @Component)
	
	//La anotacion @Autowired se usa para hacer inyecciones de dependencias
	//de objetos dados de alta dentro del contexto de Spring. 
	//Cuando se cree este objeto (ControladorPersona) dentro del contexto
	//de Spring, mediante esta anotacion le diremos que inyecte un objeto
	//de tipo DaoPersona a la referencia "daoPersona", por lo que el objeto
	//Controlador persona quedará perfectamente formado.
	@Autowired
	private DaoPersona daoPersona;
	
	//GET PERSONA POR ID
	//En este primer ejemplo vamos a configurar endpoint(punto de acceso) para
	//devolver una persona por ID. Como nos marca REST, al ser una busqueda
	//por clave primaria, el ID debe ir como parte del PATH de la URL.
	//Esto lo hacemos por medio del atributo "path="personas/{id}"
	//Podemos obtener el ID usando la anotacion @PathVariable("id") dentro
	//de un parametro de entrada. El "id" se corresponde con el "{id}",
	//es decir, deben de llamarse igual.
	
	//Ademas, queremos que el resultado sea JSON. Spring Boot serializara
	//automaticamente el resultado a json a traves de las librerías Jackson
	//Esto lo hacemos mediante el atributo "produces". Recordemos que todas
	//las respuestas van dentro del BODY del mensaje HTTP
	
	//Por ultimo, no nos olvidemos que tenemos que responder adecuadamente
	//con el codigo de respuesta apropieado, segun nos marca el protocolo HTTP.
	//Para ello usaremos la clase "ResponseEntity" que nos permite encapsular 
	//tanto el resultado en json como el codigo del mensaje. En este caso 
	//el codigo 200 "OK" si existe o 404 NOT FOUND si no existe
	
	//La URL para acceder a este metodo sería: 
	//"http://localhost:8080/personas/ID" y el metodo a usar seria GET
	//ID sería el identificador que queremos buscar
	@GetMapping(path="personas/{id}",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Persona> getPersona(@PathVariable("id") int id) {
		System.out.println("Buscando persona con id: " + id);
		Persona p = daoPersona.get(id);
		if(p != null) {
			return new ResponseEntity<Persona>(p,HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
	
	//POST 
	//En este caso vamos a dar de alta una persona, para ello usaremos
	//el metodo POST, vamos a producir tambien JSON (produces) y el 
	//formato que nos tiene que enviar el cliente tambien tiene que ser
	//JSON (consumes). La persona nos tiene que llegar sin ID, ya que
	//seremos nosotros quien le pongamos dicho ID.
	
	//Para obtener la persona que nos envie el cliente podemos usar
	//la anotacion @RequestBody en un parametro de entrada de tipo
	//Persona. Spring se encargará de deserializar automaticamente
	//el json.
	
	//En este caso devolveremos la persona creada (ya que seremos nosotros
	//los que le asignemos el ID) y el codigo de respuesta 201 CREATED
	
	//La URL para acceder a este metodo sería: 
	//"http://localhost:8080/personas" y el metodo a usar seria POST
	//Pasandole la persona sin el ID dentro del body del HTTP request
	@PostMapping(path="personas",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> altaPersona(@RequestBody Persona p) {
		System.out.println("altaPersona: objeto persona: " + p);
		daoPersona.add(p);
		return new ResponseEntity<Persona>(p,HttpStatus.CREATED);//201 CREATED
	}
	
	//GET LISTA PERSONAS
	//En este caso vamos a pedir todas las personas que tenemos almacenadas
	//Tambien nos da la opcion de filtrar por nombre si nos pasa un parametro
	//que se llame "nombre". Mediante la anotacion @RequestParam que pondremos
	//en un atributo de entrada de tipo String. Con el atributo name="nombre"
	//establecemos el nombre del parametro y con el atributo required=false
	//le decimos que no es obligatorio que nos lo envie.
	//De esta manera si NO me viene el parametro "nombre" devolveremos
	//toda la lista de personas, en caso de que venga, haremos el filtrado
	//por dicho nombre.
	
	//La URL para acceder a este metodo en caso de querer todas las personas
	//sería: 
	//"http://localhost:8080/personas" y el metodo a usar seria GET
	//Si queremos filtrar por nombre entonces deberemos usar:
	//"http://localhost:8080/personas?nombre=NOMBRE_A_FILTRAR"
	@GetMapping(path="personas",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> listarPersonas(
			@RequestParam(name="nombre",required=false) String nombre) {
		List<Persona> listaPersonas = null;
		//Si no me viene el nombre, devolvemos toda la lista
		if(nombre == null) {
			System.out.println("Listando las personas");
			listaPersonas = daoPersona.list();			
		}else {
			System.out.println("Listando las personas por nombre: " + nombre);
			listaPersonas = daoPersona.listByNombre(nombre);
		}
		System.out.println(listaPersonas);
		return new ResponseEntity<List<Persona>>(listaPersonas,HttpStatus.OK);
	}
	
	//PUT
	//En este caso vamos a hacer una modificación de persona por ID
	//Para seguir lo que nos marca REST, el ID lo recibiremos en el PATH
	//y los datos por JSON dentro del bodoy del mensaje HTTP.
	
	//Si todo ha ido bien devolvemos el codigo de respuesta de 200 OK,
	//si id de la persona no existe devolvemos 404 NOT FOUND
	
	//La URL para acceder a este metodo sería: 
	//"http://localhost:8080/personas/ID" y el metodo a usar seria PUT
	//Pasandole la persona sin el ID dentro del body del HTTP request
	@PutMapping(path="personas/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> modificarPersona(
			@PathVariable("id") int id, 
			@RequestBody Persona p) {
		System.out.println("ID a modificar: " + id);
		System.out.println("Datos a modificar: " + p);
		p.setId(id);
		Persona pUpdate = daoPersona.update(p);
		if(pUpdate != null) {
			return new ResponseEntity<Persona>(HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
	
	//DELETE
	//Aqui vamos a borar una persona a traves de un ID que le pasemos en el
	//PATH.
	
	//Si todo ha ido bien devolvemos el codigo de respuesta de 200 OK y
	//devolvemos la persona que hemos borrado
	
	//La URL para acceder a este metodo sería: 
	//"http://localhost:8080/personas/ID" y el metodo a usar seria DELETE
	@DeleteMapping(path="personas/{id}")
	public ResponseEntity<Persona> borrarPersona(@PathVariable("id") int id) {
		System.out.println("ID a borrar: " + id);
		Persona p = daoPersona.delete(id);
		if(p != null) {
			return new ResponseEntity<Persona>(p,HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
}
