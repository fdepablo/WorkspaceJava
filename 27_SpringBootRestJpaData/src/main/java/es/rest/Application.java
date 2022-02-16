package es.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.rest.modelo.entidad.Persona;
import es.rest.modelo.persistencia.DaoPersona;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private DaoPersona daoPersona;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Servicio Rest -> Contexto de Spring cargado!");
	}
		
	@Override
	public void run(String... args) throws Exception {
		
		Persona p1 = new Persona(0,"STEVE", "ROGERS", 39);
		Persona p2 = new Persona(0,"HARRY", "POTTER", 19);
		Persona p3 = new Persona(0,"CHIQUITO", "DE LA CALZADA", 79);
		Persona p4 = new Persona(0,"BUD", "SPENCER", 85);
		Persona p5 = new Persona(0,"HARRY", "CALLAHAN", 87);//ID:4
		
		daoPersona.save(p1);
		daoPersona.save(p2);
		daoPersona.save(p3);
		daoPersona.save(p4);
		daoPersona.save(p5);		
	}
}
