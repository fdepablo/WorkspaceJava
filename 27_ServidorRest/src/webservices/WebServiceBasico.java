package webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import entidad.Mensaje;

/*
 *  La anotación @Path indica la ruta que debe seguir el usuario 
 *  para acceder al servicio web (una vez haya entrado en nuestro servlet jersey,
 *  ver el fichero web.xml).
 *  Este seria el recurso al que queremos acceder
 */
@Path("mensaje")
public class WebServiceBasico {
	/*
	 * La anotación @GET indica el método HTTP que se utilizará para recibir 
	 * peticiones. 
	 * El método mostrarMensaje atenderá peticiones de clientes de tipo GET, 
	 * y también podemos utilizar @POST para atender peticiones de tipo POST.
	 * 
	 * La anotación @Produces indica el tipo MIME de la respuesta del servidor.
	 * 
	 * Para acceder a este metodo la URL a poner en el navegador seria la siguiente:
	 * localhost:8080/27_ServidorRest/rest/mensaje
	 */
	@GET
	@Produces({"text/plain"})//MIME TYPE
	public String mostrarMensaje() {
		Mensaje msg = new Mensaje("Hola amigo");
		return msg.getTexto();
	}
	
	
	//este metodo no será usado para mapear nada ya que no tiene ninguna anotación
	public void miMetodo() {
		
	}
}
