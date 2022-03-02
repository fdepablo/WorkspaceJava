package es.jpadata;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.jpadata.modelo.entidad.Pelicula;
import es.jpadata.modelo.persistencia.DaoPelicula;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	//Esta anotcion busca un objeto de el tipo DaoPelicula dentro
	//del contexto de Spring y si lo encuentra se lo inyecta.
	@Autowired
	private DaoPelicula dao;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Pelicula p = new Pelicula();
		p.setTitulo("Seven");
		p.setFechaAlta(new Date());
		p.setYear(1948);
		p.setDirector("La mujer escarlata");
		p.setGenero("Drama");
		
		dao.save(p);
		System.out.println("Pelicula guardada");
		
		Optional<Pelicula> p2 = dao.findById(1);
		if(p2.isPresent()) {
			System.out.println(p2);
		}else {
			System.out.println("No conseguimos encontrar el objeto");
		}
		
		List<Pelicula> lisPeliculas = dao.findAll();
		for(Pelicula pelicula : lisPeliculas) {
			System.out.println(pelicula);
		}
		
		//Busqueda por titulo
		lisPeliculas = dao.findByTitulo("Seven");
		for(Pelicula pelicula : lisPeliculas) {
			System.out.println(pelicula);
		}
		
	}

}
