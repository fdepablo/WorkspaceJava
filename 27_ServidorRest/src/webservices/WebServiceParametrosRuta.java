package webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import beans.Mensaje;

@Path("mensajeParametros")
public class WebServiceParametrosRuta {
	
	//0
	@GET
	@Path("/path/{nombre}")
	@Produces({"text/html"})
	public String mostrarMensajePath(@PathParam("nombre") String n) {
		Mensaje msg = new Mensaje("Hola " + n);
		String html = "<!DOCTYPE html>";
		html = html + "<html>";
		html = html + "<head>";
		html = html + "<title>Mi primer servicio web REST</title>";
		html = html + "</head>";
		html = html + "<body style='background-color: aqua'>";
		html = html + "<h1>" + msg.getTexto() + "</h1>";
		html = html + "<h2>" + Mensaje.getPeticiones() + "</h2>";
		html = html + "</body>";	
		html = html + "</html>";	
		
		return html;
	}
	
	@GET
	@Path("query")//localhost:8080/27_ServidorRest/rest/mensajeParametros/query?nombre=felix&apellidos=Gomez
	@Produces({"text/html"})
	public String mostrarMensaje(@QueryParam("nombre") String nom, 
			@QueryParam("apellidos") String apellidos) {
		System.out.println("Recibiendo peticion del cliente!!!");
		Mensaje msg = new Mensaje("Hola " + nom + " " + apellidos);
		String html = "<!DOCTYPE html>";
		html = html + "<html>";
		html = html + "<head>";
		html = html + "<title>Mi primer servicio web REST</title>";
		html = html + "</head>";
		html = html + "<body style='background-color: aqua'>";
		html = html + "<h1>" + msg.getTexto() + "</h1>";
		html = html + "<h2>" + Mensaje.getPeticiones() + "</h2>";
		html = html + "</body>";	
		html = html + "</html>";	
		
		return html;
	}
}
