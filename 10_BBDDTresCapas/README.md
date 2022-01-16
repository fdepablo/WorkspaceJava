# Configuracion


Ver el ejemplo 10_BBDD anterior para configurar la BBDD.
Este ejemplo tambien esta preparado para que funcione a traves de una bbdd derby,
pudiendo estar embebida dentro de la applicacion (carpeta bbdd) o arrancada fuera de esta
como un proceso independiente

# Configurar Derby embebida

Por ejemplo para funcionar en una derby embebida deberemos
de tener el jar derby.jar

Tenemos implementado ya una clase con la derby, en negocio
podemos cambiar de una implementacion a otra (derby-Mysql)
Si creamos la BBDD embebida deberemos de refrescar para ver
los cambios

Para explorarla
https://cwiki.apache.org/confluence/display/OFBIZ/Browsing+Derby+Database+in+Eclipse
Basicamente:
1. Abrir una perspectiva de desarrollo de base de datos
2. configurar una conexion
3. Para configurarla correctamente hay que decir donde esta el derby.jar
y ademas donde esta la base de datos (dentro del workspace)

# Configurar Derby NO embebida

Debemos de usar DerbyCliente.jar en vez de Derby.jar
Dentro de la jdk  de javatenemos una carpeta que se llama db/bin
Con startNetworkServer.bat, ejecutamos para arrancar la bbdd
Con el programa ij.bat podemos lanzar las queries y crear los schemas y tablas
(mejor mirar alguna ayuda de derby si se quiere hacer así)