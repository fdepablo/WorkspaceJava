package _05_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _00_DelForAlStream {
    public static void main(String[] args) {
        List<Integer> notas = Arrays.asList(4, 7, 3, 9, 5);

        // PASO 1: recorrer y mostrar TODAS las notas, sin filtrar.
        System.out.println("=== 1. Recorrer con forEach ===");
        System.out.println("Con for:");
        for (Integer nota : notas) {
            System.out.println(nota);
        }

        // forEach se puede usar para recorrer una lista pasandole una función lambda
        System.out.println("Con forEach directamente sobre la lista:");
        notas.forEach(nota -> System.out.println(nota));

        // stream() crea un flujo con los elementos de la lista.
        // forEach recibe una accion y la ejecuta para cada elemento.
        // La lambda recibe una nota y la imprime.
        System.out.println("Con stream y forEach:");
        notas.stream()
            .forEach(nota -> System.out.println(nota));
        // Los tres recorridos muestran: 4, 7, 3, 9 y 5, cada una en una linea.
        // Aqui stream() es opcional; sera util para encadenar filter en el paso 3.

        // PASO 2: seleccionar las aprobadas y guardarlas en otra lista.
        System.out.println("\n=== 2. Seleccionar con filter ===");
        List<Integer> aprobadasConFor = new ArrayList<>();
        for (Integer nota : notas) {
            if (nota >= 5) {
                aprobadasConFor.add(nota);
            }
        }
        System.out.println("Con for e if: " + aprobadasConFor);

        // filter recibe una condicion: la lambda devuelve true o false.
        // Si devuelve true, la nota pasa; si devuelve false, se descarta del flujo.
        // filter no imprime ni crea una lista: devuelve otro stream.
        
        // collect termina el recorrido y recoge las notas en una nueva lista.
        // Por ahora basta con reconocer collect(Collectors.toList()) como
        // la forma de guardar el resultado en una lista usando Java 8.
        List<Integer> aprobadasConStream = notas.stream()
            .filter(nota -> nota >= 5)
            .collect(Collectors.toList());
        System.out.println("Con filter: " + aprobadasConStream);
        // Ambas listas contienen: [7, 9, 5]. Aqui no hemos usado forEach.

        // PASO 3: unir lo aprendido para mostrar SOLO las aprobadas.
        System.out.println("\n=== 3. Combinar filter y forEach ===");
        System.out.println("Con for e if:");
        for (Integer nota : notas) {
            if (nota >= 5) {
                System.out.println(nota);
            }
        }

        // Leemos de arriba abajo: partir de notas, elegir aprobadas, imprimir.
        System.out.println("Con filter y forEach:");
        notas.stream()                               // Origen: las notas.
            .filter(nota -> nota >= 5)                // Seleccionar.
            .forEach(nota -> System.out.println(nota)); // Mostrar.
        // Mismo resultado: 7, 9 y 5, cada una en una linea.
        // No necesitamos guardar una lista intermedia si solo queremos imprimir.

        // La lambda es la regla. El stream organiza el recorrido.
        System.out.println("\nLista original: " + notas); // [4, 7, 3, 9, 5]
    }
}