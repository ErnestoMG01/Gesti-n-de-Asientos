public class Estudiante {
    private String matricula;
    private String nombre;

    public Estudiante(String matricula, String nombre) {
        this.matricula = matricula;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return nombre + " (" + matricula + ")";
    }
}
