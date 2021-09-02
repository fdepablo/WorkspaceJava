# Instrucciones

1. Para crear este proyecto, hay crear un proyecto web normal, comprueba la siguiente direccion para dudas:
https://www.javanicaragua.org/2019/09/23/crear-aplicacion-web-java-desde-eclipse-ide/

2. A continuacion descargate las librerias de Jersey(jars) :
    - https://eclipse-ee4j.github.io/jersey/

3. Copia las librerías que te has bajado en la carpeta WEB-INF/lib

4. Hay que configurar el web.xml para que puedan funcionar las librerías de jersey,
vete a "WebContent/WEB-INF/lib/web.xml" y copia la parte de dar de alta el servlet
REST a tu proyecto

5. Habria que crear el paquete "webservice" en la carpeta "src" de java y poner ahi dentro todos los servicios REST

Es posible que te falta alguna librería dependiendo de la versión java que estes usando.
Tambien lo que se puede hacer en copiar todas las librerías que hay en el lib de este proyecto
en el lib del proyecto nuevo.

## En caso de que te hayas descargado el proyecto

Si te bajas este proyecto del repositorio y te da problemas, comprueba la siguiente direccion para
arreglarlo:

https://stackoverflow.com/questions/10951306/web-app-libraries-empty-in-eclipse-no-jars-found

Basicamente:
1. Boton derecho sobre el proyecto -> Properties -> Project Facets
2. Seleccionamos
    - Dynamic Web Module
    - Java
3. Aceptamos