
1) Para hacer este ejemplo tenemos que crear un proyecto JPA
new -> other -> JPA Proyect
2) Tambien tenemos que elegir que implementacion queremos usar, 
para este ejemplo se uso EclipseLink (ver dibujo eclipselink1 y 2)

CREAR EL PROYECTO DE MANERA ALTERNATIVA
------
Para evitar problemas de dependecias, tambien se metio maven en el proyecto para que 
se bajara automáticamente las librerías de Elcipse Link. 
Si hacemos un proyecto maven podemos evitar hacer el paso 1) y 2)  
Es decir, podemos crear un 
3) new-> Maven Proyect 
y luego en el pom.xml meter las dependencias de elicpse link sacandolas del repositorio central 
maven. 


4) Como vamos a trabajar con mysql, debemos de usar el driver adecuado
y meterlo en el classpath (lib/mysql-connector-java-5.1.2.jar)


Una vez hecho eso debemos de configurar crear las clases de entidad
y anotarlas adecuadamente (modelo.entidad) en este caso, la clase
Persona

Por ultimo debemos de configurar el fichero META-INF/persistence.xml
mediante las pestañas. El source debe de quedar algo así

-----------------------
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1" xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
	<persistence-unit name="PruebaJPA" transaction-type="RESOURCE_LOCAL">
		<class>modelo.entidad.Persona</class>
		<properties>
			<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>
			<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/jpa_basico"/>
			<property name="javax.persistence.jdbc.user" value="root"/>
			<property name="javax.persistence.schema-generation.database.action" value="create"/>
		</properties>
	</persistence-unit>
</persistence>
-------------------------

Lo mas importante a tener en cuenta,
1- Decir queremos usar la class Persona
2- configurar la conexión a la bbdd, para este caso debemos de crear
el schema pero no es necesario crear todas las tablas (aunque tambien
podriamos hacerlo). Con solo el schema es suficiente, si luego le 
decimos a jpa la siguiente opcion
(<property name="javax.persistence.schema-generation.database.action" value="create"/>)
Entonces jpa nos creara todas las tablas si no existieran

Podemos hacerlo mediante las pestañas (ver dibujo jpa_configuracion1)

Las tablas se crearan la primera vez que creemos una query a la bbdd

 TUTORIALES
http://www.java2s.com/Tutorials/Java/JPA/index.htm