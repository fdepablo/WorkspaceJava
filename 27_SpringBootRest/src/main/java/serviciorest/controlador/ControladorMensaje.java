package serviciorest.controlador;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//El objeto creado a partir de esta clase servira como punto de entrada de 
//nuestro servicio REST
//Para dar de alta dicho objeto utilizaremos la anotacion @RestController

//Los metodos anotados seran "endpoints" (puntos de entrada a nuestra aplicacion).
//Estos metodos tendran que ser publicos y estar correctamente anotados

@RestController
public class ControladorMensaje {
		
	//Los metodos de esta clase, gracias a la anotacion @RestController, nos
	//serviran a partir de ahora para recibir peticiones http de nuestros
	//clientes (que pueden ser perfectamente un navegador web). Pero ojo,
	//solamente aquellos metodos que sean publicos y que tambien esten 
	//anotados con el verbo o metodo HTTP con el que lo queremos vincular
	
	//Con la anotacion @GetMapping(value="mensaje"= estamos mapeando el 
	//recurso "mensaje" con el metodo http GET. Tendremos anotaciones
	//para todos los verbos HTTP (@PostMapping, @PutMapping, @DeleteMapping,
	//etc.)
	
	//La url completa sería "http://localhost:8080/mensaje" con el metodo GET
	
	//Si la ponemos en la barra de un navegador nos hara una peticion GET, 
	//ya que por defecto los navegadores hacen una peticion "GET" al recurso 
	//que estamos poniendo en la URL
	@GetMapping(value = "mensaje")
	public String obtenerMensaje() {
		return "Esto es un mensaje de prueba";
	}
	
	//Podemos mapear todos los recursos que queramos con el método http que
	//nos interese (GET, POST, PUT, etc.)
	
	//Dentro de la anotacion tambien podemos poner el parámetro "produces"
	//que le estaremos indicando el "MIME Type" que produciremos.
	
	//Los tipos MIME especifican tipos de datos, como por ejemplo texto plano, 
	//imagen, texto HTML, etc. que los archivos contienen.
	
	//El tipo MIME ira dentro de la cabecera "content-type" de nuestro mensaje
	//HTTP de respuesta. Será labor del cliente interpretar el mensaje a su
	//manera.
	
	//Por ejemplo, si ponemos el "MIME Type" como "text/html" entonces el 
	//navegador leera el body como un HTML, y si ponemos "text/plain" entonces 
	//lo interpretará como un texto plano. La cabecera "content-type" es de
	//las cabeceras mas importantes que hay en HTTP
	@GetMapping(value = "mensajeHTML", produces = MediaType.TEXT_HTML_VALUE)
	public String obtenerMensajeHTML() {
		//Esta clase es muy buena para concatenar Strings
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
