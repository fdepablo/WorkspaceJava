package prueba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modelo.entidad.Persona;

public class _00_ProbarConexioinPersonaJPA {
	public static void main(String[] args) {
		//Este ejemplo es para probar la conexion
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("PruebaJPA");
		
		//Para trabajar con la bbdd necesitamos un objeto de JPA (el más importante), que es
		//el Entity Manager. Este objeto nos abrira las conexiones y las transacciones a la BBDD
		//y mientras este vivo, es decir, no lo cerremos, tambien cacheara las consultas que hayamos
		//hecho par evitar volver a lanzar peticioes a la BBDD. 
		
		//Para crear este objeto nos apollaremos en una factoria que me creara el objeto. Dicha factoria
		//esta asociada a una unidad de persistencia definida en el fichero META-INF/persistance.xml
		EntityManager em = factoria.createEntityManager();
	}
}
