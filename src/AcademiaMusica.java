import java.util.Scanner;

public class AcademiaMusica {

    //FUNCIONES
    static Scanner sc = new Scanner(System.in);

    static boolean hayAlumno = false;
    static String alumnoNombre = "";
    static  int alumnoEdad = 0;
    static String alumnoInstrumento = "";
    static boolean alumnoInscrito = false;
    static double alumnoTotalPagado = 0;
    

    //MENÚ
    static void mostrarMenu() {
        //titulo del menú
        System.out.println("===================");
        System.out.println("ACADEMIA DE MÚSICA");
        System.out.println("TAINY EPSTEIN KIRK");
        System.out.println("===================");
        //Mostrar las opciones del menú
        System.out.println("1. Registrar alumno");
        System.out.println("2. Inscripción o reinscripción");
        System.out.println("3. Pagar mensualidad");
        System.out.println("4. Rentar materiales");
        System.out.println("5. Salir");
        System.out.println("Seleccione que desea tramitar");
    }

    // VALIDACIONES
    static  int leerEntero(String mensaje, int min, int max) {
        int numero = min;
        boolean valido = false;
        do {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            try {
                numero = Integer.parseInt(linea);
                if (numero >= min && numero <= max) {
                    valido = true;
                } else {
                    System.out.println("Debe estar entre " + min + "y" + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número entero válido");
            }
        } while (!valido);
        return numero;
    }

    static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        String texto = sc.nextLine().trim();
        while (texto.length() < 2) {
            System.out.print("Debe tener al menos 2 letras. Intenta de nuevo: ");
            texto = sc.nextLine().trim();
        }
        return texto;
    }

    //OPCION 1 - REGISTRAR ALUMNO
    static void registrarAlumno() {
        System.out.println("Registrar Alumno");
        String nombre = leerTexto("Nombre del Alumno: ");
        int edad = leerEntero("Edad (3 a 50): ");
        String instrumento = leerTexto("Instrumento: ");

        alumnoNombre = nombre;
        alumnoEdad = edad;
        alumnoInstrumento = instrumento;
        alumnoInscrito = false;
        alumnoTotalPagado = 0;
        hayAlumno = true;

        String estado = alumnoInscrito ? "Inscrito" : "Aún sin inscribir";
        System.out.println("Alumno registrado: " + alumnoNombre + "años, instrumento: " + alumnoInstrumento);
    }

    static void inscribirAlumno() {
        System.out.println("Inscripción o reinscripción");
        if (!hayAlumno) {
            System.out.println("Primero registra un alumno (opción 1).");
            return;
        }
        if (alumnoInscrito) {
            System.out.println(alumnoNombre + " ya está inscrito.");
            return;
        }

        System.out.println("1 Inscripción: $" + COSTO_INSCRIPCION);
        System.out.println("2 Reinscripción: $" + COSTO_REINSCRIPCION);
        int tipo = leerEntero("Elige una opción: ", 1, 2);

        double costo = costoInscripcion(tipo);
        System.out.println("Costo: $" + costo);
        double pago = leerPago(costo);
        System.out.println("Cambio: $" + (pago - costo));

        alumnoInscrito = true;
        alumnoTotalPagado = alumnoTotalPagado + costo;
        String concepto = (tipo == 1) ? "Inscripción" : "Reinscripción";
        mostrarComprobante(concepto, costo);
    }

    // MAIN
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opción", min 1, max 5);

            switch (opcion) {
                case 1: registrarAlumno(); break;
                case 2: inscribirAlumno(); break;
                case 3: pagarMensualidad(); break;
                case 4: rentarMateriales(); break;
                case 5: System.out.println("Gracias por visitar la Academia de Música"); break;
                default: System.out.println("Opción no válida. Intenta de nuevo");
            }
        } while (opcion != 5);

            sc.close();
        }   
    } 


