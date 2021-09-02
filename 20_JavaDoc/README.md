![Javadoc](img/javadoc.png "Javadoc")
# Javadoc

Javadoc es una utilidad de Oracle para la generación de documentación de APIs en formato HTML a partir de código fuente Java. Javadoc es el estándar de la industria para documentar clases de Java. La mayoría de los IDEs los generan automáticamente.


## Objetivos

El objetivo de Javadoc es el de proporcionar informacion a otro desarrolladores de como tienen que utilizar nuestros clases y metodos. Esta documentacion no es para nosotros (que tambien) es principalmente para los programadores que usen nuestro codigo.

Es fundamental entender que con la documentación queremos dar a conocer la función que realizan nuestras clases y metodos sin necesidad de meternos en el codigo fuente de las clases para entender lo que hace.

No confundir Javadoc con los comentarios normales de java, que estos empiezan por /* y suelen ir dentro de los métodos para explicar el código. 

Es muy importante entender la diferencia entre los comentarios normales y Javadoc. El objetivo de los comentarios normales es explicar lineas de código a programadores que se meten a ver el código fuente, el objetivo de Javadoc es explicar a otros programadores como deben de usar las clases y los métodos que hemos realizado, sin necesidad de ver el codigo fuente ni de entenderlo.

En el siguiente enlace podemos ver un ejemplo resultante de una documentacion hecha para la clase [String](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html). En esta documentación, realizada con Javadoc por la gente de Oracle, podemos ver como se nos explica perfectamente toda la clase String y todos los métodos que tiene. Este sería nuestro objetivo cuando realizamos Javadoc en nuestras clases.

A su vez, la documentación esta muy ligada con las pruebas unitarias, hasta tal punto de que si la documentación esta bien hecha, podemos hacer las pruebas unitarias sin necesidad de entender el código.

Una buena practica sería documentar el código antes de implementarlo.

## Creacion de Javadoc

El Javadoc se crea dentro de las clases de java y tendrá la siguiente forma:

	/** 
	* DOCUMENTACION
	*
	* ANOTACIONES 
	*/ 
    
	Notese que Javadoc empieza con "/**", es decir, una barra y dos asteriscos. El cierre de Javadoc es con "*/"

El Javadoc <b>DEBERA IR</b> al principio de cada clase, atributo, constructor o método, dependiendo de qué parte se quiera documentar.


## Anotaciones Javadoc

Para generar API con Javadoc podemos usar ciertas palabras reservadas precedidas por el carácter "@" que son llamadas <b>anotaciones</b>. El objetivo de las anotaciones es la de enriquecer la documentación y de organizarla de una manera estandar. Cada anotación representa un valor diferente y tenemos distinto tipos.

Veamos las principales anotaciones que existen:

<table style="border: 1px solid">
 	<tr><th>ANOTACION</th><th style="text-align:left">DESCRIPCION</th></tr>
 	<tr><td style="font-weight:bold">@author</td><td>Nombre del desarrollador</td></tr>
	<tr><td style="font-weight:bold">@version</td><td>Versión del método o clase</td></tr>
	<tr><td style="font-weight:bold">@param</td><td>Definición de un parámetro de un método, es requerido para todos los parámetros del método</td></tr>
	<tr><td style="font-weight:bold">@return</td><td>Informa de lo que devuelve el método, no se puede usar en constructores o métodos "void"</td></tr>
	<tr><td style="font-weight:bold">@throws</td><td>Excepción lanzada por el método, primero la clase y luego la explicación</td></tr>
	<tr><td style="font-weight:bold">@see</td><td>Asocia con un elemento externo como un método, una clase o cualquier recurso en la red. Varias maneras de hacer referencia -> #método(); clase#método(); paquete.clase; paquete.clase#método(). Tambien podemos usar la anotacion @link (ver más abajo)</td></tr>
	<tr><td style="font-weight:bold">@since</td><td>Usado principalmente en metodos. Nos dice desde que versión de la clase se encuentra el metodo en dicha clase</td></tr>
	<tr><td style="font-weight:bold">@link</td><td>Para crear un hipervinculo sobre un texto dentro del mismo programa. Si queremos usar hiperviculos externos podemos usar la etiqueta A de HTML.</td></tr>
	<tr><td style="font-weight:bold">@deprecated</td><td>Indica que el método o clase es antigua y que no se recomienda su uso porque posiblemente desaparecerá en versiones posteriores</td></tr>
</table>

Estas anotaciones se escriben dentro del Javadoc, Ej:

    /**
    *
    * @author Steven Grant Rogers
    *
    */


## Enriquecer el Javadoc con HTML

Dento de un comentario de Javadoc, se pueden poner etiquetas HTML para enriquecer el formato. Javadoc acepta la mayoría de ellas.

    /**
    * El objetivo de esta clase es proporcionar una <b>comunicación con una impresora</b>
    *
    * @author Steven Grant Rogers
    *
    */

## Documentación de una clase

