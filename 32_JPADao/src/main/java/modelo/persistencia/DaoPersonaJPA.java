package modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Persona;
import modelo.persistencia.interfaces.DaoPersona;

public class DaoPersonaJPA implements DaoPersona{

	private EntityManager em;
	
	private boolean abrirConexion(){
		try {
			EntityManagerFactory factoria = Persistence.createEntityManagerFactory("PruebaJPA");
			em = factoria.createEntityManager();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean cerrarConexion(){
		try {
			em.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public int insertar(Persona p) {
		if(!abrirConexion()) {
			return 0;
		}
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(p);
		et.commit();
		cerrarConexion();
		//una vez persistido se me actualiza el objeto con su id, y podemos devolverlo
		return p.getId();
	}

	public Persona modificar(Persona p) {
		if(!abrirConexion()) {
			return null;
		}
		//merge sincroninza la bd con el objeto
		//tambien puede servir para dar de alta
		EntityTransaction et = em.getTransaction();
		et.begin();
		p = em.merge(p);
		et.commit();
		cerrarConexion();
		return p;
	}

	public int borrar(int id) {
		if(!abrirConexion()) {
			return 0;
		}
		//JPA solo trabaja con objetos
		//dentro del contexto de persistencia
		//por lo que no vale con borrarlo directamente
		//primero tenemos que meter el objeto en el contexto
		//de persistencia de jpa y luego ya podemos borrarlo
		//ojo! el objeto pasado y el devuelto no son el mismo 
		//objeto, aunque tengan los mismos valores
		Persona pAux = buscar(id);
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(pAux);
		et.commit();
		cerrarConexion();
		return pAux.getId();
	}
	
	public Persona buscar(int id) {
		if(!abrirConexion()) {
			return null;
		}
		return em.find(Persona.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Persona> listar() {
		if(!abrirConexion()) {
			return null;
		}		
		//para hacer la consulta debemos de usar JPQL
		Query query = em.createQuery("select p from Persona p");
		List<Persona> listaPersonas = query.getResultList();
		return listaPersonas;
	}

}