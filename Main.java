import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorHistorial gestor = new GestorHistorial();
        Scanner scanner = new Scanner(System.in);
        
        // 1. Cargar alumnos al registro desde el archivo externo
        gestor.cargarRegistro(CargadorAlumnos.obtenerLista());
        
        int opcion = -1;
        while (opcion != 4) {
            System.out.println("\n=== GESTIÓN DE AULA Y ASIENTOS ===");
            System.out.println("1. Iniciar Pase de Lista (Día nuevo)");
            System.out.println("2. Ver Historial de un Alumno");
            System.out.println("3. Ver Mapa del Aula por Día");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Opción no válida.");
                scanner.next();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("\nIngresa el número de día a registrar: ");
                    int diaLista = scanner.nextInt();
                    
                    // Arreglo temporal para evitar asignar el mismo asiento 2 veces hoy
                    boolean[] asientosOcupados = new boolean[30]; 
                    
                    System.out.println("--- PASE DE LISTA ---");
                    // Cambio de getPadron() a getRegistroGrupo()
                    for (Estudiante est : gestor.getRegistroGrupo()) {
                        int asientoElegido = -1;
                        
                        while (asientoElegido < 0 || asientoElegido > 30) {
                            System.out.print(est.getNombre() + " (" + est.getMatricula() + ") -> Asiento (1-30, o 0 si faltó): ");
                            asientoElegido = scanner.nextInt();
                            
                            if (asientoElegido > 0 && asientoElegido <= 30) {
                                if (asientosOcupados[asientoElegido - 1]) {
                                    System.out.println("Error: Ese asiento ya fue asignado hoy. Verifica físicamente y elige otro.");
                                    asientoElegido = -1; // Fuerza a preguntar de nuevo
                                } else {
                                    asientosOcupados[asientoElegido - 1] = true;
                                    gestor.asignarManual(diaLista, est, asientoElegido);
                                }
                            } else if (asientoElegido != 0) {
                                System.out.println("Número de asiento inválido.");
                            }
                        }
                    }
                    gestor.rellenarVacios(diaLista);
                    System.out.println("Pase de lista del Día " + diaLista + " guardado exitosamente.");
                    break;
                    
                case 2:
                    System.out.print("Ingresa la matrícula del alumno: ");
                    String mat = scanner.next();
                    gestor.verHistorialAlumno(mat);
                    break;
                    
                case 3:
                    System.out.print("Ingresa el número de día a consultar: ");
                    int diaConsulta = scanner.nextInt();
                    gestor.verAulaPorDia(diaConsulta);
                    break;
                    
                case 4:
                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
        scanner.close();
    }
}