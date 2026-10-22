# Java 8: interfaces, lambdas y streams

Guía de los ejemplos del proyecto `31_Java8`: desde las interfaces hasta el procesamiento de colecciones con expresiones lambda y streams.

## Índice

1. [Recorrido del proyecto](#recorrido-del-proyecto)
2. Interfaces con métodos por defecto
3. Interfaces con métodos estáticos
4. [Interfaces funcionales](#interfaces-funcionales)
5. [Expresiones lambda](#expresiones-lambda)
6. [Streams: paso a paso](#streams-paso-a-paso)
7. Bibliografía

## Recorrido del proyecto

Los ejemplos utilizan características disponibles desde **Java 8**. Conviene conocer clases, interfaces, listas, bucles y condicionales antes de empezar.

| Orden | Paquete | Contenido |
| --- | --- | --- |
| 0 | [`_00_interfaces`](src/_00_interfaces/) | Repaso de interfaces y sus implementaciones |
| 1 | [`_01_interfaces_recargadas`](src/_01_interfaces_recargadas/) | Métodos con implementación por defecto: `default` |
| 2 | [`_02_interfaces_estaticas`](src/_02_interfaces_estaticas/) | Métodos estáticos en interfaces: `static` |
| 3 | [`_03_interfaces_funcionales`](src/_03_interfaces_funcionales/) | Interfaces con un único método abstracto |
| 4 | [`_04_lambdas`](src/_04_lambdas/) | Sintaxis y uso de expresiones lambda |
| 5 | [`_05_streams`](src/_05_streams/) | Filtrar, transformar, ordenar y consultar colecciones |

**Ejecución en Eclipse:** abre una clase que contenga `main`, pulsa el botón derecho y selecciona **Run As → Java Application**. Ejecuta los ejemplos en el orden de los paquetes.

## Interfaces con métodos por defecto

Desde Java 8, una interfaz puede incluir métodos con una implementación por defecto. Esto permite que las bibliotecas incorporen comportamiento a sus interfaces sin obligar a todas las clases existentes a implementar cada nuevo método.

Estos métodos también se conocen como *métodos por defecto*, *virtuales* o *defensores*. Se declaran con la palabra reservada `default` antes del tipo de retorno:

```java
interface Saludo {
    default void saludar() {
        System.out.println("Hola");
    }
}
```

La clase que implementa la interfaz hereda este comportamiento si no proporciona su propia implementación. Si lo sobrescribe, se utiliza la versión de la clase. Para quien lo invoca, se usa como cualquier otro método de instancia de la interfaz.

## Interfaces con métodos estáticos

Java 8 también permite definir métodos `static` en una interfaz. Se invocan mediante el nombre de la interfaz, sin crear un objeto:

```java
interface Saludo {
    static String mensaje() {
        return "Hola";
    }
}

// Uso:
System.out.println(Saludo.mensaje());
```

Los métodos estáticos de una interfaz no se heredan como métodos de instancia en las clases que la implementan.

## Interfaces funcionales

Una **interfaz funcional** tiene un único método abstracto, lo que permite implementar su comportamiento mediante una expresión lambda. Puede contener además métodos `default` y `static` sin perder esta condición.

Los métodos abstractos que coinciden con métodos públicos de `java.lang.Object`, como `equals`, `hashCode` o `toString`, no cuentan para determinar ese único método abstracto.

La anotación `@FunctionalInterface` permite al compilador comprobar esta condición:

```java
@FunctionalInterface
interface Operacion {
    int aplicar(int a, int b);
}
```

### Interfaces de `java.util.function`

La JDK proporciona interfaces funcionales genéricas en el paquete **`java.util.function`**. Sus parámetros de tipo permiten elegir los tipos de entrada y salida, como ocurre con `ArrayList<T>`.

Estas interfaces describen un contrato: qué argumentos recibe una operación y qué resultado devuelve. El código que recibe esa operación puede invocarla sin conocer su implementación interna.

| Interfaz | Entrada | Salida | Método | Uso habitual |
| --- | --- | --- | --- | --- |
| `Supplier<T>` | Ninguna | `T` | `get()` | Producir un valor u objeto sin argumentos |
| `Consumer<T>` | `T` | `void` | `accept(T)` | Consumir un valor o realizar una acción |
| `Function<T, R>` | `T` | `R` | `apply(T)` | Transformar un valor |
| `BiFunction<T, U, R>` | `T` y `U` | `R` | `apply(T, U)` | Combinar dos valores, por ejemplo sumarlos |
| `Predicate<T>` | `T` | `boolean` | `test(T)` | Comprobar una condición o filtrar |

## Expresiones lambda

Las expresiones lambda proceden de la programación funcional y permiten expresar de forma compacta la implementación del método de una interfaz funcional. Se escriben donde se necesita ese comportamiento, por ejemplo como argumento de un método.

Pueden recibir cero o más argumentos y devolver un valor o realizar una acción sin retorno, según la interfaz funcional. También pueden llamar a métodos de otras clases y objetos.

Esta sintaxis está disponible desde Java 8. Antes se podía expresar un comportamiento equivalente mediante implementaciones de interfaces, por ejemplo con clases anónimas. Una lambda permite escribir muchos de esos casos con menos código.

### Sintaxis

Una expresión lambda tiene tres partes:

```java
(parametros) -> cuerpo
```

1. **Parámetros:** separados por comas y entre paréntesis. Se pueden indicar sus tipos, como en `(int a, int b)`, o dejar que el compilador los deduzca.
2. **Flecha:** `->` separa los parámetros del cuerpo.
3. **Cuerpo:** una expresión o un bloque de código entre llaves.

```java
// Dos parámetros y una expresión que devuelve un resultado.
Operacion suma = (a, b) -> a + b;

// Con un solo parámetro de tipo inferido se pueden omitir los paréntesis.
Consumer<String> imprimir = texto -> System.out.println(texto);

// Sin parámetros.
Supplier<String> saludo = () -> "Hola";

// Un bloque que devuelve un valor necesita return.
Function<Integer, Integer> doble = numero -> {
    int resultado = numero * 2;
    return resultado;
};
```

Los tres últimos ejemplos utilizan interfaces de `java.util.function`; añade sus correspondientes `import` al probarlos.

### Variables del ámbito exterior

Una lambda puede acceder a variables locales de su ámbito si son `final` o **efectivamente finales**: no se les asigna otro valor después de inicializarlas.

```java
int minimo = 5;
Predicate<Integer> aprobado = nota -> nota >= minimo;
```

La lambda no puede reasignar esa variable local. Si la variable referencia un objeto mutable, esta regla no impide modificar el estado del objeto.

## Streams: paso a paso

Este ejemplo continúa `_04_lambdas`. Solo necesitas listas, un `for`, un `if` y una lambda sencilla. Todos los ejemplos usan Java 8 y cada clase numerada tiene su propio `main`.

### La idea antes del código

Un stream permite escribir una secuencia de operaciones sobre los elementos de una lista. Por ejemplo, si tenemos varias notas y queremos mostrar solo las aprobadas, podemos indicar dos pasos: seleccionar las notas mayores o iguales que cinco y mostrar cada una.

Con un bucle `for` escribimos cómo recorrer la lista y qué hacer con cada nota. Con un stream encadenamos las operaciones que necesitamos: `filter` para seleccionar y `forEach` para mostrar. `notas.stream()` es el punto de partida para trabajar con los elementos de la lista de esta forma.

La lista sigue siendo donde están guardadas las notas. En este ejemplo, el stream solo las consulta: no elimina las suspensas ni crea automáticamente otra lista. Si queremos guardar las aprobadas en una nueva lista, lo indicamos con `collect(Collectors.toList())`.

Por ejemplo: de las notas de clase, elegir las aprobadas e imprimirlas.

```java
notas.stream()
    .filter(nota -> nota >= 5)
    .forEach(nota -> System.out.println(nota));
```

Léelo así: «De las notas, conserva las que sean al menos cinco y muestra cada una». `nota` representa un elemento que llega a la lambda; podemos elegir otro nombre. `nota -> nota >= 5` recibe una nota y devuelve `true` o `false`.

Una cadena de streams tiene tres partes:

1. **Origen**: `notas.stream()` crea el flujo desde la lista.
2. **Operaciones intermedias**: `filter`, `map`… devuelven otro stream y se pueden encadenar.
3. **Operación terminal**: `collect`, `forEach`, `count`… termina la cadena y obtiene el resultado o realiza una acción.

La lambda aporta una regla y el stream organiza cómo aplicarla. No necesitas escribir el bucle para cada pregunta.

### Orden para ejecutar los ejemplos

En Eclipse: abre la clase, botón derecho → **Run As → Java Application**. Ejecuta una clase cada vez, en este orden. Los comentarios junto al código indican los resultados esperados.

| Clase | Pregunta que resuelve | Qué aprender |
| --- | --- | --- |
| `_00_DelForAlStream` | ¿Qué notas están aprobadas? | Comparar `for` e `if` con `filter` y `forEach` |
| `_01_FiltrarYTransformar` | ¿Cómo selecciono pares y los multiplico por diez? | Distinguir `filter`, `map` y `collect` |
| `_02_StreamsConObjetos` | ¿Quién aprueba? ¿Cuántos? ¿Cuál es la media? | Comparar cada consulta con su versión mediante bucles |
| `_03_OrdenarYLimitar` | ¿Cómo quito repetidos y elijo los tres menores? | Comparar bucles y `Collections.sort` con `distinct`, `sorted` y `limit` |
| `_04_CuandoSeEjecuta` | ¿Cuándo se recorre la lista? | Ejecución perezosa y streams de un solo uso |
| `_05_EjerciciosResueltos` | ¿Cómo resuelvo los ejercicios? | Consultar soluciones después de intentarlo |

Para la primera sesión basta con los dos primeros ejemplos. Antes de ejecutar cada cadena, pide que escriban en papel qué elementos esperan al final. En otra sesión introduce ordenar y trabajar con objetos. Deja `Optional` y la ejecución perezosa para cuando entiendan las cadenas básicas.

### Principales métodos de streams

Una operación **intermedia** devuelve otro stream: permite seguir encadenando operaciones, pero no inicia por sí sola el procesamiento. Una operación **terminal** obtiene un resultado o realiza una acción y finaliza la cadena. Para otra consulta hay que crear un stream nuevo.

En los ejemplos de la tabla, `n` representa un número de la lista.

| Método | Tipo | Para qué sirve | Ejemplo |
| --- | --- | --- | --- |
| `stream()` | Inicio | Crea un stream a partir de la colección | `numeros.stream()` |
| `filter(condicion)` | Intermedia | Conserva los elementos cuya condición devuelve `true` | `.filter(n -> n >= 5)` |
| `map(transformacion)` | Intermedia | Calcula un valor por cada elemento; puede cambiar el tipo | `.map(n -> n * 10)` |
| `distinct()` | Intermedia | Elimina repetidos según `equals`; en una lista conserva la primera aparición | `.distinct()` |
| `sorted()` | Intermedia | Ordena por el orden natural: números de menor a mayor | `.sorted()` |
| `sorted(comparador)` | Intermedia | Ordena según el criterio indicado | `.sorted(Comparator.reverseOrder())` |
| `limit(cantidad)` | Intermedia | Conserva como máximo los primeros elementos; la cantidad debe ser cero o positiva | `.limit(3)` |
| `skip(cantidad)` | Intermedia | Omite los primeros elementos; la cantidad debe ser cero o positiva | `.skip(2)` |
| `collect(Collectors.toList())` | Terminal | Recoge los elementos en una nueva lista | `.collect(Collectors.toList())` |
| `forEach(accion)` | Terminal | Ejecuta una acción por elemento; devuelve `void` | `.forEach(n -> System.out.println(n))` |
| `count()` | Terminal | Devuelve cuántos elementos hay como `long` | `.count()` |
| `anyMatch(condicion)` | Terminal | Devuelve si al menos un elemento cumple la condición | `.anyMatch(n -> n == 10)` |
| `allMatch(condicion)` | Terminal | Devuelve si todos cumplen la condición; en un stream vacío devuelve `true` | `.allMatch(n -> n >= 5)` |
| `findFirst()` | Terminal | Devuelve el primero dentro de un `Optional`, o un `Optional` vacío si no hay elementos | `.findFirst()` |

Para usar el ejemplo de orden inverso, importa `java.util.Comparator`. Para recoger listas en Java 8, importa `java.util.stream.Collectors`.

**`filter` selecciona y `map` transforma.** Partiendo de `[1, 2, 3, 4]`, filtrar pares produce `[2, 4]`; multiplicar todos por diez con `map` produce `[10, 20, 30, 40]`.

**`forEach` también existe directamente en las listas.** Para mostrar todos sus elementos basta con `numeros.forEach(n -> System.out.println(n))`. En cambio, para utilizar `filter`, `map`, `distinct`, `sorted` o `limit` como en estos ejemplos, empezamos por `numeros.stream()`.

Para **guardar** el resultado usamos `collect(Collectors.toList())`; para **mostrar** cada elemento podemos usar `forEach`. Después de una terminal no podemos seguir encadenando operaciones de stream.

### Quitar repetidos, ordenar y limitar: paso a paso

El ejemplo `_03_OrdenarYLimitar` utiliza siempre la lista `[8, 3, 8, 1, 5, 3]`. Primero prueba cada método por separado y después los combina. Estas operaciones conservan la lista original.

| Operaciones antes de recoger en una lista | Resultado | Explicación |
| --- | --- | --- |
| `distinct()` | `[8, 3, 1, 5]` | Deja una aparición de cada número, sin ordenar |
| `sorted()` | `[1, 3, 3, 5, 8, 8]` | Ordena todos los números, incluidos los repetidos |
| `limit(3)` | `[8, 3, 8]` | Elige los tres primeros en el orden original |
| `distinct().sorted().limit(3)` | `[1, 3, 5]` | Elige los tres menores distintos |
| `sorted().limit(3)` | `[1, 3, 3]` | Elige los tres menores, permitiendo repetidos |
| `limit(3).sorted()` | `[3, 8, 8]` | Toma los tres primeros de la lista y ordena solo esos |

`limit(3)` no significa «los tres menores»: significa «los tres primeros que llegan a ese paso». Para obtener los menores hay que ordenar antes. Si hay menos de tres elementos disponibles, devuelve los que haya.

### Otras terminales, cuando las básicas estén claras

| Operación | Qué devuelve |
| --- | --- |
| `count()` | Cantidad de elementos, de tipo `long` |
| `anyMatch(condicion)` | `true` si algún elemento cumple la condición; `false` si ninguno la cumple |
| `findFirst()` | Un `Optional`: puede haber un primer elemento o no haber ninguno |
| `mapToInt(...).sum()` | La suma de los enteros, o cero si el flujo está vacío |
| `mapToInt(...).average()` | Un `OptionalDouble`, porque una lista vacía no tiene media |

Un `Optional` es un resultado que puede estar ausente. En el ejemplo comprobamos `isPresent()` antes de `get()`. Para la media, `orElse(0.0)` elige un valor de sustitución cuando no hay datos; es una decisión de este ejemplo, no la media matemática de una lista vacía.

### Cosas que suelen confundir

- **Preparar no es ejecutar**: las intermedias preparan la cadena. La terminal inicia el trabajo necesario. Algunas operaciones pueden terminar pronto y algunas etapas pueden optimizarse; no dependas de efectos secundarios en las lambdas.
- **Cada stream se usa una vez**: para otra consulta, vuelve a llamar a `lista.stream()`.
- **La lista original se conserva en estos ejemplos**: filtrar u ordenar el flujo no borra ni reordena la lista. Si dentro de una lambda cambias un objeto, sí estarás modificando ese objeto; `collect` tampoco hace copias profundas.
- **No modifiques la lista que estás recorriendo** desde las lambdas.
- **El orden de la cadena importa**: limitar antes de ordenar y ordenar antes de limitar responden preguntas distintas.
- **No hace falta usar streams siempre**: un `for` sigue siendo una opción válida cuando hace el código más fácil de entender.

Por ahora usamos streams secuenciales de listas. `parallelStream`, `flatMap`, `reduce` y agrupaciones pueden esperar. Los streams de esta lección son flujos de datos de `java.util.stream`, no los streams de entrada/salida para leer archivos.

### Ejercicios

Con `List<Integer> notas = Arrays.asList(3, 7, 5, 9, 4, 7);`, escribe una cadena por pregunta. Antes, predice el resultado:

1. Obtener una nueva lista de aprobados. Esperado: `[7, 5, 9, 7]`.
2. Contar los suspensos. Esperado: `2`.
3. Obtener las notas sin repetidos y ordenadas de menor a mayor. Esperado: `[3, 4, 5, 7, 9]`.
4. Comprobar si hay algún diez. Esperado: `false`.
5. Con los alumnos del ejemplo 02, obtener los nombres de quienes tengan al menos un ocho. Esperado: `[Ana, Eva]`.

Pistas: `filter` selecciona, `map` obtiene el nombre, `collect` guarda una lista, `count` cuenta y `anyMatch` responde una pregunta de sí/no. Después compara con `_05_EjerciciosResueltos`.

Prueba también con listas vacías: recoger produce `[]`, contar da `0`, `anyMatch` da `false` y buscar no encuentra un elemento.

## Bibliografía

- [Oracle: expresiones lambda y API Stream en Java](http://www.oracle.com/technetwork/es/articles/java/expresiones-lambda-api-stream-java-2633852-esa.html)