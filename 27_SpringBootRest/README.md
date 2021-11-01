# Spring Boot y Servicios REST

En este proyecto se va a ver como podemos implementar un servicio REST con el Framework de Spring y Spring Boot.

Para entender bien como hacer servicios REST con Spring Boot, primero debemos de conocer el protocolo HTTP y el estilo de arquitectura de REST. REST no es exclusivo de Spring, se pueden implementar REST de muchas maneras, por ejemplo Java proporciona las librerias Jersey para dicha implementación.

## HTTP

HTTP es el protocolo de comunicación que permite las transferencias de información a través de archivos (XHML, HTML . . .) en la World Wide Web. HTTP es posiblemente el protocolo de comunicación más importante de la historia de internet. 

HTTP define la sintaxis y la semántica que utilizan los elementos de software de la arquitectura web (clientes, servidores, proxies) para comunicarse. HTTP es un protocolo sin estado, es decir, no guarda ninguna información sobre conexiones anteriores.
 
REST esta basado en este protocolo por lo que es muy importante entender como funciona HTTP. En la carpeta "img" tenemos las imagenes con teoria sobre el protocolo HTTP.

## REST (REpresentational State Transfer)

REST es un estilo de arquitectura software para sistemas hipermedia distribuidos como la World Wide Web. El término se originó en el año 2000, en una tesis doctoral sobre la web escrita por Roy Fielding, uno de los principales autores de la especificación del protocolo HTTP y ha pasado a ser ampliamente utilizado por la comunidad de desarrollo. 

Para aprender los principios REST nos apoyaremos en el pdf ubicado en "pdf/REST by theSimpsons.pdf"

## Spring

Spring es un framework para el desarrollo de aplicaciones y un contenedor de inversión de control, de código abierto para la plataforma Java.

El corazón de Spring Framework es su contenedor de <b>inversión de control (IoC)</b>, llamado comunmente contexto de Spring. Su trabajo es instanciar, inicializar y conectar objetos de la aplicación (mediante la inyeccion de dependencias), además de proveer una serie de características adicionales disponibles en Spring a través del tiempo de vida de los objetos.

En una aplicacion Spring, podemos desarrolar todo nuestro codigo sin necesidad de que el programador haga "news" de los objetos, será el contenedor de spring el que haga este trabajo. Nosotros como programadores, programaremos los objetos o las clases pero del control del ciclo de vida de los objetos se encargara Spring. Por defecto, el ciclo de vida de los objetos creados en el contexto de Spring son de alcance "singleton", esto quiere decir que solo habrá una instancia del objeto y que su duracion sera mientras la aplicacion este arrancada.

La <b>inversion de control</b> es un concepto el cual el programador no tiene el control sobre el ciclo de vida del objeto, sino que es otra entidad el que lo tiene (en este caso, Spring)

El lugar donde se van a guardar los objetos es el llamado <b>contexto o contenedor de beans</b>. El contexto suele ser unico para toda la aplicacion.​

Los objetos creados por Spring se denominan objetos gestionados o beans. Estos objetos normalmente son del tipo POJO (Plain Old Java Object), es decir, objeto sencillos que no tienen herencias ni interfaces.

La <b>instanciacion de los objeto</b> corre a cargo de una clase llamada <b>BeanFactory</b>. Cuando nosotros trabajamos con objetos dentro del contexto de Spring, los objetos dejan de ser anonimos y pasan a tener un identificador unico, de tal manera que podemos pedirle al contexto de spring los objetos siempre que queramos. Tenemos 3 maneras de instaciar los beans (objetos) con Spring:

- Mediante anotaciones, una anotación Java es una forma de añadir metadatos (datos que describen datos) al código fuente Java para que esten disponibles en la aplicación en tiempo de ejecución o de compilación. Las anotaciones en java empiezan por "@". Esta es la manera en la que esta hecha esta aplicacon debido a su sencillez.
- Mediante fichero XML. Se necesita un fichero XML donde se pondran las etiquetas para dar de alta dichos beans
- Mediante objetos java. En este caso se configurara una clase para la creacion de los beans. Cada metodo sera un bean creado en el contexto del tipo que devuelva dicho objeto. Los metodos deben de estar anotados con la anotacion "@Bean"
    
Los objetos pueden ser obtenidos por <b>búsqueda de dependencias</b> o por <b>inyección de dependencias</b>. Se pueden usar ambos en una misma aplicacion sin problemas.

1. <b>Búsqueda de dependencias</b>, es un modelo donde se pide al objeto contenedor un objeto con un nombre específico o de un tipo específico, ya que recordemos que los beans en spring no son anonimos como en java.
2. <b>Inyección de dependencias</b>, es un patrón de diseño orientado a objetos, en el que se suministran objetos a una clase en lugar de ser la propia clase la que cree los objetos que necesiten. Nuestras clases no crean los objetos que necesitan, si no que se los suministra o inyectara otra clase 'contenedora. En este caso sera Spring el que cree los objetos y tambien sera Spring quien se encarge de inyectar las dependencias. La inyeccion de dependencias se suele hacer a traves de constructores o propiedades. 

En esta aplicacion, la manera de crear los objetos sera por anotaciones (mediante las anotaciones @Component y @RestController) y la manera de obtener las relaciones de los objetos sera por inyección de dependecias (mediante la anotacion @Autowired)

