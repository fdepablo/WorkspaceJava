package _05_streams;

// Un objeto sencillo para que el ejemplo se parezca a un caso de clase.
public class Alumno {
    private final String nombre;
    private final int nota;

    public Alumno(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return nombre + " (" + nota + ")";
    }
}
