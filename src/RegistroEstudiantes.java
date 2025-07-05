import java.util.Scanner;

public class RegistroEstudiantes {

    public static String nombre;
    public static double nota1;
    public static double nota2;
    public static double nota3;

    public static void main(String[] args) {
        var entrada = new Scanner(System.in);

        lanzarMenu(entrada);

        entrada.close();
    }

    public static void lanzarMenu(Scanner entrada) {
        var salida = false;

        do {
            System.out.println("");
            System.out.println("--- Sistema de Registro de estudiantes ---");
            System.out.println("");
            System.out.println("""
                    1. Registrar estudiante
                    2. Mostrar datos del estudiante actual
                    3. Calcular promedio de notas del estudiante actual
                    0. Salir
                    """);

            var opcion = leerEntero(entrada, "Ingrese una opción: ");
            switch (opcion) {
                case 1:
                    registroDatosEstudiante(entrada);
                    break;
                case 2:
                    mostrarDatosEstudiante();
                    break;
                case 3:
                    calcularPromedioNotas();
                    break;
                case 0:
                    salida = true;
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (!salida);
        System.out.println("--- Gracias por usar el sistema de registro de estudiantes ---");
    }

    private static void calcularPromedioNotas() {
        if (nota1 == 0 || nota1 == 0 || nota1 == 0) {
            System.out.println("No existen datos para mostrar");
        } else {
            double promedio = (nota1 + nota2 + nota3) / 3;
            System.out.printf("El promedio de notas del estudiante es: %.2f\n", promedio);
        }
    }

    public static void mostrarDatosEstudiante() {

        if (nombre == null) {
            System.out.println("N/A");
        } else {
            System.out.printf("El nombre del estudiante es: %s\n", nombre);
            System.out.printf("la nota 1 del estudiante es: %.1f\n", nota1);
            System.out.printf("la nota 2 del estudiante es: %.1f\n", nota2);
            System.out.printf("la nota 3 del estudiante es: %.1f\n", nota3);
        }
    }

    public static void registroDatosEstudiante(Scanner entrada) {

        System.out.println("Digite el nombre del estudiante");
        nombre = entrada.nextLine();
        while (!nombre.matches(("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))) {
            System.out.println("Este campo debe contener solo letras. Intente de nuevo");
            nombre = entrada.nextLine();
        }

        System.out.print("Digite la nota 1: ");
        while (!entrada.hasNextDouble()) {
            System.out.println("Nota inválida. Por favor ingrese un número.");
            entrada.next();
            System.out.print("Digite la nota 1: ");
        }
        nota1 = entrada.nextDouble();
        entrada.nextLine();

        System.out.print("Digite la nota 2: ");
        while (!entrada.hasNextDouble()) {
            System.out.println("Nota inválida. Por favor ingrese un número.");
            entrada.next();
            System.out.print("Digite la nota 2: ");
        }
        nota2 = entrada.nextDouble();
        entrada.nextLine();

        System.out.print("Digite la nota 3: ");
        while (!entrada.hasNextDouble()) {
            System.out.println("Nota inválida. Por favor ingrese un número.");
            entrada.next();
            System.out.print("Digite la nota 3: ");
        }
        nota3 = entrada.nextDouble();
        entrada.nextLine();
    }

    public static int leerEntero(Scanner entrada, String mensaje) {
        System.out.println(mensaje);
        if (!entrada.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
            entrada.nextLine(); // Limpiar el buffer de entrada
            return leerEntero(entrada, mensaje); // Volver a solicitar la entrada
        } else {
            var input = entrada.nextInt();// Leer el número entero ingresado
            entrada.nextLine();// Limpiar el buffer de entrada
            return input;
        }
    }

}
