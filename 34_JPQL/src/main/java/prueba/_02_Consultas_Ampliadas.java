package prueba;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import modelo.entidad.Cliente;
import modelo.entidad.Direccion;

public class _02_Consultas_Ampliadas {

	public static EntityManagerFactory emf = null;

	public static EntityManager em = null;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		emf = Persistence.createEntityManagerFactory("PruebaJPARelaciones");
		
		iniciarBBDD();
		
		em = emf.createEntityManager();

		// Listamos todos los clientes
		// Notese que NO se pone la tabla "clientes" sino la entidad
		// Cliente
		System.out.println("===================================");
		//Con query podemos crear querys JPQL genericas
		Query query = em.createQuery("Select c from Cliente c");
		List<Cliente> list = query.getResultList();
		System.out.println("==== listado de clientes ====");
		listarClientes(list);
		
		System.out.println("===================================");
		query = em.createQuery("SELECT cli FROM Cliente cli WHERE cli.nombre LIKE '%Burns%'");
		list = query.getResultList();
		System.out.println("==== listado de clientes burns====");
		listarClientes(list);
		
		System.out.println("===================================");
		query = em.createQuery("SELECT cli.nombre FROM Cliente cli WHERE cli.nombre LIKE '%Burns%'");
		List<String> listaNombres = query.getResultList();
		System.out.println("==== listado de nombres burns====");
		System.out.println(listaNombres);
		
		System.out.println("===================================");
		query = em.createQuery("SELECT cli.nombre, cli.telefono FROM Cliente cli WHERE cli.nombre LIKE '%Burns%'");
		List<Object[]> resultados = query.getResultList();
		System.out.println("==== listado de nombres y telefonos burns====");
		for (Object[] p : resultados) {
			System.out.println(p[0] + " - " + p[1]);//la posicion 0 tiene el nombre y la 1 el telefono
		}
		
		//Desde aquí es lo que se ha agregado los nuevos ejemplos respecto al 01_Consultas
		System.out.println("===================================");
		query = em.createQuery("SELECT cli FROM Cliente cli WHERE cli.telefono = 555");
		list = query.getResultList();
		System.out.println("==== listado de clientes con telefono 555====");
		listarClientes(list);
				
		System.out.println("===================================");
		query = em.createQuery("SELECT cli FROM Cliente cli");
		query.setFirstResult(0);//ojo, el id 1 es el primero
		query.setMaxResults(3);//ojo, el máximo numero de resultados
		list = query.getResultList();
		System.out.println("==== listado de clientes con paginación del 0 y maximo 2 ====");
		listarClientes(list);
		
		System.out.println("===================================");
		//Esto es un ejemplo de inyección SQL, jamas se debe de concatenar un valor
		//variable a una consulta SQL o JPQL
		//El siguiente ejemplo esta MUY MAL. 
		String cadena = "555";
		query = em.createQuery("SELECT cli FROM Cliente cli WHERE cli.telefono = " + cadena);
		Cliente clienteBurns = (Cliente)query.getSingleResult();//SOLO si da un único resultado
		System.out.println("==== Cliente con telefono 555 ====");
		System.out.println("Cliente-> nombre: " + clienteBurns.getNombre() + "; Telefono: " + clienteBurns.getTelefono());
		
		//La manera de usar datos introducidos por el cliente, siempre debe ser de manera
		//parametrizada.
		//Parametrizando datos de entrado podemos evitar inyecciones SQL
		System.out.println("===================================");
		cadena = "555";
		query = em.createQuery("SELECT cli FROM Cliente cli WHERE cli.telefono = :telefono");
		query.setParameter("telefono", cadena);
		clienteBurns = (Cliente)query.getSingleResult();//SOLO si da un único resultado
		System.out.println("==== Cliente con telefono 555 PARAMETRIZADO ====");
		System.out.println("Cliente-> nombre: " + clienteBurns.getNombre() + "; Telefono: " + clienteBurns.getTelefono());
		
		System.out.println("===================================");
		//Con TypedQuery podemos crear queries con valores genericos
		//o parametrizados
		TypedQuery<Long> queryTyped = em.createQuery("SELECT count(c) FROM Cliente c", Long.class);
		//Con getSingleResult() solo nos devuelve un resultado
		//Ojo, solo usar si sabes que te va a devolver un único resultado
		Long numeroClientes = queryTyped.getSingleResult();
		System.out.println("Numero de clientes: " + numeroClientes);
		
		System.out.println("===================================");
		
		em.close();
		emf.close();
	}

	/**
	 * Metodo que inicia los datos de la bbdd
	 */
	private static void iniciarBBDD() {

		Cliente c = new Cliente(null, "Montgomery Burns", "555", null);
		c.setFechaNacimiento(new Date());// fecha de hoy
		Direccion d = new Direccion();
		d.setTipoVia("Calle");
		d.setNombreVia("Portugalete");
		d.setCiudad("Madrid");

		c.setDireccion(d);

		System.out.println("==============================================");
		em = emf.createEntityManager();
		em.getTransaction().begin();

		// salvamos y observamos como la direccion se ha guardado
		// dentro de la tabla clientes(ya que direccion esta embebida)
		em.persist(c);
		
		c = new Cliente(null, "El hijo de Burns", "666", null);
		em.persist(c);
		
		//Homer, Bart y Lisa se han agregado nuevos
		c = new Cliente(null, "Homer", "777", null);
		em.persist(c);
		
		c = new Cliente(null, "Bart", "888", null);
		em.persist(c);
		
		c = new Cliente(null, "Lisa", "999", null);
		em.persist(c);

		em.getTransaction().commit();
		em.close();
	}
	
	public static void listarClientes(List<Cliente> listaClientes) {
		for(Cliente c : listaClientes) {
			System.out.println("Cliente-> nombre: " + c.getNombre() + "; Telefono: " + c.getTelefono());
		}
	}
}
