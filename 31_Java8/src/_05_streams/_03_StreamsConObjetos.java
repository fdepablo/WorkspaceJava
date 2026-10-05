package _05_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class _03_StreamsConObjetos {
    public static void main(String[] args) {
        List<Alumno> alumnos = Arrays.asList(
            new Alumno("Ana", 8), new Alumno("Luis", 4),
            new Alumno("Eva", 9), new Alumno("Pablo", 5));

        // 1. OBTENER LOS NOMBRES DE LOS APROBADOS Y ORDENARLOS.
        // ANTES: recorrer, comprobar, guardar el nombre y ordenar.
        List<String> nombresConBucle = new ArrayList<String>();
        for (Alumno alumno : alumnos) {
            if (alumno.getNota() >= 5) {
                nombresConBucle.add(alumno.getNombre());
            }
        }
        Collections.sort(nombresConBucle);
        System.out.println("Con bucle, aprobados: " + nombresConBucle);

        // CON STREAMS: filter equivale al if y map obtiene el nombre.
        List<String> nombresAprobados = alumnos.stream()
            .filter(alumno -> alumno.getNota() >= 5) // Siguen pasando objetos Alumno.
            .map(alumno -> alumno.getNombre())      // Ahora pasan String.
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Aprobados: " + nombresAprobados); // [Ana, Eva, Pablo]

        // 2. CONTAR LOS APROBADOS.
        // ANTES: un contador que aumenta cuando se cumple la condicion.
        long cantidadConBucle = 0;
        for (Alumno alumno : alumnos) {
            if (alumno.getNota() >= 5) {
                cantidadConBucle++;
            }
        }
        System.out.println("Con bucle, cantidad de aprobados: " + cantidadConBucle);

        // CON STREAMS: filter selecciona y count cuenta.
        // Cada pregunta abre un NUEVO stream desde la misma lista.
        long cantidad = alumnos.stream()
            .filter(alumno -> alumno.getNota() >= 5)
            .count(); // Terminal: devuelve un long.
        System.out.println("Cantidad de aprobados: " + cantidad); // 3

        // 3. COMPROBAR SI HAY ALGUN SUSPENSO.
        // ANTES: una bandera y break para parar al encontrar el primero.
        boolean haySuspensosConBucle = false;
        for (Alumno alumno : alumnos) {
            if (alumno.getNota() < 5) {
                haySuspensosConBucle = true;
                break;
            }
        }
        System.out.println("Con bucle, hay suspensos: " + haySuspensosConBucle);

        // CON STREAMS: anyMatch tambien puede parar al encontrar uno.
        boolean haySuspensos = alumnos.stream()
            .anyMatch(alumno -> alumno.getNota() < 5);
        System.out.println("Hay suspensos: " + haySuspensos); // true

        // 4. CALCULAR SUMA Y MEDIA.
        // ANTES: acumulamos las notas y dividimos entre la cantidad.
        int sumaConBucle = 0;
        for (Alumno alumno : alumnos) {
            sumaConBucle += alumno.getNota();
        }
        double mediaConBucle = 0.0;
        if (!alumnos.isEmpty()) {
            // Convertimos a double para evitar la division entera.
            mediaConBucle = (double) sumaConBucle / alumnos.size();
        }
        System.out.println("Con bucle, suma: " + sumaConBucle);
        System.out.println("Con bucle, media: " + mediaConBucle);

        // CON STREAMS: dos consultas, cada una con su propio stream.
        // mapToInt produce un flujo de int, que permite sum() y average().
        int suma = alumnos.stream().mapToInt(alumno -> alumno.getNota()).sum();
        double media = alumnos.stream()
            .mapToInt(alumno -> alumno.getNota())
            .average()
            .orElse(0.0); // Si no hay alumnos, elegimos mostrar 0.0.
        System.out.println("Suma: " + suma); // 26
        System.out.println("Media: " + media); // 6.5

        // 5. BUSCAR EL PRIMER SOBRESALIENTE.
        // ANTES: null representa que todavia no hemos encontrado ninguno.
        Alumno sobresalienteConBucle = null;
        for (Alumno alumno : alumnos) {
            if (alumno.getNota() >= 9) {
                sobresalienteConBucle = alumno;
                break; // Queremos el primero, no el ultimo.
            }
        }
        if (sobresalienteConBucle != null) {
            System.out.println("Con bucle, primer sobresaliente: " + sobresalienteConBucle);
        } else {
            System.out.println("Con bucle, no hay sobresalientes");
        }

        // CON STREAMS: findFirst devuelve un Optional en lugar de usar null.
        // Buscar puede no encontrar nada. Optional representa esa posibilidad.
        Optional<Alumno> sobresaliente = alumnos.stream()
            .filter(alumno -> alumno.getNota() >= 9)
            .findFirst();
        if (sobresaliente.isPresent()) {
            System.out.println("Primer sobresaliente: " + sobresaliente.get());
        } else {
            System.out.println("No hay sobresalientes");
        }
        // Aqui muestra Eva (9). No usamos get() sin comprobar antes.
    }
}
