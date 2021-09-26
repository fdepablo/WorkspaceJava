package prueba;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.entidad.Persona;

public class _04_ListarPersonaJPA {
	public static void main(String[] args) {
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = factoria.createEntityManager();
		
		//Tenemos que apoyarnos en un lenguaje auxiliar que es JPQL para hacer esta consulta
		//Lo de dentro no es un query al uso, aunque pueda parecerlo, es una sentencia/query JPQL
		//en la cual Persona hacer referencia a la clase y la p seria el alias
		List<Persona> listaPersonas = em.createQuery("from Persona p").getResultList();//select * from personas
		for(Persona p : listaPersonas) {
			System.out.println(p);
		}
		
		em.close();
		System.out.println("Fin de listar personas");
	}
}
