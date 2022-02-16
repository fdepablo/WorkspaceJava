package es.rest.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.rest.modelo.entidad.Persona;

public interface DaoPersona extends JpaRepository<Persona, Integer>{

	public List<Persona> findByNombre(String nombre);
}
