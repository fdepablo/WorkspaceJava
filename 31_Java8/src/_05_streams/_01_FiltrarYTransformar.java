package _05_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _01_FiltrarYTransformar {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        // PASO 1: seleccionar SOLO los numeros pares, sin transformarlos.
        System.out.println("=== 1. Seleccionar con filter ===");
        List<Integer> paresConFor = new ArrayList<>();
        for (Integer numero : numeros) {
            if (numero % 2 == 0) {
                paresConFor.add(numero);
            }
        }
        System.out.println("Con for e if: " + paresConFor);

        // filter recibe una condicion que devuelve true o false.
        // numero % 2 == 0 comprueba si el resto de dividir entre dos es cero.
        // Solo pasan los pares; su valor no cambia.
        // collect(Collectors.toList()) guarda el resultado en una nueva lista.
        List<Integer> paresConStream = numeros.stream()
            .filter(numero -> numero % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Con filter: " + paresConStream);
        // Resultado en ambos casos: [2, 4, 6].

        // PASO 2: multiplicar TODOS los numeros por diez, sin filtrar.
        System.out.println("\n=== 2. Transformar con map ===");
        List<Integer> porDiezConFor = new ArrayList<>();
        for (Integer numero : numeros) {
            porDiezConFor.add(numero * 10);
        }
        System.out.println("Con for: " + porDiezConFor);

        // map recibe una transformacion: entra un numero y sale su valor por diez.
        // A diferencia de filter, aqui no decidimos si pasa: calculamos un valor.
        List<Integer> porDiezConStream = numeros.stream()
            .map(numero -> numero * 10)
            .collect(Collectors.toList());
        System.out.println("Con map: " + porDiezConStream);
        // Resultado en ambos casos: [10, 20, 30, 40, 50, 60].

        // PASO 3: seleccionar los pares y multiplicar SOLO esos numeros por diez.
        System.out.println("\n=== 3. Combinar filter y map ===");
        List<Integer> resultadoConFor = new ArrayList<>();
        for (Integer numero : numeros) {
            if (numero % 2 == 0) {
                resultadoConFor.add(numero * 10);
            }
        }
        System.out.println("Con for e if: " + resultadoConFor);

        // Leemos de arriba abajo: partir de numeros, seleccionar, transformar, guardar.
        // [1, 2, 3, 4, 5, 6] -> [2, 4, 6] -> [20, 40, 60].
        List<Integer> resultado = numeros.stream()
            .filter(numero -> numero % 2 == 0)
            .map(numero -> numero * 10)
            .collect(Collectors.toList());
        System.out.println("Con filter y map: " + resultado);
        // Resultado en ambos casos: [20, 40, 60].

        // PASO 4: una vez entendido map, transformar tambien el TIPO de dato.
        System.out.println("\n=== 4. De nombres a longitudes con map ===");
        List<String> nombres = Arrays.asList("Ana", "Pedro", "Eva");
        List<Integer> longitudesConFor = new ArrayList<>();
        for (String nombre : nombres) {
            longitudesConFor.add(nombre.length());
        }
        System.out.println("Con for: " + longitudesConFor);

        // Entra un String y sale un Integer: el numero de caracteres del nombre.
        List<Integer> longitudes = nombres.stream()
            .map(nombre -> nombre.length())
            .collect(Collectors.toList());
        System.out.println("Con map: " + longitudes);
        // Resultado en ambos casos: [3, 5, 3].

        // Cada consulta utiliza un stream nuevo y conserva la lista original.
        System.out.println("\nNumeros originales: " + numeros); // [1, 2, 3, 4, 5, 6]
        System.out.println("Nombres originales: " + nombres); // [Ana, Pedro, Eva]

        // Puente con _02_Lambdas: filter recibe un Predicate (condicion),
        // map recibe una Function (transformacion) y forEach un Consumer (accion).
        // Podemos pasar la lambda directamente, sin declarar esas variables.
    }
}