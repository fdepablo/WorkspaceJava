# Depuración

La depuración es una herramienta que nos ayuda a los programadores a detectar errores y a ejecutar un programa línea por línea para poder ver los resultados parciales que se van ejecutando en los programas.

Es una herramienta importantísima a la hora de desarrollar software y es usada por los programadores en la mayor parte de la creación de los programas.

## Errores de programación

Las tareas de depuración que implementan los IDE sirven para poder revisar y corregir los fallos lógicos y de otro tipo que tiene el código generado en el desarrollo de software.

Los errores que se producen en el desarrollo de software suelen estar asociados al código fuente y su realización. Existen diferentes categorías para clasificar los errores a la hora de desarrollar software, las más importantes:

1. <b>Momento</b>: Estos errores se clasifican dependiendo del momento en el que se producen. Podemos encontrar dos tipos:

    - <b>Errores en tiempo de compilación</b> Suelen ser errores principalmente de sintaxis, como puede ser no seguir las reglas de Java, y provocan la no compilación del código. Estos errores son fáciles de detectar ya que nos avisa el IDE en cuestión y los podemos solucionar de una manera sencilla. Se llaman en tiempo de compilación porque hacen que el programa no compile (no generó adecuadamente los ficheros con extensión .class)
    - <b>Errores en tiempo de ejecución</b> Suelen ser errores de procesos no validos o lógicos. Estos errores no suelen ser detectados por el IDE, por lo que muchas veces la depuración del código nos va a ayudar a detectarlos. En este caso, el código compila, pero cuando se ejecuta, el comportamiento no es el esperado en algunos o en todos los casos. Un ejemplo podrá ser un error de cuando intentamos dividir un número por cero, en tiempo de compilación no habrá problema, pero cuando ejecutamos el código dará una excepción. 

2. <b>Consecuencia</b>: Estos errores se clasifican dependiendo si la ejecución del programa es suspendida o no. Este tipo de errores no suelen ser detectados por el IDE.

    - <b>Errores que provocan la parada del programa</b>. Este tipo de errores suelen ser debidos a una mala lógica del código, como puede ser mal uso de operadores o bucles infinitos.
    - <b>Errores que NO provocan la parada del programa</b>. Este tipo de errores son más críticos que los anteriores ya que directamente rompen la ejecución del programa. Estos errores lanzan excepciones por lo que podremos capturarlas para evitar la parada del programa en caso de necesidad.

## Funciones de un depurador

Un depurador es el módulo que nos va a permitir trabajar con el código para examinarlo en tiempo de ejecución.

Las funciones generales que esta aplicación debe soportar serían las siguientes:

1. Parar la ejecución del programa en un momento deseado.

2. Ejecutar el código sentencia a sentencia o paso a paso, como es normalmente llamado.

3. Poder examinar el estado de los hilos de ejecución, de las variables y del estado de los objetos.

4. Cambiar los valores de las variables o del estado de los objetos.

5. Saltarse un trozo de código sin tener que revisarlo o continuar la ejecución en una posición diferente de la actual.

## Puntos de ruptura o "breakpoints"

La ejecución del programa principal del proyecto se ejecuta normalmente hasta que el depurador detiene su ejecución, permitiendo al usuario examinar la situación. El depurador se parará en donde el programador haya indicado un punto de parada o ruptura llamado **breakpoint**.

Para poner un "breakpoint" debemos de hacer “doble click” sobre el lateral de la línea donde queremos que se para nuestro programa, donde viene el número de línea. La función del punto de ruptura es que cuando la máquina virtual de Java llegue a dicho punto, detenga la ejecución del programa justo en esa linea, para que el programador pueda ver el estado del programa en esa linea.

## Uso del depurador con Eclipse

Para que el programa se detenga en los puntos de ruptura, debemos arrancar el programa en modo depuración, para ello pulsaremos el fichero que tenga el método <b>main</b> con botón derecho -> debug as -> Java Application. Una vez hecho, nos aparecerá una pop-up donde se nos preguntará si queremos cambiar la perspectiva de eclipse a modo depuración. Esta perspectiva nos ayudará para ver ciertos valores que no podemos ver en una perspectiva normal de "java", tales como los hilos de ejecución (a la derecha) o el valor de las variables (a la izquierda).

Una vez que hayamos ejecutado el programa en modo depuración, el programa deberá pararse en un punto de ruptura cuando llegue a él. A partir de ahí podemos tomar una serie de opciones para continuar con la ejecución de nuestro programa, todas esas opciones las podemos ver en la pestaña <b>run</b>, las más importantes:

1. <b>F8 - Resume</b>: Continua con la ejecución del programa. Se parará en el siguiente punto de interrupción si hubiera.
2. <b>F6 - Step Over</b>: Pasa a la siguiente línea de ejecución del programa y se detiene en dicha línea. Podremos pulsar repetidamente F6 para ir ejecutando el programa línea a línea.
3. <b>F5 - Step Into</b>: Si la línea en la que estamos es un método, entonces nos meteremos dentro de dicho método. Es muy útil cuando queremos ver como actúa el método en cuestión.

## Bibliografía

- <http://www.edu4java.com/es/java/depurar-debug-programa-java-eclipse.html>
- <https://www.youtube.com/watch?v=ymV7lUUHkUU>
