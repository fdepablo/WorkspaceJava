package es.jpadata.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.jpadata.modelo.entidad.Pelicula;

/*
 * Para crear un Dao simplemente tenemos que crear una interfaz y extender
 * de la clase JpaRepository. Esta clase esta parametrizada y tenemos que 
 * decir en el primer parametro la entidad con la que vamos a trabajar.
 * En el segundo parametro el tipo de la clave primaria.
 * 
 * Con la anotacion repository estamos dando de alta un objeto de este
 * tipo en el contexto de Spring. Es una anotacion Semantica, es decir, 
 * damos de alta un objeto de este tipo y quiere decir que va a hacer
 * funciones de repositorio o acceso a datos
 */
@Repository
public interface DaoPelicula extends JpaRepository<Pelicula, Integer>{
	//YA ESTAN LOS METODOS DE ACCESO MAS IMPORTANTES
}
