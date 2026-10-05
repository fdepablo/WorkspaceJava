package _05_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _04_CuandoSeEjecuta {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4);

        Stream<Integer> pares = numeros.stream().filter(numero -> {
            // Traza SOLO para entender cuando se ejecuta; normalmente
            // un filtro se limita a devolver una condicion, sin imprimir.
            System.out.println("Comprobando " + numero);
            return numero % 2 == 0;
        });

        System.out.println("Stream preparado. Todavia no se ha comprobado nada.");
        System.out.println("Ahora llamamos a collect:");
        List<Integer> resultado = pares.collect(Collectors.toList());
        System.out.println("Resultado: " + resultado); // [2, 4]

        // filter y map son perezosos: preparan operaciones.
        // Una terminal inicia el trabajo necesario para obtener el resultado.
        // NO todas las terminales necesitan recorrer todos los elementos:
        // findFirst y anyMatch pueden parar al encontrar lo que buscan.

        // Un stream se consume una sola vez. Esta linea fallaria:
        // pares.count(); // IllegalStateException: el stream ya se ha consumido.
        // La lista si se puede reutilizar: creamos otro stream.
        System.out.println("Cantidad usando un stream nuevo: " + numeros.stream().count());
    }
}
