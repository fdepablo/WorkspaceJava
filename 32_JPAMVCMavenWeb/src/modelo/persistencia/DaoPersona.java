package modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Persona;

public class DaoPersona {

	private EntityManager em;
	
	private boolean abrirConexion(){
		try {
			EntityManagerFactory factoria = Persistence.createEntityManagerFactory("32_JPAMVCMavenWeb");
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
	
	/**
	 * metodo que inserta en la bbdd una persona
	 * @param p la persona a insertar
	 * @return 0 en caso de que no haya conexion, el id en caso de que
	 * se haya dado de alta
	 */
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
