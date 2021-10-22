package serviciorest.controlador;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Esta clase servira como punto de entrada de nuestro servicio REST
//para ello debemos de crear un objeto que sea gestionado por spring
//para que reciba las peticiones

//para dar de alta un objeto utilizaremmos la siguiente anotacion
@RestController
public class ControladorMensaje {
		
	//Los metodos de esta clase, gracias a la anotacion restcontroller, nos
	//serviran a partir de ahora para recibir peticiones http de nuestros
	//clientes (que pueden ser perfectamente un navegador web)
	
	//Con esto lo que estamos haciendo es mapear el recurso "mensaje" con el 
	//metodo http GET. La url completa sería "http://localhost:8080/mensaje"
	//si la ponemos en la barra de un navegador, por defecto los navegadores
	//hacen una peticion "GET" al recurso que estamos poniendo en la URL
	@GetMapping(value = "mensaje")
	public String obtenerMensaje() {
		return "Esto es un mensaje de prueba";
	}
	
	//podemos mapear todos los recursos que queramos con el método http que
	//queramos tambie. Dentro de la etiqueta podemos poner el parámetro "produces"
	//que le estaremos indicando el mime type que tenemos que poner en nuestra
	//cabecera "content-type" de nuestro http response, y que sera leido por nuestro
	//cliente e intrepretado a su manera.
	//si ponemos el mime type como "text/html" entonces el navegador leera el 
	//body como un html, y si ponemos "text/plain" entonces lo interpretará como
	//un texto plano
	@GetMapping(value = "mensajeHTML", produces = MediaType.TEXT_HTML_VALUE)
	public String obtenerMensajeHTML() {
		//esta clase es muy buena para concatenar Strings
		StringBuffer buffer = new StringBuffer();
		buffer.append("<!DOCTYPE html>");
		buffer.append("<html>");
		buffer.append("<head>");
		buffer.append("<title>Prueba html</title>");
		buffer.append("</head>");
		buffer.append("<body>");
		buffer.append("<h1 style='color:red'>ESTO SERIA UN MENSAJE EN HTML</h1>");
		buffer.append("</body>");
		buffer.append("</html>");
		
		return buffer.toString();
	}

}
