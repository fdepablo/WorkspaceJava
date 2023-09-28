# Hilos

Los hilos están asociados a un <b>proceso</b> de nuestro sistema operativo. La definición de proceso es un programa en ejecución. Puesto que un proceso está en ejecución, está consumiendo recursos del sistema. Por ejemplo, cuando abrimos un navegador, ejecutamos dicho programa por lo que se abrirá un proceso en nuestro sistema.

Crear un proceso en un ordenador implica los siguientes cambios:

- La reserva de una determinada memoria de trabajo.
- Carga de trabajo para el procesador, que tendrá que ir ejecutando las instrucciones incluidas en el proceso.
- Cambios de estado del proceso, que se reflejan en los valores de los registros de la CPU.

Los procesos se pueden ver en ejecución en el sistema operativo, en Windows por ejemplo los podemos ver dentro del administrador de tareas.

Un <b>hilo</b> es la unidad mínima de procesamiento y se encuentra dentro de un proceso. Es decir, un conjunto de instrucciones en ejecución dentro del contexto de un proceso. 

Todo proceso tendrá al menos un hilo en ejecución, aunque podrá tener varios simultaneo, creando lo que se denomina multitarea.

Hay que tener claro que el sistema operativo tiene control sobre los procesos, pero NO sobre las hilos de una manera directa

Esto nos lleva a distinguir entre los conceptos de multiproceso y multitarea.

- <b>Multiproceso</b>: varios procesos que se ejecutan de manera concurrente y que son gestionados por el sistema operativo.
- <b>Multitarea</b>: varios hilos de ejecución simulraneos dentro del mismo proceso.

Nosotros en esta lección nos vamos a centrar en los sistemas multitarea.

## Sistemas multitarea 

Estos sistemas tienen una serie de características:

- Varios hilos en ejecución dentro del mismo proceso.

- Todos los hilos comparten los recurso que el sistema operativo haya asignado al proceso. La incorporación de un hilo más no supone la asignación de más recursos del sistema. 

- Si el ordenador dispone de varios núcleos, cada hilo en ejecución puede aprovechar un núcleo distinto, produciéndose así la multitarea en el sentido estricto de la palabra.

- El uso de varios hilos de ejecución en un proceso es especialmente interesante en los programas en red de tipo cliente/servidor. Un hilo de ejecución puede estar atendiendo peticiones y, si el procesamiento de la respuesta es largo, podrá generarse un hilo independiente para cada respuesta. De este modo, se podrá estar atendiendo varias peticiones al mismo tiempo.

## Beneficios de un sistema multitarea

Uno de los mayores beneficios que tiene la programación multitarea es el poder reducir de manera considerada los tiempos de ejecución de una aplicación.

Supongamos que estamos haciendo una aplicación que para acabar tiene que hacer 3 tareas:

- Tarea A: Procesar unos ficheros de texto para guardar la información en base de datos. Supongamos que el tiempo de duración de esta tarea es de 25 segundos.
- Tarea B: Mandar un número indeterminado de emails a nuestros clientes. Supongamos que el tiempo de duración de esta tarea es de 20 segundos.
- Tarea C: Hacer cálculos estadísticos e informes para enviar a nuestros directores. Supongamos que el tiempo de duración de esta tarea es de 15 segundos.

En una situación normal en la que no hay multitarea (una aplicación normal en Java), es decir, en la que solo hay un hilo de ejecución, la duración total de la aplicación será de 60 segundos. En esta situación irían ejecutándose las tareas de manera secuencial (no empezará la tarea B a ejecutarse hasta que no acabe la tarea A).

En una situación en que hay multitarea, es decir, en que hay creamos varios hilos de ejecución (en este caso 3 hilos, cada uno asociado a una tarea), la duración total sería la de la tarea con mayor duración, en este caso 25 segundos, habiendo reducido el tiempo a menos de la mitad. En esta situación irían ejecutándose las tareas de manera paralela.

Por supuesto habrá que tener en cuenta que nuestro ordenador a nivel de hardware tuviera hilos suficientes para ejecutar todos nuestros hilos en paralelo, de nada serviría hacer programación multitarea si ejecutamos el código en un ordenador antiguo con un solo hilo de procesamiento.

## Hilos en Java

Existen dos maneras de declarar y configurar hilos en Java: 

