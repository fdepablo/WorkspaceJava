package _05_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Intentar primero los ejercicios del README, despues consultar este archivo.
public class _05_EjerciciosResueltos {
    public static void main(String[] args) {
        List<Integer> notas = Arrays.asList(3, 7, 5, 9, 4, 7);

        System.out.println("1. Aprobados: " + notas.stream()
            .filter(nota -> nota >= 5).collect(Collectors.toList()));

        System.out.println("2. Cantidad de suspensos: " + notas.stream()
            .filter(nota -> nota < 5).count());

        System.out.println("3. Notas diferentes ordenadas: " + notas.stream()
            .distinct().sorted().collect(Collectors.toList()));

        System.out.println("4. Hay un diez: " + notas.stream()
            .anyMatch(nota -> nota == 10));

        List<Alumno> alumnos = Arrays.asList(
            new Alumno("Ana", 8), new Alumno("Luis", 4),
            new Alumno("Eva", 9), new Alumno("Pablo", 5));
        System.out.println("5. Nombres con nota >= 8: " + alumnos.stream()
            .filter(alumno -> alumno.getNota() >= 8)
            .map(alumno -> alumno.getNombre())
            .collect(Collectors.toList()));
    }
}
