
Este ejemplo esta hecho para que funcione en MySQL
con el jar mysql-connector-java-5.1.2.jar
Si queremos que funcione en otra bbdd deberiamos de cambiar
el driver (en lib hay dos drivers, el de mysql y el de derby)

Podemos crear la tabla de personas con la siguiente sql

CREATE TABLE `personas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `peso` double DEFAULT NULL,
  PRIMARY KEY (`id`)
);

Tambien podemos crearla normalmente con un editor de bbdd (phpadmin o workbench)

//Derby embebida
Por ejemplo para funcionar en una derby embebida deberemos
de tener el jar derby.jar

Tenemos implementado ya una clase con la derby, en negocio
podemos cambiar de una implementacion a otra (derby-Mysql)
Si creamos la BBDD embebida deberemos de refrescar para ver
los cambios

Para explorarla
https://cwiki.apache.org/confluence/display/OFBIZ/Browsing+Derby+Database+in+Eclipse
Basicamente:
1- Abrir una perspectiva de desarrollo de base de datos
2- configurar una conexion
3- Para configurarla correctamente hay que decir donde esta el derby.jar
y ademas donde esta la base de datos (dentro del workspace)

//Si no usamos una derby embebida
Debemos de usar DerbyCliente.jar en vez de Derby.jar
Dentro de la jdk tenemos una carpeta que se llama db/bin
con startNetworkServer.bat arrancamos la bd
con ij.bat podemos lanzar las queries y crear los schemas y tablas
(mirar alguna ayuda si se quiere hacer así)