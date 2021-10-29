package serviciorest.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import serviciorest.cliente.entidad.Persona;
import serviciorest.cliente.servicio.ServicioProxyMensaje;
import serviciorest.cliente.servicio.ServicioProxyPersona;

@SpringBootApplication
public class Application implements CommandLineRunner{

	//Primero inyectaremos todos los objetos que necesitamos para
	//acceder a nuestro ServicioRest, el ServicioProxyPersona y el
	//ServicioProxyMensaje
	@Autowired
	private ServicioProxyPersona spp;
	
	@Autowired
	private ServicioProxyMensaje spm;
	
	//Tambien necesitaremos acceder al contexto de Spring para parar
	//la aplicacion, ya que esta app al ser una aplicacion web se
	//lanzará en un tomcat. De esta manera le decimos a Spring que
	//nos inyecte su propio contexto.
	@Autowired
	private ApplicationContext context;
	
	//En este metodo daremos de alta un objeto de tipo RestTemplate que sera
	//el objeto mas importante de esta aplicacion. Sera usado por los 
	//objetos ServicioProxy para hacer las peticiones HTTP a nuestro
	//servicio REST. Como no podemos anotar la clase RestTemplate porque
	//no la hemos creado nosotros, usaremos la anotacion @Bean para decirle
	//a Spring que ejecute este metodo y meta el objeto devuelto dentro
	//del contexto de Spring con ID "restTemplate" (el nombre del metodo)
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	//Metodo main que lanza la aplicacion
	public static void main(String[] args) {
		System.out.println("Cliente -> Cargando el contexto de Spring");
		SpringApplication.run(Application.class, args);
		System.out.println("Cliente -> Contexto de Spring cargado!");
		
		//Notese que como este metodo es estatico no podemos acceder
		//a los metodos dinamicos de la clase, como el "spp" o "spm"
		//Para solucionar esto, haremos que nuestra clase implemente
		//"CommandLineRunner" e implementaremos el metodo "run"
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("****** Arrancando el cliente REST ******");
		System.out.println("*************  MENSAJE *****************");
		String mensaje = spm.obtener("mensaje");
		System.out.println("run -> Mensaje: " + mensaje);
		
		System.out.println("***********  MENSAJE HTML **************");
		String mensajeHTML = spm.obtener("mensajeHTML");
		System.out.println("run -> Mensaje: " + mensajeHTML);
		
		System.out.println("*********** ALTA PERSONA ***************");
		Persona persona = new Persona();
		persona.setNombre("Asterix");
		persona.setApellido("El Galo");
		persona.setEdad(35);
		
		Persona pAlta = spp.alta(persona);
		System.out.println("run -> Persona dada de alta " + pAlta);
		
		System.out.println("************ GET PERSONA ***************");
		persona = spp.obtener(pAlta.getId());
		System.out.println("run -> Persona con id 5: " + persona);
		
		System.out.println("************ GET PERSONA ERRONEA ***************");
		persona = spp.obtener(20);
		System.out.println("run -> Persona con id 20: " + persona);
		
		System.out.println("********* MODIFICAR PERSONA *************");	
		Persona pModificar = new Persona();
		pModificar.setNombre("Obelix");
		pModificar.setApellido("El del menhir");
		pModificar.setEdad(40);
		boolean modificada = spp.modificar(pModificar);
		System.out.println("run -> persona modificada? " + modificada);
		
		System.out.println("********* MODIFICAR PERSONA ERRONEA*************");			
		pModificar.setNombre("Panoramix");
		pModificar.setApellido("El de la pocion magica");
		pModificar.setId(20);
		modificada = spp.modificar(pModificar);
		System.out.println("run -> persona modificada? " + modificada);
		
		System.out.println("********** BORRAR PERSONAS **************");
		boolean borrada = spp.borrar(pAlta.getId());
		System.out.println("run -> Persona con id 5 borrada? " + borrada);	
		
		System.out.println("******** BORRAR PERSONAS ERRONEA *******");
		borrada = spp.borrar(20);
		System.out.println("run -> Persona con id 20 borrada? " + borrada);		
		
		System.out.println("********** LISTAR PERSONAS ***************");
		List<Persona> listaPersonas = spp.listar(null);
		//Recorremos la lista y la imprimimos con funciones lambda
		//Tambien podriamos haber usado un for-each clasico de java
		listaPersonas.forEach((v) -> System.out.println(v));
		
		System.out.println("******* LISTAR PERSONAS POR NOMBRE *******");
		listaPersonas = spp.listar("HARRY");
		listaPersonas.forEach((v) -> System.out.println(v));
		
		System.out.println("******************************************");		
		System.out.println("******** Parando el cliente REST *********");	
		//Mandamos parar nuestra aplicacion Spring Boot
		pararAplicacion();
	}
	
	public void pararAplicacion() {
		//Esta aplicacion levanta un servidor web, por lo que tenemos que darle 
		//la orden de pararlo cuando acabemos. Para ello usamos el metodo exit, 
		//de la clase SpringApplication, que necesita el contexto de Spring y 
		//un objeto que implemente la interfaz ExitCodeGenerator. 
		//Podemos usar la funcion lambda "() -> 0" para simplificar 
		
		SpringApplication.exit(context, () -> 0);
		
		//Podriamos hacerlo tambien de una manera clasica, es decir, creando
		//la clase anonima a partir de la interfaz. 
		//El codigo de abajo sería equivalente al de arriba
		//(pero mucho más largo)
		/*
		SpringApplication.exit(context, new ExitCodeGenerator() {
			
			@Override
			public int getExitCode() {
				return 0;
			}
		});*/
	}
}
