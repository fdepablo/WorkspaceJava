package test;

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
		
		Cliente c1 = new Cliente(null, "Bud Spencer", "555", null);
		Cliente c2 = new Cliente(null, "Terence Hill", "777", null);
		Cliente c3 = new Cliente(null, "M.A. Baracus", "999", null);

		Comercial co1 = new Comercial(null,"Harry Potter",null);
		Comercial co2 = new Comercial(null,"Ron",null);
		
		//El comercial1 tiene a los cliente 1 y 2
		List<Cliente> clientes1 = new ArrayList<Cliente>();
		clientes1.add(c1);
		clientes1.add(c2);		
		co1.setClientes(clientes1);
		
		//El comercial2 tiene a los clientes 2 y 3
		List<Cliente> clientes2 = new ArrayList<Cliente>();
		clientes2.add(c2);
		clientes2.add(c3);			
		co2.setClientes(clientes2);		
		
		List<Comercial> comerciales1 = new ArrayList<Comercial>();
		comerciales1.add(co1);		
		c1.setComerciales(comerciales1);

		List<Comercial> comerciales2 = new ArrayList<Comercial>();
		comerciales2.add(co1);
		comerciales2.add(co2);		
		c2.setComerciales(comerciales2);
		
		List<Comercial> comerciales3 = new ArrayList<Comercial>();
		comerciales1.add(co2);		
		c3.setComerciales(comerciales3);
				
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(c1);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
			
		
	}
	
}