El objetivo de documentar una clase es informar de la funcionalidad y la finalidad de dicha clase.

Son importantes anotaciones como <b>@author o @version</b>.

Primero habría que documentar la clase y luego poner las anotaciones que estimemos oportunas.

    /**
    * El objetivo de esta clase es proporcionar una <b>comunicación con una impresora</b>
    *
    * Tendrá diferentes métodos para realizar acciones con la impresora, tales como
    * <u>imprimir, scanear o fotocopiar</u>.
       
    * @author Steven Grant Rogers
    * @version 1.0
    *
    */
    public class GestionImpresora {
    
    
    }

Notese como la documentación esta justo arriba de la clase que queremos documentar

## Documentación de atributos

El objetivo de documentar atibutos es la de informar de lo que representa el atributo. Se puede añadir posibles valores, unidades, etc.

Para cada uno de los atributos, primero habría que documentar el atributo y luego poner las anotaciones que estimemos oportunas.

## Documentación de un método

Documentar métodos es de las partes más importantes de Javadoc, y el objetivo es el de explicar perfectamente lo que hace el método, con todas sus casuisticas posibles o resultados.

Son muy importantes las anotaciones <b>@param</b> para cada uno de sus parámetros o <b>@return</b> para explicar los posibles valores que devuelve. Puede haber varios <b>@param</b> (uno para cada parámetro de entrada), pero como máximo habrá UN SOLO <b>@return</b> (y no lo habrá en caso de que el método devuelva <b>void</b>).

Primero habría que documentar el metodo y luego poner las anotaciones que estimemos oportunas.

	 /**
	  * Método que establece el valor al atributo titulo. El titulo pasado por parametro no pude 
	  * ser nulo ni estar vacio. En caso de que sea nulo o vacio el método arrojara una excepción.
	  *
	  * @param titulo El nuevo título que queremos establecer
	  * @throws IllegalArgumentException Si titulo es <b>null</b>, está vacío o contiene sólo espacios.s	
	  */
	 public void setTitulo (String titulo) throws IllegalArgumentException
	 {
	   if (titulo == null || titulo.trim().equals(""))
	   {
	       throw new IllegalArgumentException("El título no puede ser nulo o vacío");
	   }
	   else
	   {
	       this.titulo = titulo;
	   }
	 }

Notese que solo ponemos un <b<@param</b> porque solo hay un parámetro de entrada y no ponemos <b>@return</b> porque el metodo es void y no retorna nada. También observamos como la documentación esta justo encima del método que queremos documentar.

<b>IMPORTANTE!</b> Los setter y los getter normalmente NO se comentan. Solo se comentan en caso de que hagan alguna funcionalidad diferente a lo que hace por defecto (asingar o devolver valores de atributos). Un ejemplo podría ser el metodo anterior <b>setTitulo</b>, normalmente no se documentaría, pero en este caso SI que sería obligatorio hacerlo ya que hace una funcionalidad diferente al setTitulo por defecto que nos crearia un IDE como eclipse.

## Documentación de constructores

Los constructores tambien se pueden documentar. Siguen las mismas reglas que los métodos pero teniendo en cuenta que no se puede poner la anotación <b>@return</b> ya que los constructores no devuelven nada. 

## Generar ficheros de documentación de manera automática (HTML)

Una vez aplicado el javadoc sobre el codigo, podemos generar documentos html de manera automática con toda la información que hemos puesto sobre dicho codigo. La documentación quedará como la documentación oficial de Oracle, [documentacion oficial String](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html) 

Para hacerlo con eclipse debemos de realizar los siguientes casos.

1. Ir a la siguiente pestaña de eclipse: Proyect -> Generate JavaDoc
	
2. Elegiremos el proyecto el cual queremos generar su documentación. Nos dan muchas opciones de creación de javadoc, normalmente con elegir las opciones por defecto son suficientes.

3. Si nos da un error de tipo "javadoc command does not exist" debemos de buscar en dicha pantalla la ruta del ejecutable para que nos genere la documentación. El ejecutable que podemos escoger por defecto seria "javadoc.exe" que se encuentra donde tengamos instalado nuesta jdk de java. Un ejemplo de la ruta por defecto podría ser -> C:\Program Files\Java\jdk-11.0.11\bin

## Como ver los ejemplos

1. Ver la clase <b>basico/ClaseJavaDoc</b> para ejemplos teoricos de como hacer documentación

2. En la clase <b>basico/MainJavaDoc</b> hay ejemplos de como usar la clase anterior y como podemos ver el javadoc hecho poniendo el cursor encima de la clase o los métodos

3. En el paquete <b>entidad</b> hay ejemplos más practicos de como hacer documentación

## Bibliografía

[https://es.wikipedia.org/wiki/Javadoc](https://es.wikipedia.org/wiki/Javadoc)

[https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html](https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html)

[https://www.markdownguide.org/extended-syntax/#tables](https://www.markdownguide.org/extended-syntax/#tables)
