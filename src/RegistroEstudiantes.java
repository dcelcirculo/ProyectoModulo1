import java.util.Scanner;

public class RegistroEstudiantes {

    // Variables estáticas para almacenar los datos del estudiante actual
    public static String nombre;
    public static double nota;
    public static double nota1;
    public static double nota2;
    public static double nota3;
    public static double tempNota1;
    public static double tempNota2;
    public static double tempNota3;
    public static String tempNombre;

    public static void main(String[] args) {
        // Crear objeto Scanner para leer la entrada del usuario
        var entrada = new Scanner(System.in);

        // Llamar al menú principal
        lanzarMenu(entrada);

        // Cerrar el Scanner al finalizar
        entrada.close();
    }

    // Método que muestra el menú principal y gestiona las opciones del usuario
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

            // Leer la opción elegida por el usuario
            var opcion = leerEntero(entrada, "Ingrese una opción: ");
            switch (opcion) {
                case 1:
                    // Registrar estudiante
                    registroDatosEstudiante(entrada);
                    break;
                case 2:
                    // Mostrar datos del estudiante actual
                    mostrarDatosEstudiante();
                    break;
                case 3:
                    // Calcular promedio de notas del estudiante actual
                    calcularPromedioNotas();
                    break;
                case 0:
                    // Salir del menú
                    salida = true;
                    break;
                default:
                    // Opción no válida
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (!salida);
        System.out.println("--- Gracias por usar el sistema de registro de estudiantes ---");
    }

    // Método para validar el nombre del estudiante
    public static boolean validarNombre(String nombre) {
        // Verifica que el nombre no sea nulo, no esté vacío y solo contenga letras y
        // espacios
        return nombre != null && !nombre.trim().isEmpty() && nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }

    // Método para validar que la nota esté en el rango permitido
    public static boolean validarNota(double nota) {

        // Verifica que la nota esté entre 0 y 100 inclusive
        return nota >= 0 && nota <= 100;
    }

    // Método para calcular y mostrar el promedio de las notas
    private static void calcularPromedioNotas() {
        // Verifica si las notas están registradas
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("No existen datos para mostrar");
        } else {
            double promedio = (nota1 + nota2 + nota3) / 3;
            if (verificarAprobado(promedio)) {
                System.out.printf("El promedio de notas del estudiante es: %.2f y su estado es Aprobado.\n", promedio);
            } else {
                System.out.printf("El promedio de notas del estudiante es: %.2f y su estado es Reprobado.\n", promedio);
            }

        }
    }

    public static boolean verificarAprobado(double nota) {
        return nota >= 60;
    }

    // Método para mostrar los datos del estudiante actual
    public static void mostrarDatosEstudiante() {
        if (nombre == null) {
            System.out.println("No hay estudiante registrado");
        } else {
            System.out.printf("El nombre del estudiante es: %s\n", nombre);
            System.out.printf("la nota 1 del estudiante es: %.1f\n", nota1);
            System.out.printf("la nota 2 del estudiante es: %.1f\n", nota2);
            System.out.printf("la nota 3 del estudiante es: %.1f\n", nota3);
        }
    }

    // Método para registrar los datos del estudiante
    public static void registroDatosEstudiante(Scanner entrada) {
        // Solicitar y validar el nombre
        System.out.println("Digite el nombre del estudiante");
        tempNombre = entrada.nextLine();
        while (!validarNombre(tempNombre)) {
            System.out.println("Este campo debe contener solo letras. Intente de nuevo");
            tempNombre = entrada.nextLine();
        }

        // Solicitar y validar la nota 1
        do {
            System.out.print("Digite la nota 1: ");
            if (entrada.hasNextDouble()) {
                tempNota1 = entrada.nextDouble();
                entrada.nextLine();
                if (!validarNota(tempNota1)) {
                    System.out.println("Nota inválida. Nota debe ser un número entre 0 y 100. Intente de nuevo.");
                }
            } else {
                System.out.println("Nota inválida. Debe ser un número");
                entrada.next();
                tempNota1 = -1;
            }
        } while (!validarNota(tempNota1));

        // Solicitar y validar la nota 2
        do {
            System.out.print("Digite la nota 2: ");
            if (entrada.hasNextDouble()) {
                tempNota2 = entrada.nextDouble();
                entrada.nextLine();
                if (!validarNota(tempNota2)) {
                    System.out.println("Nota inválida. Nota debe ser un número entre 0 y 100. Intente de nuevo.");
                }
            } else {
                System.out.println("Nota inválida. Debe ser un número");
                entrada.next();
                tempNota2 = -1;
            }
        } while (!validarNota(tempNota2));

        // Solicitar y validar la nota 3
        do {
            System.out.print("Digite la nota 3: ");
            if (entrada.hasNextDouble()) {
                tempNota3 = entrada.nextDouble();
                entrada.nextLine();
                if (!validarNota(tempNota3)) {
                    System.out.println("Nota inválida. Nota debe ser un número entre 0 y 100. Intente de nuevo.");
                }
            } else {
                System.out.println("Nota inválida. Debe ser un número");
                entrada.next();
                tempNota3 = -1;
            }
        } while (!validarNota(tempNota3));

        System.out.println("\n--- Resumen de los datos a registrar ---");
        System.out.printf("Nombre: %s\n", tempNombre);
        System.out.printf("Nota 1: %s\n", tempNota1);
        System.out.printf("Nota 2: %s\n", tempNota2);
        System.out.printf("Nota 3: %s\n", tempNota3);
        System.out.print("¿Desea confirmar el registro? (S/N): ");
        String confirm = entrada.nextLine();
        confirmarDatos(confirm);
    }

    // Metodo para confirmar datos a guardar
    public static void confirmarDatos(String confirm) {
        if (confirm.equalsIgnoreCase("S")) {
            nombre = tempNombre;
            nota1 = tempNota1;
            nota2 = tempNota2;
            nota3 = tempNota3;
            System.out.println("--- Registro confirmado ---");
        } else {
            System.out.println("--- Registro cancelado ---");
        }
    }

    // Método para leer un número entero de la consola con validación
    public static int leerEntero(Scanner entrada, String mensaje) {
        System.out.print(mensaje);
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
