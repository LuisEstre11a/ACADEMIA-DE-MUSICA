import java.util.Scanner;

public class AlgoritmoPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Variables de estado, montos y control
        double porcentajeDescuento = 10.0;
        int opcion;
        
        String nomEstudiante = "";
        String numEstudiante = "";
        String tipoTramite = "", cursoSeleccionado = "", tipoClase = "";
        boolean traeInstrumento;
        
        double cuotaBase, mensualidad, costoRenta, subtotal, montoDescuento, totalPagar;

        // Bucle interactivo del menú principal
        do {
            System.out.println("===========================================");
            System.out.println("   ACADEMIA DE MUSICA TAINY EPSTEIN KIRK   ");
            System.out.println("       SISTEMA DE LA ESCUELA DE MUSICA     ");
            System.out.println("===========================================");
            System.out.println("1. Registrar alumno");
            System.out.println("2. Inscripcion o Reinscripcion");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opcion:");
            
            // Validación de entrada para evitar errores si escriben texto
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            // --- AQUÍ CONECTA EL SWITCH-CASE (MÓDULOS DE REGISTRO E INSCRIPCIÓN) ---

        } while (opcion != 3);
        
        System.out.println("Gracias por utilizar el sistema de la academia.");
        scanner.close();
    }
}