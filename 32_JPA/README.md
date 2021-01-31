Aplicacion JPA
-
Este proyecto esta hecho con JPA, EclipseLink y Maven


Configuracion de proyecto con maven
-
Para evitar problemas de dependecias, podemos hacer un proyecto maven y que sea este el que 
nos lleve las dependencias del proyecto

Para ello ver el proyecto 43_Maven

Una vez creado el proyecto maven, debemos de configurar y crear las clases de entidad
y anotarlas adecuadamente (modelo.entidad). En este caso, la clase Persona

Por ultimo debemos de configurar el fichero META-INF/persistence.xml que se encuentra en
src/main/resoruces. Es importante que se encuentre en la carpeta META-INF.

Este fichero va a llevar la configuracion de nuestra BBDD y las clases que van a ser
mapeadas a la bbdd.

Lo mas importante a tener en cuenta:

	1) Decir las clases que vamos a mapear a la bbdd (en este caso la persona)

	2) Configurar la conexión a la bbdd y el schema en la bbdd: Las tablas serían optativas crearlas, ya 	que si no lo hacemos, JPA creara las tablas por nosotros mediante la siguiente propiedad: 
	(<property name="javax.persistence.schema-generation.database.action" value="update"/>)


Bibliografia
-
http://www.java2s.com/Tutorials/Java/JPA/index.htm