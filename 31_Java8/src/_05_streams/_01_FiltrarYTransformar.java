package _05_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _01_FiltrarYTransformar {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        // filter selecciona; map transforma CADA elemento que le llega.
        // Aqui: [1,2,3,4,5,6] -> [2,4,6] -> [20,40,60].
        List<Integer> resultado = numeros.stream()
            .filter(numero -> numero % 2 == 0)
            .map(numero -> numero * 10)
            .collect(Collectors.toList()); // Terminal: recoge en una nueva lista.

        System.out.println("Pares por diez: " + resultado); // [20, 40, 60]
        System.out.println("Original: " + numeros); // [1, 2, 3, 4, 5, 6]

        List<String> nombres = Arrays.asList("Ana", "Pedro", "Eva");
        // map tambien puede cambiar el tipo: String -> Integer.
        List<Integer> longitudes = nombres.stream()
            .map(nombre -> nombre.length())
            .collect(Collectors.toList());
        System.out.println("Longitudes: " + longitudes); // [3, 5, 3]

        // Puente con _02_Lambdas: filter recibe un Predicate,
        // map recibe una Function y forEach recibe un Consumer.
        // No hace falta declarar esas variables: podemos pasar la lambda directamente.
    }
}
