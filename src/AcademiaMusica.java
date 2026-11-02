import java.util.Scanner;

public class AcademiaMusica {
    
    static Scanner sc = new Scanner(System.in);
    static void mostrarMenu(){
        //titulo del menú
        System.out.println("===================");
        System.out.println("ACADEMIA DE MÚSICA");
        System.out.println("TAINY EPSTEIN KIRK");
        System.out.println("===================");
        //Mostrar las opciones
        System.out.println("1. Registrar alumno");
        System.out.println("2. Incripción o reinscripción");
        System.out.println("3. Pagar mensualidad");
        System.out.println("4. Rentar materiales");
        System.out.println("5. Salir");
        System.out.println("Elige una opción: ");
    }
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            if (opcion >= 1 && opcion <= 4){
                System.out.println("Elegiste la opcion: " + opcion);
            } else if (opcion != 5){
                System.out.println("Opción no válida");
            }
        } while (opcion != 5);
        sc.close();

            switch (opcion) {
                case 1: System.out.println("Registrar Alumno"); break;
                case 2: System.out.println("Incripción o reinscripción"); break;
                case 3: System.out.println("Pagar mensualidad"); break;
                case 4: System.out.println("Rentar materiales"); break;
                case 5: System.out.println("Salir"); break;
                default: System.out.println("Opción no válida");
            }
        } 
    }


