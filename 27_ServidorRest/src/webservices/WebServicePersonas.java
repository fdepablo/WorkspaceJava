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

import beans.Persona;
import persistencia.DaoPersona;

@Path("personas")
public class WebServicePersonas {
	
	DaoPersona daoPersona = new DaoPersona();
	
	//http://localhost:8080/27_ServidorRest/rest/personas
	@GET
	@Produces({"application/json"})
	public List<Persona> listarPersonas() {
		System.out.println("Listando las personas");
		return daoPersona.list();	
	}
	
	@GET
	@Path("/{id}")
	@Produces({"application/json"})
	public Persona getPersona(@PathParam("id") int id) {
		System.out.println("Buscando persona con id: " + id);
		Persona p = daoPersona.get(id);
		return p;	
	}
	
	@GET
	@Path("buscar")
	@Produces({"application/json"})
	public List<Persona> getPersonaQuery(@QueryParam("nombre") String nombre) {
		System.out.println("Buscando persona con nombre " + nombre);
		return daoPersona.getByName(nombre);	
	}

	@POST
	@Consumes({"application/json"})
	@Produces({"application/json","application/xml"})
	public Persona altaPersona(Persona p) {
		System.out.println(p);	
		daoPersona.add(p);
		return p;	
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
	public Persona modificarPersona(@PathParam("id") int id, Persona p) {
		System.out.println("ID a modificar: " + id);
		System.out.println("Datos a modificar: " + p);
		p.setId(id);
		p = daoPersona.update(p);
		return p;	
	}		

}
