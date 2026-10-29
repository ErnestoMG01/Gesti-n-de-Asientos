public class Registro {
    private int dia;
    private Estudiante estudiante; // null si el asiento está vacío
    private Asiento asiento;

    public Registro(int dia, Estudiante estudiante, Asiento asiento) {
        this.dia = dia;
        this.estudiante = estudiante;
        this.asiento = asiento;
    }

    public int getDia() {
        return dia;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public boolean estaVacio() {
        return estudiante == null;
    }

    @Override
    public String toString() {
        if (estaVacio()) {
            return "Día " + dia + " - " + asiento.toString() + ": [VACÍO]";
        }
        return "Día " + dia + " - " + asiento.toString() + ": " + estudiante.getNombre();
    }
}