# Spring Boot y Servicios REST - Lado del cliente

En este proyecto se va a ver como podemos consumir un servicio REST con el Framework de Spring y Spring Boot.

## Configuracion

Para crear este proyecto podemos seguir los mismos pasos que para crear el servicio rest, es decir, habrá que hacer un proyecto web con Spring Boot.

Por otro parte, al ser un proyecto web tambien se levantará un Tomcat, por lo que los puertos del Tomcat cliente y el Tomcat servidor deben de ser diferentes. En este caso en el fichero "src/main/resources/application.properties" hemos configurado el puerto 8081 ya que el puerto del servidor es el 8080.

## Visualizacion del ejemplo

Primero ver la clase "serviciorest.cliente.servicio.ServicioProxyMensaje" que es mas sencillo y consumimos el servicio REST de mensajes.

Segundo ver la clase "serviciorest.cliente.servicio.ServicioProxyPersona" que hacemos el CRUD contra el servicio REST de mensajes.

Por ultimo visualizamos la clase "serviciorest.cliente.Application" que lanza tanto las peticiones al webservice de Mensaje como de Persona.

## Arranque del ejemplo

Ejecutando la clase "serviciorest.cliente.Application"

## Bibliografia:
1. [https://spring.io/guides/gs/consuming-rest/](https://spring.io/guides/gs/consuming-rest/)
2. [http://javainsimpleway.com/spring-resttemplate-crud-operations-with-json/](http://javainsimpleway.com/spring-resttemplate-crud-operations-with-json/)
3. [https://www.baeldung.com/spring-rest-template-list](https://www.baeldung.com/spring-rest-template-list)
4. [https://stackoverflow.com/questions/16899179/get-string-response-from-resttemplate-put](https://stackoverflow.com/questions/16899179/get-string-response-from-resttemplate-put)

