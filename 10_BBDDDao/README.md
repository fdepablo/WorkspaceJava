# Configuracion

Para probar este ejemplo mirar el ejemplo anterior "10_BBDD" para configurar la BBDD
Tambien esta preparado para que sea lanzado con una bbdd derby, tanto embebida como
configurada como proceso

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
Dentro de la jdk tenemos una carpeta que se llama db/bin
Con startNetworkServer.bat arrancamos la bbdd
Con ij.bat podemos lanzar las queries y crear los schemas y tablas
(mirar alguna o tutorial de derby, si se quiere hacer así)
