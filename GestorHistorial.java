import java.util.ArrayList;
import java.util.List;

public class GestorHistorial {
    private List<Registro> historial;
    private List<Estudiante> registroGrupo; // Antes padronGrupo
    private Asiento[] aula;
    private final int MAX_ALUMNOS = 30;

    public GestorHistorial() {
        this.historial = new ArrayList<>();
        this.registroGrupo = new ArrayList<>();
        this.aula = new Asiento[MAX_ALUMNOS];
        
        for (int i = 0; i < MAX_ALUMNOS; i++) {
            aula[i] = new Asiento(i + 1);
        }
    }

    // Método renombrado
    public void cargarRegistro(List<Estudiante> alumnos) {
        this.registroGrupo.addAll(alumnos);
        System.out.println("Registro cargado con " + alumnos.size() + " alumnos.");
    }

    // Método renombrado
    public List<Estudiante> getRegistroGrupo() {
        return registroGrupo;
    }

    public void asignarManual(int dia, Estudiante estudiante, int numAsiento) {
        if (numAsiento >= 1 && numAsiento <= MAX_ALUMNOS) {
            historial.add(new Registro(dia, estudiante, aula[numAsiento - 1]));
        }
    }

    public void rellenarVacios(int dia) {
        for (int i = 0; i < MAX_ALUMNOS; i++) {
            boolean ocupado = false;
            for (Registro reg : historial) {
                if (reg.getDia() == dia && reg.getAsiento().getNumero() == (i + 1)) {
                    ocupado = true;
                    break;
                }
            }
            if (!ocupado) {
                historial.add(new Registro(dia, null, aula[i]));
            }
        }
    }

    public void verHistorialAlumno(String matricula) {
        System.out.println("\n--- HISTORIAL DEL ALUMNO: " + matricula + " ---");
        boolean encontrado = false;
        for (Registro reg : historial) {
            if (!reg.estaVacio() && reg.getEstudiante().getMatricula().equals(matricula)) {
                System.out.println("Día " + reg.getDia() + ": Ocupó el " + reg.getAsiento());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay registros para esta matrícula.");
        }
    }

    public void verAulaPorDia(int dia) {
        System.out.println("\n--- MAPA DEL AULA - DÍA " + dia + " ---");
        for (Registro reg : historial) {
            if (reg.getDia() == dia) {
                System.out.println(reg.toString());
            }
        }
    }
}