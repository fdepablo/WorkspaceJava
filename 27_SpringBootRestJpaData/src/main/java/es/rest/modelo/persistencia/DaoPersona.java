package es.rest.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.rest.modelo.entidad.Persona;

@Repository
public interface DaoPersona extends JpaRepository<Persona, Integer>{

	public List<Persona> findByNombre(String nombre);
}
