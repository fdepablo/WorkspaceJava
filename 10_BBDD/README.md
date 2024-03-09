# Indicaciones

Para este ejemplo se ha usado una base de datos MySql, concretamente la que viene
incluida en el “all-in-one” del [XAMPP](https://www.apachefriends.org/es/download.html)

Se podría usar cualquier BBDD siempre y cuando se cambie el driver de conexión a dicha BBDD.

El driver de conexión, en nuestro caso "mysql-connector-java-8.0.22.jar", que está en la
carpeta "lib" se debe de añadir al “classpath” del proyecto. Podemos descargarlo también 
del repositorio central de [maven](https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.22)

Para añadir el “jar” a nuestro proyecto debemos de:

1. Pulsar botón derecho sobre el proyecto.

2. Build Path -> Configure Build Path

3. En la pestaña "libraries" pulsar el botón "Add JARs"

4. Buscar la carpeta “lib” de nuestro proyecto y elegir el fichero "mysql-connector-java-8.0.22.jar"

# Configurar la BBDD para los ejemplos del paquete "test"


1. Primero debemos de crear el esquema "bbdd" en nuestro MySQL

2. A continuación, lanzar la siguiente instrucción “sql”

	CREATE TABLE `personas` (
	  `id` int(11) NOT NULL AUTO_INCREMENT,
	  `nombre` varchar(45) DEFAULT NULL,
	  `edad` int(3) DEFAULT NULL,
	  `peso` double DEFAULT NULL,
	  PRIMARY KEY (`id`)
	);

# Configurar la BBDD para el ejemplo del paquete "transacciones"


Podemos lanzar directamente las siguientes instrucciones en nuestra BBDD

	CREATE SCHEMA FERRETERIA;
	USE FERRETERIA;
	
	CREATE TABLE CLIENTE (
		NIF CHAR(9) PRIMARY KEY,
	    	NOMBRE VARCHAR(25) NOT NULL,
	    	DOMICILIO VARCHAR(100),
	    	TLF VARCHAR(25),
	    	CIUDAD VARCHAR(50)
	);
	
	CREATE TABLE PRODUCTO (
		CODIGO CHAR(4) PRIMARY KEY,
	    	DESCRIPCION VARCHAR(100) NOT NULL,
	    	PRECIO FLOAT,
	   		STOCK FLOAT,
	    	MINIMO FLOAT
	);
	
	CREATE TABLE FACTURA (
		NUMERO INT PRIMARY KEY,
	    	FECHA DATE,
	    	PAGADO BOOLEAN,
	    	NIF CHAR(9),
	    	FOREIGN KEY (NIF) REFERENCES CLIENTE(NIF)
	);
	
	CREATE TABLE DETALLE (
		NUMERO INT,
	    	CODIGO CHAR(4),
	    	UNIDADES INT,
	    	PRECIO FLOAT,
	    	FOREIGN KEY (NUMERO) REFERENCES FACTURA(NUMERO),
	   	FOREIGN KEY (CODIGO) REFERENCES PRODUCTO(CODIGO),
	    	PRIMARY KEY (NUMERO, CODIGO)
	);
	
	
	INSERT INTO CLIENTE VALUES 
	('43434343A', 'DELGADO PEREZ MARISA', 'C/ MIRAMAR, 84 3A', '925-200-967', 'TOLEDO');
	
	INSERT INTO CLIENTE VALUES 
	('51592939K', 'LOPEZ VAL SOLEDAD', 'C/ PEZ, 54 4C', '915-829-394', 'MADRID');
	
	INSERT INTO CLIENTE VALUES 
	('51639989K', 'DELGADO ROBLES MIGUEL', 'C/ OCA, 54 5C', '913-859-293', 'MADRID');
	
	INSERT INTO CLIENTE VALUES
	('51664372R', 'GUTIERREZ PEREZ ROSA', 'C/ CASTILLA, 4 4A', '919-592-932', 'MADRID');
	
	
	INSERT INTO PRODUCTO VALUES
	('CAJ1', 'CAJA DE HERRAMIENTAS DE PLASTICO', 8.50, 4.00, 3);
	
	INSERT INTO PRODUCTO VALUES
	('CAJ2', 'CAJA DE HERRAMIENTAS DE METAL', 12.30, 3.00, 2);
	
	INSERT INTO PRODUCTO VALUES
	('MAR1', 'MARTILLO PEQUE�O', 3.50, 5, 10);
	
	INSERT INTO PRODUCTO VALUES
	('MAR2', 'MARTILLO GRANDE', 6.50, 12, 10);
	
	INSERT INTO PRODUCTO VALUES
	('TOR7', 'CAJA DE 100 TORNILLOS DEL 7', 0.80, 20, 100);
	
	INSERT INTO PRODUCTO VALUES
	('TOR9', 'CAJA DE 100 TORNILLOS DEL 9', 0.80, 25, 100);
	
	INSERT INTO PRODUCTO VALUES
	('TUE7', 'CAJA DE 100 TUERCAS DEL 7', 0.50, 40, 100);
	
	INSERT INTO PRODUCTO VALUES
	('TUE9', 'CAJA DE 100 TUERCAS DEL 9', 0.50, 54, 100);
	
	
	INSERT INTO FACTURA VALUES 
	(5440, '2017-09-05', true, '43434343A');
	
	INSERT INTO FACTURA VALUES 
	(5441, '2017-09-05', true, '51639989K');
	
	INSERT INTO FACTURA VALUES 
	(5442, '2017-09-06', false, '43434343A');
	
	INSERT INTO FACTURA VALUES 
	(5443, '2017-10-10', true, '51639989K');
	
	INSERT INTO FACTURA VALUES 
	(5444, '2017-10-13', true, '51664372R');
	
	INSERT INTO FACTURA VALUES 
	(5445, '2017-10-14', false, '43434343A');
	
	
	INSERT INTO DETALLE VALUES (5440, 'CAJ2', 2, 12.3);
	INSERT INTO DETALLE VALUES (5440, 'MAR1', 1, 3.50);
	INSERT INTO DETALLE VALUES (5440, 'TOR7', 2, 0.80);
	INSERT INTO DETALLE VALUES (5440, 'TUE7', 2, 0.50);
	INSERT INTO DETALLE VALUES (5441, 'CAJ1', 1, 8.50);
	INSERT INTO DETALLE VALUES (5442, 'CAJ1', 1, 8.50);
	INSERT INTO DETALLE VALUES (5442, 'MAR1', 2, 3.50);
	INSERT INTO DETALLE VALUES (5443, 'TOR7', 1, 0.80);
	INSERT INTO DETALLE VALUES (5443, 'TUE7', 1, 0.50);
	INSERT INTO DETALLE VALUES (5444, 'MAR2', 1, 12.0);
	INSERT INTO DETALLE VALUES (5445, 'TOR7', 5, 0.80);
	INSERT INTO DETALLE VALUES (5445, 'TOR9', 5, 0.80);
	INSERT INTO DETALLE VALUES (5445, 'TUE7', 5, 0.50);
	INSERT INTO DETALLE VALUES (5445, 'TUE9', 5, 0.50);

