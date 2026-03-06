// Clases estándar necesarias para I/O y manejo de excepciones de red
import java.io.IOException;
import java.util.Scanner;

// Clase principal de la aplicación
public class App {
    // Método de entrada al programa
    public static void main(String[] args) {
        // config: clave de API fija para acceder al servicio de tasas
        String apiKey = "87d0a0a89f1badabf44a6b17";
        ConsultaMoneda consulta = new ConsultaMoneda(apiKey); // cliente HTTP
        Scanner scanner = new Scanner(System.in); // lectura de teclado

        // bucle principal que muestra el menú hasta que el usuario elija salir
        while (true) {
            System.out.println("\n=== Menú de Conversión ===");
            System.out.println("Monedas soportadas: USD, ARS, BOB, BRL, CLP, COP, MXN");
            System.out.println("1. Consultar tasa de cambio directa");
            System.out.println("2. Convertir un monto específico");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");

            // obtener la elección del usuario y convertir a entero
            String entradaOpcion = scanner.nextLine().trim();
            int opcion;

            try {
                opcion = Integer.parseInt(entradaOpcion);
            } catch (NumberFormatException e) {
                // entrada no numérica, vuelve a mostrar menú
                System.out.println("Opción basura. Debes ingresar un número entero válido.");
                continue; // Reinicia el ciclo while
            }

            // opción de salida limpia
            if (opcion == 3) {
                System.out.println("Cerrando el sistema... Adiós.");
                break;
            }

            // procesar la opción seleccionada
            switch (opcion) {
                case 1 -> {
                    // pedir monedas y mostrar tasa
                    System.out.print("Moneda base (ej. USD): ");
                    String base = scanner.nextLine().toUpperCase().trim();
                    System.out.print("Moneda objetivo (ej. MXN): ");
                    String objetivo = scanner.nextLine().toUpperCase().trim();
                    
                    try {
                        TasaDeCambio tasa = consulta.buscarTasa(base, objetivo);
                        mostrarResultado(tasa);
                    } catch (IOException | InterruptedException e) {
                        // problemas de red
                        System.out.println("Error de red o interrupción: " + e.getMessage());
                    } catch (RuntimeException e) {
                        // error de lógica o API
                        System.out.println("Error en la ejecución: " + e.getMessage());
                    }
                }
                case 2 -> {
                    // conversión de un monto en base a la tasa solicitada
                    System.out.print("Moneda base (ej. USD): ");
                    String base = scanner.nextLine().toUpperCase().trim();
                    System.out.print("Moneda objetivo (ej. MXN): ");
                    String objetivo = scanner.nextLine().toUpperCase().trim();
                    
                    System.out.print("Cantidad a convertir: ");
                    String entradaMonto = scanner.nextLine().trim();
                    double monto;
                    
                    try {
                        monto = Double.parseDouble(entradaMonto);
                    } catch (NumberFormatException e) {
                        // monto no es número
                        System.out.println("Cantidad inválida. Operación cancelada.");
                        continue; // Vuelve al menú principal
                    }

                    try {
                        TasaDeCambio tasa = consulta.buscarTasa(base, objetivo);
                        double res = calcularConversion(monto, tasa.conversionRate());
                        System.out.printf("Resultado: %.2f %s = %.2f %s%n", monto, base, res, objetivo);
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Error de red: No se pudo conectar con la API.");
                    } catch (RuntimeException e) {
                        System.out.println("Error de API: Verifica que las siglas de las monedas sean correctas.");
                    }
                }
                default -> System.out.println("Opción no reconocida, intenta de nuevo.");
            }
        }
        // cerrar el escáner antes de salir
        scanner.close();
    }

    public static double calcularConversion(double cantidad, double tasa) {
        return cantidad * tasa;
    }

    // despliega la tasa de cambio obtenida
    private static void mostrarResultado(TasaDeCambio tasa) {
        System.out.printf("Tasa de cambio actual: 1 %s = %.4f %s%n", 
            tasa.baseCode(), tasa.conversionRate(), tasa.targetCode());
    }
}