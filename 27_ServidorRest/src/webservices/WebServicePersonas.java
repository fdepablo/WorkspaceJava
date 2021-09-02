package webservices;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import entidad.Persona;
import persistencia.DaoPersona;

@Path("personas")
public class WebServicePersonas {
	
	DaoPersona daoPersona = new DaoPersona();
	
	//http://localhost:8080/27_ServidorRest/rest/personas
	@GET
	@Produces({"application/json"})
	public List<Persona> listarPersonas(@QueryParam("nombre") String nombre) {
		System.out.println("Listando las personas " + nombre);
		//En caso de que me pida filtrar por un nombre lo hago, en caso de que
		//no, le devuelvo toda la lista
		if(nombre == null)
			return daoPersona.list();	
		else 
			return daoPersona.getByName(nombre);
	}
	
	@GET
	@Path("/{id}")
	@Produces({"application/json"})
	public Persona getPersona(@PathParam("id") int id) {
		System.out.println("Buscando persona con id: " + id);
		Persona p = daoPersona.get(id);
		return p;	
	}

	//Este metodo funcionaría de una manera sencilla, pero mejor mirar el ejemplo
	//del siguiente metodo post
	/*
	@POST
	@Consumes({"application/json"})
	@Produces({"application/json","application/xml"})
	public Persona altaPersona(Persona p) {
		System.out.println(p);	
		daoPersona.add(p);
		return p;	
	}	
	*/
	
	//Realmente los metodos tendrían que responder adecuadamente, por ejemplo
	//cuando creamos un objeto mediante POST deberiamos devolver un "201 CREATED"
	//no un "200 OK". Habria que hacer cosas parecidas en todos los metodos y no
	//devolver siempre un "200 OK", ¡hay que reponder adecuadamente!
	@POST	
	@Consumes({"application/json"})//esta etiqueta esta relacionada con content-type
								//del cliente, decimos que solo consumimos los
								//mime type que son "application/json"
								//es decir, el cliente tiene que tener la cabecera
								//content-type con valor "application/json"
	@Produces({"application/json","application/xml"})
	public Response altaPersona(Persona p) {//la persona la tenemos que enviar
										//en el body del mensaje HTTP
		System.out.println("altaPersona: objeto persona: " + p);
		daoPersona.add(p);
		//por defecto todas las respuestas crean el codigo de respuesta 200
		//creamos el codigo de respuesta 201, metemos la entidad y lo construimos
		return Response.status(Response.Status.CREATED).entity(p).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces({"application/json"})
	public Persona borrarPersona(@PathParam("id") int id) {
		System.out.println("ID a borrar: " + id);
		Persona p = daoPersona.delete(id);
		return p;
	}
	
	@PUT
	@Path("/{id}")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	//En el path le voy a poner el ID y en el body le voy a mandar el nuevo
	//contenido del objeto en formato json
	public Persona modificarPersona(@PathParam("id") int id, Persona p) {
		System.out.println("ID a modificar: " + id);
		System.out.println("Datos a modificar: " + p);
		p.setId(id);
		p = daoPersona.update(p);
		return p;	
	}
}
