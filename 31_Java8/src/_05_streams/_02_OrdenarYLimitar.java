package _05_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _02_OrdenarYLimitar {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(8, 3, 8, 1, 5, 3);

        // ANTES: hacemos explicitamente los tres pasos.
        List<Integer> sinRepetidos = new ArrayList<Integer>();
        for (Integer numero : numeros) {
            if (!sinRepetidos.contains(numero)) {
                sinRepetidos.add(numero); // Solo lo guardamos si no estaba.
            }
        }
        Collections.sort(sinRepetidos); // Ordenamos la nueva lista.
        List<Integer> primerosTres = new ArrayList<Integer>();
        for (int i = 0; i < sinRepetidos.size() && i < 3; i++) {
            primerosTres.add(sinRepetidos.get(i));
        }
        System.out.println("Con bucles, sin repetidos y primeros tres: " + primerosTres);

        // CON STREAMS: los mismos pasos se expresan con operaciones.
        List<Integer> resultado = numeros.stream()
            .distinct() // Quita repetidos del flujo: [8, 3, 1, 5].
            .sorted()   // Orden natural: [1, 3, 5, 8].
            .limit(3)   // Conserva los tres primeros: [1, 3, 5].
            .collect(Collectors.toList());
        System.out.println("Sin repetidos, ordenados, primeros tres: " + resultado);

        // El orden de las operaciones importa: aqui elegimos ANTES de ordenar.
        // ANTES: copiar los tres primeros y despues ordenar esa copia.
        List<Integer> tresAntesDeOrdenar = new ArrayList<Integer>();
        for (int i = 0; i < numeros.size() && i < 3; i++) {
            tresAntesDeOrdenar.add(numeros.get(i));
        }
        Collections.sort(tresAntesDeOrdenar);
        System.out.println("Con bucles, primero limitar: " + tresAntesDeOrdenar);

        // CON STREAMS: limit antes de sorted, igual que en el bucle anterior.
        List<Integer> otroResultado = numeros.stream()
            .limit(3) // [8, 3, 8]
            .sorted() // [3, 8, 8]
            .collect(Collectors.toList());
        System.out.println("Primero limitar, despues ordenar: " + otroResultado);
    }
}
