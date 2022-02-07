# JPQL
JPQL es un lenguaje intermedio entre POO y SQL, usado por JPA para hacer consultas
a la BBDD

Tiene el siguiente formato:

	SELECT atributos FROM ClaseEntidad Alias 
		WHERE criterio
		GROUP BY atributos
		HAVING criterio
		ORDER BY atributos
		
Es muy importante tener en cuenta que todos los atributos hacen referencia a las propiedades de las clases de entidad.

## Bibliografía
1. <https://docs.oracle.com/html/E13946_04/ejb3_langref.html>
2. <https://www.tutorialspoint.com/es/jpa/jpa_jpql.htm>
