# JPQL

JPQL es un lenguaje intermedio entre POO y SQL, usado normalmente por JPA para hacer consultas
a la BBDD

Tiene el siguiente formato:

	SELECT atributos FROM ClaseEntidad Alias 
		WHERE criterio
		GROUP BY atributos
		HAVING criterio
		ORDER BY atributos
		
Es muy importante tener en cuenta que:

1. Se trabaja con clases, no con tablas.
2. Todos los atributos hacen referencia a las propiedades de las clases, no con los campos de las tablas

## Bibliografía
1. <https://docs.oracle.com/html/E13946_04/ejb3_langref.html>
2. <https://www.tutorialspoint.com/es/jpa/jpa_jpql.htm>
