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
import serviciorest.cliente.servicio.MensajeServicioProxy;
import serviciorest.cliente.servicio.PersonaServicioProxy;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private PersonaServicioProxy psp;
	
	@Autowired
	private MensajeServicioProxy msp;
	
	@Autowired
	private ApplicationContext context;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("****** Arrancando el cliente REST ******");
		System.out.println("****************************************");
		String mensaje = msp.obtener();
		System.out.println("Mensaje: " + mensaje);
				
		System.out.println("*********** ALTA PERSONA ***************");
		Persona persona = new Persona();
		persona.setNombre("Asterix");
		persona.setApellido("El Galo");
		persona.setEdad(35);
		
		Persona pAlta = psp.alta(persona);
		System.out.println("Persona dada de alta " + pAlta);
		
		System.out.println("************ GET PERSONA ***************");
		persona = psp.obtener(5);
		System.out.println("Persona con id 5: " + persona);
		
		System.out.println("********* MODIFICAR PERSONA *************");	
		
		persona.setNombre("Obelix");
		persona.setApellido("El del menhir");
		psp.modificar(persona);
		
		System.out.println("Personsa con id 5 modificada: " + persona);
		System.out.println(persona);
		
		System.out.println("********** BORRAR PERSONAS **************");
		
		psp.borrar(5);
		System.out.println("Persona con id 5 borrada");		
		
		System.out.println("********** LISTAR PERSONAS ***************");
		List<Persona> listaPersonas = psp.listar();
		listaPersonas.forEach((v) -> System.out.println(v));
		
		System.out.println("******* LISTAR PERSONAS POR NOMBRE *******");
		listaPersonas = psp.listar("HARRY");
		listaPersonas.forEach((v) -> System.out.println(v));
		
		System.out.println("******************************************");
		System.out.println("******** Parando el cliente REST *********");	
		pararAplicacion();
	}
	
	public void pararAplicacion() {
		//Esta aplicacion levanta un servidor web, por lo que tenemos que darle 
		//la orden de pararlo cuando acabemos. Para ello usamos el metodo exit, 
		//de la clase SpringApplication, que necesita el contexto de Spring y 
		//un objeto de tipo ExitCodeGenerator. 
		//Podemos usar funciones lambda para simplificar la sentencia
		
		SpringApplication.exit(context, () -> 0);
		
		//Podriamos hacerlo tambien de una manera clasica, es decir, creando
		//clases anonimas a partir de la interfaz. 
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