## Spring Boot

Si bien es cierto que Spring Framework es muy potente, la configuración inicial y la preparación de las aplicaciones para producción son tareas bastante tediosas. Spring Boot simplifica el proceso al máximo gracias a sus dos principales mecanismos:

1. <b>Starters</b> Spring Boot nos proporciona una serie de dependencias, llamadas starters, que podemos añadir a nuestro proyecto dependiendo de lo que necesitemos: crear un controlador REST, acceder a una base de datos usando JDBC, conectar con una cola de mensajes Apache ActiveMQ, etc. Una vez añadimos un starter, éste nos proporciona todas las dependencias que necesitamos, tanto de Spring como de terceros. Además, los starters vienen configurados con valores por defecto, que pretenden minimizar la necesidad de configuración a la hora de desarrollar. Cualquier configuración puede ser modificada de ser necesario: desde el puerto en el que la aplicación escucha peticiones, hasta el banner que sale por consola al arrancar la aplicación.

2. <b>Contenedor de aplicaciones integrado</b> Spring Boot permite compilar nuestras aplicaciones Web como un archivo .jar (pero NO es obligatorio) que podemos ejecutar como una aplicación Java normal (como alternativa a un archivo .war, que desplegaríamos en un servidor de aplicaciones como Tomcat). Esto lo consigue integrando el servidor de aplicaciones en el propio .jar y levantándolo cuando arrancamos la aplicación. De esta forma, podemos distribuir nuestras aplicaciones de una forma mucho más sencilla, al poder configurar el servidor junto con la aplicación. Esto también es muy útil en arquitecturas de microservicios, puesto que permite distribuir nuestras aplicaciones como imágenes Docker que podemos escalar horizontalmente (algo muy complicado con un .war).


## Instalacion de plugins de Spring
Este ejemplo esta hecho con Eclipse, por lo que se necesita tener algun plugin que nos facilite la creacion y el manejo de proyectos Spring. Podemos instalar plugins desde el marketplace de Eclipse.

1. Pulsamos en -> Help | Eclipse Marketplace
2. Buscamos el plugin <b>Spring Tools 4</b> y lo instalamos (o uno superior)
3. Dejamos que se instale y reiniciamos Eclipse.

## Creacion del proyecto REST con Spring Boot

Para crear este proyecto debemos de crear un proyecto spring boot con algunos starters concretos. Hay muchas maneras de crear un proyecto Spring Boot, pero si tenemos instalado el plugin de eclipse podemos hacerlo de la siguiente manera:

1. Pulsamos -> File | new | Spring starter proyect
2. En la opciones debemos de elegir la siguiente configuracion y pulsar next:
    - El nombre del proyecto
    - Elegir la version java que queramos (este caso 11)
    - Si vamos a desplegar el proyecto en un servidor de aplicaciones, debemos de empaquetar el proyecto en formato WAR
    - Podemos cambiar el paquete por defecto (en este caso "serviciorest")
	
4. En la siguiente pantalla debemos de elegir el starter web -> spring web
5. Aceptamos y finalizamos.

Tambien podriamos hacer estos pasos desde la pagina web oficial de creacion de proyectos [Spring IO](https://start.spring.io/) y luego importar el proyecto en eclipse.

Al ser un proyecto web, spring boot automáticamente configura un tomcat donde se desplegará nuestra app.

A partir de aqui debermos de dar de alta las clases que reciban y gestionen peticiones HTTP, en nuestro caso, las daremos de alta en el paquete "serviciorest.controlador"

<b>NOTA IMPORTANTE</b> Para que Spring Boot detecte correctamente todas las anotaciones y de de alta adecuadamente los objetos en el contexto de Spring, todas nuestras clases deben estar en el mismo paquete o en un paquete hijo del paquete raiz de la aplicacion. Se puede seguir este proyecto para ver como estan organizadas las clases con sus paquetes.

## Poner en marcha la aplicacion

Para arrancar una aplicacion Spring Boot debemos ejecutar el método main de la misma. En este caso debemos de ejecutar la clase "serviciorest.Application".

Por defecto una aplicacion REST hecha con Spring Boot arranca en el mismo puerto del Tomcat, el 8080. Si quereis cambiar el puerto por defecto podeis hacerlo en "src/main/resources/applicatioin.properties". En este mismo proyecto hay un ejemplo.

## Visualizacion del ejemplo

Primero ver la clase "serviciorest.controlador.ControladorMensaje" que tiene ejemplos sencillos de uso de un servicio REST.

Segundo ver la clase "serviciorest.controlador.ControladorPersona" que tiene un CRUD completo de la entidad Persona.

## Probar todos los metodos http

Para probar todos los verbos o metoso http necesitamos una app que nos lo permita hacer, podemos utilizar [POSTMAN](https://www.postman.com/downloads/). Se recomienda instalarla para poder hacer toda la funcionalidad de la aplicacion.

## Bibliografia:
1. [Protocolo HTTP Mozilla](https://developer.mozilla.org/es/docs/Web/HTTP/Overview)
2. [Protocolo HTTP Wikipedia](https://es.wikipedia.org/wiki/Protocolo_de_transferencia_de_hipertexto)
3. [Tipos MIME](https://developer.mozilla.org/es/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types)
