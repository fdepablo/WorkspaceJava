# XPath (XML Path Language): 
Permite filtrar la informacion contenida en un documento XML. Sirve para hacer busquedas en un fichero .xml

## Rutas a elementos

El siguiente seria un resumen de las Expresiones XPath mas importantes

### Absoluta: 

	'/raiz/elemento1/elemento2' 
	devuelve todos los nodos 'elemento2' contenidos en 'raiz/elemento1'
	
### Relativa:
Para ello debemos situarnos en un nodo especifico, a partir de ahi, las busquedas serÃ­an relativas a ese nodo

	'elemento2' 
	devuelve todos los nodos 'elemento2' desde el nodo que nos encontremos

	'elemento1/elemento2' 
	nodos 'elemento2' que sean hijos de 'elemento1' desde el nodo que nos encontremos

### Busquedas en todo el documento
Si la expresion comienza por '//' se trata de una busqueda en cualquier lugar del documento

	'//elemento2' 
	devuelve todos los nodos 'elemento2' se encuentren donde se encuentren en el documento
	'//elemento1/elemento2' 
	devuelve nodos 'elemento2' que sean hijos de 'elemento1' este donde este el nodo 'elemento1'

### Indicando el comienzo de la ruta y el final, quedando la parte intermedia variable

	'/raiz/elemento1//elemento3' 
	devuelve los nodos 'elemento3' que sean sucesores de 'raiz/elemento1'

### Seleccionando nodos de texto:

	'//elemento1/text()'
	devuelve todos los nodos texto de los nodos 'elemento1'

### Seleccionando atributos:	
Se utiliza '@' para acceder a los atributos de un nodo

	'/raiz/elemento1/elemento2/@id' 
	devuelve todos los atributos id que esten en /raiz/elemento1/elemento2
	'//@id' 
	devuelve los atributos 'id' de cualquier elemento

## Predicados

Los predicados '[]' son condiciones que le ponemos a las expresiones XPATH para que filtre la busqueda. Algunos ejemplos:

	'/raiz/elemento1[1]' primer elemento 'elemento1' que sea hijo de 'raiz'
	'/raiz/elemento1[1]/elemento2' 'elemento2' del primer 'elemento1' de 'raiz'
	'/elemento1/elemento2[last()]' el ultimo
	'/elemento1/elemento2[last()-1]' el penïultimo
	'/elemento1/elemento2[position()<3]' los dos primeros (el primero es el 1)
	'//elemento1[@atributo]' aquellos 'elemento1' que tienen el atributo indicado
	'//elemento1[@atributo='XXX']' aquellos 'elemento1' que tienen el atributo indicado con valor XXX
	'/elemento1/elemento2[elemento3>35.00]' aquellos 'elemento2' que contienen un 'elemento3' de valor superior a 35
	'/elemento1/elemento2[elemento3>35.00]/elemento4' auqellos elemento4 que esten en elemento1/elemento2/elemento3 y cuyo valor del elemento 3 sea mayor que 35
	'/elemento1/elemento2[elemento3>35.00]'

## Seleccionando nodos desconocidos

	'//elemento1/*' Todos los hijos de 'elemento1'

## Seleccionando varias rutas

	'//elemento1/elemento2 | //elemento3/elemento4'

## Operadores

	|		Computes two node-sets	//book | //cd
	+		Addition	6 + 4
	-		Subtraction	6 - 4
	*		Multiplication	6 * 4
	div		Division	8 div 4
	=	eq	Equal	price=9.80
	!=	ne	Not equal	price!=9.80
	<	lt	Less than	price<9.80
	<=	le	Less than or equal to	price<=9.80
	>	gt	Greater than	price>9.80
	>=	ge	Greater than or equal to	price>=9.80
	or		or	price=9.80 or price=9.70
	and		and	price>9.00 and price<9.90
	mod		Modulus (division remainder)	5 mod 2

## Visualizar este ejemplo 

El fichero "cruceros.xsl" contiene ejemplos de expresiones XPATH sobre el fichero "cruceros.xml". Habria que ejecutarlo en un servidor y verlo mediante un navegador web. Ver el ejempolo 35_XML para mas detalles de la instalacion del servidor y su ejecucion.

Una vez desplegado en un servidor debemos de poner una URL similar a la siguiente http://localhost:PUERTO/36_XPATH/cruceros.xml

## Ejecutar XPATH en ELIPSE

En Eclise hay una vista sobre la que podemos ejecutar xpath
windows -> show view -> other -> XML -> xpath

## Ejecutar XPATH en Visual Studio Code
Necesitamos algun plugin como puede ser:
1. XML Tools
2. XPATH Tools

## Bibliografia
1. https://developer.mozilla.org/es/docs/Web/XPath
2. https://www.w3schools.com/xml/xpath_intro.asp
3. https://www.mclibre.org/consultar/xml/lecciones/xml-xpath.html
