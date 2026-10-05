package _05_streams;

import java.util.Arrays;
import java.util.List;

public class _00_DelForAlStream {
    public static void main(String[] args) {
        List<Integer> notas = Arrays.asList(4, 7, 3, 9, 5);

        // Objetivo: mostrar las notas aprobadas. Primero, como ya sabemos.
        System.out.println("Con for:");
        for (Integer nota : notas) {
            if (nota >= 5) {
                System.out.println(nota);
            }
        }

        // Mismo resultado: 7, 9 y 5, cada uno en una linea.
        // Leemos de arriba abajo: partir de notas, elegir aprobadas, imprimir.
        System.out.println("Con stream:");
        notas.stream()                           // Origen: los elementos de la lista.
            .filter(nota -> nota >= 5)            // Intermedia: conserva si devuelve true.
            .forEach(nota -> System.out.println(nota)); // Terminal: ejecuta el recorrido.

        // La lambda es la regla. El stream organiza el recorrido.
        // filter no borra las notas suspensas de la lista original.
        System.out.println("Lista original: " + notas);
    }
}
