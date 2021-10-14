# INSTRUCCIONES PARA ARRANCAR ESTE PROYECTO

1. Copiar este proyecto en el workspace
2. Importar el proyecto a tu workspace como maven proyect, para ello:
    - File -> import -> Existing Maven Proyect -> seleccionar este proyecto de la lista
3. Para arrancar el proyecto 
    - acceder a "src/main/java/serviciorest"
    - ejecutar Application.java, boton derecho -> rus as -> Java Application
4. Probar mediante un explorador web o una app como el POSTMAN que se pueden acceder a las URLs de nuestros servicios web
5. Si se quisieran hacer más servicios rest o cambiar los que tenemos, deberemos de añadir o cambiar dichos servicios en "src/main/java/serviciorest/JerseyConfig.java"
6. Si queremos cambiar la raiz de nuestra URL para acceder a nuestros servicios rest,
deberemos de hacerlo en "src/main/resources/application.properties" dentro de la propiedad
"spring.jersey.application-path="
 
# INSTRUCCIONES PARA ARRANCAR DE CERO UN PROYECTO SPRING BOOT

Para hacer un proyecto Spring boot, primero de todo tenemos que tener algún plug-in de
spring del marketplace (algún plugin llamado "Spring Tools")

Una vez instalado el plugin realizar los siguientes pasos

1. boton derecho -> new -> Spring Starter Proyect
2. Elegir nombre del proyecto
3. Elegir la version de java
4. Cambiar el nombre del paquete incial(opcional)
5. Hacer Next y elegir los starter que queramos, en este caso hemos elegido JERSEY

# Estructura de un proyecto Spring boot con maven

Este proyecto tiene estructura maven, ver el ejemplo 30_Maven para más información.

1. src/main/java -> aqui van todos nuestros fuentes de la aplicacion, es decir, los .java
2. src/main/resources -> aqui van todos nuestro ficheros de recursos de nuestra aplicacion, por ejemplo el context.mxl, banner.txt
    - OJO! En esta carpeta esta el fichero más imporante de una aplicacion Spring Boot que es el "aplication.properties",aqui iria todo el tema de configuración

3. src/test/java -> aqui van todos los fuentes de pruebas de nuestra aplicacion como por ejemplo JUNIT
4. Maven Dependencies -> aqui van todas las dependencias de nuestro proyecto

# Configurar Jersey

Crear la clase JerseyConfig, dentro de esta tenemos que poner la clase que contiene las anotaciones del servicio rest (o todas las clases que queramos)

OJO, todos los paquete deben de tener el paquete "serviciorest" como paquete raiz!

# Bibliografía

https://howtodoinjava.com/spring-boot/spring-boot-jersey-example/
