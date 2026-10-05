# Streams: paso a paso

Este ejemplo continúa `_04_lambdas`. Solo necesitas listas, un `for`, un `if` y una lambda sencilla. Todos los ejemplos usan Java 8 y cada clase numerada tiene su propio `main`.

## La idea antes del código

Una lista guarda datos. Un stream permite procesar sus elementos: elegir algunos, transformarlos y obtener un resultado. Piensa en una cinta por la que pasan elementos y en las operaciones que aplicas a los que van pasando. El stream no es otra lista ni guarda por sí mismo el resultado.

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

## Orden para ejecutar los ejemplos

En Eclipse: abre la clase, botón derecho → **Run As → Java Application**. Ejecuta una clase cada vez, en este orden. Los comentarios junto al código indican los resultados esperados.

| Clase | Pregunta que resuelve | Qué aprender |
| --- | --- | --- |
| `_00_DelForAlStream` | ¿Qué notas están aprobadas? | Comparar `for` e `if` con `filter` y `forEach` |
| `_01_FiltrarYTransformar` | ¿Cómo selecciono pares y los multiplico por diez? | Distinguir `filter`, `map` y `collect` |
| `_02_OrdenarYLimitar` | ¿Cómo quito repetidos y elijo los tres menores? | Comparar bucles y `Collections.sort` con `distinct`, `sorted` y `limit` |
| `_03_StreamsConObjetos` | ¿Quién aprueba? ¿Cuántos? ¿Cuál es la media? | Comparar cada consulta con su version mediante bucles |
| `_04_CuandoSeEjecuta` | ¿Cuándo se recorre la lista? | Ejecución perezosa y streams de un solo uso |
| `_05_EjerciciosResueltos` | ¿Cómo resuelvo los ejercicios? | Consultar soluciones después de intentarlo |

Para la primera sesión basta con los dos primeros ejemplos. Antes de ejecutar cada cadena, pide que escriban en papel qué elementos esperan al final. En otra sesión introduce ordenar y trabajar con objetos. Deja `Optional` y la ejecución perezosa para cuando entiendan las cadenas básicas.

## Tres operaciones que conviene distinguir

| Operación | Regla que recibe | Resultado |
| --- | --- | --- |
| `filter` | `Predicate`: un elemento → boolean | Pasan los elementos que cumplen la condición |
| `map` | `Function`: un elemento → un valor | Pasa el valor transformado; puede cambiar el tipo |
| `forEach` | `Consumer`: un elemento → acción sin retorno | Ejecuta una acción; devuelve `void` |

`filter` selecciona; `map` transforma. Para `[1, 2, 3, 4]`, filtrar pares da `[2, 4]`; multiplicar todos por diez con `map` da `[10, 20, 30, 40]`.

Para **guardar** el resultado en Java 8 usamos `collect(Collectors.toList())`. Para **mostrarlo** podemos usar `forEach`. Después de `forEach` no podemos seguir encadenando operaciones: no devuelve un stream.

## Otras terminales, cuando las básicas estén claras

| Operación | Qué devuelve |
| --- | --- |
| `count()` | Cantidad de elementos, de tipo `long` |
| `anyMatch(condicion)` | `true` si algún elemento cumple la condición; `false` si ninguno la cumple |
| `findFirst()` | Un `Optional`: puede haber un primer elemento o no haber ninguno |
| `mapToInt(...).sum()` | La suma de los enteros, o cero si el flujo está vacío |
| `mapToInt(...).average()` | Un `OptionalDouble`, porque una lista vacía no tiene media |

Un `Optional` es un resultado que puede estar ausente. En el ejemplo comprobamos `isPresent()` antes de `get()`. Para la media, `orElse(0.0)` elige un valor de sustitución cuando no hay datos; es una decisión de este ejemplo, no la media matemática de una lista vacía.

## Cosas que suelen confundir

- **Preparar no es ejecutar**: las intermedias preparan la cadena. La terminal inicia el trabajo necesario. Algunas operaciones pueden terminar pronto y algunas etapas pueden optimizarse; no dependas de efectos secundarios en las lambdas.
- **Cada stream se usa una vez**: para otra consulta, vuelve a llamar a `lista.stream()`.
- **La lista original se conserva en estos ejemplos**: filtrar u ordenar el flujo no borra ni reordena la lista. Si dentro de una lambda cambias un objeto, sí estarás modificando ese objeto; `collect` tampoco hace copias profundas.
- **No modifiques la lista que estás recorriendo** desde las lambdas.
- **El orden de la cadena importa**: limitar antes de ordenar y ordenar antes de limitar responden preguntas distintas.
- **No hace falta usar streams siempre**: un `for` sigue siendo una opción válida cuando hace el código más fácil de entender.

Por ahora usamos streams secuenciales de listas. `parallelStream`, `flatMap`, `reduce` y agrupaciones pueden esperar. Los streams de esta lección son flujos de datos de `java.util.stream`, no los streams de entrada/salida para leer archivos.

## Ejercicios

Con `List<Integer> notas = Arrays.asList(3, 7, 5, 9, 4, 7);`, escribe una cadena por pregunta. Antes, predice el resultado:

1. Obtener una nueva lista de aprobados. Esperado: `[7, 5, 9, 7]`.
2. Contar los suspensos. Esperado: `2`.
3. Obtener las notas sin repetidos y ordenadas de menor a mayor. Esperado: `[3, 4, 5, 7, 9]`.
4. Comprobar si hay algún diez. Esperado: `false`.
5. Con los alumnos del ejemplo 03, obtener los nombres de quienes tengan al menos un ocho. Esperado: `[Ana, Eva]`.

Pistas: `filter` selecciona, `map` obtiene el nombre, `collect` guarda una lista, `count` cuenta y `anyMatch` responde una pregunta de sí/no. Después compara con `_05_EjerciciosResueltos`.

Prueba también con listas vacías: recoger produce `[]`, contar da `0`, `anyMatch` da `false` y buscar no encuentra un elemento.
