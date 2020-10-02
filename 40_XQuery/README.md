Habria que tener la bbdd documental BASEX instalada

Debemos poner los ficheros "xml" y "xq" segun el dibujo 
"configuracion_basex.png" (copiarlos en la carpeta y crearlas
si no existen las carpetas)

Luego debemos de cargar las bases de datos:
dentro de basesx -> database -> new y seleccionamos la
base de datos que queramos dentro de la carpeta xml,
almacen.xml por ejemplo (las bbdd son un fichero xml)
(ver crear_database.png)

Una vez hecho esto ya podemos lanzar los ficheros con extensión
.xq sobre el fichero xml.

Para la parte de java, debemos bajarnos las librerias de basex
http://xqj.net/basex/download.jsp

Creamos la carpeta lib y las metemos en el classpath

Para que los ejemplos java funcionen deberemos arrancar la 
bbdd como servicio (ver arrancar_basex.png)


