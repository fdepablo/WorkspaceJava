package prueba;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.entidad.Cliente;
import modelo.entidad.Comercial;

public class _04_PruebasManyToMany {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPARelaciones");
				
		//Creamos los objetos
		//Cliente 1
		Cliente bud = new Cliente(null, "Bud Spencer", "555", null);
		//Cliente 2
		Cliente terence = new Cliente(null, "Terence Hill", "777", null);
		//Clliente 3
		Cliente baracus = new Cliente(null, "M.A. Baracus", "999", null);
		
		//Comercial 1
		Comercial harry = new Comercial(null,"Harry Potter",null);
		//Comercial 2
		Comercial ron = new Comercial(null,"Ron",null);
				
		//Asignamos los comerciales a los clientes
		
		//Asignamos al cliente Bud su lista de comerciales
		//El cliente BUD tiene al comercial Harry
		List<Comercial> comercialesBud = new ArrayList<Comercial>();
		comercialesBud.add(harry);		
		bud.setComerciales(comercialesBud);

		//Asignamos al cliente Terence su lista de comerciales
		//El cliente Terence tiene al comercial Harry y al comercial Ron
		List<Comercial> comercialesTerence = new ArrayList<Comercial>();
		comercialesTerence.add(harry);
		comercialesTerence.add(ron);		
		terence.setComerciales(comercialesTerence);
		
		//Asignamos al cliente Baracus su lista de comerciales
		//El cliente Baracus tiene al comercial Ron
		List<Comercial> comercialesBaracus = new ArrayList<Comercial>();
		comercialesBaracus.add(ron);		
		baracus.setComerciales(comercialesBaracus);
				
		//Bidireccion
		//Asignammos comerciales a los clientes
		
		//El comercial Harry tiene a los cliente Bud y Terence
		List<Cliente> clientesHarry = new ArrayList<Cliente>();
		clientesHarry.add(bud);
		clientesHarry.add(terence);		
		harry.setClientes(clientesHarry);
		
		//El comercial Ron tiene a los clientes Terence y Baracus
		List<Cliente> clientesRon = new ArrayList<Cliente>();
		clientesRon.add(terence);
		clientesRon.add(baracus);			
		ron.setClientes(clientesRon);		
		
		//Persistimos los objetos
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Como estan puestos los cascades, al dar de alta un cliente, se dan de alta
		//sus comerciales, y a dar de alta esos comerciales, se dan de alta los clientes
		//Si no hubiera cascades, habría que hacerlo poco a poco como en las relaciones
		//"one to many"
		em.persist(bud);
		
		//Ojo, JPA lanza los insertes NO NECESARIAMENTE en el mismo orden que se crean los
		//objetos de este ejemplo, por lo que los IDs de los clientes pueden variar
		//en la BBDD
		em.getTransaction().commit();
		em.close();
		emf.close();		
	}	
}
