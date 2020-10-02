XPath (XML Path Language): 
Permite filtrar la información contenida en un documento XML.

En eclise hay una vista sobre la que podemos ejecutar xpath
windows -> show view -> other -> XML -> xpath

////////////////////////////////////////////////////
//Expresiones XPath
////////////////////////////////////////////////////
//Rutas a elementos

1- Absoluta: 

'/raiz/elemento1/elemento2' 
devuelve todos los nodos 'elemento2' contenidos en 'raiz/elemento1'

2- Relativa:

'elemento2' 
devuelve todos los nodos 'elemento2' desde el nodo que nos encontremos
'elemento1/elemento2' 
nodos 'elemento2' que sean hijos de 'elemento1' desde el nodo que nos encontremos

3- En todo el documento

Si la expresión comienza por '//' se trata de una busqueda en cualquier lugar del
documento
'//elemento2' 
devuelve todos los nodos 'elemento2' se encuentren donde se encuentren en el documento
'//elemento1/elemento2' 
nodos 'elemento2' que sean hijos de 'elemento1' estén donde estén los nodos 'elemento2'

Indicando el comienzo de la ruta y el final, quedando la parte intermedia variable

'/raiz/elemento1//elemento3' devuelve los nodos 'elemento3' que sean sucesores de 'raiz/elemento1'

Seleccionando nodos de texto:

'//elemento1/text()'

Seleccionando atributos:
	Se utiliza '@'

'//@id' atributos 'id' de cualquier elemento


////////////////////////////////////////////////////
//Predicados

'/raiz/elemento1[1]' primer elemento 'elemento1' que sea hijo de 'raiz' 
'/raiz/elemento1[1]/elemento2' 'elemento2' del primer 'elemento1' de 'raiz'

'/elemento1/elemento2[last()]' el último
'/elemento1/elemento2[last()-1]' el penúltimo
'/elemento1/elemento2[position()<3]' los dos primeros (el primero es el 1)
'//elemento1[@atributo]' aquellos 'elemento1' que tienen el atributo indicado
'//elemento1[@atributo='XXX']' aquellos 'elemento1' que tienen el atributo indicado con valor XXX
'/elemento1/elemento2[elemento3>35.00]' aquellos 'elemento2' que contienen un 'elemento3' de valor superior a 35
'/elemento1/elemento2[elemento3>35.00]/elemento4' 

////////////////////////////////////////////////////
//Seleccionando nodos desconocidos

'//elemento1/*' Todos los hijos de 'elemento1'

////////////////////////////////////////////////////
//Seleccionando varias rutas

'//elemento1/elemento2 | //elemento3/elemento4'

////////////////////////////////////////////////////
//Operadores

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

