package calc;

public class exceptionTryCatch {
    // Método principal que inicia la ejecución del programa
    public static void main(String[] args) {
        // Crea un objeto Scanner para leer entrada del usuario desde la consola
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        // Bloque try-catch para manejar excepciones
        try {
            // Solicita al usuario que ingrese su edad
            System.out.print("Ingrese su edad: ");
            // Lee la entrada del usuario como una cadena de texto
            String entrada = scanner.nextLine();
            // Intenta convertir la cadena a un número entero
            int edad = Integer.parseInt(entrada);
            // Imprime la edad ingresada si la conversión es exitosa
            System.out.println("Edad ingresada: " + edad);
        } catch (NumberFormatException e) {
            // Captura la excepción si la entrada no es un número válido
            System.out.println("Error: Debe ingresar un número válido. Dato ingresado no es numérico.");
        } finally {
            // Bloque que siempre se ejecuta para cerrar el Scanner y liberar recursos
            System.out.println("Gracias por su participación.");
            scanner.close();
        }
    }
}
