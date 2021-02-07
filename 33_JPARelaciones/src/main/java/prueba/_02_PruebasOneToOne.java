package prueba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.entidad.Cliente;
import modelo.entidad.DatosBancarios;

public class _02_PruebasOneToOne {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("PruebaJPARelaciones");
		EntityManager em = null;

		Cliente c = new Cliente(null, "Hommer", "555-1234", null);
		DatosBancarios db = new DatosBancarios(null, "Bankia", 6000, null);
		
		// Si la relación es bidireccional debemos SIEMPRE cruzar las referencias,
		// es decir, que el Cliente apunte a los Datos Bancarios y los datos
		// bancarios apunten al Cliente
		// Si no lo hacemos, la columna de la FK de la tabla de datos bancarios
		// aparecería en null. 
		c.setDatosBancarios(db);
		db.setCliente(c);
				
		System.out.println("==============================================");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Podemos guardarlos individualmente, primero uno
		// Esto funcionaria siempre, sin importar si hemos declarado CASCADES
		//em.persist(c);//guardamos el cliente
		//em.persist(db);//guardamos los datos bancarios del cliente
		
		//Como hemos definido la relación en las dos clases con un CASCADE.ALL,
		//persistiendo el objeto Cliente, se persistirían los dos. Si NO hubiera
		// un CASCADE.ALL o un CASCADE.PERSIST, esta persistencia fallaría.
		em.persist(c); 
		
		// El siguiente "persist" fallaría ya que no hay ningun tipo de
		// CASCADE en la clase DatosBancarios
		//em.persist(db); //-> se insería el cliente SI HUBIERA un cascade en DatosBancarios
		
		em.getTransaction().commit(); 
		em.close();		
				
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Es posible que no siempre podamos dar de alta un cliente y unos datos bancarios
		// (o no nos interese)
		// Si queremos dar primero un cliente y luego unos datos bancarios (en un futuro)
		// primero dariamos de alta el cliente, luego cuando tengamos los datos bancarios,
		// hariamos una busqueda de dicho cliente, le pondriamos los datos bancarios creados, 
		// y por ultimo lo persistiriamos
		
		//Ejemplo:
		//Damos de alta a lisa
		Cliente c1 = new Cliente(null, "Lisa", "555-9988", null);
		em.persist(c1);
		em.getTransaction().commit(); 
		
		//En un futuro lisa me manda los datos bancarios
		//Creamos otra transaccion, simulando que en otro momento del ciclo de vida del programa
		//queremos añadir a lisa unos datos bancarios
		em.getTransaction().begin();
		DatosBancarios db2 = new DatosBancarios(null, "ING", 8008, null);
		
		//Buscamos a lisa en nuestra bbdd
		c1 = em.find(Cliente.class, 2);
		
		//le asignamos a lisa los datos bancarios previamente creados
		db2.setCliente(c1);
		//persistimos
		em.persist(db2);
		
		em.getTransaction().commit(); 
		em.close();				

		//cerramos el entitymanager
		emf.close();			
	}
	
}
