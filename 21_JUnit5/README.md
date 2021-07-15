![Junit5](img/junit5.png "Junit5")

# JUnit

Para alcanzar los resultados deseados de forma rápida se requiere un framework de prueba. JUnit es un framework bastante bueno para realizar y automatizar estas pruebas en Java.

Una prueba unitaria se caracteriza por realizar una comparación del resultado esperado de un método con lo retornado por la codificación de dicho método.  

Esta comparación puede ser con cualquier tipo de dato o conjunto de datos, ya sean numéricos, textos, booleanos o incluso una excepción de programación esperada. 

El único requisito para que una prueba unitaria resulte efectiva es que tenga únicamente dos posibilidades de resolución (correcta/incorrecta). 

Con las pruebas unitarias podemos comparar el resultado aislado de un método, como el cálculo de una fórmula matemática que nos retorne un único dato estático. Pero también podemos realizar pruebas enviando una serie de datos parametrizados, sometiendo al método a realizar operaciones con diferentes rangos y así comprobar su correcto funcionamiento en diferentes situaciones.

Con las pruebas unitarias se busca tambien dar un porcentaje de cobertura a tu código, es decir, por cuantas lineas del total del lineas que tiene tu programa son capaces de pasar tus pruebas. Un 100% sería el caso, pero muchas veces es dificil de conseguir, entre un 70% y un 90% suele ser lo normal.


## Caracteristicas

   1. JUnit es un framework de código abierto que se utiliza para escribir y ejecutar pruebas.

   2. Proporciona anotaciones para identificar los métodos de ensayo o test.

   3. Proporciona aserciones para resultados esperados del análisis.

   4. Proporciona clases para la ejecución de pruebas o ejecutores de pruebas.

## Instalación

JUnit5 no viene incluido en Java 11 por lo que hay que add las librerías al classpath.

Ademas JUnit 5 esta fragmentado en 3 proyectos, pero nosotros nos centraremos en <b>JUnit Jupiter</b>.

Los otros dos serían <b>Junit vintage</b> con las caracteristicas de JUnit4, y el otro <b>Junit platform</b> que es para pruebas con la JVM)

## Para crear un modulo JUnit5 en eclipse:

   1. Crear una carpeta al mismo nivel que src (test)
   2. Add esa carpeta al classpath del proyecto
       - Botón derecho sobre la carpeta que hemos creado (test) -> build path -> configure build path
       - Pulsamos en la pestaña source y dentro de ahi -> add Folder -> add carpeta test -> pulsamos OK
     
   3. boton derecho sobre la carpeta (test) -> new -> JUnit Test Case -> new JUnit Jupiter test. Es mejor crear primero un paquete antes de hacer este paso, y luego hacerlo sobre dicho paquete.
   4. Dentro de la ventana rellenamos el nombre del paquete (juni5) y el nombre de la clase (_00_Anotaciones)
   5. Si no tenemos JUnit5 add al proyecto, Eclipse nos preguntará para añadir el framework de JUNIT5. Decid que sí :)
   6. Podemos observar como se ha creado una libreria en nuestro proyecto con el nombre de JUNIT 5

## Pasos para ver los ejemplos

Dentro la carpeta test/junit estan los primero ejemplos 

##Bibliografía

[https://junit.org/junit5/](https://junit.org/junit5/)