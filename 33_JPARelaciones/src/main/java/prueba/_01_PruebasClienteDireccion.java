package prueba;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.entidad.Cliente;
import modelo.entidad.Direccion;

//En esta prueba buscamos ver como la direccion que esta embebida en el cliente
//los atributos de dirección van dentro de la clase cliente
public class _01_PruebasClienteDireccion {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("PruebaJPARelaciones");
			
		EntityManager em = null;

		//No pondemos ni el id ni los datos bancarios, el id se autogenera y 
		//los datos bancarios no es objeto de esta prueba
		Cliente c = new Cliente(null, "Montgomery Burns", "555-7654", null);
		c.setFechaNacimiento(new Date());//fecha de hoy
		
		Direccion d = new Direccion();
		d.setTipoVia("Calle");
		d.setNombreVia("Portugalete");
		d.setCiudad("Madrid");
		
		c.setDireccion(d);
		
		System.out.println("==============================================");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Salvamos y observamos como la direccion se ha guardado
		//dentro de la tabla clientes(ya que direccion esta embebida)
		em.persist(c);
		
		em.getTransaction().commit(); 
		em.close();		
		
		emf.close();		
	}
	
	
}
