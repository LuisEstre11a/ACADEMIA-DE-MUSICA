import java.util.Scanner;

public class AcademiaMusica {

// --- DEFINICIÓN DE MÉTODOS (FUNCIONES) ---

    public static double calcularCuotaBase(String tipoTramite) {
        double cuota;
        if (tipoTramite.equalsIgnoreCase("Inscripcion")) {
            cuota = 1500.0;
        } else {
            cuota = 1400.0;
        }
        return cuota;
    }

    public static double calcularMensualidad(String tipoClase) {
        double mens;
        if (tipoClase.equalsIgnoreCase("Clases privadas")) {
            mens = 1400.0;
        } else {
            mens = 950.0;
        }
        return mens;
    }

    public static double calcularCostoRenta(boolean traeInstrumento) {
        double renta;
        if (traeInstrumento) {
            renta = 0.0;
        } else {
            renta = 150.0;
        }
        return renta;
    }

    public static double calcularMontoDescuento(double cuotaBase, boolean traeInstrumento, double porcentajeDescuento) {
        double descuento;
        if (traeInstrumento) {
            descuento = cuotaBase * (porcentajeDescuento / 100.0);
        } else {
            descuento = 0.0;
        }
        return descuento;
    }
    
    // --- ALGORITMO PRINCIPAL ---
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double porcentajeDescuento = 10.0;
        int opcion;
        
        String nomEstudiante = "";
        String numEstudiante = "";
        String tipoTramite = "", cursoSeleccionado = "", tipoClase = "";
        boolean traeInstrumento;
        
        double cuotaBase, mensualidad, costoRenta, subtotal, montoDescuento, totalPagar;

        do {
            System.out.println("===========================================");
            System.out.println("   ACADEMIA DE MUSICA TAINY EPSTEIN KIRK   ");
            System.out.println("       SISTEMA DE LA ESCUELA DE MUSICA     ");
            System.out.println("===========================================");
            System.out.println("1. Registrar alumno");
            System.out.println("2. Inscripcion o Reinscripcion");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opcion:");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    // --- MODULO: REGISTRO DE ALUMNO ---
                    System.out.println("=== REGISTRO DE ALUMNO ===");
                    System.out.println("Ingrese el nombre completo del estudiante:");
                    nomEstudiante = scanner.nextLine();
                    
                    // Generación de matrícula aleatoria de 3 dígitos (del 1 al 999) con ceros a la izquierda
                    int numeroAleatorio = (int) (Math.random() * 999) + 1;
                    numEstudiante = String.format("MTX-2026-%03d", numeroAleatorio);
                    
                    System.out.println(">> Alumno registrado exitosamente con matricula: " + numEstudiante);
                    System.out.println();
                    break;

                case 2:
                    // --- MODULO: INSCRIPCION O REINSCRIPCION ---
                    System.out.println("===========================================");
                    System.out.println("       INSCRIPCION O REINSCRIPCION         ");
                    System.out.println("===========================================");
                    
                    // Si ya se registró un alumno en el paso 1, se usan sus datos automáticamente.
                    // Si no, los solicita de forma manual.
                    if (nomEstudiante.equals("") || numEstudiante.equals("")) {
                        System.out.println("Ingrese el nombre del alumno:");
                        nomEstudiante = scanner.nextLine();
                        
                        System.out.println("Ingrese la matricula del estudiante:");
                        numEstudiante = scanner.nextLine();
                    } else {
                        System.out.println("Alumno recuperado: " + nomEstudiante);
                        System.out.println("Matricula recuperada: " + numEstudiante);
                    }
                    
                    System.out.println("Ingrese el tipo de tramite (Inscripcion / Reinscripcion):");
                    tipoTramite = scanner.nextLine();
                    
                    System.out.println("Ingrese el curso seleccionado (Guitarra, Bateria, Piano, Canto):");
                    cursoSeleccionado = scanner.nextLine();
                    
                    System.out.println("Ingrese la modalidad de clase (Presencial / Clases privadas):");
                    tipoClase = scanner.nextLine();
                    
                    System.out.println("¿Cuenta con instrumento propio? (Si / No):");
                    String respuestaInstrumento = scanner.nextLine();
                    if (respuestaInstrumento.equalsIgnoreCase("Si")) {
                        traeInstrumento = true;
                    } else {
                        traeInstrumento = false;
                    }
                    
                    // --- LLAMADO A FUNCIONES (ASIGNACIÓN DE COSTOS Y CALCULOS) ---
                    cuotaBase = calcularCuotaBase(tipoTramite);
                    mensualidad = calcularMensualidad(tipoClase);
                    costoRenta = calcularCostoRenta(traeInstrumento);
                    
                    subtotal = cuotaBase + mensualidad + costoRenta;
                    montoDescuento = calcularMontoDescuento(cuotaBase, traeInstrumento, porcentajeDescuento);
                    totalPagar = subtotal - montoDescuento;
                    
                    // --- MODULO: COMPROBANTE DE PAGO ---
                    System.out.println();
                    System.out.println("===========================================");
                    System.out.println("                 COMPROBANTE               ");
                    System.out.println("             ESCUELA DE MUSICA             ");
                    System.out.println("===========================================");
                    System.out.println("Alumno: " + nomEstudiante);
                    System.out.println("Matricula: " + numEstudiante);
                    System.out.println("Tramite: " + tipoTramite + " ($" + cuotaBase + ")");
                    System.out.println("Curso: " + cursoSeleccionado);
                    System.out.println("Modalidad: " + tipoClase + " ($" + mensualidad + ")");
                    System.out.println("Costo Renta Material: $" + costoRenta);
                    System.out.println("-------------------------------------------");
                    System.out.println("Subtotal: $" + subtotal);
                    System.out.println("Descuento (" + porcentajeDescuento + "%): -$" + montoDescuento);
                    System.out.println("TOTAL A PAGAR: $" + totalPagar);
                    System.out.println("===========================================");
                    System.out.println("¡Gracias por inscribirse!");
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Gracias por utilizar el sistema de la academia.");
                    break;

                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 3);
        
        scanner.close();
    }
}
