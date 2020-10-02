package webservices;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import beans.Persona;

@Path("personas")
public class WebServicePersonas {
	
	@GET
	@Path("xml/{id}")
	@Produces({"application/xml"})
	public Persona personaXML(@PathParam("id") int id) {
		Persona p = obtenerPersona(id);
		//al retornar la p las librerias jersey lo convierten automaticamente a xml
		return p;	
	}
	
	@GET
	@Path("xml")
	@Produces({"application/xml"})
	public ArrayList<Persona>  listaPersonasXML() {
		ArrayList<Persona> listaPersonas = obtenerPersonas();
		//al retornar la p las librerias jersey lo convierten automaticamente a xml
		return listaPersonas;	
	}
	
	@GET
	@Path("json/{id}")
	@Produces({"application/json"})
	public Persona personaJSON(@PathParam("id") int id) {
		Persona p = obtenerPersona(id);
		//al retornar la p las librerias jersey lo convierten automaticamente a json
		return p;	
	}	

	private Persona obtenerPersona(int id) {
		//esto lo suyo seria hacer una consulta a la base de datos para obtener la persona
		Persona p = new Persona(id,"RODOLFO", "LANGOSTINO", 47);
		return p;
	}
	
	private ArrayList<Persona> obtenerPersonas() {
		//esto lo suyo seria hacer una consulta a la base de datos para obtener la persona
		Persona p1 = new Persona(1,"RODOLFO", "LANGOSTINO", 47);
		Persona p2 = new Persona(1,"HARRY", "POTTER", 47);
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		return listaPersonas;
	}
	
	//Es mas, lo suyo seria lo siguiente
	@GET
	@Path("xml/{id}")
	@Produces({"application/xml"})
	public Persona personaXMLPorId(@PathParam("id") int id) {
		Persona p = obtenerPersonaPorId(id);
		//al retornar la p las librerias jersey lo convierten automaticamente a xml
		return p;	
	}
	
	@GET
	@Path("json/{id}")
	@Produces({"application/json"})
	public Persona personaJSONPorId(@PathParam("id") int id) {
		Persona p = obtenerPersonaPorId(id);
		//al retornar la p las librerias jersey lo convierten automaticamente a json
		return p;	
	}	
	
	private Persona obtenerPersonaPorId(int id) {
		//simulamos acceso a bbdd
		Persona p = new Persona(id,"Bud", "Spencer", 85);
		return p;
	}

	//********************************************************************************
	//Fuera de temario, pero para los más curiosos :)
	@POST
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Persona altaPersona(Persona p) {
		System.out.println(p);	
		//ahora habria que darlo de alta en bbdd
		p.setId(455);
		//devolvemos el objeto a nuestro cliente en formato json
		return p;	
	}	
	
	@DELETE
	@Path("/{id}")
	@Produces({"application/json"})
	public String borrarPersona(@PathParam("id") String id) {
		System.out.println("ID a borrar: " + id);
		//ahora habria que lanzar las queries a bbdd para borrar dicho id
		return id;
	}
	
	@PUT
	@Path("/{id}")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Persona modificarPersona(@PathParam("id") int id, Persona p) {
		System.out.println("ID a modificar: " + id);
		System.out.println("Persona a modificar: " + p);
		p.setId(id);
		//ahora habria que modificarlo en bbdd
		
		//devolvemos el objeto a nuestro cliente en formato json
		return p;	
	}	
}
