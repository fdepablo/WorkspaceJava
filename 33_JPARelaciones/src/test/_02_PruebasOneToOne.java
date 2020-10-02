package test;

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

		DatosBancarios db = new DatosBancarios(null, "Bankia", 6000, null);
		//le pasamos la referencia al cliente de los datos bancarios
		Cliente c = new Cliente(null, "Hommer", "555", db);
		//Si la relación es bidireccional debemos cruzar las referencias:
		//si no lo hacemos, la columna fk de la tabla de datos bancarios
		//aparecería en null
		db.setCliente(c);
				
		System.out.println("==============================================");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Podemos guardarlos individualmente y en orden
		//o si no existieran los cascades
		//em.persist(c);  //Aqui el cliente no tiene ID 
		//em.persist(db); //Aqui si
		
		//Como hemos definido la relaciï¿½n en las dos clases podriamos, insertando
		//solo un objeto, insertar los dos
		
		em.persist(c); //-> se insertan los DB por el cascade que hay en Cliente
		//este falla ya que no hay cascade en la clase DatosBancarios
		//em.persist(db); //-> se inserta el cliente por el cascade de DatosBancarios
		
		em.getTransaction().commit(); 
		em.close();		
		
		
		//si queremos dar primero un cliente y luego unos datos bancarios
		//primero dariamos de alta el cliente y luego le buscariamos
		//y se lo asociariamos esos datos bancarios
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Cliente c1 = new Cliente(null, "Lisa", "555", null);
		em.persist(c1);
		em.getTransaction().commit(); 
		
		em.getTransaction().begin();
		DatosBancarios db2 = new DatosBancarios(null, "ING", 8008, null);
		c1 = em.find(Cliente.class, 2);
		db2.setCliente(c1);
		em.persist(db2);
		
		em.getTransaction().commit(); 
		em.close();		
		
		//Prueba
		
		//cerramos el entitymanager
		emf.close();			
	}
	
}