- Crear una clase que extienda de la clase **Thread** (herencia)

- Crear un clase que implemente la interfaz **Runnable** (interfaces)

Además, existen muchos métodos estáticos asociados a la clase Thread que nos van a ayudar:

- sleep(X): Duerme el hilo por el que está pasando el programa X milisegundos
- start(): Arranca un hilo, ejecutando su método run(). El hilo acabará cuando salga del método run().
- currentThread().getName(): Nos da el nombre el hilo que está pasando por el programa.


Existen muchos más metodos que podemos ver en la documentacion oficial.

En el paquete 01_basico podemos encontrar ejemplos sobre los hilos en java

## Estados de un hilo

![Estados Hilos](img/estadosHilos.png))

La imagen refleja los distintos cambios de estados por los que pasa un hilo y los métodos que pueden provocar dichos cambios. Un hilo nuevo pasa a ejecutable por la invocación al método **start()**. Por otro lado, puede pasar de ejecutable a bloqueado por la invocación a los métodos sleep(), wait(), o a la espera de una operación de entrada/salida, volviendo de nuevo al estado ejecutable cuando llegue el momento.

Un hilo pasa a estar muerto en la mayoría de los casos cuando ha terminado de ejecutarse el método **run()** y, por consiguiente, ya cumplirá su misión, pero también podrá pasar a estado muerto por la ejecución del método stop(), que interrumpe el hilo, o por otro tipo de interrupción inesperada.

## Hilos sincronizados en Java

Cuando estamos trabajando con hilos podemos tener problemas de sincronización entre ellos o lo que es lo mismo problemas cuando dos hilos acceden simultáneamente a la misma posición de memoria.

Varios hilos podrán compartir información accediendo a la misma variable, objeto, fichero, etc. Esto podrá crear zonas críticas, es decir, áreas de código que podrán crear problemas de concurrencia.

Para indicar que un fragmento de código está sincronizado, es decir, que solamente un hilo puede acceder a dicho método a la vez, se utilizará la palabra reservada <b>"synchronized"</b>.

Se podrá afirmar que un método sincronizado tiene una marca de abierto y cerrado: cuando está cerrado ningún otro hilo puede entrar en dicho método.

La clave de la sincronización está en entender la palabra <b>monitor</b>. Como hemos comentado anteriormente, sólo un hilo de ejecución puede acceder a un método sincronizado al mismo tiempo; se dice que ese hilo es el que tiene el monitor y tendrá bloqueado el proceso hasta que finalice su ejecución y lo libere.

Podemos ver los ejemplos 03_Sincronizado_XX de este proyecto para ver como podemos utilizar la sincronización de hilos.

## Wait y Notify

Los métodos <b>wait() y notify()</b> pertenecen a la clase Object, por consiguiente, todos los objetos cuentan con ellos ya que todos las clases heredan de la clase Object.

El método **wait()** deja bloqueado el hilo que lo llama, hasta que es liberado por otro hilo por medio de la ejecución del método notify(). Siempre que se haga un notify() a un objeto despierta a un hilo que esté en estado de wait().

Los métodos wait() y notify() solamente se pueden llamar dentro de un método o bloque sincronizado. En caso de que se usen fuera de bloques o métodos sincronizados dará la excepción <b>java.lang.IllegalMonitorStateException</b>

El método wait() esta sobrecargado y admite también un parámetro de entrada en el que le pasamos un número de milisegundos, en caso de que pase dicho número de milisegundos y ningún hilo haya ejecutado un **notify** sobre el objeto, entonces el hilo seguirá su ejecución.

Por otro lado, es muy importante también saber que el método **wait()** además de parar indefinidamente el hilo, libera el bloque sincronizado (libera el monitor del hilo) y dejará pasar a otro hilo que este esperando para entrar en dicho bloque sincronizado. De esta manera, permitiríamos entrar a otros hilos que quieran ejecutar el método **notify()** para despertar a otros hilos parados con el método **wait()**. 

Podemos ver el ejemplo 04 para ver un sistema de productores y consumidores usando los métodos **wait() y notify()**.

## Bibliografia
- <https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Thread.html>
- <https://www.java67.com/2019/05/why-wait-and-notify-method-should-be-called-in-loop-not-if-block.html>
