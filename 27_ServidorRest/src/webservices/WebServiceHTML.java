package webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import entidad.MensajeHTML;

@Path("mensajeHTML")
public class WebServiceHTML {
	
	@GET
	@Produces({"text/html"})
	public String mostrarMensaje() {
		MensajeHTML msg = new MensajeHTML("Hola Amigo");
		String html = "<!DOCTYPE html>";
		html = html + "<html>";
		html = html + "<head>";
		html = html + "<title>Mi primer servicio web REST</title>";
		html = html + "</head>";
		html = html + "<body style='background-color: aqua'>";
		html = html + "<h1>" + msg.getTexto() + "</h1>";
		html = html + "<h2>" + msg.getPeticiones() + "</h2>";
		html = html + "</body>";	
		html = html + "</html>";	
		
		return html;
	}
}
