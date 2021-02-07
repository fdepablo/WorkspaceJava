Ejemplo JPA con varias relaciones
-

Ejemplo Maven de JPA con relaciones entre clases

Para que funcionen bien los ejemplos se debe configurar el fichero persistence.xml para que elimine 
y cree las tablas en cada ejecución.

Lo haremos con la siguiente linea para una implementacion de Eclipse Link

<property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>