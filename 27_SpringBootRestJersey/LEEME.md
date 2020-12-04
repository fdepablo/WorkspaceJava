 INSTRUCCIONES
---------------
Para hacer un proyecto Spring boot, primero de todo tenemos que tener algún plug-in de
spring del market place (algún "Spring Tools")

A continuación

1) boton derecho -> new -> Spring Starter Proyect

2.1) Elegir nombre del proyecto
2.2) Elegir la version de java
2.3) Cambiar el nombre del paquete incial(opcional)

3) Hacer Next y elegir los starter que queramos, en este caso hemos elegido JERSEY

Estructura de un proyecto Spring boot con maven
------------------------------------------------

1) src/main/java -> aqui van todos nuestros fuentes de la aplicacion, es decir, los .java

2) src/main/resources -> aqui van todos nuestro ficheros de recursos de nuestra aplicacion, por ejemplo el context.mxl, banner.txt

OJO! En esta carpeta esta el fichero más imporante de una aplicacion Spring Boot que es el "aplication.properties",aqui iria todo el tema de configuración

3) src/test/java -> aqui van todos los fuentes de pruebas de nuestra aplicacion como por ejemplo JUNIT

4) Maven Dependencies -> aqui van todas las dependencias de 
nuestro proyecto

 Configurar Jersey
-------------------
Crear la clase JerseyConfig, dentro de esta tenemos que poner la clase que contiene el 
webservice.

OJO, todos los paquete deben de tener el paquete raiz como raiz!

 FUENTES
---------
https://howtodoinjava.com/spring-boot/spring-boot-jersey-example/
