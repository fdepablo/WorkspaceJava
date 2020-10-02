package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.entidad.Cliente;
import modelo.entidad.DatosBancarios;
import modelo.entidad.Pedido;


public class _03_PruebasOneToMany {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("PruebaJPARelaciones");
			
		EntityManager em = null;

		DatosBancarios db = new DatosBancarios(null, "Htb", 7000, null);
		Cliente c = new Cliente(null, "Bender B. Rodriguez", "666", db);
		//Si la relaciï¿½n es bidireccional debemos cruzar las referencias:
		db.setCliente(c);
		//aqui no tenemos el id del cliente
		System.out.println("Id del cliente:"+c.getId());
		
		List<Pedido> pedidos = new ArrayList<>();
		Pedido p1 = new Pedido(null,"PED-1",new Date(),c);
		Pedido p2 = new Pedido(null,"PED-2",new Date(),c);
		Pedido p3 = new Pedido(null,"PED-3",new Date(),c);
		Pedido p4 = new Pedido(null,"PED-4",new Date(),c);
		Pedido p5 = new Pedido(null,"PED-5",new Date(),c);
		pedidos.add(p1);
		pedidos.add(p2);
		pedidos.add(p3);
		pedidos.add(p4);
		pedidos.add(p5);
		//hacemos bidrecionalidad
		c.setPedidos(pedidos);		
		
		System.out.println("==============================================");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Si queremos insertar todos los objetos y NO hay CASCADES hemos
		//de hacerlo por orden
		//em.persist(c);
		//em.persist(p1);
		//em.persist(p2);
		//em.persist(p3);
		//em.persist(p4);
		//em.persist(p5);
		//em.persist(db);

		
		//Como tenemos cascades en los dos extremos da igual el objeto
		//que escojamos para hacer el persist...
		
		em.persist(c); //Se insertan tb los pedidos en una especie de proceso batch
		//em.persist(p2); //tambien funcionaria, de hecho al insertar cliente
		//y detectar que tiene 4 pedidos mas, tambien se insertarian
		
		em.getTransaction().commit(); 
		em.close();		
		
		//observar como JPA actualiza el id de el objeto cliente
		//al persistir el objeto en la bbdd
		System.out.println("Id del cliente:"+c.getId());
		
		
		//Acceso a objetos
		System.out.println("==============================================");
		em = emf.createEntityManager();

		Cliente c2 = em.find(Cliente.class, 1);
		System.out.println(c2.getNombre());
		//TIPOS DE CARGA DE OBJETOS
		//1- CARGA ANSIOSA (EAGER MODE)
		//Tipo de carga la cual al obtener un objeto(s) de bbdd nos trae 
		//tambien sus objetos asociados.
		//Las relaciones onetoone son ansiosas por defecto
		//En este caso, al buscar el objeto Cliente tambien nos ha 
		//traido su objeto DatosBancarios de manera automatica. 
		System.out.println(c2.getDatosBancarios().getBanco());

		//2- CARGA PEREZOSA (LAZY MODE)
		//Cuando SOLO nos traemos el objeto que hemos buscado en la base de datos
		//y NO nos traemos su objeto(s) asociados al mismo.
		//Las relaciones onetomany y manytomany son perezosas por defecto
		//En este caso, al buscar el objeto Cliente NO nos ha traido de manera
		//automatica los objetos Pedido asociados a él.
		//Cuando queramos acceder a los pedidos, será cuando se haga la query
		//En la siguiente linea, al acceder al size() de los pedidos, sera cuando
		//JPA haga la query para traerse los pedidos. Los objetos que tenia antes
		//asociados se llaman objetos proxy
		//System.out.println("Numero de pedidos " + c2.getPedidos().size());
		
		//La carga por defecto de los objetos (LAZY o EAGER) se puede cambiar
		//dento de las etiquetas correspondientes de la clase Cliente, por ejemplo:
		//@OneToOne(mappedBy = "cliente", cascade=CascadeType.ALL,fetch = FetchType.LAZY)
		//@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL, fetch = FetchType.EAGER) 
		
		//Nota para hibernate:
		//tengo que acceder a los pedidos antes de cerrar el entity manager
		//si no, daria error al intentar acceder a los pedidos más adelante.
		//Si se utiliza eclipselink o toplink no haria falta0
		em.close();
		
		for(Pedido pAux: c2.getPedidos()){
			System.out.println(pAux.getCodigo());
		}
		
		emf.close();
	}
}
