/*Descripción de la práctica
        Lista de Estudiantes:
        Cada estudiante tendrá un nombre, edad y una lista de calificaciones.

        Operaciones:
        Filtrar a los estudiantes mayores de 18 años.
        Convertir los nombres de los estudiantes a mayúsculas.
        Calcular el promedio de calificaciones de cada estudiante.
        Encontrar el primer estudiante que tiene una calificación mayor o igual a 90.
        Usar Optional para manejar posibles valores nulos en las calificaciones.*/

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Estudiante> estudiantes = Arrays.asList(
                new Estudiante("Juan", 20, Arrays.asList(90, 80, 85)),
                new Estudiante("Ana", 17, Arrays.asList(70, 75, 80)),
                new Estudiante("Pedro", 22, Arrays.asList(88, 92, 95)),
                new Estudiante("Lucia", 19, Arrays.asList(60, 65, 70)),
                new Estudiante("Sofia", 21, Arrays.asList())
        );

        // Filtrar estudiantes mayores de 18 años
        List<Estudiante> mayoresDeEdad = estudiantes.stream()
                .filter(est -> est.getEdad() > 18)
                .collect(Collectors.toList());
        System.out.println("Estudiantes mayores de 18 años: " + mayoresDeEdad);

        // Convertir los nombres de los estudiantes a mayúsculas
        List<String> nombresEnMayusculas = estudiantes.stream()
                .map(est -> est.getNombre().toUpperCase())
                .collect(Collectors.toList());
        System.out.println("Nombres en mayúsculas: " + nombresEnMayusculas);

        // Calcular el promedio de calificaciones de cada estudiante
        estudiantes.forEach(est -> {
            Optional<Double> promedio = est.obtenerPromedioCalificaciones();
            System.out.println("Promedio de " + est.getNombre() + ": " +
                    promedio.orElse(Double.NaN));
        });

        // Encontrar el primer estudiante con una calificación mayor o igual a 90
        Optional<Estudiante> estudianteConAltaCalificacion = estudiantes.stream()
                .filter(est -> est.getCalificaciones().stream()
                        .anyMatch(calif -> calif >= 90))
                .findFirst();
        estudianteConAltaCalificacion.ifPresent(est -> System.out.println("Primer estudiante con calificación >= 90: " + est.getNombre()));
    }
}