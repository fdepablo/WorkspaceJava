package es.pruebaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import es.pruebaspring.entidad.Persona;

@SpringBootApplication
public class Application {

	public static ApplicationContext context;
	
	public static void main(String[] args) {
		//Aqui estamos creando el contexto de spring
		context = SpringApplication.run(Application.class, args);
		
		//obtenemos el bean con id "persona" que nos viene además
		//con la direccion inyectada
		Persona persona = context.getBean("persona", Persona.class);
		
		persona.setNombre("Steve");
		persona.getDireccion().setNombreVia("Gran via");
		
		System.out.println(persona);
	}

}
