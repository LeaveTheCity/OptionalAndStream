import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Estudiante {
    private String nombre;
    private int edad;
    private List<Integer> calificaciones;

    public Estudiante(String nombre, int edad, List<Integer> calificaciones) {
        this.nombre = nombre;
        this.edad = edad;
        this.calificaciones = calificaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public List<Integer> getCalificaciones() {
        return calificaciones;
    }

    public Optional<Double> obtenerPromedioCalificaciones() {
        if (calificaciones.isEmpty()) {
            return Optional.empty();
        }
        double promedio = calificaciones.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        return Optional.of(promedio);
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", calificaciones=" + calificaciones +
                '}';
    }
}