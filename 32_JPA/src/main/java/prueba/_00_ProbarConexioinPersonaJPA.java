package prueba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class _00_ProbarConexioinPersonaJPA {
	public static void main(String[] args) {
		//Este ejemplo es para probar la conexion
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("PruebaJPA");
		
		//Para trabajar con la bbdd necesitamos un objeto de JPA (el más importante), que es
		//el Entity Manager. Este objeto nos abrira las conexiones y las transacciones a la BBDD
		//y mientras este vivo, es decir, no lo cerremos, tambien cacheara las consultas que hayamos
		//hecho par evitar volver a lanzar peticioes a la BBDD. 
		
		//Para crear este objeto nos apollaremos en una factoría que me creará el objeto. Dicha factoría
		//está asociada a una unidad de persistencia definida en el fichero META-INF/persistance.xml
		EntityManager em = factoria.createEntityManager();
	}
}
