import java.io.IOException;

/**
 * Clase principal - Conversor de Monedas
 * Demuestra el uso de la clase ConsultaMoneda para obtener tasas de cambio
 */
public class App {
    
    public static void main(String[] args) {
        try {
            // Crear instancia de ConsultaMoneda
            // NOTA: Asegúrate de configurar la variable de entorno EXCHANGE_RATE_API_KEY
            // O pasa tu API_KEY directamente: new ConsultaMoneda("tu_api_key_aqui")
            ConsultaMoneda consulta = new ConsultaMoneda("87d0a0a89f1badabf44a6b17");

            // Ejemplo 1: Consultar tasa USD a MXN
            System.out.println("=== Conversor de Monedas ===\n");
            
            TasaDeCambio tasa1 = consulta.buscarTasa("USD", "MXN");
            mostrarResultado(tasa1);

            // Ejemplo 2: Consultar tasa EUR a USD
            System.out.println();
            TasaDeCambio tasa2 = consulta.buscarTasa("EUR", "USD");
            mostrarResultado(tasa2);

            // Ejemplo 3: Consultar tasa GBP a MXN
            System.out.println();
            TasaDeCambio tasa3 = consulta.buscarTasa("GBP", "MXN");
            mostrarResultado(tasa3);

            // Ejemplo de conversión
            System.out.println("\n=== Ejemplos de Conversión ===");
            double monto = 100;
            double resultado = monto * tasa1.conversionRate();
            System.out.printf("%.2f %s = %.2f %s%n", 
                monto, tasa1.baseCode(), resultado, tasa1.targetCode());

        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error de validación: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("❌ Solicitud interrumpida: " + e.getMessage());
            Thread.currentThread().interrupt();
        } catch (RuntimeException e) {
            System.out.println("❌ Error en la API: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Método auxiliar para mostrar los resultados de forma formateada
     */
    private static void mostrarResultado(TasaDeCambio tasa) {
        System.out.printf("Conversión: %s → %s%n", tasa.baseCode(), tasa.targetCode());
        System.out.printf("Tasa: 1 %s = %.4f %s%n", 
            tasa.baseCode(), tasa.conversionRate(), tasa.targetCode());
    }
}
