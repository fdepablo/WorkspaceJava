package _05_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _03_OrdenarYLimitar {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(8, 3, 8, 1, 5, 3);

        // PASO 1: quitar repetidos, sin ordenar ni limitar.
        System.out.println("=== 1. Quitar repetidos con distinct ===");
        List<Integer> sinRepetidosConFor = new ArrayList<>();
        for (Integer numero : numeros) {
            if (!sinRepetidosConFor.contains(numero)) {
                sinRepetidosConFor.add(numero);
            }
        }
        System.out.println("Con for e if: " + sinRepetidosConFor);

        // distinct no recibe una lambda: compara los elementos usando equals.
        // En esta lista conserva la primera aparicion de cada numero.
        List<Integer> sinRepetidos = numeros.stream()
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Con distinct: " + sinRepetidos); // [8, 3, 1, 5]

        // PASO 2: ordenar TODOS los numeros, sin quitar repetidos.
        System.out.println("\n=== 2. Ordenar con sorted ===");
        List<Integer> ordenadosSinStream = new ArrayList<>(numeros);
        Collections.sort(ordenadosSinStream);
        System.out.println("Con Collections.sort: " + ordenadosSinStream);

        // sorted() usa el orden natural: para Integer, de menor a mayor.
        // Conserva los repetidos. Ordena el flujo, no la lista original.
        List<Integer> ordenados = numeros.stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Con sorted: " + ordenados); // [1, 3, 3, 5, 8, 8]

        // PASO 3: quedarse con los TRES PRIMEROS en el orden de la lista.
        System.out.println("\n=== 3. Elegir los primeros con limit ===");
        List<Integer> primerosConFor = new ArrayList<>();
        for (int i = 0; i < numeros.size() && i < 3; i++) {
            primerosConFor.add(numeros.get(i));
        }
        System.out.println("Con for: " + primerosConFor);

        // limit(3) deja pasar como maximo tres elementos: no busca los menores.
        // Si hay menos de tres, conserva los que haya; con cero, no pasa ninguno.
        // La cantidad no puede ser negativa.
        List<Integer> primeros = numeros.stream()
            .limit(3)
            .collect(Collectors.toList());
        System.out.println("Con limit: " + primeros); // [8, 3, 8]

        // PASO 4: combinar las tres operaciones para obtener los tres menores distintos.
        System.out.println("\n=== 4. Quitar repetidos, ordenar y limitar ===");
        List<Integer> combinadosSinStream = new ArrayList<>(sinRepetidosConFor);
        Collections.sort(combinadosSinStream);
        List<Integer> resultadoConFor = new ArrayList<>();
        for (int i = 0; i < combinadosSinStream.size() && i < 3; i++) {
            resultadoConFor.add(combinadosSinStream.get(i));
        }
        System.out.println("Con los pasos anteriores sin stream: " + resultadoConFor);

        List<Integer> resultado = numeros.stream() // [8, 3, 8, 1, 5, 3]
            .distinct()                           // [8, 3, 1, 5]
            .sorted()                             // [1, 3, 5, 8]
            .limit(3)                             // [1, 3, 5]
            .collect(Collectors.toList());
        System.out.println("Con distinct, sorted y limit: " + resultado);
        // collect termina la cadena y guarda el resultado en una nueva lista.
        // Las listas de los comentarios muestran que produce cada paso;
        // el codigo no crea una lista intermedia por cada operacion.

        // PASO 5: comparar SOLO el orden de sorted y limit, sin distinct.
        System.out.println("\n=== 5. El orden de las operaciones importa ===");
        List<Integer> ordenarYLimitar = numeros.stream()
            .sorted() // [1, 3, 3, 5, 8, 8]
            .limit(3) // [1, 3, 3]
            .collect(Collectors.toList());
        System.out.println("Ordenar y luego limitar: " + ordenarYLimitar);
        // Pregunta: cuales son los tres menores, aunque se repitan?

        List<Integer> limitarYOrdenar = numeros.stream()
            .limit(3) // [8, 3, 8]
            .sorted() // [3, 8, 8]
            .collect(Collectors.toList());
        System.out.println("Limitar y luego ordenar: " + limitarYOrdenar);
        // Pregunta: como quedan ordenados los tres primeros de la lista?
        // El 1 ya no puede aparecer: limit lo dejo fuera antes de ordenar.

        System.out.println("\nLista original: " + numeros); // [8, 3, 8, 1, 5, 3]
    }
}