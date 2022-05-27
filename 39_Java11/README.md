# Java 11

La version de java 11 trajo algunos cambios importantes:

## Eliminación de paquetes Java EE y CORBA

Java 9 dejo obsoletos muchos modulos de Java EE y CORBA, y en Java 11 fueron eliminados. Los paquetes fueron los siguientes:

- java.xml.ws (JAX-WS)
- java.xml.bind (JAXB)
- java.activation (JAF)
- java.xml.ws.annotation (Common Annotations)
- java.corba (CORBA)
- java.transaction (JTA)
- java.se.ee (Aggregator module for the six modules above)

Además, se eliminaron una sería de herramientas:

- wsgen and wsimport (from jdk.xml.ws)
- schemagen and xjc (from jdk.xml.bind)
- idlj, orbd, servertool, and tnamesrv (from java.corba)

## HTTPClient

Java 11 incluye un cliente HTTP simpre, para hacer peticiones a servicios REST principalmente. Ejemplo de código:

	HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();
            
	HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create("https://httpbin.org/get"))
            .setHeader("User-Agent", "Java 11 HttpClient Bot")
            .build();
            
	HttpResponse<String> response =
      httpClient.send(request, HttpResponse.BodyHandlers.ofString());
	HttpHeaders headers = response.headers();
	
    headers.map().forEach((k, v) -> System.out.println(k + ":" + v));
	System.out.println(response.statusCode());
	System.out.println(response.body());
	
	

## Bibliografia

- <https://www.oracle.com/java/technologies/javase/11-relnote-issues.html>
- <https://www.baeldung.com/java-11-new-features>
- <https://mkyong.com/java/what-is-new-in-java-11/>
- <https://examples.javacodegeeks.com/core-java/java-11-new-features-tutorial/>


